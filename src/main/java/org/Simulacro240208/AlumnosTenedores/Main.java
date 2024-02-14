package org.Simulacro240208.AlumnosTenedores;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
        Semaphore tenedor1 = new Semaphore(1);
        Semaphore tenedor2 = new Semaphore(1);
        Semaphore tenedor3 = new Semaphore(1);
        Semaphore tenedor4 = new Semaphore(1);
        Semaphore tenedor5 = new Semaphore(1);

        Alumno alumno1 = new Alumno(tenedor1, tenedor2, 1);
        Alumno alumno2 = new Alumno(tenedor2, tenedor3, 2);
        Alumno alumno3 = new Alumno(tenedor3, tenedor4, 3);
        Alumno alumno4 = new Alumno(tenedor4, tenedor5, 4);
        Alumno alumno5 = new Alumno(tenedor5, tenedor1, 1);
        
        alumno1.start();
        alumno2.start();
        alumno3.start();
        alumno4.start();
        alumno5.start();
    }
    
    
}
