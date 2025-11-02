package p1;

public class Main {
    public static void main(String[] args) {
        Sala sala = new Sala();
        Estudiante[] estudiantes = new Estudiante[9];
        Thread[] hilos = new Thread[9];
        for (int i = 0; i < hilos.length; i++) {
            estudiantes[i] = new Estudiante(sala);
            hilos[i] = new Thread(estudiantes[i]);
        }
        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }
    }
}
