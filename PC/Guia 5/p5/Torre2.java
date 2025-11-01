package p5;

import java.util.concurrent.Semaphore;

public class Torre2 {
    private Semaphore despegue;
    private Semaphore aterrizaje;
    private int cantAterrizajes;
    private int esperandoA;
    private int esperandoD;
    private Semaphore usoPista;
    private Semaphore mutex;

    public Torre2() {
        mutex = new Semaphore(1);
        despegue = new Semaphore(1);
        aterrizaje = new Semaphore(10);
        usoPista = new Semaphore(1);
        cantAterrizajes = 0;
    }

    public void aterrizar() {
        try {
            mutex.acquire();
            esperandoA++;
            mutex.release();
            aterrizaje.acquire();
            usoPista.acquire();
            mutex.acquire();
            cantAterrizajes++;
            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void despegar() {
        try {
            mutex.acquire();
            esperandoD++;
            mutex.release();
            despegue.acquire();
            usoPista.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void terminaAterrizar() {
        try {
            mutex.acquire();
            if (cantAterrizajes == 10 && esperandoD == 0) {
                aterrizaje.release(10);
                cantAterrizajes = 0;
            }
            esperandoA--;
            usoPista.release();
            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void terminaDespegar() {

        try {
            mutex.acquire();
            if (cantAterrizajes == 10 && esperandoA > 0) {
                aterrizaje.release(10);
                cantAterrizajes = 0;
            }
            despegue.release();
            esperandoD--;
            usoPista.release();
            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
