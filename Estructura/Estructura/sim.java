public class sim {
    public static void main(String[] args) {
        int[][] matriz = { { 2, 3, 2 }, { 101, 11, 10 }, { 4, 20, 2 } };
        System.out.println(recorrerMatriz(matriz, 0, 0));
        System.out.println(sumaImpares(11237));
    }

    public static int recorrerMatriz(int[][] matriz, int i, int j) {
        int cantNum = 0;
        if (i < matriz.length) {
            if (j < matriz[0].length) {
                if ((i + j) == sumaImpares(matriz[i][j])) {
                    cantNum++;
                }
                cantNum = recorrerMatriz(matriz, i, j + 1) + cantNum;
            } else {
                cantNum = recorrerMatriz(matriz, i + 1, 0);
            }
        }
        return cantNum;
    }

    public static int sumaImpares(int num) {
        int suma = 0;
        if (num > 0) {
            int ultimoDigito = num % 10;
            if ((ultimoDigito % 2) == 0) {
                ultimoDigito = 0;
            }
            suma = sumaImpares(num / 10) + ultimoDigito;
        }
        return suma;
    }
}
