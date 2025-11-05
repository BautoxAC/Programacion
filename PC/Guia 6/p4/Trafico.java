import dinamicas.Cola;

public class Trafico {
    private int esperandoNorte;
    private int esperandoSur;
    private int pasando;
    private int puedenPasar;
    private int pasaronRondaSur;
    private char turno;
    private Cola cola;
    private int pasaronRondaNorte;

    public Trafico() {
        cola = new Cola();
        esperandoNorte = 0;
        turno = 'T';
        esperandoSur = 0;
        pasando = 0;
        puedenPasar = 5;
        pasaronRondaNorte = 0;
        pasaronRondaSur = 0;
    }

    public synchronized void entrarCocheDelNorte(String nombre) {
        try {
            esperandoNorte++;

            while (turno == 'S' || pasando >= puedenPasar || pasaronRondaNorte >= 10) {
                wait();
            }
            System.out.println(nombre);
            cola.poner(nombre);
            if (turno == 'T') {
                turno = 'N';
            }
            pasando++;
            esperandoNorte--;

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public synchronized void salirCocheDelNorte(String nombre) {
        try {

            while (!cola.obtenerFrente().equals(nombre)) {
                wait();
            }
            System.out.println(nombre);

        } catch (Exception e) {
            // TODO: handle exception
        }
        cola.sacar();
        pasaronRondaNorte++;
        pasando--;
        if (pasaronRondaNorte >= 10) {
            if (esperandoSur > 0) {
                turno = 'S';

            } else {
                turno = 'T';

            }
            pasaronRondaNorte = 0;
        } else {
            if (esperandoNorte == 0 && pasando == 0) {
                turno = 'T';
                pasaronRondaNorte = 0;
            }
        }
        notifyAll();
    }

    public synchronized void entrarCocheDelSur(String nombre) {
        try {
            esperandoSur++;

            while (turno == 'N' || pasando >= puedenPasar || pasaronRondaSur >= 10) {
                wait();
            }
            if (turno == 'T') {
                turno = 'S';
            }
            System.out.println(nombre);
            cola.poner(nombre);

            pasando++;
            esperandoSur--;

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public synchronized void salirCocheDelSur(String nombre) {
        try {
            while (!cola.obtenerFrente().equals(nombre)) {
                wait();
            }
            System.out.println(nombre);
        } catch (Exception e) {
            // TODO: handle exception
        }
        cola.sacar();
        pasaronRondaSur++;
        pasando--;
        if (pasaronRondaSur >= 10) {
            if (esperandoNorte > 0) {
                turno = 'N';

            } else {
                turno = 'T';

            }
            pasaronRondaSur = 0;
        } else {
            if (esperandoSur == 0 && pasando == 0) {
                turno = 'T';
                pasaronRondaSur = 0;
            }
        }
        notifyAll();
    }
}
