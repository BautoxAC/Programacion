package p5;

import java.util.Random;

public class Avion implements Runnable {
    private Torre torre;
    // A (aterrizar) y D (despegar)
    private char tipo;

    public Avion(Torre torre) {
        Random random = new Random();
        this.torre = torre;
        int numeroEntero = random.nextInt(2) + 1;
        switch (numeroEntero) {
            case 1:
                this.tipo = 'A';
                break;
            case 2:
                this.tipo = 'D';
                break;
            default:
                break;
        }
    }

    @Override
    public void run() {
        try {
            switch (this.tipo) {
                case 'D':
                    torre.revisaSiDespega();
                    System.out.println("Avion llega para ver si despega");
                    torre.despegue();
                    System.out.println("Avion despegando");
                    Thread.sleep(4000);
                    System.out.println("Termino de despegar");
                    torre.terminaDespegar();
                    break;
                case 'A':
                    torre.revisaSiAterriza();
                    System.out.println("Avion llega para ver si aterriza");
                    torre.aterrizaje();
                    System.out.println("Avion aterrizando");
                    Thread.sleep(4000);
                    System.out.println("Termino de aterrizar");
                    torre.terminaAterrizar();
                    break;

                default:
                    break;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
