package gui.testepdv;


import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import pdv.TestePDV;
import pdv.dominio.Loja;
import pdv.dominio.Registradora;
import pdv.dominio.Venda;

public class HelloController {
    @FXML
    private Label welcomeText1;

    @FXML
    private Registradora registradora;

    @FXML
    private Loja loja;

    @FXML
    private Venda venda;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText1.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private Parent root;
}