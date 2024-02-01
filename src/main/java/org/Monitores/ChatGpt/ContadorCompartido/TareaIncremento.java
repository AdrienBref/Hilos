package org.Monitores.ChatGpt.ContadorCompartido;

public class TareaIncremento implements Runnable{
    private Contador contador;


    public TareaIncremento(Contador contador) {
        this.contador = contador;
        
        
    }

    @Override
    public void run() {
        while (true) { // Ejecución infinita
            contador.incrementar();
        }
    }
}
