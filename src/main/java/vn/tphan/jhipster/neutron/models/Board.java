package vn.tphan.jhipster.neutron.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.ArrayUtils;
import org.javers.common.collections.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.tphan.jhipster.neutron.endpoints.GameEndpoint;
import vn.tphan.jhipster.neutron.errors.IllegalMoveException;

import javax.persistence.Tuple;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static vn.tphan.jhipster.core.Constants.*;

public class Board {
    private static final Logger logger = LoggerFactory.getLogger(GameEndpoint.class);
    private ArrayList<Piece> bluePieces = new ArrayList<>();
    private ArrayList<Piece> redPieces = new ArrayList<>();
    private Integer[][] board = {
        {1, 1, 1, 1, 1},
        {0, 0, 0, 0, 0},
        {0, 0, 3, 0, 0},
        {0, 0, 0, 0, 0},
        {2, 2, 2, 2, 2}
    };
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
    @JsonIgnore
    private Integer j = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Board(String name) {
        Piece red, blue;
        this.name = name;
        for (i = 0; i<BOARD_SIZE; i++) {
            bluePieces.add(new Piece(Color.BLUE, i, BLUE_STARTING_POSITION, i+BLUE_STARTING_POSITION + 1));
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
        return id > BLUE_STARTING_POSITION ? bluePieces.get(id - BLUE_STARTING_POSITION - 1) : redPieces.get(id - RED_STARTING_POSITION);
    }

    public Integer bitMapGet(Integer x, Integer y) {
        return this.board[y][x];
    }

    public void bitMapSet(Integer x, Integer y, Integer value) {
        if (value <= 3 && value >= 0) {
            this.board[y][x] = value;
        }
    }

    public void setPiece(Piece updated) {
        bitMapPrint();
        Piece piece = getPieceWithId(updated.getId());
        logger.info("Move: {}{}->{}{}",piece.getX(), piece.getY(), updated.getX(),updated.getY());
        int dx = updated.getX() - piece.getX();
        int dy = updated.getY() - piece.getY();
        Pair<Integer, Integer> direction = new Pair<>(dx != 0?dx/Math.abs(dx) + updated.getX():updated.getX(), dy!=0?dy/Math.abs(dy) + updated.getY():updated.getY());
        logger.info("dx, dy : {}{} ,Direction: {}{} {}", dx, dy, direction.left(), direction.right(), checkPositionValidity(direction.left(), direction.right()));
        if (!checkLandingPositionValidity(updated.getX(), updated.getY()) || !checkPathValidity(piece, updated, dx, dy) || !checkPositionValidity(direction.left(), direction.right())) {
            throw new IllegalMoveException();
        }
        logger.info("game state : {}, target square {}",board[4], bitMapGet(updated.getX(),updated.getY()));
        bitMapSet(updated.getX(), updated.getY(), bitMapGet(piece.getX(), piece.getY()));
        bitMapSet(piece.getX(), piece.getY(), 0);
        piece.setX(updated.getX());
        piece.setY(updated.getY());
        bitMapPrint();

    }

    public boolean checkLandingPositionValidity(Integer x, Integer y) {
        if (x >= RED_STARTING_POSITION && x <= BLUE_STARTING_POSITION && y >= RED_STARTING_POSITION && y <= BLUE_STARTING_POSITION) {
            return bitMapGet(x, y) == 0;
        }
        return false;
    }

    public boolean checkPositionValidity(Integer px, Integer py) {
        if (px >= RED_STARTING_POSITION && px <= BLUE_STARTING_POSITION && py >= RED_STARTING_POSITION && py <= BLUE_STARTING_POSITION) {
            return bitMapGet(px, py) != 0;
        }
        return true;
    }

    public boolean checkDirectionValidity(int dx, int dy) {
        return dx == 0 || (dy == 0 || Math.abs(dx) == Math.abs(dy));
    }

    public boolean checkPathValidity(Piece origin, Piece target, int dx, int dy) {
        if (!checkDirectionValidity(dx, dy)) {
            return false;
        }
        Pair<Integer, Integer> path = new Pair<>(dx != 0?dx/Math.abs(dx):dx, dy!=0?dy/Math.abs(dy):dy);
        logger.info("inputs : {}{} path: {}{}",dx, dy, path.left(), path.right());
        int index;
        for (index = path.left()!=0?Math.abs(path.left()):Math.abs(path.right()); index < Math.max(Math.abs(dx), Math.abs(dy)); index++) {
            logger.info(" {},{} looking at : {},{}",index * path.left(),index * path.right(), origin.getX() + index * path.left(), origin.getY() + index * path.right());
            if (bitMapGet(origin.getX() + index * path.left(), origin.getY() + index * path.right()) != 0) {
                logger.error("obstacle on path at {}{}", origin.getX() + index * path.left(), origin.getY() + index * path.right());
                return false;
            }
        }
        return true;
    }

    private void bitMapPrint() {
        for (int index = 0; index<5; index++) {
            logger.info("{}:{}",index, board[index]);
        }
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
