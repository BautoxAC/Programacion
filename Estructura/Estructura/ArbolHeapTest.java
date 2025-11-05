import constructistas.ArbolHeap.ArbolHeap;

public class ArbolHeapTest {
    public static void main(String[] args) {
        ArbolHeap arbol = new ArbolHeap();
        arbol.insertar(1);
        arbol.insertar(3);
        arbol.insertar(4);
        arbol.insertar(5);
        arbol.insertar(6);
        arbol.insertar(7);
        arbol.insertar(8);
        arbol.insertar(9);
        arbol.insertar(10);
        arbol.insertar(11);
        arbol.insertar(2);
        arbol.eliminarCima();
        System.out.println(arbol.toString());
    }
}
