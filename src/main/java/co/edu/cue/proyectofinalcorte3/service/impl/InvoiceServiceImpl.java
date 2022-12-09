package co.edu.cue.proyectofinalcorte3.service.impl;

import co.edu.cue.proyectofinalcorte3.model.*;
import co.edu.cue.proyectofinalcorte3.service.InvoiceService;
import co.edu.cue.proyectofinalcorte3.service.SellService;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class InvoiceServiceImpl implements InvoiceService {
    ArrayList<Client> listClients;
    ArrayList<Detail> detailList;
    double totalPrice;

    public void getList() {
        detailList = SellServiceImpl.getDetailList();
        listClients = ClientServiceImpl.getListClients();
    }

    public void informationMovie(Label movie,Label information) {
        getList();
        for (Detail detail : detailList) {
            movie.setText(
                    "Factura\n" +
                            "Película: " + detail.getMovie() + "\n" +
                            "Cliente: " + detail.getClient().getName() + "\n"
            );
            loadTickets(movie,detail.getClientSeat());
            loadFood(movie,detail.getFoodList());
            compareClient(detail.getClient(),information);
            movie.setText("\n"+movie.getText() + "Precio total: " + totalPrice);
            totalPrice = 0;
        }
    }


    public void loadTickets(Label movie, ArrayList<Ticket> clientSeat) {
        for (Ticket ticket : clientSeat) {
            movie.setText(movie.getText() + "sillas: " + ticket.getChair() + " Precio :" + ticket.getPrice() + "\n"
            );
            totalPrice += ticket.getPrice();
        }
    }

    public void loadFood(Label movie,ArrayList<Food> foodList){
        if (foodList.size() != 0) {
            for (Food food : foodList) {
                movie.setText(movie.getText() +
                        "Producto: " + food.getFood() + " Precio: " + food.getFoodPrice() + "\n"
                );
                totalPrice += food.getFoodPrice();
            }
        } else {
            movie.setText(movie.getText() + "No Hay comida" + "\n");
        }
    }

    //Comparador de cliente registrado
    public void compareClient(Person client,Label information){
        for(Client clients: listClients){
            if(clients.getId().equals(client.getId()) && clients.getName().equals(client.getName())){
                totalPrice = totalPrice - (totalPrice*(0.1));
                information.setText("Información del cliente: \n"+
                        "Nombre: "+clients.getName()+"\n"+
                        "ID: "+clients.getId()+"\n"+
                        "Numero de teléfono: "+clients.getPhoneNumber()+"\n"+"\n"+
                        "Obtuvo el descuento de miembro"
                        );
                break;
            }else {
                information.setText("Información del cliente: \n"+
                        "El cliente "+client.getName()+" no esta registrado y por eso no obtendrá el descuento de miembro");
            }
        }
    }







}


