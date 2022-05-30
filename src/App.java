public class App {
    public static void main(String[] args) throws Exception {

        /**
         * Declaracion de variables
         */
        
        int N = 1000; //Numero de filas y columnas de la matriz
        int [][] A = new int[N][N];
        int [][] B = new int[N][N];
        int [][] C = new int[N][N];
        int [][] si = new int[N][N];
        int [][] no = new int[N][N];
        Matrix matriz = new Matrix();

        System.out.println("***************PRACTICA 06: MATRICES***************\n\n");
        /**
         * Rellenado de las matrices con numeros aleatorios
         */
        matriz.rellenarMatriz(A);
        matriz.rellenarMatriz(B);

        /*System.out.println("Matriz 1:");
        matriz.imprimirMatriz(A); //Impresion de la Matriz A
        System.out.println();
        System.out.println("Matriz 2:");
        matriz.imprimirMatriz(B); //Impresion de la Matriz B
        System.out.println();*/

        /**
         * Toma de tiempos en ms y llamado de las funciones de multiplicacion
         */

        //Metodo tradicional para multiplicar 2 matrices cuadradas
        long startTime = System.currentTimeMillis();
        si = matriz.multiplicarMatrizBasico(A, B); //Llamado de la funcion de multiplicacion
        long endTime = System.currentTimeMillis();
        //matriz.imprimirMatriz(si); //Impresion de la Matriz si
        System.out.println("Tiempo de ejecucion (normal): " + (endTime - startTime) + "ms");
        System.out.println();

        //Metodo Recursivo (normal) para multiplicar 2 matrices cuadradas
        startTime = System.currentTimeMillis();
        no = matriz.multiplicacionMatrizRecursiva(A, B); //Llamado de la funcion de multiplicacion recursiva
        endTime = System.currentTimeMillis();
        //matriz.imprimirMatriz(no); //Impresion de la Matriz no
        System.out.println("Tiempo de ejecucion (recursivo): " + (endTime - startTime) + "ms");
        System.out.println();

        //Metodo Recursivo (Strassen) para multiplicar 2 matrices cuadradas
        startTime = System.currentTimeMillis();
        C = matriz.multiplicacionMatrizStrassen(A, B); //Llamado de la funcion de multiplicacion recursiva con algoritmo de Strassen
        endTime = System.currentTimeMillis();
        //matriz.imprimirMatriz(C); 
        System.out.println("Tiempo de ejecucion (Strassen): " + (endTime - startTime) + "ms");
    }
    
}
