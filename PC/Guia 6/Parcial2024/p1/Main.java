package Parcial2024.p1;

public class Main {
    public static void main(String[] args) {
        Fabrica f = new Fabrica();
        EquipoCarroceria eC = new EquipoCarroceria(f);
        EquipoPuertas eP = new EquipoPuertas(f);
        EquipoRuedas eR = new EquipoRuedas(f);
        EquipoAuto eA = new EquipoAuto(f);
        new Thread(eA).start();
        new Thread(eC).start();
        new Thread(eP).start();
        new Thread(eR).start();

    }
}
