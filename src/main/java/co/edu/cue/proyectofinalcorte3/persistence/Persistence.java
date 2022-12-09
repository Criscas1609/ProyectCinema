package co.edu.cue.proyectofinalcorte3.persistence;

import co.edu.cue.proyectofinalcorte3.model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistence {
    public static final String RUTA_ARCHIVO_MOVIE1 = "src/main/java/co/edu/cue/proyectofinalcorte3/utilities/movie1.txt";
    public static final String RUTA_ARCHIVO_MOVIE2 = "src/main/java/co/edu/cue/proyectofinalcorte3/utilities/movie2.txt";
    public static final String RUTA_ARCHIVO_MOVIE3 = "src/main/java/co/edu/cue/proyectofinalcorte3/utilities/movie3.txt";
    public static final String RUTA_ARCHIVO_MOVIE4 = "src/main/java/co/edu/cue/proyectofinalcorte3/utilities/movie4.txt";
    public static final String RUTA_ARCHIVO_DETAIL = "src/main/java/co/edu/cue/proyectofinalcorte3/utilities/detail.txt";
    public static final String RUTA_ARCHIVO_CLIENT = "src/main/java/co/edu/cue/proYectofinalcorte3/utilities/client.txt";

    static ArrayList<String> contenido;

    //Cliente

    public static void saveClient(ArrayList<Client> listClient) throws IOException {
        String contenido = "";

        for(Client clients: listClient) {
            contenido+= clients.getName()+"@"+clients.getId()+"@"+clients.getPhoneNumber()+"@"+
                    clients.getBirthday()+"@"+clients.getLastName()+"@"+clients.getAddress()+"\n";
        }

        UsefulFile.saveFile(RUTA_ARCHIVO_CLIENT, contenido, false);

    }

    public static ArrayList<Client> loadClients() throws FileNotFoundException, IOException {

        ArrayList<Client> clients = new ArrayList<Client>();
        contenido = UsefulFile.leerArchivo(RUTA_ARCHIVO_CLIENT);
        String linea = "";
        if(contenido.size() !=0) {
            for (String lista : contenido) {
                Client client = new Client();
                linea = lista;
                client.setName(linea.split("@")[0]);
                client.setId(linea.split("@")[1]);
                client.setPhoneNumber(linea.split("@")[2]);
                client.setBirthday(linea.split("@")[3]);
                client.setLastName(linea.split("@")[4]);
                client.setAddress(linea.split("@")[5]);
                clients.add(client);
            }
        }
        return clients;
    }




    //Películas
    public static void saveMovie(ArrayList<Ticket> movie,String movies) throws IOException {
        String contenido = "";

        for(Ticket chair: movie) {
            contenido+= chair.getChair()+"@"+chair.getPrice()+"\n";
        }
        validatorSave(movies,contenido);
    }



    public static ArrayList<Ticket> cargarClientes(String movies) throws FileNotFoundException, IOException {

        ArrayList<Ticket> movie = new ArrayList<Ticket>();
        validatorLoad(movies);
        String linea = "";
        if(contenido.size() !=0) {
            for (String lista : contenido) {
                Ticket chair = new Ticket();
                linea = lista;
                chair.setChair(linea.split("@")[0]);
                chair.setPrice(Double.parseDouble(linea.split("@")[1]));
                movie.add(chair);
            }
        }
        return movie;
    }

    public static void validatorLoad(String movies) throws IOException {
        switch (movies){
            case "Wakanda por siempre":
                contenido = UsefulFile.leerArchivo(RUTA_ARCHIVO_MOVIE1);
                break;
            case "Strange world":
                contenido = UsefulFile.leerArchivo(RUTA_ARCHIVO_MOVIE2);
                break;
            case "Black Adam":
                contenido = UsefulFile.leerArchivo(RUTA_ARCHIVO_MOVIE3);
                break;
            case "Avatar 2":
                contenido = UsefulFile.leerArchivo(RUTA_ARCHIVO_MOVIE4);
                break;
        }
    }

    public static void validatorSave(String movies,String contenido) throws IOException {
        switch (movies){
            case "Wakanda por siempre":
                UsefulFile.saveFile(RUTA_ARCHIVO_MOVIE1, contenido, false);
                break;
            case "Strange world":
                UsefulFile.saveFile(RUTA_ARCHIVO_MOVIE2, contenido, false);
                break;
            case "Black Adam":
                UsefulFile.saveFile(RUTA_ARCHIVO_MOVIE3, contenido, false);
                break;
            case "Avatar 2":
                UsefulFile.saveFile(RUTA_ARCHIVO_MOVIE4, contenido, false);
                break;
        }
    }




}
