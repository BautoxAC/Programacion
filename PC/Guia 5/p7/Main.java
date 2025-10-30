package p7;

public class Main {
    public static void main(String[] args) {
        Cuerda cuerda = new Cuerda();
        cuerda.soutPermisos();
        hacerHilos(3, 9, cuerda);
        
          
        
        try {
            Thread.sleep(20000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        hacerHilos(1, 1, cuerda);
    }

    public static void hacerHilos(int izq, int der, Cuerda cuerda) {

        Thread[] hilosD = new Thread[der];
        BabuinoD[] D = new BabuinoD[der];
        Thread[] hilosI = new Thread[izq];
        BabuinoI[] I = new BabuinoI[izq];
        for (int i = 0; i < hilosD.length; i++) {
            D[i] = new BabuinoD(cuerda);
            hilosD[i] = new Thread(D[i]);
        }
        for (int i = 0; i < hilosI.length; i++) {
            I[i] = new BabuinoI(cuerda);
            hilosI[i] = new Thread(I[i]);
        }
        for (int i = 0; i < hilosI.length; i++) {
            hilosI[i].start();
        }
        for (int i = 0; i < hilosD.length; i++) {
            hilosD[i].start();
        }
        try {
          for (int i = 0; i < hilosI.length; i++) {
          hilosI[i].join();
          }
          for (int i = 0; i < hilosD.length; i++) {
          hilosD[i].join();
          }
          cuerda.soutPermisos();
          } catch (Exception e) {
          // TODO: handle exception
          }
    }
}
