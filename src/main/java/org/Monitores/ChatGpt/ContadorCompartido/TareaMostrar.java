package org.Monitores.ChatGpt.ContadorCompartido;

public class TareaMostrar implements Runnable{

    private Contador contador;

    public TareaMostrar(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        while (true) { // Ejecución infinita
            try {
                Thread.sleep(1000); // Espera 1 segundo antes de mostrar el valor
                System.out.println("Valor del contador: " + contador.getValor());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Hilo interrumpido");
                return;
            }
        }
    }
}
