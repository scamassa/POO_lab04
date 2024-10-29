public class Main {
    public static void main(String[] args) {

        int[][] val = {{1, 2, 3, 4}, {5, 6, 7, 0}, {1, 2, 3, 4}, {5, 6, 7, 0}, {1, 2, 3, 4}};
        Matrix m1 = new Matrix(3, 4, 7);
        Matrix m2 = new Matrix(4, 3, 7);
        Matrix m3 = MatrixOperation.soustraction(m1, m2);
        m1.displayMatrix();
        m2.displayMatrix();
        m3.displayMatrix();
    }
}