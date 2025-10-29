

public class Pasajero  implements Runnable{
    private Tren tren;
    public Pasajero(Tren tren){
        this.tren = tren;
    }
    @Override
    public void run() {
       tren.subirseAlTren();
       tren.esperaBajada();
       tren.bajarseDelTren();
    }

}
