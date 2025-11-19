import java.util.Random;

public class AuxFarmacia implements Runnable{
    private Canasta canastaGeneral;
    public AuxFarmacia(Canasta canastaGeneral){
        this.canastaGeneral = canastaGeneral;
    }
    @Override
    public void run() {
        Random random = new Random();
        int numColegiala = random.nextInt(30);
        int importe = random.nextInt(20);
        int numReceta = random.nextInt(40);
        Ficha ficha = new Ficha(numColegiala, importe, numReceta);
        canastaGeneral.ponerFicha(ficha);
        System.out.println("Ficha puesta en fichas general");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
