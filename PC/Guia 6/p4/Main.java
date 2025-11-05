public class Main {
    public static void main(String[] args) {
        Auto[] autos = new Auto[14];
        Trafico trafico = new Trafico();
        int mitad = autos.length / 2;
        for (int i = 0; i < autos.length-mitad; i++) {
            autos[i] = new Auto('N', trafico);
            new Thread(autos[i]).start();
        }
        for (int i = mitad; i < autos.length; i++) {
            autos[i] = new Auto('S', trafico);
            new Thread(autos[i]).start();
            
        }
    }
}
