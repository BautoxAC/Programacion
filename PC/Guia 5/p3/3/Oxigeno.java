public class Oxigeno implements Runnable {

    private Recipiente recipiente;
    public Oxigeno(Recipiente recipiente){
        this.recipiente = recipiente;
    }
    @Override
    public void run() {
        recipiente.Olisto();
        System.out.println("Oxigeno Listo y esperando hidrogeno");
        recipiente.esperarHidrogeno();
        recipiente.hacerAgua();
        System.out.println("Haciendo agua");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("Agua hecha");
        recipiente.OLiberar();
    }
    
}
