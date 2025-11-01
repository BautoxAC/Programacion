package p5;

public class Main {
    public static void main(String[] args) {
        Torre torre = new Torre();
        Avion[] aviones = new Avion[30];
        Thread[] hAviones = new Thread[30];
        for (int i = 0; i < hAviones.length; i++) {
            aviones[i] = new Avion(torre);
            hAviones[i] = new Thread(aviones[i]);
        }
        for (int i = 0; i < hAviones.length; i++) {
            hAviones[i].start();
        }
    }
}
