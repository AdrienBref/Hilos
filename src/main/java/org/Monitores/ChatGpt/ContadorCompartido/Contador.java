package org.Monitores.ChatGpt.ContadorCompartido;

public class Contador {
    private int cuenta = 0;

    // Método sincronizado para incrementar el contador
    public synchronized void incrementar() {
        cuenta++;
    }

    // Método para obtener el valor actual del contador
    public synchronized int getValor() {
        return cuenta;
    }
}