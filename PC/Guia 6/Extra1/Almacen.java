 package Extra1;

import java.util.concurrent.locks.ReentrantLock;

public class Almacen {
    private int capacidadParaSalir;
    private int cajasTotal;
    private int cajaSinFermentar;
    private ReentrantLock lock;
    private 

    public Almacen(){
        cajasTotal = 0;
        capacidadParaSalir = 100;
        cajaSinFermentar=0;
    }
    public synchronized void sacarCajas(){

    }
    public synchronized void ponerCaja(){

    }
}