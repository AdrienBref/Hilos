package org.semaforos.bebedero;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Bebedero {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el nunmero de perros que van a beber");
        int numeroPerros = Integer.parseInt(scanner.nextLine());
        ArrayList<Perros> arrayListPerro = new ArrayList<>();
        for(int i = 0; i < numeroPerros; i++) {
            arrayListPerro.add(new Perros(semaphore));
        }

        for(Perros perro : arrayListPerro) {
            perro.start();
        }

        try {
            for(Perros perro : arrayListPerro) {
                perro.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for(Perros perro : arrayListPerro) {
            int litrosBebidos = perro.getLitrosBebidos();
            int totallitros = 0;
            totallitros = totallitros + litrosBebidos;
            System.out.println("Total de litros bebidos =" + totallitros);
        }


    }
}
