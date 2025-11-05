import constructistas.AVL.ArbolAVL;

public class AVLTest {
    public static void main(String[] args) {
        ArbolAVL arbol = new ArbolAVL();
        arbol.insertar(3);
        arbol.insertar(2);
        arbol.insertar(6);
        arbol.insertar(324);
        arbol.insertar(325);
        arbol.insertar(4);
        arbol.insertar(1);
        arbol.insertar(43);
        arbol.insertar(5);
        arbol.insertar(456);
        arbol.insertar(44);
        arbol.insertar(0);
        arbol.insertar(23);
        arbol.insertar(567);
        arbol.insertar(78);
        arbol.insertar(-12);//0.5
        arbol.insertar(45367);
        arbol.insertar(457634577);
        arbol.insertar(56);
        arbol.insertar(77);
        arbol.insertar(11);
        arbol.insertar(34);
        arbol.insertar(45);
        arbol.insertar(79);
        arbol.insertar(111);
        arbol.insertar(222);
        arbol.insertar(555); 
        arbol.insertar(10); 
        arbol.insertar(554); 
        System.out.println(arbol.toString());
    }
}
