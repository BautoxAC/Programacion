
public class ControlTren implements Runnable {
    private Tren tren;

    public ControlTren(Tren tren) {
        this.tren = tren;
    }

    @Override
    public void run() {
        while (true) {

            tren.esperaControlTrenSalida();
            try {
                Thread.sleep(8000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            tren.liberaLlegada();
        }
    }
}
