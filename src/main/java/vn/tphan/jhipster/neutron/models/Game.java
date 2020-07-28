package vn.tphan.jhipster.neutron.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import liquibase.pro.packaged.B;
import vn.tphan.jhipster.core.IdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "jhi_neutron_games")
public class Game extends IdEntity {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Size(min = 1, max = 10)
    @Column(length = 10, unique = true, nullable = false)
    private String name;

    public Game(@NotNull @Size(min = 1, max = 10) String name) {
        this.name = name;
    }

    public Game(){

    }

    private String playerOne;
    private String playerTwo;

    public String getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(String playerOne) {
        this.playerOne = playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(String playerTwo) {
        this.playerTwo = playerTwo;
    }

    @JsonIgnore
    public boolean isFull() {
        return playerOne != null && playerTwo != null;
    }

    public boolean isEmpty() {
        return playerOne == null && playerTwo == null;
    }

    public void setPlayer(String name) {
        if(playerOne != null) {
            this.setPlayerTwo(name);
        } else {
            this.setPlayerOne(name);
        }
    }

    public void removePlayer(String name) {
        if (name.equals(playerOne)) {
            setPlayerOne(null);
        }
        else if (name.equals(playerTwo)) {
            setPlayerTwo(null);
        }
    }
}
