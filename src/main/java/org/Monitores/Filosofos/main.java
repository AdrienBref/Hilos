package org.Monitores.Filosofos;

import javax.accessibility.AccessibleExtendedComponent;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) throws InterruptedException {
        
        Filosofo filosofo1;
        Filosofo filosofo2;
        Filosofo filosofo3;
        Filosofo filosofo4;
        Filosofo filosofo5;

        ArrayList <Tenedores> tenedores = new ArrayList<>() {{
            for(int i = 0; i < 5; i++){
                add(new Tenedores(i));
            }
        }};
        
        filosofo1 = new Filosofo(1, tenedores.get(0), tenedores.get(1));
        filosofo2 = new Filosofo(2, tenedores.get(1), tenedores.get(2));
        filosofo3 = new Filosofo(3, tenedores.get(2), tenedores.get(3));
        filosofo4 = new Filosofo(4, tenedores.get(3), tenedores.get(4));
        filosofo5 = new Filosofo(5, tenedores.get(4), tenedores.get(0));
        
        Thread HiloFiloso1 = new Thread(filosofo1);
        Thread HiloFiloso2 = new Thread(filosofo2);
        Thread HiloFiloso3 = new Thread(filosofo3);
        Thread HiloFiloso4 = new Thread(filosofo4);
        Thread HiloFiloso5 = new Thread(filosofo5);
        
        HiloFiloso1.start();

        HiloFiloso2.start();
        Thread.sleep(100);
        HiloFiloso3.start();

        HiloFiloso4.start();
        Thread.sleep(100);
        HiloFiloso5.start();
        
        
    }
}
