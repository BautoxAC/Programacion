package Parcial2024.p1;

public class EquipoAuto implements Runnable{
    private Fabrica fabrica;

    public EquipoAuto(Fabrica fabrica){
        this.fabrica = fabrica;
    }

    @Override
    public void run() {
        while (true) {
            fabrica.empezarProduccionAuto();
            System.out.println("Produciendo Auto");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println("Se termino de producir Auto");
            boolean empaquetar = fabrica.terminarProducirAuto();
            if (empaquetar) {
                fabrica.empaquetarAutos();
                System.out.println("Empaquetando Autos");
                try {
                    Thread.sleep(4500);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                System.out.println("Se termino de empaquetar Autos");
            }
        }
    }

}