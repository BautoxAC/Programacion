import java.util.Random;

public class EncargadoGeneral implements Runnable {
    private Canasta[] canastas;
    private int totalGlobal;

    // Va a recibir tres canastas en el arreglo la primera sera la general, la
    // segunda la contable y la tercera la de encargado
    public EncargadoGeneral(Canasta[] c) {
        this.canastas = c;
        totalGlobal = 0;
    }

    @Override
    public void run() {
        Random random = new Random();
        int turno = random.nextInt(1);
        Ficha ficha = null;
        try {
            if (turno == 0) {
                ficha = canastas[0].sacarFicha();
                System.out.println("Saque ficha y anontando");
                Thread.sleep(3000);
                canastas[1].ponerFicha(ficha);
            } else {
                ficha = canastas[2].sacarFicha();
                System.out.println("Saque ficha y anontando");
                Thread.sleep(3000);
            }
            totalGlobal += ficha.importe;
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
