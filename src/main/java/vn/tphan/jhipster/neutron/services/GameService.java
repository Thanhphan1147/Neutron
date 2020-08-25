package vn.tphan.jhipster.neutron.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import vn.tphan.jhipster.core.CrudService;
import vn.tphan.jhipster.neutron.errors.GameIsFullException;
import vn.tphan.jhipster.neutron.errors.GameNotFoundException;
import vn.tphan.jhipster.neutron.errors.NameAlreadyExistedException;
import vn.tphan.jhipster.neutron.errors.UnauthorizedUserException;
import vn.tphan.jhipster.neutron.models.Board;
import vn.tphan.jhipster.neutron.models.Game;
import vn.tphan.jhipster.neutron.models.Piece;
import vn.tphan.jhipster.neutron.models.utils.RandomStringGenerator;
import vn.tphan.jhipster.neutron.repositories.GameRepository;
import vn.tphan.jhipster.neutron.services.dto.GameDTO;
import vn.tphan.jhipster.security.SecurityUtils;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GameService extends CrudService<Game, Long> {
    private static final Logger logger = LoggerFactory.getLogger(GameService.class);
    private final GameRepository gameRepository;
    private final HashMap<String, Board> hashMap;
    private final RandomStringGenerator generator;

    public GameService(GameRepository gameRepository, HashMap<String, Board> hashMap, RandomStringGenerator randomStringGenerator) {
        this.hashMap = hashMap;
        this.generator = randomStringGenerator;
        this.repository = this.gameRepository = gameRepository;
    }

    public List<Game> findAll() {
        return this.gameRepository.findAll();
    }

    public GameDTO joinGame(String name) {
        Game entity = this.gameRepository.findByNameIgnoreCase(name);
        String login = SecurityUtils.getCurrentUserLogin().orElse("Anonymous");
        if (entity != null)
        {
            if (entity.isFull()) {
                return null;
            }

            entity.setPlayer(login);
            if (hashMap.get(entity.getName()) == null) {
                logger.info("No board present in hashmap, creating a new one");
                hashMap.put(entity.getName(), new Board(entity.getName()));
            }
            return new GameDTO(entity, hashMap.get(entity.getName()));
        }
        return this.createGame(name, login);
    }

    public GameDTO createGame(String name, String login) {
        Game entity = new Game(name);
        beforeCreate(entity);
        this.gameRepository.save(entity);
        entity.setPlayer(login);
        Board board = new Board(entity.getName());
        this.hashMap.put(entity.getName(), board);
        logger.info("Created game {}@{}",entity.getName(), board.hashCode());
        return new GameDTO(entity, board);
    }

    public GameDTO createGame() {
        String login = SecurityUtils.getCurrentUserLogin().orElse("Anonymous");
        return createGame(generator.getAlphaNumericString(10), login);
    }

    @Override
    protected void beforeCreate(Game entity) {
        super.beforeCreate(entity);

        // Check if email already exists
        String name = entity.getName();
        Game room = this.gameRepository.findFirstByName(name);
        if (room != null) {
            throw new NameAlreadyExistedException();
        }
    }

    public GameDTO gameInformation(String name) {
        Game entity = this.gameRepository.findByNameIgnoreCase(name);
        if (entity == null) {
            return null;
        }
        return new GameDTO(entity, this.hashMap.get(name)!=null?this.hashMap.get(name):new Board(name));
    }

    public Optional<Game> gameDetails(String name) {
        return gameRepository.findByName(name);
    }

    public void deleteAll() {
        this.gameRepository.deleteAll();
    }

    public GameDTO updateGameState(String name, Piece piece) {
        GameDTO entityDTO = gameInformation(name);
        if (entityDTO == null) {
            throw new GameNotFoundException(name);
        }
        String login = SecurityUtils.getCurrentUserLogin().orElse("Anonymous");
        if ( login.equals("Anonymous") || !(entityDTO.isPlayer(login)) ) {
            throw new UnauthorizedUserException();
        }
        entityDTO.getBoard().setPiece(piece);
        return entityDTO;
    }

    public Optional<Game> leave(String name) {
        Optional<Game> game = gameDetails(name);
        game.ifPresent(this::unSetPlayer);
        return game;
    }

    private void unSetPlayer(@NotNull Game game) {
        String login = SecurityUtils.getCurrentUserLogin().orElse("Anonymous");
        game.removePlayer(login);
    }


}
