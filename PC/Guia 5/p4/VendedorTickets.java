
public class VendedorTickets implements Runnable {
    private Tren tren;

    public VendedorTickets(Tren tren) {
        this.tren = tren;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Bienvenidos al tren");
            tren.esperaSubida();
            System.out.println("El tren empieza su recorrido");
            tren.liberaControlTrenSalida();
            tren.esperaLlegada();
            System.out.println("El tren ha llegado a destino, se libera la puerta de salida");
            tren.liberaBajada();  
            try {
                Thread.sleep(6000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

}
