package org.Hilos.galgos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroGalgos = 0;
        ArrayList<Galgo> arrarListGalgos = new ArrayList<>();
        System.out.println("Introduce numero de galgos");
        numeroGalgos = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce tiempo de cada galgo");

        for(int i   = 0; i < numeroGalgos; i++) {
            System.out.println("Introduce tiempo galgo " + i);
            int tiempoCarrera = Integer.parseInt(scanner.nextLine());
            arrarListGalgos.add(new Galgo(tiempoCarrera));
        }

        for (Galgo galos: arrarListGalgos) {
            galos.start();
        }

        for (Galgo galos: arrarListGalgos) {
            try {
                galos.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}