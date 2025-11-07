package Extra1;

public class Embotellador implements Runnable {
    private Mesa mesa;
    private char tipoBotella;

    public Embotellador(Mesa mesa, char tipoBotella) {
        this.mesa = mesa;
        this.tipoBotella = tipoBotella;
    }

    @Override
    public void run() {
        while (true) {
            switch (tipoBotella) {
                case 'V':
                    mesa.ponerBotellaVino();
                    System.out.println("Botella de vino puesta");
                    try {
                        Thread.sleep(4000);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    break;
                case 'S':
                    mesa.ponerBotellaSaborisada();
                    System.out.println("Botella de agua saborizada puesta");
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    break;
                default:
                    break;
            }
        }

    }
}
