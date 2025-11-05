import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Sala {
    private ReentrantLock lock;
    private Condition visitantes;
    private Condition investigadores;
    private Condition mantenimiento;

    private int capacidad;
    // Contadores Adentro
    private int cantMantenimiento;
    private int cantSillaRuedas;
    private boolean hayInvestigador;
    private int cantVisitantes;
    // Limites
    private int limVisitantes;
    private int limManteni;
    // Contadores de los limites
    private int limVisitantesCont;
    private int limManteniCont;
    // Contadores de los de espera
    private int esperaVisitantes;
    private int esperaInvestigadores;
    private int esperaMantenimiento;

    public Sala() {
        capacidad = 8;
        cantMantenimiento = 0;
        cantVisitantes = 0;
        hayInvestigador = false;
        limVisitantes = 3;
        limManteni = 1;
        limVisitantesCont = 0;
        limManteniCont = 0;
        esperaVisitantes = 0;
        esperaInvestigadores = 0;
        esperaMantenimiento = 0;
        lock = new ReentrantLock(true);
        visitantes = lock.newCondition();
        investigadores = lock.newCondition();
        mantenimiento = lock.newCondition();
    }

    public void entrarVisitante() {
        lock.lock();
        try {
            esperaVisitantes++;
            while (cantVisitantes >= capacidad || cantMantenimiento > 0 || hayInvestigador
                    || limVisitantes == limVisitantesCont) {
                visitantes.await();
            }
            esperaVisitantes--;
            limVisitantesCont++;
            cantVisitantes++;
            lock.unlock();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void entrarSillaRueda() {
        lock.lock();
        try {
            esperaVisitantes++;
            while (cantVisitantes >= capacidad || cantMantenimiento > 0 || hayInvestigador
                    || limVisitantes == limVisitantesCont) {
                visitantes.await();
            }
            esperaVisitantes++;
            limVisitantes++;
            cantSillaRuedas++;
            capacidad = 4;
            cantVisitantes++;
            lock.unlock();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void entrarMantenimiento() {
        lock.lock();
        try {
            esperaMantenimiento++;
            while (cantVisitantes > 0 || cantMantenimiento >= capacidad || hayInvestigador
                    || limManteniCont == limManteni) {
                mantenimiento.await();
            }
            esperaMantenimiento--;
            limManteniCont++;
            cantMantenimiento++;
            lock.unlock();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void entrarInvestigador() {
        lock.lock();
        try {
            esperaInvestigadores++;
            while (cantVisitantes > 0 || cantMantenimiento > 0 || hayInvestigador) {
                investigadores.await();
            }
            esperaInvestigadores--;
            hayInvestigador = true;
            lock.unlock();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void salirVisitante() {
        lock.lock();
        try {

            cantVisitantes--;
            if (cantVisitantes == 0) {
                if (esperaInvestigadores > 0) {
                    investigadores.signal();
                    limVisitantesCont = 0;
                }
                if (esperaMantenimiento > 0) {
                    mantenimiento.signalAll();
                    limVisitantesCont = 0;
                }
                if (esperaMantenimiento == 0 && esperaInvestigadores == 0 && esperaVisitantes > 0) {
                    limVisitantesCont = 0;
                    visitantes.signalAll();
                }
            }
            visitantes.signal();
            lock.unlock();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void salirSalirSillaRuedas() {
        lock.lock();
        try {
            cantVisitantes--;
            cantSillaRuedas--;
            if (cantSillaRuedas == 0) {
                capacidad = 8;
                visitantes.signalAll();
            }
            if (cantVisitantes == 0) {
                if (esperaInvestigadores > 0) {
                    investigadores.signal();
                    limVisitantesCont = 0;
                }
                if (esperaMantenimiento > 0) {
                    mantenimiento.signalAll();
                    limVisitantesCont = 0;
                }
                if (esperaMantenimiento == 0 && esperaInvestigadores == 0 && esperaVisitantes > 0) {
                    limVisitantesCont = 0;
                    visitantes.signalAll();
                }
            }
            visitantes.signal();
            lock.unlock();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void salirMantenimiento() {
        lock.lock();
        try {

            cantMantenimiento--;
            if (cantMantenimiento == 0) {
                if (esperaVisitantes > 0) {
                    visitantes.signalAll();
                    limManteniCont = 0;
                }
                if (esperaInvestigadores > 0) {
                    investigadores.signal();
                    limManteniCont = 0;
                }
                if (esperaVisitantes == 0 && esperaInvestigadores == 0 && esperaMantenimiento > 0) {
                    limManteniCont = 0;
                    mantenimiento.signalAll();
                }
            }
            mantenimiento.signal();
            lock.unlock();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void salirInvestigador() {
        lock.lock();
        try {

            hayInvestigador = false;
            if (esperaMantenimiento > 0) {
                mantenimiento.signalAll();
            }
            if (esperaVisitantes > 0) {
                visitantes.signalAll();
            }
            System.out.println(esperaInvestigadores);
            if (esperaVisitantes == 0 && esperaMantenimiento == 0 && esperaInvestigadores > 0) {
                investigadores.signal();
            }
            lock.unlock();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
