package org.Monitores.ChatGpt.ContadorCompartido;

public class Main {
    public static void main(String[] args) {
        Contador contador = new Contador();

        // Crear e iniciar hilos de incremento
        Thread[] hilos = new Thread[10];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(new TareaIncremento(contador));
            hilos[i].start();
        }

        try {
            Thread.sleep(100); // Pausa de 100 milisegundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Crear e iniciar hilo para mostrar el valor del contador
        Thread hiloMostrar = new Thread(new TareaMostrar(contador));
        hiloMostrar.start();
    }
}

