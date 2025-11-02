package p2;

public class Auto implements Runnable{
    private Ferry ferry;
    public Auto(Ferry ferry){
        this.ferry = ferry;
    }
    public void run(){
        ferry.contarseAuto();
        try {
            Thread.sleep(1);
        } catch (Exception e) {
            // TODO: handle exception
        }
        ferry.subirseAuto();
        ferry.revisarSalida();
        ferry.bajarseFerryAuto();
    }
}
