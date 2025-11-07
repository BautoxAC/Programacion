package Extra2;

import java.util.Random;

public class Persona implements Runnable {
    private Salon salon;
    private int actividad;

    public Persona(Salon salon, int actividad) {
        this.salon = salon;
        this.actividad = actividad;
    }

    @Override
    public void run() {
        int actividadHizo= actividad;
        System.out.println("Persona entrando a la actividad");
        salon.entrarActividad(actividad);
        salon.esperarEmpiezaActividad();
        System.out.println("Haciendo la actividad");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("Se termino la actividad");
        salon.seTerminoLaActidad();
        
        
        System.out.println("Persona entrando a la actividad");
        salon.entrarActividad((actividadHizo + 1)%3);
        salon.esperarEmpiezaActividad();
         System.out.println("Haciendo la actividad");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("Se termino la actividad");
          salon.seTerminoLaActidad();
         
    }

}
