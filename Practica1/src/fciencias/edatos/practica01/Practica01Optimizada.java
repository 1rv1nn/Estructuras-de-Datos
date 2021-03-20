package fciencias.edatos.practica01;

/**
 * Práctica Estructuras de Datos.
 * 
 * @author Erick Daniel Arrollo Martínez.
 * @author Cruz González Irvin Javier.
 * @version 1.0 Marzo 2021.
 * @since Laboratorio de Estructuras de Datos 2020-2.
 */
public class Practica01Optimizada {

    /**
     * Encuentra el índice del primer y último valor específico.
     * 
     * @param num   un arreglo de enteros.
     * @param value el valor a encontrar índices.
     * @return un arreglo de longitud 2, con el primer y último índice donde se
     *         encuentra el elemento value.
     */

    // Algoritmo de Irvin
    public static int[] findFirstAndLast(int[] num, int value) {
        int[] result = new int[2];
        try {
            int n = num.length;
            int primerV = -1, ultimoV = -1;
            for (int i = 0; i < n; i++) {
                if (value != num[i])
                    continue;
                if (primerV == -1)
                    primerV = i;
                ultimoV = i;
            }
            if (primerV != -1) {
                System.out.println(" [" + primerV + ", " + ultimoV + "]");
            } else
                System.out.println("[-1,-1]");
        } catch (Exception e) {
            System.out.println("Upps ocurrio un error.Verifica tus datos.");
        }
        return result;

    }

    /**
     * Verifica si un tablero de sudoku de 6x6 es válido, considerando únicamente
     * los casos de las verticales y las diagonales.
     * 
     * @param board el arreglo bidimensional de 6x6 que representa el tablero.
     * @return true si el tablero es válido, false, en otro caso.
     */

    /* Algoritmo de Erick-Sudoku */
    public static boolean filas(int[][] pruebas, int asi) {
        int[] auxiliar = { 1, 2, 3, 4, 5, 6 };
        int contador = 0;
        boolean verdad0 = true;
        boolean verdad1 = true;
        boolean verdad2 = true;
        boolean verdad3 = true;
        boolean verdad4 = true;
        boolean verdad5 = true;
        boolean verdadFinal = true;
        for (int i = 0; i < 6; i++) {
            if (pruebas[asi][0] == auxiliar[i]) {
                auxiliar[i] = 0;
                verdad0 = false;
            } else {

            }
            if (pruebas[asi][1] == auxiliar[i]) {
                auxiliar[i] = 0;
                verdad1 = false;
            }
            if (pruebas[asi][2] == auxiliar[i]) {
                auxiliar[i] = 0;
                verdad2 = false;
            }
            if (pruebas[asi][3] == auxiliar[i]) {
                auxiliar[i] = 0;
                verdad3 = false;
            }
            if (pruebas[asi][4] == auxiliar[i]) {
                auxiliar[i] = 0;
                verdad4 = false;
            }
            if (pruebas[asi][5] == auxiliar[i]) {
                auxiliar[i] = 0;
                verdad5 = false;
            }

        }
        verdadFinal = verdad0 || verdad1 || verdad2 || verdad3 || verdad4 || verdad5;
        return verdadFinal;

    }

    /**
     * @param pruebas - MAtriz de enteros
     * @param asi     valor int que indica la columna Metodo auxiliar para comprobar
     *                que una colunma de la matriz es valida
     */

    /* Algoritmo de Erick */
    public static boolean columnas(int[][] pruebas, int asi) {
        int[] auxiliar = { 1, 2, 3, 4, 5, 6 };
        int contador = 0;
        boolean verdad0 = true;
        boolean verdad1 = true;
        boolean verdad2 = true;
        boolean verdad3 = true;
        boolean verdad4 = true;
        boolean verdad5 = true;
        boolean verdadFinal = true;
        try {
            for (int i = 0; i < 6; i++) {
                if (pruebas[0][asi] == auxiliar[i]) {
                    auxiliar[i] = 0;
                    verdad0 = false;
                }
                if (pruebas[1][asi] == auxiliar[i]) {
                    auxiliar[i] = 0;
                    verdad1 = false;
                }
                if (pruebas[2][asi] == auxiliar[i]) {
                    auxiliar[i] = 0;
                    verdad2 = false;
                }
                if (pruebas[3][asi] == auxiliar[i]) {
                    auxiliar[i] = 0;
                    verdad3 = false;
                }
                if (pruebas[4][asi] == auxiliar[i]) {
                    auxiliar[i] = 0;
                    verdad4 = false;
                }
                if (pruebas[5][asi] == auxiliar[i]) {
                    auxiliar[i] = 0;
                    verdad5 = false;
                }
            }
            verdadFinal = verdad0 || verdad1 || verdad2 || verdad3 || verdad4 || verdad5;
        } catch (Exception e) {
            System.out.println("Error:" + " " + e);
        }
        return verdadFinal;

    }

    /**
     * @param matriz - Matriz de enteros Metodo para comprobar que una matriz es
     *               valida en sudoku
     */

    /* Algoritmo de Erick */
    public static boolean sudoku2(int[][] matriz) {
        boolean f1, f2, f3, f4, f5, f6, c1, c2, c3, c4, c5, c6, pasa = false;
        try {
            f1 = filas(matriz, 0);
            f2 = filas(matriz, 1);
            f3 = filas(matriz, 2);
            f4 = filas(matriz, 3);
            f5 = filas(matriz, 4);
            f6 = filas(matriz, 5);
            c1 = columnas(matriz, 0);
            c2 = columnas(matriz, 1);
            c3 = columnas(matriz, 2);
            c4 = columnas(matriz, 3);
            c5 = columnas(matriz, 4);
            c6 = columnas(matriz, 5);
            pasa = f1 || f2 || f3 || f4 || f5 || f6 || c1 || c2 || c3 || c4 || c5 || c6;
            if (pasa == false) {
                pasa = true;
            } else if (pasa == true) {
                pasa = false;
            }

        } catch (Exception e) {
            System.out.println("Error:" + " " + e);
        }
        return pasa;
    }

    /**
     * @param num      - Arreglo de enteros
     * @param position - Valor entero que indica las veces que se movera cada
     *                 elemnto del arreglo Metodo para rotar a todos los elementos
     *                 de una arreglo segun el valor que toma position(rota hacia la
     *                 izquierda)
     */

    /* Algoritmo Erick */
    public static int[] proRotate(int[] num, int position) {
        int[] aux = new int[num.length];
        try {
            if (position == 0) {
                aux = num;
                return aux;
            }
            for (int i = 0; i < num.length; i++) {
                if (i < position) {
                    aux[(i + num.length) - position] = num[i];

                } else if (i == position) {
                    aux[0] = num[i];

                } else {
                    aux[i - position] = num[i];

                }
            }
        } catch (Exception e) {
            System.out.println("Error" + " " + e);
        }

        return aux;

    }

    // ACTIVIDAD 1
    public static void main(String[] args) {

        int[] ejemplo1a = { 1, 4, 2, 1, 6, 2, 9 };
        int[] ejemplo1b = { 4, 2, 7, 5, 4, 3, 7, 2, 5, 3, 4, 1 };
        int[] ejemplo1c = { 3, 2, 1, 4, 2 };

        System.out.println("\n ACTIVIDAD 1 ");
        // int[] resultado2a = findFirstAndLast(ejemplo1a, 2);
        int[] resultado2b = findFirstAndLast(ejemplo1b, 15);
        // int[] resultado2c = findFirstAndLast(ejemplo1c, 1);
        long inicial = System.nanoTime();
        // long inicial = System.currentTimeMillis();
        // int[] salida11 = resultado2a;
        int[] salida12 = resultado2b;
        // int[] salida13 = resultado2c;
        // long fin = System.currentTimeMillis();
        long fin = System.nanoTime();
        System.out.println(" El algoritmo 2 tarda " + (fin - inicial) + " milisegundos");

        // ACTIVIDAD 2

        int[][] ejemplo2a = { { 4, 5, 6, 2, 3, 1 }, { 3, 1, 2, 6, 4, 5 }, { 1, 6, 4, 3, 5, 2 }, { 5, 2, 3, 1, 6, 4 },
                { 2, 3, 5, 4, 1, 6 }, { 6, 4, 1, 5, 2, 3 } };

        int[][] ejemplo2b = { { 4, 5, 6, 2, 3, 1 }, { 3, 1, 2, 6, 4, 5 }, { 2, 6, 4, 3, 5, 2 }, { 5, 2, 3, 1, 6, 4 },
                { 1, 3, 5, 4, 1, 6 }, { 6, 4, 1, 5, 2, 3 } };

        System.out.println("\n ACTIVIDAD 2 ");
        long inicialDos = System.currentTimeMillis();
        boolean resultadoDosA = sudoku2(ejemplo2a);
        boolean resultadoDosB = sudoku2(ejemplo2b);
        System.out.println(" El sudoku 1 es válido: " + resultadoDosA);
        System.out.println(" El sudoku 2 es válido: " + resultadoDosB);
        long finDos = System.currentTimeMillis();
        System.out.println(" El algoritmo 2 tarda " + (finDos - inicialDos) + " nanosegundos");

        // ACTIVIDAD 3

        proRotate(ejemplo1a, 5);
        proRotate(ejemplo1b, 0);
        proRotate(ejemplo1c, 2);

        System.out.println("\n ACTIVIDAD 3");
        System.out.println(" Arreglo 1 rotado 5 veces");
        long inicial2 = System.currentTimeMillis();
        for (int i : ejemplo1a)
            System.out.print(i + " ");

        System.out.println("\n Arreglo 2 rotado 0 veces");
        for (int i : ejemplo1b)
            System.out.print(i + " ");
        System.out.println("\n Arreglo 3 rotado 2 veces");
        for (int i : ejemplo1c)
            System.out.print(i + " ");
        long fin2 = System.currentTimeMillis();
        System.out.println("\n El algoritmo 2 tarda " + (fin2 - inicial2) + " nanosegundos");

    }
}