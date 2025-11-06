package Extra1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Mesa {
    private int capacidadCaja;
    private int totalEnCajaVino;
    private int totalEnCajaSaborizada;
    private int cajaFermentando;
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
        cajaFermentando = 0;
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
                embotelladorVino.await();
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
            System.out.println("a");
            while (!cambiandoCajaSaborizada && !cambiandoCajaVino) {
                System.out.println("a1");
                empaquetador.await();
                System.out.println("a2");
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            System.out.println("a");
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
                cambiandoCajaVino = false;
                totalEnCajaVino = 0;
                embotelladorVino.signalAll();
                tipoCaja = 'V';
            }
            if (tipoCaja=='V' && cajaFermentando==0) {
                cajaFermentando++;
                tipoCaja = 'N';
            }else{
                cajaFermentando--;
                cajaFermentando++;
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
        return tipoCaja;
    }

}
