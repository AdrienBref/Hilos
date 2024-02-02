package org.Monitores.ChatGpt.BaseDeDatos;

import java.awt.desktop.ScreenSleepEvent;

import static java.lang.Thread.sleep;

public class MainBaseDeDatos {
    public static void main(String[] args) {
        BaseDeDatos[] baseDeDatos = new BaseDeDatos[3];
        Thread[] hilosClientes = new Thread[10];
        
        for(int i = 0; i < hilosClientes.length; i++) {
            for(int j = 0; j < baseDeDatos.length; j++) {
                baseDeDatos[j] = new BaseDeDatos();
                hilosClientes[i] = new Thread(new TareaConectar(baseDeDatos[j], i));
                hilosClientes[i].start();
            }
        }
    }
}
