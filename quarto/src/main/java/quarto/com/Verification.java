package quarto.com;

import java.util.ArrayList;
import java.util.List;

public class Verification {
    private Piece[][] board;
    private List<Piece> pieces;

    public Verification() {
        // Initialisation du plateau et des pièces
        board = new Piece[4][4];
        pieces = new ArrayList<>();
        // Remplissage de la liste des pièces
    }

    public boolean checkForWin() {
        // Vérifier les lignes
        for (int i = 0; i < 4; i++) {
            if (checkLine(board[i][0], board[i][1], board[i][2], board[i][3])) {
                return true;
            }
        }
        // Vérifier les colonnes
        for (int i = 0; i < 4; i++) {
            if (checkLine(board[0][i], board[1][i], board[2][i], board[3][i])) {
                return true;
            }
        }
        // Vérifier les diagonales
        if (checkLine(board[0][0], board[1][1], board[2][2], board[3][3])) {
            return true;
        }
        if (checkLine(board[0][3], board[1][2], board[2][1], board[3][0])) {
            return true;
        }
        return false;
    }

    private boolean checkLine(Piece p1, Piece p2, Piece p3, Piece p4) {
        if (p1 == null || p2 == null || p3 == null || p4 == null) {
            return false;
        }
        return (p1.estRond() == p2.estRond() && p1.estRond() == p3.estRond() && p1.estRond() == p4.estRond()) ||
                (p1.estPetit() == p2.estPetit() && p1.estPetit() == p3.estPetit() && p1.estPetit() == p4.estPetit()) ||
                (p1.estCreux() == p2.estCreux() && p1.estCreux() == p3.estCreux() && p1.estCreux() == p4.estCreux()) ||
                (p1.estBlanc() == p2.estBlanc() && p1.estBlanc() == p3.estBlanc() && p1.estBlanc() == p4.estBlanc());
    }
}
