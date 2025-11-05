public class Auto implements Runnable {

    private char direccion;
    private Trafico trafico;

    public Auto(char direccion, Trafico trafico) {
        this.direccion = direccion;
        this.trafico = trafico;
    }

    @Override
    public void run() {
        switch (direccion) {
            case 'N':
            System.out.println("Trata de entrar auto del norte");
            trafico.entrarCocheDelNorte();
            System.out.println("Entra auto del norte");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            trafico.salirCocheDelNorte();
            System.out.println("Sale auto del norte");
            break;
            case 'S':
            System.out.println("Trata de entrar auto del sur");
            trafico.entrarCocheDelSur();
            System.out.println("Entra auto del sur");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            trafico.salirCocheDelSur();
            System.out.println("Sale auto del sur");
                break;
            default:
                break;
        }
    }

}