import java.lang.Math;

/*
 * Classe représentant une matrice de taille quelconque M x N contenant des éléments entre 0 et modulo-1
 * @author David Berger, Sara Camassa
 */
public class Matrix {
    private int m, n, modulo;
    private int[][] matrix;

    public Matrix(int m, int n, int mod) {
        if(m < 0 || n < 0) {
            throw new RuntimeException("Invalid matrix size");
        } else if(m == 0 || n == 0) {
            this.m = 0;
            this.n = 0;
        } else {
            this.m = m;
            this.n = n;
        }

        this.matrix = new int[m][n];
        this.modulo = mod;

        for(int i = 0; i < this.m; i++) {
            for(int j = 0; j < this.n; j++) {
                matrix[i][j] = (int)(Math.random() * (this.modulo));
            }
        }
    }

    public Matrix(int[][] values, int mod) {
        if (values.length == 0 || values[0].length == 0) {
            this.m = 0;
            this.n = 0;
        } else {
            this.m = values.length;
            this.n = values[0].length;
        }
        this.matrix = new int[m][n];
        this.modulo = mod;

        for(int i = 0; i < this.m; i++) {
            if(values[i] == null) throw new RuntimeException("Invalid matrix element (null)");
            for(int j = 0; j < this.n; j++) {
                matrix[i][j] = Math.floorMod(values[i][j], this.modulo);
            }
        }
    }

    /*
     * Fonction effectuant l'opération souhaitée entre deux matrices.
     * @param m1 la première matrice
     * @param operation la MatrixOperation que l'on souhaite appliquer
     * @param m2 la deuxième matrice
     */
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
