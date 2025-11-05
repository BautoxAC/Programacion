import JERARQUICAS.ARBOLGEN.ArbolGen;
import lineales.dinamicas.Lista;

public class ArbolGenTest {
    public static void main(String[] args) {
        ArbolGen arbol = new ArbolGen();
        arbol.insertar(9, 5);
        arbol.insertar(2, 9);
        arbol.insertar(3, 9);
        arbol.insertar(3, 2);
        arbol.insertar(4, 2);
        arbol.insertar(4, 2);
        arbol.insertar(5, 4);
        arbol.insertar(412, 5);
        arbol.insertar(13, 412);
        arbol.insertarPorPosicion(10, 5);
        arbol.insertarPorPosicion(100, 9);
        System.out.println(arbol.toString());
        arbol.jerarquizar(3);
        System.out.println(arbol.toString());
        
        /* arbol.ancestros(4); */
        /* System.out.println(arbol.listarPreorden().toString());
        System.out.println(arbol.listarPosorden().toString());
        System.out.println(arbol.listarInorden().toString());
        System.out.println(arbol.toString());
        ArbolGen clon = arbol.clone();
        System.out.println(clon.toString()); */
    }
}
