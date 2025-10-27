import java.util.concurrent.Semaphore;

public class Recipiente {
    private Semaphore hidrogeno;
    private Semaphore oxigeno;
    private Semaphore mutex;
    private Semaphore espera;

    public Recipiente() {
        hidrogeno = new Semaphore(0);
        espera = new Semaphore(0);
        oxigeno = new Semaphore(1);
        mutex = new Semaphore(1);
    }

    public void Hlisto() {
        try {
            mutex.acquire();
            hidrogeno.release();
            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }


    public void Olisto() {
        try {
            oxigeno.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void OLiberar() {
        oxigeno.release();
    }

    public void esperaAgua() {
       try {
            espera.acquire(1);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void esperarHidrogeno() {
        try {
            hidrogeno.acquire(2);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void hacerAgua() {

        try {
            mutex.acquire();
            espera.release(2);
            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
