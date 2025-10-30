package p7;

public class BabuinoD implements Runnable{
    private Cuerda cuerda;
    public BabuinoD(Cuerda cuerda){
        this.cuerda = cuerda;
    }
    @Override
    public void run() {
        
        cuerda.llegueDer();
        /* System.out.println("llego un babuino por derecha"); */
        cuerda.subirseDer();
        System.out.println("Paso un babuino por derecha");
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("Se bajo un babuino por derecha");
        cuerda.bajarseDer();
        
    }

}
