module quarto {
    requires javafx.controls;
    requires javafx.fxml;

    opens quarto to javafx.fxml;
    exports quarto;
}
