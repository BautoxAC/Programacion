package p7;

public class BabuinoI implements Runnable {
    private Cuerda cuerda;

    public BabuinoI(Cuerda cuerda) {
        this.cuerda = cuerda;
    }

    @Override
    public void run() {
        cuerda.llegueIzq();
        /* System.out.println("llego un babuino por izquierda"); */
        cuerda.subirseIzq();
        System.out.println("Paso un babuino por izquierda");
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("Se bajo un babuino por izquierda");
        cuerda.bajarseIzq();
        
    }
}
