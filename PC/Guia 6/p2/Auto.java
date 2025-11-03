package p2;

public class Auto implements Runnable{
    private Ferry ferry;
    public Auto(Ferry ferry){
        this.ferry = ferry;
    }
    public void run(){
        ferry.contarseAuto();
        ferry.subirseAuto();
        ferry.revisarSalida();
        ferry.bajarseFerryAuto();
    }
}
