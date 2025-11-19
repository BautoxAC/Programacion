

public class Mainq {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        GeneradorPedidos g = new GeneradorPedidos(restaurante);
        Repartidor r =new Repartidor(restaurante);
        new Thread(g).start();
        new Thread(r).start();
        MaestroPizza[] maestros = new MaestroPizza[3];
        for (int i = 0; i < maestros.length; i++) {
            maestros[i] = new MaestroPizza(restaurante);
            new Thread(maestros[i]).start();
        }
    }

}
