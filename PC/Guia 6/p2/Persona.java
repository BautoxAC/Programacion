package p2;

public class Persona  implements Runnable{
    private Ferry ferry;
    public Persona(Ferry ferry){
        this.ferry = ferry;
    }
    public void run(){
        ferry.contarsePersona();
        ferry.subirsePersona();
        ferry.revisarSalida();
        ferry.bajarseFerryPersona();
    }
}
