package Extra1;

public class Empaquetador implements Runnable {
    private Mesa mesa;
    private char tipoBotella;

    public Empaquetador(Mesa mesa, char tipoBotella) {
        this.mesa = mesa;
        this.tipoBotella = tipoBotella;
    }

    @Override
    public void run() {
        switch (tipoBotella) {
            case 'V':

                break;
            case 'S':

                break;
            default:
                break;
        }
    }

}
