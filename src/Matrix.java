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

        if(values.length != m || values[0].length != n) {
            throw new RuntimeException();
        }

        for(int i = 0; i < this.m; i++) {
            for(int j = 0; j < this.n; j++) {
                // TODO check modulo
                matrix[i][j] = Math.floorMod(values[i][j], this.modulo);
            }
        }
        /*try {


        }catch(RuntimeException e) {
            System.out.println("Values array size doesn't match matrix size.");
        }*/
    }

    public void displayMatrix() {

        for(int i = 0; i < this.m; i++) {
            for(int j = 0; j < this.n; j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.print('\n');
        }

    }
}
