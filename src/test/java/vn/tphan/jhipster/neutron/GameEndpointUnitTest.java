package vn.tphan.jhipster.neutron;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import vn.tphan.jhipster.JhipsterApp;
import vn.tphan.jhipster.neutron.models.Board;
import vn.tphan.jhipster.neutron.models.Game;
import vn.tphan.jhipster.neutron.models.utils.RandomStringGenerator;
import vn.tphan.jhipster.neutron.services.dto.GameDTO;
import vn.tphan.jhipster.security.AuthoritiesConstants;

@AutoConfigureMockMvc
@SpringBootTest(classes = JhipsterApp.class)
public class GameEndpointUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RandomStringGenerator generator;

    @Test
    public void showAllGames() throws Exception {
        this.mockMvc.perform(get("/api/games")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @Test
    @Transactional
    @WithMockUser(username = "mock_user", authorities = AuthoritiesConstants.USER)
    public void joinANewGame() throws Exception {
        GameDTO mockDTO = createMockDTO();
        this.mockMvc.perform(post("/api/games/"+ mockDTO.getName())
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated())
            .andExpect(content().string(containsString(mockDTO.getName())));
    }

    private GameDTO createMockDTO() {
        Game game = new Game(generator.getAlphaNumericString(10));
        return new GameDTO(game, new Board(game.getName()));
    }

}
