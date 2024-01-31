package org.Monitores.ChatGpt.BufferNumeros;

import static java.lang.Thread.sleep;

public class GenerateNumber extends Thread{
    
    GenShift_Numbers genShiftNumbers;
    
    public GenerateNumber(GenShift_Numbers genShiftNumbers) {
        this.genShiftNumbers = genShiftNumbers;
    }
    @Override
    public void run() {
        while(true) {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            genShiftNumbers.bufferNumbers();
        }
    }
}
