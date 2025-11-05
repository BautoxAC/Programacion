
import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;
public class TestLista {

    public static void main(String[] args) {
        Lista lista = new Lista();
        
        /* System.out.println(lista.toString());
        lista.eliminar(2);
        System.out.println(lista.toString());
        System.out.println(lista.recuperar(2)); */
        /* System.out.println(lista.localizar(3));
        System.out.println(lista.toString());
        System.out.println(lista.esVacia()); */
        /* System.out.println(lista.esVacia());
        System.out.println(listaClon.toString());
        System.out.println(lista.toString()); */
        lista.insertar(3, 3);
        lista.insertar(4, 2);
        Lista listaClon = lista.clone();
        Cola colaPrint=new Cola();
        colaPrint.poner('a');
        colaPrint.poner('b');
        colaPrint.poner('c');
        colaPrint.poner('#');
        colaPrint.poner('d');
        colaPrint.poner('e');
        colaPrint.poner('f');
        colaPrint.poner('#');
        colaPrint.poner('q');
        colaPrint.poner('w');
        colaPrint.poner('r');
        colaPrint.poner('t');
        colaPrint.poner('y');
        colaPrint.poner('#');
        colaPrint.poner('s');
        colaPrint.poner('j');
        System.out.println(colaPrint.toString());
        System.out.println(generarLista(colaPrint).toString());
    }
    public static Lista generarLista(Cola q){
        Pila pilaAux = new Pila();
        Cola clon = q.clone();
        Cola colaAux = new Cola();
        Object elActual= clon.obtenerFrente();
        Lista listaRet=new Lista();
        int contIt=0;
        int longi=1;
        while (elActual!=null && !clon.esVacia()) {
            System.out.println(elActual);
            if (!elActual.equals('#')) {
                if (contIt%2==0) {
                    pilaAux.apilar(elActual);
                }else{
                    colaAux.poner(elActual);
                }
                clon.sacar();
                elActual=clon.obtenerFrente();
                if (clon.obtenerFrente()==null) {
                    elActual='#';
                    clon.poner(elActual);
                }
            }else{
                if (!pilaAux.esVacia()) {
                    Object obPila=pilaAux.obtenerTope();
                    listaRet.insertar(obPila, longi);
                    longi++;
                    pilaAux.desapilar();
                }else if (!colaAux.esVacia()) {
                    Object obCola=colaAux.obtenerFrente();
                    listaRet.insertar(obCola, longi);
                    longi++;
                    colaAux.sacar();
                }else if (clon.obtenerFrente()!=null) {
                    listaRet.insertar(elActual, longi);
                    longi++;
                    contIt++;
                    clon.sacar();
                    elActual=clon.obtenerFrente();
                    if (clon.obtenerFrente()==null) {
                        listaRet.eliminar(longi-1);
                    }
                }
            }
        }
        return listaRet;
    }
}