package co.edu.cue.proyectofinalcorte3.controller.hilos;

import co.edu.cue.proyectofinalcorte3.controller.ModelFactoryController;

public class HilosB implements Runnable{
    ModelFactoryController mfc= ModelFactoryController.getInstance();
    @Override
    public void run() {
        try {
            mfc.loadPersistence();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
