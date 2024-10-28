public class Main {
    public static void main(String[] args) {

        int[][] val = {{1, 2, 3, 4}, {5, 6, 7, 0}, {1, 2, 3, 4}, {5, 6, 7, 0}, {1, 2, 3, 4}};
        Matrix m = new Matrix(5, 4, 7, val);
        m.displayMatrix();
    }
}