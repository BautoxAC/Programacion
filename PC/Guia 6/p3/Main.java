public class Main {
    public static void main(String[] args) {

        Sala sala = new Sala();
        Thread[] hilosVisitante = new Thread[10];
        Visitante[] visitantes = new Visitante[10];
        Thread[] hilosSillaruedas = new Thread[3];
        SillaRuedas[] sillaRuedas = new SillaRuedas[3];
        Thread[] hilosMante = new Thread[4];
        Mantenimiento[] mante = new Mantenimiento[4];

        for (int i = 0; i < visitantes.length; i++) {
            visitantes[i] = new Visitante(sala);
            hilosVisitante[i] = new Thread(visitantes[i]);
        }
        for (int i = 0; i < hilosVisitante.length; i++) {
            hilosVisitante[i].start();
        }

        for (int i = 0; i < sillaRuedas.length; i++) {
            sillaRuedas[i] = new SillaRuedas(sala);
            hilosSillaruedas[i] = new Thread(sillaRuedas[i]);
        }
        for (int i = 0; i < hilosSillaruedas.length; i++) {
            hilosSillaruedas[i].start();
        }

        for (int i = 0; i < mante.length; i++) {
            mante[i] = new Mantenimiento(sala);
            hilosMante[i] = new Thread(mante[i]);
        }
        for (int i = 0; i < hilosMante.length; i++) {
            hilosMante[i].start();
        } 

        Thread[] hilosInve = new Thread[5];
        Investigador[] inves = new Investigador[5];
        for (int i = 0; i < inves.length; i++) {
            inves[i] = new Investigador(sala);
            hilosInve[i] = new Thread(inves[i]);
        }
        for (int i = 0; i < hilosInve.length; i++) {
            hilosInve[i].start();
        }


    }
}
