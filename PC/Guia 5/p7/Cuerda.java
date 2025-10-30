package p7;

import java.util.concurrent.Semaphore;

public class Cuerda {
    private char lado;
    private int esperandIzq;
    private int esperandDer;
    private Semaphore ladoIzq;
    private Semaphore ladoDer;
    private int pasaronRonda;
    private int vanApasar;
    private Semaphore mutex;

    public Cuerda() {
        // puede ser I(izquierda), D(derecha) y N(ningun lado)
        lado = 'N';
        esperandDer = 0;
        esperandIzq = 0;
        pasaronRonda = 0;

        // Sera de 0 a 5 los permisos de los semaforos
        ladoIzq = new Semaphore(0);
        ladoDer = new Semaphore(0);

        mutex = new Semaphore(1);
    }

    public void soutPermisos() {
        System.out.println(ladoDer.availablePermits());
        System.out.println(ladoIzq.availablePermits());
    }

    public void bajarseIzq() {
        adquirirMutex();
        esperandIzq--;
        pasaronRonda++;
        if (esperandIzq > 0 && esperandDer == 0 && pasaronRonda == vanApasar) {
            lado = 'I';
            if (esperandIzq >= 5) {
                ladoIzq.release(5);
                vanApasar = 5;
            } else {
                ladoIzq.release(esperandIzq);
                vanApasar = esperandDer;
            }
            pasaronRonda = 0;
        }
        if (esperandDer == 0 && esperandIzq == 0) {
            lado = 'N';
            pasaronRonda = 0;
            vanApasar = 0;
        }
        if (esperandDer > 0 && (esperandIzq == 0 || pasaronRonda == vanApasar)) {
            lado = 'D';
            if (esperandDer >= 5) {
                ladoDer.release(5);
                vanApasar = 5;
            } else {
                ladoDer.release(esperandDer);
                vanApasar = esperandDer;
            }
            pasaronRonda = 0;
        }
        mutex.release();
    }

    public void bajarseDer() {
        adquirirMutex();
        esperandDer--;
        pasaronRonda++;
        if (esperandDer > 0 && (esperandIzq == 0 && pasaronRonda == vanApasar)) {
            lado = 'D';
            if (esperandDer >= 5) {
                ladoDer.release(5);
                vanApasar  = 5;
            } else {
                ladoDer.release(esperandDer);
                vanApasar = esperandDer;
            }
            pasaronRonda = 0;
        }
        if (esperandDer == 0 && esperandIzq == 0) {
            lado = 'N';
            pasaronRonda = 0;
        }

        if (esperandIzq > 0 && (esperandDer == 0 || pasaronRonda == vanApasar)) {
            lado = 'I';
            if (esperandIzq >= 5) {
                ladoIzq.release(5);
                vanApasar = 5;
            } else {
                ladoIzq.release(esperandIzq);
                vanApasar = esperandIzq;
            }
            pasaronRonda = 0;
        }
        mutex.release();
    }

    public void subirseIzq() {
        try {
            ladoIzq.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void subirseDer() {
        try {
            ladoDer.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void llegueIzq() {
        adquirirMutex();
        if (lado == 'N') {
            lado = 'I';
        }
        if (lado == 'I' && vanApasar < 5) {
            ladoIzq.release();
            vanApasar++;
        }
        esperandIzq++;

        mutex.release();
    }

    public void llegueDer() {
        adquirirMutex();
        if (lado == 'N') {
            lado = 'D';
        }
        if (lado == 'D' && vanApasar < 5) {
            ladoDer.release();
            vanApasar++;
        }
        esperandDer++;
        mutex.release();
    }

    public void adquirirMutex() {
        try {
            mutex.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
