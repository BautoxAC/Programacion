package p2;

public class Ferry {
    private int capacidad;
    private int subidosTotal;
    private boolean arrancaFerry;
    private boolean finalizoFerry;
    private int esperandoAutos;
    private int esperandoPersonas;

    public Ferry() {
        capacidad = 50;
        subidosTotal = 0;
        arrancaFerry = false;
        finalizoFerry = false;
        esperandoAutos = 0;
        esperandoPersonas = 0;
    }

    public synchronized void contarsePersona() {
        esperandoPersonas++;
    }

    public synchronized void contarseAuto() {
        esperandoAutos++;
    }

    public synchronized void subirsePersona() {
        try {

            while (subidosTotal >= capacidad || arrancaFerry || finalizoFerry) {
                wait();
            }
            esperandoPersonas--;
            subidosTotal++;
            System.out.println("Subidos total persona " + subidosTotal);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public synchronized void subirseAuto() {
        try {
            while (subidosTotal >= capacidad - 2 || arrancaFerry || finalizoFerry) {
                wait();
            }
            esperandoAutos--;
            subidosTotal += 3;
            System.out.println("Subidos total auto " + subidosTotal);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public synchronized void revisarSalida() {
        if (subidosTotal == 50 || ((subidosTotal == 48 || subidosTotal == 49) && esperandoPersonas == 0)
                || (esperandoPersonas == 0 && esperandoAutos == 0)) {
            arrancaFerry = true;
            notifyAll();
        }
    }

    public synchronized void esperaFerryArranque() {
        try {
            while (!arrancaFerry) {
                wait();
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public synchronized void terminoElRecorrido() {
        try {
            finalizoFerry = true;
            arrancaFerry = false;
            notifyAll();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public synchronized void bajarseFerryPersona() {
        try {
            while (!finalizoFerry) {
                wait();
            }
            subidosTotal--;
            if (subidosTotal == 0) {
                finalizoFerry = false;
            }
            if (subidosTotal == 0 && (esperandoPersonas > 0 || esperandoAutos > 0)) {
                notifyAll();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public synchronized void bajarseFerryAuto() {
        try {
            while (!finalizoFerry) {
                wait();
            }
            subidosTotal -= 3;
            if (subidosTotal == 0) {
                finalizoFerry = false;
            }
            if (subidosTotal == 0 && (esperandoPersonas > 0 || esperandoAutos > 0)) {
                notifyAll();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
