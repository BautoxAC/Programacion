package p2;


public class Main {
    public static void main(String[] args) {
        Pedido p = new Pedido();
        Thread[] t = new Thread[2];
        Mozo m = new Mozo(p);
        Cocinero c = new Cocinero(p);
        Empleado[] ps = new Empleado[2];
        for (int i = 0; i < ps.length; i++) {
            ps[i] = new Empleado(p);
            t[i] = new Thread(ps[i]);
        }
        for (int i = 0; i < ps.length; i++) {
            t[i].start();
        }
        new Thread(m).start();
        new Thread(c).start();
   } 
}
