public class Maint {
    public static void main(String[] args) {
        Empaquetador[] empaquetadores = new Empaquetador[3];
        Horno[] hornos = new Horno[3];
        Mesa mesa = new Mesa(empaquetadores.length);
        Brazo brazo = new Brazo(mesa);
        Mostrador mostrador = new Mostrador();
        for (int i = 0; i < hornos.length; i++) {
            hornos[i] = new Horno(mostrador, (i + 1) * 2);
            new Thread(hornos[i]).start();
        }
        for (int i = 0; i < empaquetadores.length; i++) {
            empaquetadores[i] = new Empaquetador(mesa, mostrador);
            new Thread(empaquetadores[i]).start();
        }
        new Thread(brazo).start();;
    }

}
