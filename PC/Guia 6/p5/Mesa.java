public class Mesa {
    private int cajaCapacidad;
    private int intentaronPonerYEsperan;
    private int pesoTotalPasteles;
    private int totalEmpaquetadores;
    private boolean cambiarCaja;

    public Mesa(int totalEmpaquetadores) {
        cajaCapacidad = 2;
        intentaronPonerYEsperan = 0;
        pesoTotalPasteles = 0;
        cambiarCaja = false;
        this.totalEmpaquetadores = totalEmpaquetadores;
    }

    public synchronized void soltarPastel(int peso) {
        try {
            
            intentaronPonerYEsperan++;
            while (peso + pesoTotalPasteles > cajaCapacidad || cambiarCaja) {
                if (intentaronPonerYEsperan == totalEmpaquetadores) {
                    cambiarCaja = true;
                    notifyAll();
                }
                wait();
            }
            pesoTotalPasteles+=peso;
            intentaronPonerYEsperan--;
            notifyAll();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public synchronized void retirarCaja() {
        try {
            while (!cambiarCaja) {
                wait();
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public synchronized void reponerCaja() {
        try {
            cambiarCaja = false;
            pesoTotalPasteles = 0;
            notifyAll();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
