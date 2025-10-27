import java.util.concurrent.Semaphore;

public class Colectivo {
    private Semaphore cole;
    private Semaphore salida;
    private Semaphore ultimo;
    private Semaphore mutex;
    private Semaphore esperaGente;
    private int asientosDisponibles;
    private int totales;
    private int esperando;

    public Colectivo() {
        cole = new Semaphore(0);
        esperaGente = new Semaphore(0);
        salida = new Semaphore(0);
        ultimo = new Semaphore(0);
        mutex = new Semaphore(1);
        esperando = 0;
        totales = 15;
        asientosDisponibles = 15;
    }

    public boolean liberarCole() {
        boolean si = false;
        try {
            mutex.acquire();
            si = this.esperando > 0 && this.asientosDisponibles > 0;
            if (si) {
                cole.release();
            }

            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return si;
    }

    public boolean esperando() {
        boolean si = false;
        if (this.esperando > 0) {
            si = true;
        }
        return si;
    }

    public void esperarGente(){
        try {
            esperaGente.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void esperaCole() {
        try {
            mutex.acquire();
            if (esperando == 0) {
                esperaGente.release();
            }
            esperando++;
            mutex.release();
            cole.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void liberarSalida() {
        salida.release();
    }

    public void esperarSalida() {
        try {
            salida.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void subir() {
        try {
            mutex.acquire();
            if (this.asientosDisponibles > 0) {
                this.asientosDisponibles--;
                this.esperando--;
            }
            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void bajarse() {
        try {
            mutex.acquire();
            // usar parametro
            asientosDisponibles++;
            if (this.asientosDisponibles == totales) {
                ultimo.release();
            } else {
                salida.release();
            }
            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void esperaUltimo() {
        try {
            ultimo.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
