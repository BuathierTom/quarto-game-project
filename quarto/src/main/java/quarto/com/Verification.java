package quarto.com;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;

public class Verification {

    public static boolean checkWin(List<Button> plateau, List<Piece> pieces) {
        // Vérifie les lignes
        for (int i = 0; i < 16; i += 4) {
            System.out.println("lignes");
            if (checkLine(plateau, pieces, i, i + 1, i + 2, i + 3)) {
                System.out.println("lignes dans if");
                return true;
            }
        }
        // Vérifie les colonnes
        for (int i = 0; i < 4; i++) {
            System.out.println("colonione");
            if (checkLine(plateau, pieces, i, i + 4, i + 8, i + 12)) {
                System.out.println("colonione dans if");
                return true;
            }
        }
        // Vérifie les diagonales
        System.out.println("diagolianes");
        if (checkLine(plateau, pieces, 0, 5, 10, 15) || checkLine(plateau, pieces, 3, 6, 9, 12)) {
            System.out.println("diagolianes dans if");
            return true;
        }
        return false;
    }

    private static boolean checkLine(List<Button> plateau, List<Piece> pieces, int i1, int i2, int i3, int i4) {
        System.out.println("I1 "+i1);
        System.out.println("I2 "+i2);
        System.out.println("I3 "+i3);
        System.out.println("I4 "+i4);

        Button p1 = plateau.get(i1);
        Button p2 = plateau.get(i2);
        Button p3 = plateau.get(i3);
        Button p4 = plateau.get(i4);

        Piece pi1 = new Piece(false, false, false, false);
        Piece pi2 = new Piece(false, false, false, false);
        Piece pi3 = new Piece(false, false, false, false);
        Piece pi4 = new Piece(false, false, false, false);


        for (Piece piece : pieces) {
            if ((piece.toString()).equals(p1.getText())) {
                pi1 = new Piece(piece);
            }else if ((piece.toString()).equals(p2.getText())) {
                pi2 = new Piece(piece);
            }else if ((piece.toString()).equals(p3.getText())) {
                pi3 = new Piece(piece);
            }else if ((piece.toString()).equals(p4.getText())) {
                pi4 = new Piece(piece);
            }
        }
        System.out.println("P1 ---------> " + pi1);
        System.out.println("P2 ---------> " + pi2);
        System.out.println("P3 ---------> " + pi3);
        System.out.println("P4 ---------> " + pi4);

        
        if ((pi1.estRond() == true && pi2.estRond() == true) && (pi2.estRond() == true && pi3.estRond() == true) && (pi3.estRond() == true && pi4.estRond()== true)) {
            System.out.println("rond");
            return true;
        }else if ((pi1.estPetit() == true && pi2.estPetit() == true) && (pi2.estPetit() == true && pi3.estPetit() == true) && (pi3.estPetit() == true && pi4.estPetit()== true)) {
            System.out.println("petit");
            return true;
        }else if ((pi1.estCreux() == true && pi2.estCreux() == true) && (pi2.estCreux() == true && pi3.estCreux() == true) && (pi3.estCreux() == true && pi4.estCreux()== true)) {
            System.out.println("creux");
            return true;
        }else if ((pi1.estBlanc() == true && pi2.estBlanc()== true) && (pi2.estBlanc() == true && pi3.estBlanc()== true) && (pi3.estBlanc() == true && pi4.estBlanc() == true)) {
            System.out.println("blanc");
            return true;
        }
        return false;
    }

}

