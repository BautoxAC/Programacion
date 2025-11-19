

import java.util.concurrent.Semaphore;

import dinamicas.Cola;

public class Restaurante {
    private Semaphore pedidosParaHacer;
    private Semaphore pedidosPrepados;
    private Semaphore esperaReparto;
    private Semaphore mutex;
    private Cola colaPedidosParaHacer;
    private Cola colaPedidosPreparados;
    private int MaximoPedidosPreparados;
    private int cantPedidosPreparados;
    private int esperandoReparto;
    private int repartosTotales;

    public Restaurante() {
        pedidosParaHacer = new Semaphore(0);
        pedidosPrepados = new Semaphore(0);
        esperaReparto = new Semaphore(0);
        mutex = new Semaphore(1);
        colaPedidosParaHacer = new Cola();
        colaPedidosPreparados = new Cola();
        MaximoPedidosPreparados = 5;
        cantPedidosPreparados = 0;
        esperandoReparto = 0;
        repartosTotales = 0;
    }

    public Pedido crearPedido(char tipoPizza, String nombreCliente) {
        Pedido p = new Pedido(tipoPizza, nombreCliente);
        colaPedidosParaHacer.poner(p);
        pedidosParaHacer.release(1);
        return p;
    }

    public void empezarPedido() {
        try {
            pedidosParaHacer.acquire(1);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

     public void terminarPedido() {
        try {
            
            mutex.acquire();
            Pedido p = (Pedido)colaPedidosParaHacer.obtenerFrente();
            colaPedidosParaHacer.sacar();
            if (MaximoPedidosPreparados == cantPedidosPreparados || esperandoReparto>0) {
                esperandoReparto ++;
                mutex.release();
                esperaReparto.acquire();
                mutex.acquire();
                esperandoReparto--;
            }
            cantPedidosPreparados++;
            colaPedidosPreparados.poner(p);
            mutex.release();
            pedidosPrepados.release(1);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void empezarReparto(){  
        try {
            pedidosPrepados.acquire(1);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public boolean terminarReparto(){
        boolean descanso = false;
        try {
            mutex.acquire();
            colaPedidosPreparados.sacar();
            cantPedidosPreparados--;
            if (esperandoReparto>0) {
                esperaReparto.release(1);
            }
            repartosTotales++;
            if (repartosTotales ==10) {
                descanso = true;
                repartosTotales=0;
            }
            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return descanso;
    }
}
