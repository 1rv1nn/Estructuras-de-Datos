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

     //Algoritmo de Irvin
    public static int[] findFirstAndLast(int[] num, int value) {

        int[] result = new int[2];
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
            System.out.println("[" + primerV + ", " + ultimoV + "]");
        } else
            System.out.println("[-1,-1]");

        return result;
    }

    //Algoritmo de Erick
    public static int[] remasterA1(int[] arregloA, int numero) {
        long inicio = System.nanoTime();

        int[] aux = new int[2];
        int contadorIzq = arregloA.length - 1;
        int longi = 0;
        int derecha = 0;
        int izq = 0;
        int izquierda = arregloA.length - 1;

        aux[0] = -1;
        aux[1] = -1;

        if (arregloA.length % 2 == 0) {
            longi = arregloA.length / 2;
        } else {
            longi = (arregloA.length + 1) / 2;
        }

        for (int i = 0; i < longi; i++) {
            if (arregloA[i] == numero && derecha == 0) {
                aux[0] = i;
                derecha++;
            }
            if (arregloA[contadorIzq] == numero && izq == 0) {
                aux[1] = contadorIzq;
                izq++;
            }
            if (izq == 1 && derecha == 1) {
                break;
            }
            contadorIzq--;
        }
        long finala = System.nanoTime();
        System.out.println("Tiempo de ejecucion dentro del método:"); //Problema
        System.out.println(finala - inicio + " " + "nanosegundos");

        return aux;

    }

    // ACTIVIDAD 1
    public static void main(String[] args) {

        int[] ejemplo1a = { 1, 4, 2, 1, 6, 2, 9 };
        // int[] ejemplo1b = { 4, 2, 7, 5, 4, 3, 7, 2, 5, 3, 4, 1 };
        // int[] ejemplo1c = { 3, 2, 1, 4, 2 };

        System.out.println("\n ACTIVIDAD 1 \n");
        int[] resultado1a = remasterA1(ejemplo1a, 2);
        // findFirstAndLast(ejemplo1b, 67);
        // findFirstAndLast(ejemplo1c, 1);
        long inicial = System.nanoTime();
        int[] salida1 = resultado1a;
        long fin = System.nanoTime();
        System.out.println("\n \n El algoritmo 2 de Erick tarda " + (fin - inicial) + " nanosegundos");
      
         
        int[] resultado2a = findFirstAndLast(ejemplo1a, 2);
        inicial = System.nanoTime();
        int[] salida12 = resultado2a;
        fin = System.nanoTime();
        System.out.println("\n \n El algoritmo 2 de Irvin tarda " + (fin - inicial) + " nanosegundos");


    }
}   