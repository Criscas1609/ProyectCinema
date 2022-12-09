package co.edu.cue.proyectofinalcorte3.controller.hilos;

import co.edu.cue.proyectofinalcorte3.controller.ModelFactoryController;

public class HilosA extends Thread{
    ModelFactoryController mfc= ModelFactoryController.getInstance();

    @Override
    public void run(){
        try {
            mfc.loadClients();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
