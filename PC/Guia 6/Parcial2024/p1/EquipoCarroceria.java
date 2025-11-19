package Parcial2024.p1;

public class EquipoCarroceria implements Runnable{
    private Fabrica fabrica;
    public EquipoCarroceria(Fabrica fabrica){
        this.fabrica = fabrica;
    }
    @Override
    public void run() {
        while (true) {
            fabrica.empezarProducirCarroceria();
            System.out.println("Produciendo Carroceria");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println("Se termino de producir Carroceria");
            fabrica.terminarProducirCarroceria();
        }
    }
}
