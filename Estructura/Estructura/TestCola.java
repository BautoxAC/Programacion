
import lineales.dinamicas.Cola;

public class TestCola {
    public static void main(String[] args) {
        Cola cola = new Cola();
        cola.poner(3);
        cola.poner(4);
        cola.poner(5);
        cola.poner(6);
        cola.poner(7);
        cola.poner(8);
        cola.poner(9);
        Cola clon = cola.clone();
        System.out.println(cola.toString());
        System.out.println(clon.toString());
    }
}
