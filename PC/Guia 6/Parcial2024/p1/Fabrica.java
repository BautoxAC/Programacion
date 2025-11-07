package Parcial2024.p1;

import java.util.concurrent.Semaphore;

public class Fabrica {
    private int CAPACIDAD_RUEDAS;
    private int CAPACIDAD_PUERTAS;
    private int CAPACIDAD_CARROCERIAS;
    private Semaphore ruedasListas;
    private Semaphore puertasListas;
    private Semaphore carroceriasListas;
    private Semaphore produccionEspera;
    private int cantCarrocerias ;
    private int cantRuedas ;
    private int cantPuertas;
    private Semaphore mutex;
    private int producidos;

    public Fabrica() {
        CAPACIDAD_CARROCERIAS = 1;
        CAPACIDAD_RUEDAS = 4;
        CAPACIDAD_PUERTAS = 2;
        cantCarrocerias = 0;
        cantRuedas = 0;
        cantPuertas = 0;
        produccionEspera = new Semaphore(0);
        ruedasListas = new Semaphore(0);
        puertasListas = new Semaphore(0);
        carroceriasListas = new Semaphore(0);
        mutex = new Semaphore(1);
        producidos = 0;
    }

    public void empezarProducirRuedas() {
        try {

            if (CAPACIDAD_RUEDAS == cantRuedas) {
                produccionEspera.acquire();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void terminarProducirRuedas() {
        try {
            mutex.acquire();
            cantRuedas+=1;
            mutex.release();
            ruedasListas.release(1);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void empezarProducirPuertas() {
        try {

            if (CAPACIDAD_PUERTAS == cantPuertas) {
                produccionEspera.acquire();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void terminarProducirPuertas() {
        try {
            mutex.acquire();
            cantPuertas+=1;
            mutex.release();
            puertasListas.release(1);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void empezarProducirCarroceria() {
        try {

            if (CAPACIDAD_CARROCERIAS == cantCarrocerias) {
                produccionEspera.acquire();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void terminarProducirCarroceria() {
        try {
            mutex.acquire();
            cantCarrocerias+=1;
            mutex.release();
            carroceriasListas.release(1);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void empezarProduccionAuto(){
        try {
            System.out.println("as");
            ruedasListas.acquire(4);
            puertasListas.acquire(2);
            carroceriasListas.acquire(1);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public boolean terminarProducirAuto(){
        boolean hizoCinco = false;
        try {
            mutex.acquire();
            cantPuertas-=2;
            cantRuedas-=4;
            cantCarrocerias-=1;
            producidos++;
            if (producidos==5) {
                hizoCinco = true;
            }
            mutex.release();
            produccionEspera.release(3);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return hizoCinco;
    }
    public void empaquetarAutos(){
        try {
            producidos-=5;
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
