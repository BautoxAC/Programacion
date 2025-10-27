public class Pasajero implements Runnable{
    private Colectivo cole;
    public Pasajero(Colectivo cole) {
        this.cole = cole;

    }
    @Override
    public void run() {
        cole.esperaCole();
        cole.subir();
        cole.esperarSalida();
        cole.bajarse();
    }


}