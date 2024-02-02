package org.Monitores.ChatGpt.BaseDeDatos;

public class MainBaseDeDatos {
    public static void main(String[] args) {
        BaseDeDatos[] baseDeDatos = new BaseDeDatos[3];
        Thread[] hilosClientes = new Thread[10];

        for(int j = 0; j < baseDeDatos.length; j++) {
            baseDeDatos[j] = new BaseDeDatos();
        }

        for(int i = 0; i < hilosClientes.length; i++) {
            int indiceBaseDeDatos = i % baseDeDatos.length; // Esto asegura que se use cada instancia de BaseDeDatos
            hilosClientes[i] = new Thread(new TareaConectar(baseDeDatos[indiceBaseDeDatos], i));
            hilosClientes[i].start();
        }
    }
}
