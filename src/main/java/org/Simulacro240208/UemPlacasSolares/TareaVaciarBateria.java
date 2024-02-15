package org.Simulacro240208.UemPlacasSolares;

public class TareaVaciarBateria extends Thread{
    
    Bateria monitor;
    
    public TareaVaciarBateria(Bateria monitor) {
        this.monitor = monitor;
    }
    @Override
    public void run() {
        super.run();
    }
}
