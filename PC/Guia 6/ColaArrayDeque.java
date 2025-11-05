import java.util.ArrayDeque;
import java.util.Queue;

public class ColaArrayDeque {
    public static void main(String[] args) {
        Queue<Integer> cola = new ArrayDeque<>();

        cola.offer(10);
        cola.offer(20);
        cola.offer(30);

        System.out.println("Cola: " + cola);
        System.out.println("Frente: " + cola.peek());

        cola.poll(); // elimina el 10
        System.out.println("Después de poll: " + cola);
    }
}