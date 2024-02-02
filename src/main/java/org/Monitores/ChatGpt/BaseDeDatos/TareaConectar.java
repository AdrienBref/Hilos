package org.Monitores.ChatGpt.BaseDeDatos;

public class TareaConectar implements Runnable{
    
    BaseDeDatos baseDeDatos;
    
    
    private int id;
    
    public TareaConectar(BaseDeDatos baseDeDatos, int id) {
        this.baseDeDatos = baseDeDatos;
        this.id = id;
    }


    @Override
    public void run() {
        while(true) {
            baseDeDatos.conectar(id);
        }
    }
}
