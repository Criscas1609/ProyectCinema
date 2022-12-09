package co.edu.cue.proyectofinalcorte3.service.impl;

import co.edu.cue.proyectofinalcorte3.service.*;

public class TheaterServiceImpl {

    private final ClientService clientService;
    private final LoginService loginService;
    private final SellService sellService;
    private final TicketService ticketService;

    public TheaterServiceImpl(){
        clientService = (ClientService) new ClientServiceImpl();
        loginService = (LoginService) new LoginServiceImpl();
        sellService = (SellService) new SellServiceImpl();
        ticketService = (TicketService) new TicketServiceImpl();
    }

    public ClientService getClientService() {
        return clientService;
    }

    public TicketService getTicketService() {return ticketService;}

    public SellService getSellService() {return sellService;}
    public LoginService getLoginService() {return loginService;}



}
