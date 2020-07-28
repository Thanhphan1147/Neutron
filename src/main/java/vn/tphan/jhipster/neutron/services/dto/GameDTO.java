package vn.tphan.jhipster.neutron.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.javers.core.metamodel.annotation.DiffIgnore;
import vn.tphan.jhipster.neutron.models.Board;
import vn.tphan.jhipster.neutron.models.Game;

import java.util.Objects;

public class GameDTO {
    private final Board board;
    private final Long id;
    private final String name;
    private final String playerOne;
    private final String playerTwo;
    private Long created;
    @DiffIgnore
    private Long updated;
    private String createdBy;

    public Board getBoard() {
        return board;
    }

    public String getName() {
        return name;
    }

    public String getPlayerOne() {
        return playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @DiffIgnore
    private String updatedBy;
    private Game game;

    public GameDTO(Game game, Board board) {
        this.board = board;
        this.id = game.getId();
        this.name = game.getName();
        this.playerOne = game.getPlayerOne();
        this.playerTwo = game.getPlayerTwo();
        this.created = game.getCreated();
        this.createdBy = game.getCreatedBy();
        this.updated = game.getUpdated();
        this.createdBy = game.getUpdatedBy();
    }

    @Override
    public String toString() {
        return "GameDTO{" +
            "board=" + board +
            ", id=" + id +
            ", name='" + name + '\'' +
            ", playerOne='" + playerOne + '\'' +
            ", playerTwo='" + playerTwo + '\'' +
            ", created=" + created +
            ", updated=" + updated +
            ", createdBy='" + createdBy + '\'' +
            ", updatedBy='" + updatedBy + '\'' +
            ", game=" + game +
            '}';
    }

    @JsonIgnore
    public boolean isPlayer(String player) {
        return player.equals(playerOne) || player.equals(playerTwo);
    }
}
