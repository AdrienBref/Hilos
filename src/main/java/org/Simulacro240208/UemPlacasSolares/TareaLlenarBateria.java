package org.Simulacro240208.UemPlacasSolares;

import org.Monitores.ChatGpt.CuentaBancaria.TareaRetirar;

public class TareaLlenarBateria extends Thread{
    
    Bateria monitor;
    
    public TareaLlenarBateria(Bateria monitor) {
        this.monitor = monitor;
    }
    @Override
    public void run() {
        super.run();
    }
}
