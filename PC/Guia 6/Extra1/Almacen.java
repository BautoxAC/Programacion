package Extra1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Almacen {
    private int capacidadParaSalir;
    private int cajasTotal;
    private int cajaSinFermentar;
    private ReentrantLock lock;
    private Condition camion;

    public Almacen() {
        cajasTotal = 0;
        capacidadParaSalir = 100;
        lock = new ReentrantLock();
        camion = lock.newCondition();
    }

    public void sacarCajas() {
        lock.lock();
        try {
            while (cajasTotal<capacidadParaSalir) {
                camion.await();
            }
            cajasTotal-=100;
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }

    public void ponerCaja(char tipoCaja) {
        lock.lock();
        try {
            if (tipoCaja!='N') {
                cajasTotal+=10;
                if (cajasTotal>=capacidadParaSalir) {
                    camion.signal();
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }
}