package co.edu.cue.proyectofinalcorte3.controller;

import co.edu.cue.proyectofinalcorte3.HelloApplication;
import co.edu.cue.proyectofinalcorte3.controller.hilos.HilosA;
import co.edu.cue.proyectofinalcorte3.controller.hilos.HilosB;
import co.edu.cue.proyectofinalcorte3.exeptions.AllExeption;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginViewController implements Initializable {

    ModelFactoryController mfc= ModelFactoryController.getInstance();
    private Stage stage;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private TextField userNameInput;

    @FXML
    void changeView(ActionEvent event) throws IOException {
        String username = userNameInput.getText();
        String password = passwordInput.getText();
        boolean b = AllExeption.validatorLogin1(username, password);
        if (b) {
            boolean a = mfc.login(username, password);
            if (a) {
                System.out.println("Usuario y contraseña valida");
                HelloApplication.mainViews(event);
            }else {
                AllExeption.passwordAlert();
            }
        }
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Thread hilo2 = new Thread(new HilosB());
        hilo2.start();
        HilosA hilo1 = new HilosA();
        hilo1.start();
    }
}
