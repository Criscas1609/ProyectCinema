package co.edu.cue.proyectofinalcorte3.service.impl;

import co.edu.cue.proyectofinalcorte3.model.Client;
import co.edu.cue.proyectofinalcorte3.model.ClientDTO;
import co.edu.cue.proyectofinalcorte3.service.ClientService;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClientServiceImpl implements ClientService {
    public List<Client> listClients = new ArrayList<Client>();

    public List<Client> getListClients() {
        return listClients;
    }

    Client clientAux;

    public void addClient(String name, String id, String lastName, String birthday, String phoneNumber, String address, ObservableList<Client> clientsView, TableView<Client> tblClient) {
        clientAux = new Client(name, id, lastName, birthday, phoneNumber, address);
        listClients.add(clientAux);
        clientsView.add(clientAux);
        tblClient.setItems(clientsView);
        tblClient.refresh();
    }
    public void selectClient(TextField nameClient, TextField lastName, TextField idClient, TextField phoneCliente, TextField emailCliente, DatePicker birthday,ObservableList<Client> clientsView, TableView<Client> tblClient){
    clientAux = tblClient.getSelectionModel().getSelectedItem();
    fillInput(nameClient, lastName, idClient, phoneCliente, emailCliente, birthday);
    }
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
    public void deleteClient(ObservableList<Client> clientsView, TableView<Client> tblClient){
        if (clientAux == null){
            System.out.println("Debe de tener un cliente seleccionado");
        }else{
            clientsView.remove(clientAux);
            listClients.remove(clientAux);
            tblClient.refresh();
        }
    }
    public void editClient(ObservableList<Client> clientsView, TableView<Client> tblClient,Client aux){
        if (clientAux == null){
            System.out.println("Debe de tener un cliente seleccionado");
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



    /*public void fillTable(Client aux) {
        client.setName(aux.getName());
        client.setLastName(aux.getLastName());
        client.setId(aux.getId());
        client.setPhoneNumber(aux.getPhoneNumber());
        client.setAddress(aux.getAddress());
        client.setBirthday(aux.getBirthday());
    }*/


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



    }





