public class Test {

    /*
    * modulo negatif
    * grands chiffres
    * modulo differents
    * taille 0
    * taille negative
    * */
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

    private static Matrix testAddMatrix(Matrix m1, Matrix m2) {
        return Matrix.matrixOperation(m1, new MatrixAddition(), m2);
    }

    private static Matrix testSubMatrix(Matrix m1, Matrix m2) {
        return Matrix.matrixOperation(m1, new MatrixAddition(), m2);
    }

    private static Matrix testMultMatrix(Matrix m1, Matrix m2) {
        return Matrix.matrixOperation(m1, new MatrixAddition(), m2);
    }
}
