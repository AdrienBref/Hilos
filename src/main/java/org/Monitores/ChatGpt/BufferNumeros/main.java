package org.Monitores.ChatGpt.BufferNumeros;

import javax.xml.stream.events.StartDocument;

import static java.lang.Thread.sleep;

public class main {

    public static void main(String[] args) {

        GenShift_Numbers genShiftNumbers = new GenShift_Numbers();
        
        try {
            new GenerateNumber(genShiftNumbers).start();
            sleep(300);
            new ShiftNumber(genShiftNumbers).start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    
}
