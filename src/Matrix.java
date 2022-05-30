public class Matrix {

    /**
     * Rellena una matriz con valores aleatorios
     * @param matrix    matriz a rellenar
     */
    public void rellenarMatriz(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 9);
            }
        }
    }

    /**
     * Imprime una matriz de tipo int
     * @param matrix matriz a imprimir
     */
    public void imprimirMatriz(int [][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Multiplica dos matrices
     * @param A   matriz a Multiplicar A
     * @param B   matriz a Multiplicar B
     */
    public void multiplicarMatrizBasico(int [][] A, int [][] B) {
        int [][] C = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < B.length; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        imprimirMatriz(C);
    }

    /**
     * Multiplica dos matrices de manera recursiva
     * @param A matriz a Multiplicar A
     * @param B matriz a Multiplicar B   
     */
    public void multiplicacionMatrizRecursiva(int [][] A,int [][] B)
   {
       if (A[0].length==B.length)
 
       {
           int[][] C = new int[A.length][B[0].length];
           multiplicacionMatrizRecursiva(A, B, C, 0);
           imprimirMatriz(C);
       }else
       {
           System.out.println("Matrices ingresadas no son compatibles");
       }
   }
 
   private void multiplicacionMatrizRecursiva(int [][] A,int [][] B,int [][]C,int i)
   {
 
       if (i<A.length)
       {
           multiplicacionMatrizRecursiva(A,B,C,i,0);
           multiplicacionMatrizRecursiva(A,B,C,i+1);
       }
   }
 
   private void multiplicacionMatrizRecursiva(int [][]A,int [][]B,int [][]C,int i,int j)
   {
       if (j<B[0].length)
       {
           multiplicacionMatrizRecursiva(A,B,C,i,j,0);
           multiplicacionMatrizRecursiva(A,B,C,i,j+1);
       }
   }
 
   private void multiplicacionMatrizRecursiva(int [][]A,int [][]B,int [][]C,int i,int j,int k)
   {
       if (k<A[0].length)
       {
           C[i][j] += A[i][k] * B[k][j];
           multiplicacionMatrizRecursiva(A,B,C,i,j,k+1);
       }
   }

   /**
    * Multiplica dos matrices de con el algoritmo de Strassen 
    * @param A  matriz a Multiplicar A
    * @param B  matriz a Multiplicar B
    * @return C  matriz resultado de la multiplicacion
    */
   public int[][] multiplicacionMatrizStrassen(int[][] A, int[][] B) {
    int n = A.length;
    int[][] C = new int[n][n];

    if (n == 1) {
        C[0][0] = A[0][0] * B[0][0];
    } else {
        int[][] a = new int[n / 2][n / 2];
        int[][] b = new int[n / 2][n / 2];
        int[][] c = new int[n / 2][n / 2];
        int[][] d = new int[n / 2][n / 2];

        int[][] e = new int[n / 2][n / 2];
        int[][] f = new int[n / 2][n / 2];
        int[][] g = new int[n / 2][n / 2];
        int[][] h = new int[n / 2][n / 2];

        dividirArreglo(A, a, 0, 0);
        dividirArreglo(A, b, 0, n / 2);
        dividirArreglo(A, c, n / 2, 0);
        dividirArreglo(A, d, n / 2, n / 2);

        dividirArreglo(B, e, 0, 0);
        dividirArreglo(B, f, 0, n / 2);
        dividirArreglo(B, g, n / 2, 0);
        dividirArreglo(B, h, n / 2, n / 2);
       
        int[][] p1 = multiplicacionMatrizStrassen(crearMatriz(a, d), crearMatriz(e, h));
        int[][] p2 = multiplicacionMatrizStrassen(crearMatriz(c,d),e);
        int[][] p3 = multiplicacionMatrizStrassen(a, subMatriz(f, h));           
        int[][] p4 = multiplicacionMatrizStrassen(d, subMatriz(g, e));
        int[][] p5 = multiplicacionMatrizStrassen(crearMatriz(a,b), h);
        int[][] p6 = multiplicacionMatrizStrassen(subMatriz(c, a), crearMatriz(e, f));
        int[][] p7 = multiplicacionMatrizStrassen(subMatriz(b, d), crearMatriz(g, h));
       
        int[][] C11 = crearMatriz(subMatriz(crearMatriz(p1, p4), p5), p7);
        int[][] C12 = crearMatriz(p3, p5);
        int[][] C21 = crearMatriz(p2, p4);
        int[][] C22 = crearMatriz(subMatriz(crearMatriz(p1, p3), p2), p6);

        copiarSubArreglo(C11, C, 0, 0);
        copiarSubArreglo(C12, C, 0, n / 2);
        copiarSubArreglo(C21, C, n / 2, 0);
        copiarSubArreglo(C22, C, n / 2, n / 2);
        }
        return C;
    }

    public static int[][] crearMatriz(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    public static int[][] subMatriz(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    public static void dividirArreglo(int[][] P, int[][] C, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                C[i1][j1] = P[i2][j2];
    }

    public static void copiarSubArreglo(int[][] C, int[][] P, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                P[i2][j2] = C[i1][j1];
    }  

}
