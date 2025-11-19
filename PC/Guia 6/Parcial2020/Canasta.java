import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Canasta {
    private Cola colaFichaS;
    private ReentrantLock lock;
    private Condition condicion;

    public Canasta() {
        colaFichaS = new Cola();
        lock = new ReentrantLock();
        condicion = lock.newCondition();
    }

    public void ponerFicha(Ficha ficha) {
        lock.lock();
        colaFichaS.poner(ficha);
        condicion.signal();
        lock.unlock();
    }

    public Ficha sacarFicha() {
        Ficha ficha = null;
        try {
            lock.lock();
            while (colaFichaS.esVacia()) {
                condicion.await();
            }
            ficha = (Ficha) colaFichaS.obtenerFrente();
            colaFichaS.sacar();
            lock.unlock();
        } catch (Exception e) {
            // TODO: handle exception
        }

        return ficha;
    }
}