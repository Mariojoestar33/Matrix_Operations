public class App {
    public static void main(String[] args) throws Exception {

        /**
         * Declaracion de variables
         */
        
        int N = 16; //Numero de filas y columnas de la matriz
        int [][] A = new int[N][N];
        int [][] B = new int[N][N];
        int [][] C = new int[N][N];
        Matrix matriz = new Matrix();

        //HOLA
        /**
         * Rellenado de las matrices con numeros aleatorios
         */
        matriz.rellenarMatriz(A);
        matriz.rellenarMatriz(B);
        System.out.println("Matriz 1:");
        matriz.imprimirMatriz(A); //Impresion de la Matriz A
        System.out.println();
        System.out.println("Matriz 2:");
        matriz.imprimirMatriz(B); //Impresion de la Matriz B
        System.out.println();

        /**
         * Toma de tiempos en ms y llamado de las funciones de multiplicacion
         */

        //Metodo tradicional para multiplicar 2 matrices cuadradas
        long startTime = System.currentTimeMillis();
        matriz.multiplicarMatrizBasico(A, B); //Llamado de la funcion de multiplicacion
        long endTime = System.currentTimeMillis();
        System.out.println("Tiempo de ejecucion: " + (endTime - startTime) + "ms");
        System.out.println();

        //Metodo Recursivo (normal) para multiplicar 2 matrices cuadradas
        startTime = System.currentTimeMillis();
        matriz.multiplicacionMatrizRecursiva(A, B); //Llamado de la funcion de multiplicacion recursiva
        endTime = System.currentTimeMillis();
        System.out.println("Tiempo de ejecucion: " + (endTime - startTime) + "ms");
        System.out.println();

        //Metodo Recursivo (Strassen) para multiplicar 2 matrices cuadradas
        startTime = System.currentTimeMillis();
        C = matriz.multiplicacionMatrizStrassen(A, B); //Llamado de la funcion de multiplicacion recursiva con algoritmo de Strassen
        endTime = System.currentTimeMillis();
        matriz.imprimirMatriz(C); 
        System.out.println("Tiempo de ejecucion: " + (endTime - startTime) + "ms");
    }
    
}
