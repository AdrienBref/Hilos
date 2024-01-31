package org.Monitores.ChatGpt.ContadorCompartido;

public class ShowCounter extends Thread {
    
    private IncShowCounter incShowCounter;
    
    public ShowCounter(IncShowCounter incShowCounter) {
        
        this.incShowCounter = incShowCounter;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            incShowCounter.showCounter();
        }
    }
}
