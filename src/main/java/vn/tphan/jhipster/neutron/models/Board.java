package vn.tphan.jhipster.neutron.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import static vn.tphan.jhipster.core.Constants.*;

public class Board {
    private ArrayList<Piece> bluePieces = new ArrayList<>();
    private ArrayList<Piece> redPieces = new ArrayList<>();
    private String name;
    private String player;

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    @JsonIgnore
    private Integer i = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Board(String name) {
        this.name = name;
        for (i = 0; i<BOARD_SIZE; i++) {
            bluePieces.add(new Piece(Color.BLUE, i, BLUE_STARTING_POSITION, i+BLUE_STARTING_POSITION));
            redPieces.add(new Piece(Color.RED, i, RED_STARTING_POSITION, i+RED_STARTING_POSITION));
        }
    }

    public List<Piece> getBluePieces() {
        return bluePieces;
    }

/*
    public void setBluePieces(ArrayList<Piece> bluePieces) {
        this.bluePieces = bluePieces;
    }
*/

    public List<Piece> getRedPieces() {
        return redPieces;
    }

/*
    public void setRedPieces(ArrayList<Piece> redPieces) {
        this.redPieces = redPieces;
    }
*/
    public Piece getPieceWithId(Integer id) {
        return id > BLUE_STARTING_POSITION ? bluePieces.get(id - BLUE_STARTING_POSITION) : redPieces.get(id - RED_STARTING_POSITION);
    }

    public void setPiece(Piece updated) {
        Piece piece = getPieceWithId(updated.getId());
        piece.setX(updated.getX());
        piece.setY(updated.getY());
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Board)) {
            return false;
        }
        return this.name.equals( ((Board)obj).getName() );
    }
}
