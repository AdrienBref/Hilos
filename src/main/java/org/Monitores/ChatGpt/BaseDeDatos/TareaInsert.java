package org.Monitores.ChatGpt.BaseDeDatos;

public class TareaInsert implements Runnable {

    BaseDeDatos baseDeDatos;
    private int id;

    public TareaInsert(BaseDeDatos baseDeDatos, int id) {
        this.baseDeDatos = baseDeDatos;
        this.id = id;
    }
    
    @Override
    public void run() {
        while(true) {
            baseDeDatos.insert(id);
        }
    }
}
