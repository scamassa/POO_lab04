
/*
 * Contient des fonctions de tests sur la classe Matrix et les opérations MatrixOperation.
 * @author David Berger, Sara Camassa
 */
public class Test {

    private static Matrix testAddMatrix(Matrix m1, Matrix m2) {
        return Matrix.matrixOperation(m1, new MatrixAddition(), m2);
    }

    private static Matrix testSubMatrix(Matrix m1, Matrix m2) {
        return Matrix.matrixOperation(m1, new MatrixAddition(), m2);
    }

    private static Matrix testMultMatrix(Matrix m1, Matrix m2) {
        return Matrix.matrixOperation(m1, new MatrixAddition(), m2);
    }

    /*
     * Teste la création de matrices (éléments aléatoires) et les opérations sur leurs éléments.
     * @param M1, N1 la taille de la première matrice
     * @param m2, N2 la taille de la deuxième matrice
     * @param mod le modulo des deux matrices
     */
    public static void testMatrix(int M1, int N1, int M2, int N2, int mod) {
        Matrix m1 = new Matrix(M1, N1, mod);
        Matrix m2 = new Matrix(M2, N2, mod);

        System.out.println("The modulus is " + mod + "\n");

        System.out.println("one\n" + m1);
        System.out.println("two\n" + m2);

        System.out.println("one + two\n" + testAddMatrix(m1, m2));
        System.out.println("one - two\n" + testSubMatrix(m1, m2));
        System.out.println("one x two\n" + testMultMatrix(m1, m2));
    }

    /*
     * Teste la création de matrices (éléments choisis) et les opérations sur leurs éléments.
     * @param val1 le tableau 2d de int des valeurs de la première matrice
     * @param val2 le tableau 2d de int des valeurs de la deuxième matrice
     * @param mod1, mod2 les modulos des deux matrices respectivement
     */
    public static void testMatrixGivenElements(int[][] val1, int [][] val2, int mod1, int mod2) {
        Matrix m1 = new Matrix(val1, mod1);
        Matrix m2 = new Matrix(val2, mod2);

        testAddMatrix(m1, m2);
        testSubMatrix(m1, m2);
        testMultMatrix(m1, m2);

        System.out.println("passed");
    }

    /*
     * Fonction identique à testMatrix(), mais affiche uniquement le mot "passed" dans le cas où aucune erreur n'est survenue.
     */
    public static void testMatrixNoComments(int M1, int N1, int M2, int N2, int mod) {
        Matrix m1 = new Matrix(M1, N1, mod);
        Matrix m2 = new Matrix(M2, N2, mod);

        testAddMatrix(m1, m2);
        testSubMatrix(m1, m2);
        testMultMatrix(m1, m2);

        System.out.println("passed");
    }

    /*
     * Teste la création de matrices (éléments aléatoires) et les opérations sur leurs éléments.
     * @param M1, N1 la taille de la première matrice
     * @param m2, N2 la taille de la deuxième matrice
     * @param mod1, mod2 le modulo des deux matrices respectivement
     */
    public static void testDiffModMatrix(int M1, int N1, int M2, int N2, int mod1, int mod2) {
        Matrix m1 = new Matrix(M1, N1, mod1);
        Matrix m2 = new Matrix(M2, N2, mod2);

        testAddMatrix(m1, m2);
        testSubMatrix(m1, m2);
        testMultMatrix(m1, m2);

        System.out.println("-> passed");
    }

    public static void main(String[] args) {
        int[][] val1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        int[][] val2 = {{1, 2}, {3, 4}, {5, 6}};
        int[][] valMaxInt = {{-2147483648, 2147483647}, {3, 4}, {5, 6}};
        int[][] valNullRow = {{1, 2}, null, {3, 4}, {5, 6}};
        int[][] valSize0 = new int[0][0];
        int[][] valSize1 = new int[1][1];

        System.out.println("Tests of Matrix class and operations: random elements");

        System.out.println("same sizes:");
        try {
            testMatrixNoComments(5, 4, 5, 4, 6);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("different sizes:");
        try {
            testMatrixNoComments(5, 4, 6, 3, 6);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Different modulus:");
        try {
            testDiffModMatrix(5, 4, 6, 3, 7, 6);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Negative modulus:");
        try {
            testMatrixNoComments(5, 4, 6, 3, -2);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("negative size:");
        try {
            testMatrixNoComments(-3, 4, 6, 3, 7);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("size 0:");
        try {
            testMatrixNoComments(0, 4, 6, 3, 7);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("size 1:");
        try {
            testMatrixNoComments(1, 1, 6, 3, 7);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\nTests of Matrix class and operations: given elements");

        System.out.println("same sizes:");
        try {
            testMatrixGivenElements(val1, val1, 7, 7);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("different sizes:");
        try {
            testMatrixGivenElements(val1, val2, 7, 7);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Different modulus:");
        try {
            testMatrixGivenElements(val1, val2, 7, 3);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Negative modulus:");
        try {
            testMatrixGivenElements(val1, val2, -7, -7);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("size 0:");
        try {
            testMatrixGivenElements(valSize0, val2, 2, 2);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("size 1:");
        try {
            testMatrixGivenElements(valSize1, val2, 2, 2);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("one row is null:");
        try {
            testMatrixGivenElements(valNullRow, val2, 2, 2);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("element is int limit:");
        try {
            testMatrixGivenElements(valMaxInt, val2, 2, 2);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
