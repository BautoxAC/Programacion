import java.util.concurrent.Semaphore;

public class Toboganes {
    private Semaphore gente;
    private Semaphore Tobogan;
    private Semaphore habilitarTobogan;

    public Toboganes() {
        gente = new Semaphore(0);
        Tobogan = new Semaphore(0);
        habilitarTobogan = new Semaphore(0);

    }

}
