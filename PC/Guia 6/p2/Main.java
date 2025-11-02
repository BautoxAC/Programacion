package p2;

public class Main {
    public static void main(String[] args) {
        Ferry ferry = new Ferry();
        ControlFerry controlFerry = new ControlFerry(ferry);
        Thread hiloFerry = new Thread(controlFerry);
        Thread[] hilosPersonas = new Thread[70];
        Persona[] personas = new Persona[70];
        Thread[] hilosAutos = new Thread[20];
        Auto[] autos = new Auto[20];
        for (int i = 0; i < autos.length; i++) {
            personas[i] = new Persona(ferry);
            hilosPersonas[i] = new Thread(personas[i]);
            autos[i] = new Auto(ferry);
            hilosAutos[i] = new Thread(autos[i]);

        }
        for (int i = 0; i < autos.length; i++) {
            hilosAutos[i].start();
            hilosPersonas[i].start();
        }
        hiloFerry.start();
    }
}
