package org.Monitores.ChatGpt.ContadorCompartido;

import static java.lang.Thread.sleep;

public class main {
    public static void main(String[] args) {
        
        IncShowCounter incShowCounter1 = new IncShowCounter();
        IncShowCounter incShowCounter2 = new IncShowCounter();
        IncShowCounter incShowCounter3 = new IncShowCounter();
        IncShowCounter showCounter = new IncShowCounter();
        
        try {
            new IncCounter(incShowCounter1).start();
            new IncCounter(incShowCounter2).start();
            new IncCounter(incShowCounter3).start();
            sleep(200);
            new ShowCounter(showCounter);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
