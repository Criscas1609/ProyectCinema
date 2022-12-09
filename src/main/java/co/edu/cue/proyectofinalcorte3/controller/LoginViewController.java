package co.edu.cue.proyectofinalcorte3.controller;
import co.edu.cue.proyectofinalcorte3.HelloApplication;
import co.edu.cue.proyectofinalcorte3.controller.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginViewController {

    ModelFactoryController mfc= ModelFactoryController.getInstance();
    private Stage stage;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private TextField userNameInput;

    @FXML
    void changeView(ActionEvent event) throws IOException {
        boolean x = mfc.login(userNameInput.getText(), passwordInput.getText());
        if (x) {
            System.out.println("Usuario y contraseña valida");
            HelloApplication.mainViews(event);
        }
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
