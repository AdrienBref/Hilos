package org.semaforos.tiendaDeportes;

/*
* Imaginamos una tienda de deportes que tiene 4 cajas en funcionamiento en todo momento para cobrar a los clientes .
*A dicha tienda no pueden acceder más de 10 personas a la vez, ya que es muy pequeña y queremos seguir cumpliendo
* la normativa de cercanía para evitar problemas de salud. A su vez, sólo un cliente puede estar en cada caja para cobrarle.
* Queremos saber cuánto dinero hemos ganado con cada una de las cajas que entran a comprar y el total al cerrar la aplicación.

NOTA: Ahora mismo no es necesario complicarse en la aplicación para la compra de cada cliente, vale con indicar una cantidad por teclado o aleatoria de lo que gasta cada uno.
*
*
* */

import java.util.concurrent.Semaphore;

public class TiendaDeportes {

    public static void main(String[] args) {

        Semaphore semaphoreTienda = new Semaphore(10);
        Semaphore[] cajas = new Semaphore[]{new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1)};

        for (int i = 0; i < 10; i++) { // Ejemplo con 20 clientes
            new Thread(new Cliente(i, semaphoreTienda, cajas)).start();
        }
    }

}
