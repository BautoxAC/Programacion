package p1;

public class Main {
   public static void main(String[] args) {
        GestorPiscina p = new GestorPiscina(7);
        Thread[] t = new Thread[50];
        Persona[] ps = new Persona[50];
        for (int i = 0; i < ps.length; i++) {

            ps[i] = new Persona(p);
            t[i] = new Thread(ps[i]);
        }
        for (int i = 0; i < ps.length; i++) {
            t[i].start();
        }
   } 
}
