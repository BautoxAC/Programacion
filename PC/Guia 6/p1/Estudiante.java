package p1;

public class Estudiante implements Runnable{
    private Sala sala;
    public Estudiante(Sala sala){
        this.sala = sala;
    }
    @Override
    public void run() {
        System.out.println("Estudiante tratando de entrar a la sala");
        sala.entrarALaSala();
        System.out.println("Estudiante entro a la sala");
        
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("Estudiante sale de la sala");
        sala.salirDeLaSala();
    }
    
}