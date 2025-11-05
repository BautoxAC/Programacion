
import lineales.dinamicas.*;
import java.util.Scanner;

public class ColaXd {
    public static void main(String[] args) {
        String palabra = "mary es la mejor";
        String copiaPalabra = "";
        for (int i = 0; i < palabra.length(); i++) {
            if (!esVocal(palabra.charAt(i)) && palabra.charAt(i) != ' ') {
                copiaPalabra += palabra.charAt(i);
            }
        }

    }

    public static boolean esVocal(char l) {
        return true;
    }
}
