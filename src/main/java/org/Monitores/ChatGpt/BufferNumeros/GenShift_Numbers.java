package org.Monitores.ChatGpt.BufferNumeros;

import java.util.ArrayList;
import java.util.Random;

public class GenShift_Numbers {
    
    private ArrayList<Integer> bufferNumeros = new ArrayList<Integer>();
    private Random random = new Random();
    private boolean shiftingNum;
    private int bufferedNum;
    
    public GenShift_Numbers() {
        shiftingNum = false;
    }
    
    
    public int genRandNum(){
        int randNum = random.nextInt(75 - 0 + 1) + 0;
        return randNum;
    }
    
    public synchronized void bufferNumbers() {
        if(!shiftingNum) {
            bufferedNum = genRandNum();
            bufferNumeros.add(bufferedNum);
            System.out.println("Numero guardado del Buffer -> " + bufferedNum);

            try {
                shiftingNum = true;
                notifyAll();
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    public synchronized void shiftNum() {
        if(shiftingNum) {
            System.out.print("Numero en el Buffer -> ");
            for (Integer numero: bufferNumeros) {
                System.out.print(numero + ", ");
            }
            System.out.println("");
            try {
                shiftingNum = false;
                notifyAll();
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        
    }
    
}
