package p1;

import java.util.concurrent.Semaphore;

public class GestorPiscina {
    private Semaphore capacidad;
    private int capacidadP;
    public GestorPiscina(int capacidadP){
        this.capacidadP=capacidadP;
        capacidad = new Semaphore(this.capacidadP);
    }
    public void ingresarPiscina(){
        try {
            
            capacidad.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void salirPiscina(){
        capacidad.release();
    }
}
