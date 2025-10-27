public class Colectivero implements Runnable {

    private Colectivo cole;
    private int pasadas;

    public Colectivero(Colectivo cole) {
        this.cole = cole;
        this.pasadas = 5;
    }

    @Override
    public void run() {
        for (int i = 0; i < pasadas; i++) {
            cole.esperarGente();
            System.out.println("empieza el viaje");
            try {
                boolean repetir = false;
                do {
                    repetir = cole.liberarCole();
                } while (repetir);
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println("viajando");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            cole.liberarSalida();
            cole.esperaUltimo();
            System.out.println("termino el viaje");
        }

    }

}
