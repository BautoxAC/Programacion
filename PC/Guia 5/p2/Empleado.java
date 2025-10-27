package p2;

import java.util.Random;

public class Empleado implements Runnable {

    private Pedido p;

    public Empleado(Pedido p) {
        this.p = p;
    }

    @Override
    public void run() {
        Random random = new Random();

        // Genera un número aleatorio entre 1 y 3
        int numero = random.nextInt(3) + 1;
        p.esperaLugar();
        System.out.println(numero);
        switch (numero) {
            // Bebida
            case 1:
                p.llegoClienteMozo();
                p.esperaAtencionMozo();
                break;

            // Comida
            case 2:
                p.llegoClienteCocinero();
                p.esperaAtencionCocinero();
                break;
            // Bebida y Comida
            case 3:
                p.llegoClienteMozo();
                p.esperaAtencionMozo();
                p.llegoClienteCocinero();
                p.esperaAtencionCocinero();
                break;

            default:
                break;
        }
        p.liberaLugar();

    }

}
