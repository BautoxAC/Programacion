public class Hidrogeno implements Runnable {
    private Recipiente recipiente;
    public Hidrogeno(Recipiente recipiente){
        this.recipiente = recipiente;
    }
    @Override
    public void run() {
        recipiente.Hlisto();
        recipiente.esperaAgua();
    }

    
}