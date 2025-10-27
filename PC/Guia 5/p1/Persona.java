package p1;


public class Persona implements Runnable {
    private GestorPiscina piscina;
    public Persona(GestorPiscina p){
        this.piscina = p;
    }
    @Override
    public void run() {
        System.out.println("Ingresando a la pileta");
        piscina.ingresarPiscina();
        System.out.println("Disfrutando de la pileta");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        piscina.salirPiscina();
        System.out.println("Salio de la pileta");
    }

}
