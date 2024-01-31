package org.Monitores.ChatGpt.ContadorCompartido;

public class IncCounter extends Thread {
    
    private IncShowCounter genCounterNums;
    
    public IncCounter(IncShowCounter genCounterNums) {
        this.genCounterNums = genCounterNums;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            genCounterNums.incrementCounter();
        }
    }
}
