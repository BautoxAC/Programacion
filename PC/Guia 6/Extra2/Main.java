package Extra2;

public class Main {
    public static void main(String[] args) {
        Salon salon = new Salon();
        Persona[] personas = new Persona[12];
        for (int i = 0; i < personas.length; i++) {
            
            personas[i] = new Persona(salon, i%3);
            new Thread(personas[i]).start();
        }
    }
}
