package p2;

public class Persona  implements Runnable{
    private Ferry ferry;
    public Persona(Ferry ferry){
        this.ferry = ferry;
    }
    public void run(){
        ferry.contarsePersona();
        /* try {
            Thread.sleep(1);
        } catch (Exception e) {
            // TODO: handle exception
        } */
        ferry.subirsePersona();
        ferry.revisarSalida();
        ferry.bajarseFerryPersona();
    }
}
