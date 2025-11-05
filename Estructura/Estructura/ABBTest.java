
import constructistas.ABB.ArbolBB;
import constructistas.ABB.ArbolBB2;
import lineales.dinamicas.Lista;

public class ABBTest {
    public static void main(String[] args) {
        ArbolBB arbol = new ArbolBB();
        System.out.println(((Comparable)10).compareTo(122));
        arbol.insertar(3);
        arbol.insertar(2);
        arbol.insertar(6);
        arbol.insertar(3214);
        arbol.insertar(4);
        Lista lista = arbol.listarMenores(5);
        System.out.println(lista.toString());
        /* ArbolBB arbol2 = arbol.clonarParteInvertida(6);
        System.out.println(arbol2.listar().toString());
        Lista lista2 = arbol.listarRango(0, 1000000);
        System.out.println(lista2.toString()); */
    }
}
