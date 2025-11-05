/************* Autores ***********
Tomas Ismael Cárdenas Maldonado - FAI-4884
Bautista Tosi: Juan Bautista Tosi Griedassov- FAI-5162
Santiago Fuentes: Santiago Emanuel Fuentes FAI  - [5383]
Santiago Fuentes: PASCAL RIOS, IVO JAVIER, FAI-5200
*/
package lineales.dinamicas;

import lineales.dinamicas.NODO.Nodo;

public class Lista {
    private Nodo cabecera;

    public Lista() {
        this.cabecera = null;
    }

    public boolean insertar(Object elem, int indice) {
        boolean logrado = false;
        int longitud = this.longitud();
        if (indice > 0 && indice <= longitud + 1) {
            Nodo nuevo = new Nodo(elem, null);
            if (indice == 1) {
                nuevo.setEnlace(cabecera);
                this.cabecera = nuevo;
            } else {
                Nodo actual = this.cabecera;
                for (int i = 1; i < indice - 1; i++) {
                    actual = actual.getEnlace();
                }
                nuevo.setEnlace(actual.getEnlace());
                actual.setEnlace(nuevo);

            }
            logrado = true;
        }
        return logrado;
    }

    public boolean eliminar(int indice) {
        boolean hecho = true;
        int longitud = this.longitud();
        if (indice > 0 && indice <= longitud) {
            if (indice == 1) {
                this.cabecera = this.cabecera.getEnlace();
            } else {
                Nodo actual = this.cabecera;
                for (int i = 1; i < indice - 1; i++) {
                    actual = actual.getEnlace();
                }
                actual.setEnlace(actual.getEnlace().getEnlace());
            }
        } else {
            hecho = false;
        }
        return hecho;
    }

    public String toString() {
        Nodo actual = this.cabecera;
        String txt = "";
        txt += "[";
        int longitud = this.longitud();
        for (int i = 1; i < longitud + 1; i++) {
            txt += actual.getElem();
            if (actual.getEnlace() != null) {
                txt += ",";
            }
            actual = actual.getEnlace();
        }
        txt += "]";
        return txt;
    }

    public Object recuperar(int indice) {
        Nodo nodo = this.cabecera;
        Object elem = null;
        int longitud = this.longitud();
        if (indice >= 1 && indice <= longitud) {
            elem = nodo.getElem();
            for (int i = 1; i < indice; i++) {
                nodo = nodo.getEnlace();
                elem = nodo.getElem();
            }
        }
        return elem;
    }

    public int localizar(Object elem) {
        Nodo nodo = this.cabecera;
        int i = 1;
        int longitud = this.longitud();
        while (i <= longitud && !elem.equals(nodo.getElem())) {
            nodo = nodo.getEnlace();
            i++;
        }
        if (i == longitud + 1) {
            i = -1;
        }
        return i;
    }

    public int longitud() {
        Nodo nodo = this.cabecera;
        int i = 0;
        while (nodo != null) {
            nodo = nodo.getEnlace();
            i++;
        }
        return i;
    }

    public boolean esVacia() {
        boolean siEs = true;
        if (this.cabecera != null) {
            siEs = false;
        }
        return siEs;
    }

    public void vaciar() {
        this.cabecera = null;
    }

    public Lista clone() {
        Lista listaClon = new Lista();
        listaClon.cabecera = recorrerLista(this.cabecera);
        return listaClon;
    }

    private Nodo recorrerLista(Nodo nodoRecorrer) {
        Nodo nuevo = null;
        if (nodoRecorrer != null) {
            nuevo = new Nodo(nodoRecorrer.getElem(), recorrerLista(nodoRecorrer.getEnlace()));
        }
        return nuevo;
    }
}
