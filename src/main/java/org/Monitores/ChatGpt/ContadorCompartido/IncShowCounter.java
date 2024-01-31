package org.Monitores.ChatGpt.ContadorCompartido;

public class IncShowCounter {
    private int counter;
    private static int numeroHilo;
    private boolean ShowingNumber;
    
    public IncShowCounter() {
        numeroHilo++;
        ShowingNumber = false;
        counter = 0;
    }
    
    public synchronized void incrementCounter()  {
        if(!ShowingNumber) {
            try {
                System.out.println("Hilo numero " + numeroHilo + " incrmenta");
                counter++;
                ShowingNumber = true;
                notifyAll();
                wait();
                
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        
    }
    
    public synchronized void showCounter() {
        try {
            if(ShowingNumber) {
                System.out.println("El Contador va por -> " + counter);
                ShowingNumber = false;
                notifyAll();
                wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
