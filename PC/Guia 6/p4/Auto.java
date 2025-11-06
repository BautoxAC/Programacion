public class Auto implements Runnable {

    private char direccion;
    private Trafico trafico;
    private String nombre;

    public Auto(char direccion, Trafico trafico, String nombre) {
        this.direccion = direccion;
        this.trafico = trafico;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        switch (direccion) {
            case 'N':
                System.out.println("Trata de entrar auto del norte " + nombre);
                trafico.entrarCocheDelNorte(nombre);
                System.out.println("Entra auto del norte " + nombre);
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                trafico.salirCocheDelNorte(nombre);
                System.out.println("Sale auto del norte " + nombre);
                break;
            case 'S':
                System.out.println("Trata de entrar auto del sur " + nombre);
                trafico.entrarCocheDelSur(nombre);
                System.out.println("Entra auto del sur " + nombre);
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                trafico.salirCocheDelSur(nombre);
                System.out.println("Sale auto del sur " + nombre);
                break;
            default:
                break;
        }
    }

}