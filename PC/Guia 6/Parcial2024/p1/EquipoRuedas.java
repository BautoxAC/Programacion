package Parcial2024.p1;

public class EquipoRuedas implements Runnable{
    private Fabrica fabrica;
    public EquipoRuedas(Fabrica fabrica){
        this.fabrica = fabrica;
    }
    @Override
    public void run() {
        while (true) {
            fabrica.empezarProducirRuedas();
             System.out.println("Produciendo Ruedas");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println("Se termino de producir Ruedas");
            fabrica.terminarProducirRuedas();
        }
    }
    
}
