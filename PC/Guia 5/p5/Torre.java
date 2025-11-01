package p5;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Torre {
    private Semaphore despegue;
    private Semaphore aterrizaje;
    private boolean pistaEnUso;
    private int cantEsperandoD;
    private int cantEsperandoA;
    private int cantAterrizajesRonda;
    private Semaphore mutex;

    public Torre() {
        despegue = new Semaphore(0);
        aterrizaje = new Semaphore(0);
        mutex = new Semaphore(1);
        cantEsperandoA = 0;
        cantEsperandoD = 0;
        pistaEnUso = false;
    }

    public void revisaSiAterriza() {
        try {
            mutex.acquire();
            cantEsperandoA++;
            if (!pistaEnUso) {
                if (cantAterrizajesRonda < 10) {
                    aterrizaje.release();
                    cantEsperandoA--;
                } else {
                    if (cantEsperandoD > 0) {
                        despegue.release();
                        cantEsperandoD--;
                    } else {
                        aterrizaje.release();
                        cantEsperandoA--;
                    }
                }
                pistaEnUso = true;
            }

            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void revisaSiDespega() {
        try {
            mutex.acquire();
            cantEsperandoD++;
            if (!pistaEnUso) {
                despegue.release();
                cantEsperandoD--;
                pistaEnUso = true;
            }

            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void despegue() {
        try {
            despegue.acquire();
            mutex.acquire();
            if (!pistaEnUso) {
                cantEsperandoD--;
            }
            pistaEnUso = true;
            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void aterrizaje() {
        try {
            aterrizaje.acquire();
            mutex.acquire();
            if (!pistaEnUso) {
                cantEsperandoA--;
            }
            pistaEnUso = true;
            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void terminaAterrizar() {
        try {
            mutex.acquire();
            pistaEnUso = false;
            cantAterrizajesRonda++;
            System.out.println(cantEsperandoA);
            if (cantAterrizajesRonda >= 10) {
                if (cantEsperandoD > 0) {
                    despegue.release();
                } else {
                    if (cantEsperandoA > 0) {
                        aterrizaje.release();
                    }
                }
            } else {
                if (cantEsperandoD > 0 && cantEsperandoA == 0) {
                    despegue.release();
                }
                if (cantEsperandoA > 0 && cantEsperandoD == 0) {
                    aterrizaje.release();
                }
                if (cantEsperandoA > 0 && cantEsperandoD > 0) {
                    Random random = new Random();
                    int numeroEntero = random.nextInt(2) + 1;
                    switch (numeroEntero) {
                        case 1:
                            despegue.release();
                            break;
                        case 2:
                            aterrizaje.release();
                            break;
                        default:
                            break;
                    }
                }
            }

            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void terminaDespegar() {
        try {
            mutex.acquire();
            pistaEnUso = false;
            cantAterrizajesRonda = 0;
            if (cantEsperandoD > 0 && cantEsperandoA == 0) {
                despegue.release();
            }
            if (cantEsperandoA > 0 && cantEsperandoD == 0) {
                aterrizaje.release();
            }
            if (cantEsperandoA > 0 && cantEsperandoD > 0) {
                Random random = new Random();
                int numeroEntero = random.nextInt(2) + 1;
                switch (numeroEntero) {
                    case 1:
                        despegue.release();
                        break;
                    case 2:
                        aterrizaje.release();
                        break;
                    default:
                        break;
                }
            }

            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
