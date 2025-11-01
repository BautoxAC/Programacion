package p5;

public class Main {
    public static void main(String[] args) {
        Torre2 torre = new Torre2();
        Avion2[] aviones = new Avion2[30];
        Thread[] hAviones = new Thread[30];
        for (int i = 0; i < hAviones.length; i++) {
            aviones[i] = new Avion2(torre);
            hAviones[i] = new Thread(aviones[i]);
        }
        for (int i = 0; i < hAviones.length; i++) {
            hAviones[i].start();
        }
    }
}
