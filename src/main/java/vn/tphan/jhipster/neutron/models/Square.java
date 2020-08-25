package vn.tphan.jhipster.neutron.models;

public class Square {
    private Piece piece;

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Square(Piece piece) {
        this.piece = null;
    }
}
