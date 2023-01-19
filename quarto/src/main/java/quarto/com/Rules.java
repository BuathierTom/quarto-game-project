/* Imports */
package quarto.com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Rules{

    /**
     * Va chercher les regles dans le fichier texte et afficher ligne par ligne le texte  
     * @return Une liste de String avec chaque ligne du fichier "regle.txt"
     */
    public static ArrayList<String> placeRules() throws FileNotFoundException{
        // Récuperation du fichier texte de rules
        InputStream regle = new FileInputStream("../regle.txt");
        Scanner obj = new Scanner(regle);
        ArrayList<String> res = new ArrayList<>() ;
        // Je lis chaque ligne du fichier règles
        while (obj.hasNextLine()) {
            res.add(obj.nextLine());
        }
        obj.close();
        return res;
    }

    /**
     * Créé une fenetre avec les regles affichées dedans grace a la fonction créé juste avant
     * @param mainWindow La fenêtre créé dans plateau.java et passer en parametre
     * @return un stage et qui est affichable dans la classe plateau.java
     */
    public static Stage windowRules(Stage mainWindow){
        /* Liste de String qui va contenir toutes les règles */
        ArrayList<String> rules = new ArrayList<>();
                try {
                    rules = placeRules();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                
                /* On créé le layout */
                VBox secondaryLayout = new VBox();
                Label secondLabel = new Label();

                /* For each qui va rechercher tous les éléments dans la list créé */
                for (String string : rules) {
                    secondLabel = new Label(string);
                    secondaryLayout.getChildren().add(secondLabel);
                }
                /* Affichage des regles */
                Scene secondScene = new Scene(secondaryLayout, 920, 740);

				/* Definition d'une nouvelle fenêtre */
				Stage rulesWindow = new Stage();
                rulesWindow.getIcons().add(new Image("Rules_logo.jpg"));
				rulesWindow.setTitle("REGLES");
				rulesWindow.setScene(secondScene);

                /* Permettre que la fenêtre doit se fermer pour pouvoir acceder a l'ancienne fenetre */
                rulesWindow.initModality(Modality.WINDOW_MODAL);
                rulesWindow.initOwner(mainWindow);

                /* On return la fenêtre créé */
                return rulesWindow;
    }
}