package p1;

public class Sala {
    private int cantEstudiantes;
    private int cantMesas;
    private int cantEstudiantesEsperando;
    public Sala(){
        cantMesas = 3;
        cantEstudiantes = 0;
        cantEstudiantesEsperando = 0;
    }
    public synchronized void entrarALaSala(){
        try {
            cantEstudiantesEsperando++;
            while (cantEstudiantes==cantMesas) {
                this.wait();
            }
            cantEstudiantesEsperando--;
            cantEstudiantes++;
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
     public synchronized void salirDeLaSala(){
        try {
            cantEstudiantes--;
            if (cantEstudiantesEsperando>0) {
                notify();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
