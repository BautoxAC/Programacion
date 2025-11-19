import java.util.Random;

public class AuxContable implements Runnable{
    private Canasta[] canastas;
    private int pizarra;
    //Va a recibir tres canastas en el arreglo la primera sera la general, la segunda la contable y la tercera la de encargado
    public AuxContable(Canasta[] c) {
        this.canastas = c;
        pizarra = 0;
    }
    @Override
    public void run() {
        Random random = new Random();
        int turno = random.nextInt(1);
        try {
             if (turno == 0) {
            Ficha ficha= canastas[0].sacarFicha();
            System.out.println("Saque ficha y anontando");
            Thread.sleep(3000);
            pizarra+= ficha.importe;
            canastas[2].ponerFicha(ficha);
        } else {
            Ficha ficha= canastas[1].sacarFicha();
            System.out.println("Saque ficha y anontando");
            Thread.sleep(3000);
            pizarra+= ficha.importe;
        }
        } catch (Exception e) {
            // TODO: handle exception
        }
       
    }

}
