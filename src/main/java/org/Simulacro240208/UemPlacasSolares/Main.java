package org.Simulacro240208.UemPlacasSolares;

public class Main {
    
    public static void main(String[] args) {
        Bateria monitor = new Bateria();
        TareaLlenarBateria tareaLlenarBateria = new TareaLlenarBateria(monitor);
        TareaVaciarBateria tareaVaciarBateria = new TareaVaciarBateria(monitor);
        
        tareaLlenarBateria.start();
        tareaVaciarBateria.start();
    }
}
