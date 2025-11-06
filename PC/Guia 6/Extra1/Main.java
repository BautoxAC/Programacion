package Extra1;

public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen();
        Mesa mesa = new Mesa();
        Empaquetador empaquetador = new Empaquetador(mesa, almacen);
        Camion camion = new Camion(almacen);
        Embotellador[] embotelladores = new Embotellador[4];
        new Thread(camion).start();
        
        new Thread(empaquetador).start();
        for (int i = 0; i < embotelladores.length; i++) {
            if (i%2 ==0) {
                embotelladores[i] = new Embotellador(mesa, 'V');
            }else{
                embotelladores[i] = new Embotellador(mesa, 'S');
                
            }
            new Thread(embotelladores[i]).start();
        }
    }
}
