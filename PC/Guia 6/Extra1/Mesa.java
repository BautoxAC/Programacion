package Extra1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Mesa {
    private int capacidadCaja;
    private int totalEnCajaVino;
    private int totalEnCajaSaborizada;
    private boolean cambiandoCajaSaborizada;
    private boolean cambiandoCajaVino;
    private ReentrantLock lock;
    private Condition embotelladorSaborizada;
    private Condition embotelladorVino;
    private Condition empaquetador;

    public Mesa() {
        capacidadCaja = 10;
        totalEnCajaSaborizada = 0;
        totalEnCajaVino = 0;
        cambiandoCajaSaborizada = false;
        cambiandoCajaVino = false;
        lock = new ReentrantLock();
        embotelladorSaborizada = lock.newCondition();
        embotelladorVino = lock.newCondition();
        empaquetador = lock.newCondition();
    }

    public synchronized void ponerBotellaVino() {
        lock.lock();
        try {
            while (totalEnCajaVino >= capacidadCaja) {
                if (!cambiandoCajaVino) {
                    cambiandoCajaVino = true;
                    empaquetador.signal();
                }
                embotelladorSaborizada.await();
            }
            totalEnCajaVino++;

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }

    public synchronized void ponerBotellaSaborisada() {
        lock.lock();
        try {
            while (totalEnCajaSaborizada >= capacidadCaja) {
                if (!cambiandoCajaSaborizada) {
                    cambiandoCajaSaborizada = true;
                    empaquetador.signal();
                }
                embotelladorSaborizada.await();
            }
            totalEnCajaSaborizada++;

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }

    public synchronized void esperaSacarCaja() {
        lock.lock();
        try {
            while (!cambiandoCajaSaborizada && !cambiandoCajaVino) {
                empaquetador.await();
            }

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }

    public synchronized char cambiarCaja() {
        lock.lock();
        char tipoCaja= 'N';
        try {
            if (cambiandoCajaSaborizada) {
                cambiandoCajaSaborizada = false;
                totalEnCajaSaborizada = 0;
                embotelladorSaborizada.signalAll();
                tipoCaja = 'S';
            }
            if (cambiandoCajaVino) {
                cambiandoCajaSaborizada = false;
                totalEnCajaSaborizada = 0;
                embotelladorSaborizada.signalAll();
                tipoCaja = 'V';
            }
            //Poner caja en almacen
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
        return tipoCaja;
    }

}
