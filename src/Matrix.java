import java.lang.Math;

public class Matrix {
    private int m, n, modulo;
    private int[][] matrix;

    public Matrix(int m, int n, int mod) {
        this.m = m;
        this.n = n;
        this.matrix = new int[m][n];
        this.modulo = mod;

        for(int i = 0; i < this.m; i++) {
            for(int j = 0; j < this.n; j++) {
                matrix[i][j] = (int)(Math.random() * (this.modulo));
            }
        }
    }

    public Matrix(int[][] values, int mod) {
        this.m = values.length;
        this.n = values[0].length;
        this.matrix = new int[m][n];
        this.modulo = mod;


        for(int i = 0; i < this.m; i++) {
            for(int j = 0; j < this.n; j++) {
                matrix[i][j] = Math.floorMod(values[i][j], this.modulo);
            }
        }
    }

    public static Matrix matrixOperation(Matrix m1, MatrixOperation operation, Matrix m2) {
        if (m1.modulo != m2.modulo) {
            throw new RuntimeException("mods are not equal");
        }

        int maxM = Math.max(m1.m, m2.m);
        int maxN = Math.max(m1.n, m2.n);

        int[][] resultValues = new int[maxM][maxN];

        for(int i = 0; i < maxM; i++) {
            for(int j = 0; j < maxN; j++) {

                int a = (i >= m1.m || j >= m1.n) ? 0 : m1.matrix[i][j];
                int b = (i >= m2.m || j >= m2.n) ? 0 : m2.matrix[i][j];

                resultValues[i][j] = operation.applyOperation(a, b);
            }
        }
        return new Matrix(resultValues, m1.modulo);
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < this.m; i++) {
            for(int j = 0; j < this.n; j++) {
                s = s.concat(this.matrix[i][j] + " ");
            }
            s = s.concat("\n");
        }
        return s;
    }
}
