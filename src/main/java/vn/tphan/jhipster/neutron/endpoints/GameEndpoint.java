package vn.tphan.jhipster.neutron.endpoints;

import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.tphan.jhipster.core.CrudApiEndpoint;
import vn.tphan.jhipster.core.CrudService;
import vn.tphan.jhipster.neutron.errors.GameIsFullException;
import vn.tphan.jhipster.neutron.errors.GameNotFoundException;
import vn.tphan.jhipster.neutron.errors.UnauthorizedUserException;
import vn.tphan.jhipster.neutron.models.Board;
import vn.tphan.jhipster.neutron.models.Game;
import vn.tphan.jhipster.neutron.models.Piece;
import vn.tphan.jhipster.neutron.services.GameService;
import vn.tphan.jhipster.neutron.services.dto.GameDTO;
import vn.tphan.jhipster.neutron.services.mapper.GameDTOMapper;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameEndpoint extends CrudApiEndpoint<Game, Long> {
    private static final Logger logger = LoggerFactory.getLogger(GameEndpoint.class);
    private GameService gameService;
    private GameDTOMapper mapper;
    private HashMap<String, Board> hashMap;

    public GameEndpoint(GameService service, HashMap<String, Board> hashMap, GameDTOMapper mapper) {
        super(service);
        this.gameService = service;
        this.mapper = mapper;
        this.hashMap = hashMap;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<List<Game>> findAll() {
        return new ResponseEntity<>(this.gameService.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/{name}")
    public ResponseEntity<GameDTO> createGame(@PathVariable String name) {
        GameDTO entity;
        if ((entity = this.gameService.joinGame(name)) == null) {
            throw new GameIsFullException(name);
        }
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<GameDTO> createGame() {
        return new ResponseEntity<>(this.gameService.createGame(), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<GameDTO> gameInfo(@PathVariable String name) {
        return ResponseUtil.wrapOrNotFound(gameService.gameDetails(name).map(mapper::gameToGameDTO));
    }
    @PutMapping(path = "/{name}")
    public ResponseEntity<GameDTO> updateGameState(@PathVariable String name,
                                                   @RequestBody Piece piece) {
        try {
            return new ResponseEntity<>(this.gameService.updateGameState(name, piece), HttpStatus.OK);
        } catch (UnauthorizedUserException uae) {
            throw new UnauthorizedUserException();
        }
    }
}
