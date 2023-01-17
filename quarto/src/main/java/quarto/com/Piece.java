package quarto.com;

public class Piece {
    private boolean estRond;
    private boolean estPetit;
    private boolean estCreux;
    private boolean estBlanc;

    public Piece(boolean estRond, boolean estPetit, boolean estCreux, boolean estBlanc) {
        this.estRond = estRond;
        this.estPetit = estPetit;
        this.estCreux = estCreux;
        this.estBlanc = estBlanc;
    }

    public boolean estRond() {
        return estRond;
    }

    public boolean estPetit() {
        return estPetit;
    }

    public boolean estCreux() {
        return estCreux;
    }

    public boolean estBlanc() {
        return estBlanc;
    }

    public String toString() {
        return (estRond ? "Rond" : "Carre") + "_" + (estPetit ? "Court" : "Long") + "_" + (estCreux ? "Creux" : "Plein") + "_" + (estBlanc ? "Blanc" : "Noir");
    }
}

