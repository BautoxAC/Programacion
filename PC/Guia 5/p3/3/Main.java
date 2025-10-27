public class Main {
    public static void main(String[] args) {
        Recipiente r = new Recipiente();
        int h=2; 
        while (h<=2) {
            h++;
            Hidrogeno[] hs = new Hidrogeno[4];
            Oxigeno[] os = new Oxigeno[2];
            for (int i = 0; i < os.length; i++) {
                os[i] = new Oxigeno(r);
                hs[i] = new Hidrogeno(r);
            }
            for (int i = 0; i < os.length; i++) {
                new Thread(os[i]).start();
                new Thread(hs[i]).start();
            }
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
