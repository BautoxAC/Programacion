import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mesa {
    private Lock[] locks;
    private Condition[] condiciones;
    private int[] cantidades;

    public Mesa() {
        for (int i = 0; i < 4; i++) {
            locks[i] = new ReentrantLock();
            cantidades[i] = 0;
            condiciones[i] = locks[i].newCondition();
        }
    }
    public void ponerCancion(int tipo){
        locks[tipo].lock();
        cantidades[tipo]++;
        condiciones[tipo].signal();
        locks[tipo].unlock();
    }
    public void sacarCancion(int tipo){
        try {
            
            locks[tipo].lock();
            while (cantidades[tipo] == 0) {
                condiciones[tipo].await();
            }
            cantidades[tipo]--;
            locks[tipo].unlock();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}