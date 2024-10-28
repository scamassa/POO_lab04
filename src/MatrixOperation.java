import java.lang.Math;

public class MatrixOperation {

    /*
    private Matrix m1;
    private Matrix m2;

    public MatrixOperation(Matrix matrix1, Matrix matrix2) {
        m1 = matrix1;
        m2 = matrix2;
    }
    */

    public Matrix addition(Matrix m1, Matrix m2) {
        Matrix m3 = new Matrix(Math.max(m1.getM(), m2.getM()), Math.max(m1.getN(), m2.getN()));

    }
}
