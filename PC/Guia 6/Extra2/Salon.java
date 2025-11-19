package Extra2;

import java.util.concurrent.Semaphore;

public class Salon {
    private Semaphore entrarActividad;
    private Semaphore esperandoInicioActividad;
    private Semaphore mutex;
    private int dentroDeLyra;
    private int dentroDeYoga;
    private int dentroDeAcro;
    private int salieronDe;
    private int limiteActividad;

    public Salon() {
        mutex = new Semaphore(1);
        esperandoInicioActividad = new Semaphore(0);
        entrarActividad = new Semaphore(12);
        dentroDeAcro = 0;
        dentroDeLyra = 0;
        dentroDeYoga = 0;
        salieronDe = 0;
        limiteActividad = 4;
    }

    public void entrarActividad(int actividad) {
        boolean exito = false;
        int intento = 0;
        int actividadQueHizo = actividad;
        try {
            entrarActividad.acquire(1);
            while (!exito && intento < 2) {
                switch (actividadQueHizo) {
                    
                    case 0:
                        mutex.acquire(1);
                        if (dentroDeAcro < limiteActividad) {
                            dentroDeAcro++;
                            exito = true;
                        } else {
                            intento++;
                            actividadQueHizo = (actividad + 1) % 3;
                        }
                        mutex.release(1);
                        break;
                    case 1:
                    mutex.acquire(1);
                        if (dentroDeLyra < limiteActividad) {
                            dentroDeLyra++;
                            exito = true;
                        } else {
                            intento++;
                            actividadQueHizo = (actividad + 1) % 3;
                        }
                        mutex.release(1);
                        break;
                    case 2:
                    mutex.acquire();
                        if (dentroDeYoga < limiteActividad) {
                            dentroDeYoga++;
                            exito = true;
                        } else {
                            intento++;
                            actividadQueHizo = (actividad + 1) % 3;
                        }
                        mutex.release();
                        break;
                    default:
                        break;
                }
            }
            mutex.acquire(1);
            if (dentroDeAcro == limiteActividad && dentroDeLyra == limiteActividad && dentroDeYoga == limiteActividad) {
                esperandoInicioActividad.release(12);
            }
            mutex.release(1);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void esperarEmpiezaActividad() {
        try {
            esperandoInicioActividad.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void seTerminoLaActidad() {
        try {
            mutex.acquire();
            salieronDe++;
            if (salieronDe == 12) {
                dentroDeAcro = 0;
                dentroDeLyra = 0;
                dentroDeYoga = 0;
                salieronDe = 0;
                entrarActividad.release(12);
            }
            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
