package p2;

import java.util.concurrent.Semaphore;

public class Pedido {
    private Semaphore esperaClienteMozo;
    private Semaphore esperaClienteCocinero;
    private Semaphore lugar;
    private Semaphore atencionMozo;
    private Semaphore atencionCocinero;

    public Pedido() {
        lugar = new Semaphore(2);
        esperaClienteMozo = new Semaphore(0);
        atencionMozo = new Semaphore(0);
        esperaClienteCocinero = new Semaphore(0);
        atencionCocinero = new Semaphore(0);
    }

    public void esperaClienteMozo() {
        try {
            esperaClienteMozo.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void llegoClienteMozo() {
        esperaClienteMozo.release();
    }

    public void esperaClienteCocinero() {
        try {
            esperaClienteCocinero.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void llegoClienteCocinero() {
        esperaClienteCocinero.release();
    }

    public void esperaLugar() {
        try {
            lugar.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void liberaLugar() {
        lugar.release();
    }

    public void liberarAtencionMozo() {
        atencionMozo.release();
    }

    public void esperaAtencionMozo() {
        try {
            atencionMozo.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void liberarAtencionCocinero() {
        atencionCocinero.release();
    }

    public void esperaAtencionCocinero() {
        try {
            atencionCocinero.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
