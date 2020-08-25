package vn.tphan.jhipster.neutron.models;


import vn.tphan.jhipster.core.Constants;
import vn.tphan.jhipster.core.Constants.*;

public class Piece {
    private Color color;
    private Integer x;
    private Integer y;

    public Piece() {

    }

    public Piece(Color color, Integer x, Integer y, Integer id) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;

    public Constants.Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

//    public Pair<Integer, Integer> getXY() {
//        return new Pair<>(this.x, this.y);
//    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Piece{" +
            "color=" + color +
            ", x=" + x +
            ", y=" + y +
            ", id=" + id +
            '}';
    }

}
