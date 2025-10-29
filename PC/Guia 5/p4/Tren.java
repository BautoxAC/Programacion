import java.util.concurrent.Semaphore;

public class Tren {
    private Semaphore asientos;
    private Semaphore bajarse;
    private Semaphore avisoControlTren;
    private Semaphore llegada;
    private Semaphore subida;

    public Tren() {
        asientos = new Semaphore(15);
        bajarse = new Semaphore(0);
        avisoControlTren = new Semaphore(0);
        llegada = new Semaphore(0);
        subida = new Semaphore(0);
    }

    public void subirseAlTren() {
        try {
            asientos.acquire();
            subida.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void bajarseDelTren() {
        try {
            asientos.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void esperaBajada() {
        try {
            bajarse.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void liberaBajada() {
        bajarse.release(15);
    }

    public void esperaControlTrenSalida() {
        try {
            avisoControlTren.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void liberaControlTrenSalida() {
        try {
            avisoControlTren.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void esperaLlegada() {
        try {
            llegada.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void liberaLlegada() {
        try {
            llegada.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void esperaSubida() {
        try {
            subida.acquire(15);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
