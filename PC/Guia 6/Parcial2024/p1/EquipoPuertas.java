package Parcial2024.p1;

public class EquipoPuertas implements Runnable{
    private Fabrica fabrica;
    public EquipoPuertas(Fabrica fabrica){
        this.fabrica = fabrica;
    }
    @Override
    public void run() {
        while (true) {
            fabrica.empezarProducirPuertas();
            System.out.println("Produciendo Puertas");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println("Se termino de producir puertas");
            fabrica.terminarProducirPuertas();
        }
    }
}
