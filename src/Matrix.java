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

    public Matrix(int m, int n, int modulo, int[][] values) {
        this.m = m;
        this.n = n;
        this.matrix = new int[m][n];
        this.modulo = modulo;

        if(m < 0 || n < 0) {
            throw new RuntimeException();
        }

        for(int i = 0; i < this.m; i++) {
            for(int j = 0; j < this.n; j++) {
                matrix[i][j] = (i >= values.length || j >= values[0].length) ? 0 : Math.floorMod(values[i][j], this.modulo);
            }
        }
    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    public int getValue(int i, int j) {
        return matrix[i][j];
    }

    public void setValue(int i, int j, int value) {
        matrix[i][j] = value;
    }

    public int getModulo() { return modulo; }

    public void displayMatrix() {

        for(int i = 0; i < this.m; i++) {
            for(int j = 0; j < this.n; j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.print('\n');
        }

    }
}
