package co.edu.cue.proyectofinalcorte3.service.impl;

import co.edu.cue.proyectofinalcorte3.exeptions.AllExeption;
import co.edu.cue.proyectofinalcorte3.model.Client;
import co.edu.cue.proyectofinalcorte3.model.ClientDTO;
import co.edu.cue.proyectofinalcorte3.persistence.Persistence;
import co.edu.cue.proyectofinalcorte3.service.ClientService;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClientServiceImpl implements ClientService {
    private static ArrayList<Client> listClients = new ArrayList<Client>();

    public static ArrayList<Client> getListClients() {
        return listClients;
    }

    Client clientAux;

    //Función que crea un nuevo cliente y lo añade a la lista y actualiza para que se muestre en la tabla
    public void addClient(String name, String id, String lastName, String birthday, String phoneNumber, String address, ObservableList<Client> clientsView, TableView<Client> tblClient) {
        clientAux = new Client(name, id, lastName, birthday, phoneNumber, address);
        listClients.add(clientAux);
        clientsView.add(clientAux);
        tblClient.setItems(clientsView);
        tblClient.refresh();
    }

    //Esta función permite acceder a los datos de la tabla y los pone en los inputs
    public void selectClient(TextField nameClient, TextField lastName, TextField idClient, TextField phoneCliente, TextField emailCliente, DatePicker birthday,ObservableList<Client> clientsView, TableView<Client> tblClient){
        try {
        clientAux = tblClient.getSelectionModel().getSelectedItem();
        fillInput(nameClient, lastName, idClient, phoneCliente, emailCliente, birthday);
        }catch (Exception e){
            AllExeption.errorAlert();
        }
    }

    //Funciones auxiliares
    public void fillInput(TextField nameClient, TextField lastName, TextField idClient, TextField phoneCliente, TextField emailCliente, DatePicker birthday){
        nameClient.setText(clientAux.getName());
        lastName.setText(clientAux.getLastName());
        idClient.setText(clientAux.getId());
        phoneCliente.setText(clientAux.getPhoneNumber());
        emailCliente.setText(clientAux.getAddress());
        birthday.setValue(LocalDate.parse(clientAux.getBirthday()));
    }

    public void showTbl(ObservableList<Client> clientsView, TableView<Client> tblClient){
        clientsView.clear();
        for(Client client: listClients){
            clientsView.add(client);
            tblClient.setItems(clientsView);
            tblClient.refresh();
        }
    }

    //Esta función permite eliminar al cliente y actualizar la tabla
    public void deleteClient(ObservableList<Client> clientsView, TableView<Client> tblClient){
        if (clientAux == null){
            AllExeption.selectClientAlert();
        }else{
            clientsView.remove(clientAux);
            listClients.remove(clientAux);
            tblClient.refresh();
        }
    }
    public void editClient(ObservableList<Client> clientsView, TableView<Client> tblClient,Client aux){
            if (clientAux == null){
                AllExeption.selectClientAlert();
            }else {
                editList(aux);
                showTbl(clientsView,tblClient);
            }

    }
    public void search(TableView<Client> tblClient, String search){
        for (Client client : listClients){
            if(client.getName().equals(search) || client.getId().equals(search) || client.getPhoneNumber().equals(search)){
                tblClient.getSelectionModel().select(client);
                tblClient.refresh();
            }
        }
    }

    public void editList(Client aux){
        for (Client client : listClients){
            if(client == clientAux){
                client.setName(aux.getName());
                client.setLastName(aux.getLastName());
                client.setId(aux.getId());
                client.setPhoneNumber(aux.getPhoneNumber());
                client.setAddress(aux.getAddress());
                client.setBirthday(aux.getBirthday());
            }
        }
    }

    //Persistencia
    public void loadClients() {
        try {
            listClients = Persistence.loadClients();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveClients() {
        try {
            Persistence.saveClient(listClients);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    //


    public Stream<Client> search(String name){
        return listClients.stream()
                .filter(c-> name.equalsIgnoreCase(c.getName()))
                .limit(1);
    }

    //retorna una lista con el DTOs
    public List<ClientDTO> generateListDTOs(){
        return  listClients.stream()
                .map(client-> new ClientDTO(client.getName(),client.getBirthday()))
                .collect(Collectors.toList());
    }

    public void stringId(ArrayList<String> idlist){
        for(Client client: listClients){
            idlist.add(client.getId());
        }
    }

    public void showClients(Label clientLabel){
        clientLabel.setText(String.valueOf(listClients.size()));
    }



    }





