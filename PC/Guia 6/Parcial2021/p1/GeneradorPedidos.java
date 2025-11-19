
public class GeneradorPedidos implements Runnable {
    private Restaurante restaurante;

    GeneradorPedidos(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    @Override
    public void run() {
        char tipoPizza = 'N';
        while (true) {
            switch (tipoPizza) {
                case 'N':
                    restaurante.crearPedido(tipoPizza, "Napolitano");
                    break;
                case 'V':
                    restaurante.crearPedido(tipoPizza, "Vegano");
                    break;
                default:
                    break;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
