package org.Simulacro240208.EstadioBenito;


public class Asistente extends Thread{
    
    /*
    * Al asistente se le da las posibles zonas a donde puede ir por constructor y el numero de asistente
    * que le toca.
    * La clave para entender esta clase es que el asistente tiene una vision de las 4 salas porque le paso 
    * el array de salas declaradas en el Main por constructor. De esta manera puedo manipular la sala a la que
    * va el asistente dependiendo si hay sitios o no.
    * */
    
    private int zonaVipAsignada = 0; // Todos los asistentes empiezan a mirar asientos en la sala 0
    private int numeroAsistente;
    private ZonaVip[] zonasVip;
    int asientosLibresTotales;
    private static final Object lock = new Object(); 
    private static int contadorPersonas; // Es estatico para llevar una cuenta total de la clase y no de la instancia
    

    public Asistente(ZonaVip[] zonasVip, int numeroAsistente) {
        this.zonasVip = zonasVip;
        this.numeroAsistente = numeroAsistente;
    }
    
    @Override
    public void run() {
        super.run();
        try {
            /*
            * Miramos cuantos asientos totales quedan libres en los 4 palcos para que no se intenten meter
            * mas hilos tras llenar todo
            * */
            for(int i = 0; i < zonasVip.length; i++) {
                asientosLibresTotales = zonasVip[i].getCantidadPermitida().availablePermits();
            }
            //Si en total hay 0 asientos...>>al else
            if(asientosLibresTotales > 0) {
                int asientosDisponibles = zonasVip[zonaVipAsignada].getCantidadPermitida().availablePermits();
                //Si en la sala donde estoy mirando hay 0 asientos...
                while(asientosDisponibles == 0) {
                    zonaVipAsignada++;//... me meto en el while Miro en la siguiente 
                    asientosDisponibles = zonasVip[zonaVipAsignada].getCantidadPermitida().availablePermits();
                    //Actualizo los asientos de la siguiente sala para en el siguiente ciclo de while saber si hay asientos libres
                }
                //Si hay mas de 0 asientos el hilo sale del While y ocupo un semaforo de esta sala y ocupo el torno
                zonasVip[zonaVipAsignada].getCantidadPermitida().acquire();
                System.out.println("Asistente " + numeroAsistente + " entra en sala " + zonaVipAsignada);
                zonasVip[zonaVipAsignada].getTorno().acquire();
                sleep(1500);
                zonasVip[zonaVipAsignada].getTorno().release();
                //Para luego soltarlo
                synchronized (lock) {
                    //Con esto me aseguro de que no entre mas de un hilo a contra +1 a personas
                    contadorPersonas++;
                }
                
            } else {
                //...me quedo sin asiento y manejo esa posibilidad
                System.out.println("Asistente " + numeroAsistente + " sin sala vip");
            }
            

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static int getContadorPersonas() {
        return contadorPersonas;
    }
    
}
