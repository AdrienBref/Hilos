package org.Monitores.Uem.Deposito;

public class main {
    public static void main(String[] args) {
        Deposito deposito = new Deposito();

        Thread hiloLlenado = new Thread(new Llenado(deposito));
        Thread hiloVaciado = new Thread(new Vaciado(deposito));

        hiloLlenado.start();
        hiloVaciado.start();
    }
}
