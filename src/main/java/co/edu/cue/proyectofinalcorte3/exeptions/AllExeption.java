package co.edu.cue.proyectofinalcorte3.exeptions;

import co.edu.cue.proyectofinalcorte3.model.Ticket;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.Objects;

public class AllExeption {

    //Login
    public static boolean validatorLogin1(String username, String password){
        if(Objects.equals(username, "") || Objects.equals(password, "")){
            errorAlert();
            return false;
        }
        return true;
    }

    //Venta
    public static boolean validator1(ArrayList<Ticket> movie, Ticket ticket){
        for (Ticket movies : movie) {
            if (Objects.equals(movies.getChair(), ticket.getChair())) {
                chairAlert();
                return true;
            }
        }
        return false;
    }
    public static boolean validator2(ArrayList<Ticket> clientSeat){
        if (clientSeat.size()>=2){
            ticketAlert();
            return true;
        }
        return false;
    }

    //Alertas
    public static void errorAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("Llene todos los campos");
        alert.showAndWait();
    }

    public static void passwordAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("Usuario o contraseña incorrecta");
        alert.showAndWait();
    }
    public static void dateAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("Eres muy joven para ser miembro");
        alert.showAndWait();
    }
    public static void chairAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("Silla ya ocupada");
        alert.showAndWait();
    }
    public static void ticketAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("Solo 2 boletas por Cliente");
        alert.showAndWait();
    }
    public static void selectClientAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("Debe seleccionar un cliente");
        alert.showAndWait();
    }

    //Cliente
    public static boolean fieldClient(String name, String id, String lastName, String birthday, String phoneNumber, String address){
        if (Objects.equals(name, "") || Objects.equals(lastName, "") || Objects.equals(birthday, "")
                || Objects.equals(phoneNumber, "") || Objects.equals(address,"")){
            errorAlert();
            return false;
        }
        return true;
    }
    public static boolean birthday(String birthday){
        try {
        if(!Objects.equals(birthday, "")) {
            String[] date = birthday.split("-");
            double year = Double.parseDouble(date[0]);
            if (year > 2004) {
                dateAlert();
                return false;
            }
            return true;
        }
        return false;
        }catch (NumberFormatException e){
            return false;
        }

    }

    //Venta
    public static boolean inputSell(String member, String id,String name){
        if(Objects.equals(member, "")){
            if (Objects.equals(id, "") && Objects.equals(name, "")) {
                errorAlert();
                return false;
            }
        }
        return true;
    }


}
