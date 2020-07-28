package vn.tphan.jhipster.neutron.services.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tphan.jhipster.neutron.models.Board;
import vn.tphan.jhipster.neutron.models.Game;
import vn.tphan.jhipster.neutron.services.dto.GameDTO;

import java.util.HashMap;

@Service
public class GameDTOMapper {
    @Autowired
    private final HashMap<String, Board> hashMap;

    public GameDTOMapper(HashMap<String, Board> hashMap) {
        this.hashMap = hashMap;
    }

    public GameDTO gameToGameDTO(Game game) {
        Board board = hashMap.get(game.getName());
        if (board == null) {
            board = new Board(game.getName());
            hashMap.put(game.getName(), board);
        }
        return new GameDTO(game, board);
    }


}
