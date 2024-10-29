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

/*    public Matrix addition(Matrix m1, Matrix m2) {
        Matrix m3 = new Matrix(Math.max(m1.getM(), m2.getM()), Math.max(m1.getN(), m2.getN()));

    }*/

    public static Matrix soustraction(Matrix m1, Matrix m2) {
        if (m1.getModulo() != m2.getModulo()) {
            throw new RuntimeException();
        }
        Matrix m3 = new Matrix(Math.max(m1.getM(), m2.getM()), Math.max(m1.getN(), m2.getN()), m1.getModulo());

        Matrix newm1 = new Matrix(Math.max(m1.getM(), m2.getM()), Math.max(m1.getN(), m2.getN()), m1.getModulo(), m1.getAllValues());
        Matrix newm2 = new Matrix(Math.max(m1.getM(), m2.getM()), Math.max(m1.getN(), m2.getN()), m2.getModulo(), m2.getAllValues());

        for(int i = 0; i < m3.getM(); i++) {
            for(int j = 0; j < m3.getN(); j++) {
                m3.setValue(i, j, Math.floorMod(newm1.getValue(i, j) - newm2.getValue(i, j), newm1.getModulo()));
            }
        }
        return m3;
    }
}
