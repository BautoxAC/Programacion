import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Sala {
    private ReentrantLock lock;
    private Condition visitantes;
    private Condition investigadores;
    private Condition sillaRuedas;
    private Condition mantenimiento;
    private int capacidad;
    private int cantMantenimiento;
    private int cantSillaRuedas;
    private boolean hayInvestigador;
    private int cantVisitantes;
    public Sala(){
        capacidad = 50;
        cantMantenimiento = 0;
        cantVisitantes = 0;
        hayInvestigador = false;
        lock = new ReentrantLock(true);
        visitantes = lock.newCondition();
        investigadores = lock.newCondition();
        sillaRuedas = lock.newCondition();
        mantenimiento = lock.newCondition();
    }


    public void entrarVisitante(){
        lock.lock();
        try {
            while (cantVisitantes>=capacidad || cantMantenimiento>0 || hayInvestigador) {
                visitantes.await();
            }
            cantVisitantes++;
            lock.unlock();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void entrarSillaRueda(){
        lock.lock();
        try {
            while (cantVisitantes>=capacidad|| cantMantenimiento>0 || hayInvestigador) {
                visitantes.await();
            }
            cantSillaRuedas++;
            capacidad = 30;
            cantVisitantes++;
            lock.unlock();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void entrarMantenimiento(){
        lock.lock();
        try {
            while (cantVisitantes>0 || cantMantenimiento>=capacidad || hayInvestigador) {
                mantenimiento.await();
            }
            cantMantenimiento++;
            lock.unlock();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void entrarInvestigador(){
        lock.lock();
        try {
            while (cantVisitantes>0 || cantMantenimiento>0 || hayInvestigador) {
                investigadores.await();
            }
            hayInvestigador = true;
            lock.unlock();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void salirVisitante(){
        lock.lock();
        try {
            
            cantVisitantes--;
            if (cantVisitantes==0) {
                mantenimiento.signalAll();
                investigadores.signal();
            }
            lock.unlock();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void salirSalirSillaRuedas(){
        lock.lock();
        try {
            cantVisitantes--;
            cantSillaRuedas--;
            if (cantSillaRuedas==0) {
                capacidad = 50;
                visitantes.signalAll();
            }
            if (cantVisitantes==0) {
                mantenimiento.signalAll();
                investigadores.signal();
            }
            lock.unlock();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void salirMantenimiento(){
        lock.lock();
        try {
            
            cantMantenimiento--;
            if (cantMantenimiento>0) {
                mantenimiento.signal();
            } else {
                investigadores.signal();
                visitantes.signalAll();
            }
            lock.unlock();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void salirInvestigador(){
        lock.lock();
        try {
            
            hayInvestigador = false;
            visitantes.signalAll();
            mantenimiento.signalAll();
            lock.unlock();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
