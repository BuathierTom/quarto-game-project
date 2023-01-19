package quarto.com;

public class Piece {
    // Valeurs des pièces
    private boolean estRond;
    private boolean estPetit;
    private boolean estCreux;
    private boolean estBlanc;

    /**
     * Constructeur par défaut
     * @param estRond true ou false
     * @param estPetit true ou false
     * @param estCreux true ou false
     * @param estBlanc true ou false
     */
    public Piece(boolean estRond, boolean estPetit, boolean estCreux, boolean estBlanc) {
        this.estRond = estRond;
        this.estPetit = estPetit;
        this.estCreux = estCreux;
        this.estBlanc = estBlanc;
    }

    /**
     * Constructeur par recopie
     * @param p 
     */
    public Piece(Piece p){
        this.estRond = p.estRond;
        this.estPetit = p.estPetit;
        this.estCreux = p.estCreux;
        this.estBlanc = p.estBlanc;
    }

    /*
     * Return true ou false en fonction de si la piece est ronde ou pas.
     */
    public boolean estRond() {
        return estRond;
    }

    /*
     * Return true ou false en fonction de si la piece est petite ou pas.
     */
    public boolean estPetit() {
        return estPetit;
    }

    /*
     * Return true ou false en fonction de si la piece est creuse ou pas.
     */
    public boolean estCreux() {
        return estCreux;
    }

    /*
     * Return true ou false en fonction de si la piece est blanche ou pas.
     */
    public boolean estBlanc() {
        return estBlanc;
    }

    /*
     * Permet l'appel des pieces avec leurs caractéristiques en les séparent d'un "_"
     * Exemple : Rond_Court_Creux_Blanc
     */
    public String toString() {
        return (estRond ? "Rond" : "Carre") + "_" + (estPetit ? "Court" : "Long") + "_" + (estCreux ? "Creux" : "Plein") + "_" + (estBlanc ? "Blanc" : "Noir");
    }
}

