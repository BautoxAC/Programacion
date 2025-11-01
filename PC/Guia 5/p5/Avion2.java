package p5;

import java.util.Random;

public class Avion2 implements Runnable{
    private Torre2 torre;
    // A (aterrizar) y D (despegar)
    private char tipo;

    public Avion2(Torre2 torre) {
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
                    System.out.println("Avion llega para ver si despega");
                    torre.despegar();
                    System.out.println("Avion despegando");
                    Thread.sleep(4000);
                    System.out.println("Termino de despegar");
                    torre.terminaDespegar();
                    break;
                case 'A':
                    System.out.println("Avion llega para ver si aterriza");
                    torre.aterrizar();
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
