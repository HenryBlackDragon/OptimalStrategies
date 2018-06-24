package Methods;

public class Value {
    private int r1 = 428;
    private float[] mu1 = new float[]{1.31f, 1.68f, 1.41f, 1.5f, 1f, 1f, 4f};
    private float[][] matrixP1 = {{0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0.15f, 0.3f, 0.2f, 0.25f, 0.1f, 0, 0}, {0, 0, 0, 0, 0, 1, 0},};
    private float[][] matrixR1 = {{0, 0, 0, 0, 0, 0, 217}, {0, 0, 0, 0, 0, 0, 399}, {0, 0, 0, 0, 0, 0, 203},
            {0, 0, 0, 0, 0, 0, 297}, {0, 0, 0, 0, 0, 0, 198}, {151, 279, 142, 207, 139, 0, 0}, {0, 0, 0, 0, 0, 20, 0},};

    private int r2 = 130;
    private float[] mu2 = new float[]{0.91f, 1.1f, 0.82f, 1f, 0.5f, 0.5f, 2f};
    private float[][] matrixP2 = {{0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0.1f, 0.35f, 0.15f, 0.3f, 0.1f, 0, 0}, {0, 0, 0, 0, 0, 1, 0},};
    private float[][] matrixR2 = {{0, 0, 0, 0, 0, 0, 180}, {0, 0, 0, 0, 0, 0, 318}, {0, 0, 0, 0, 0, 0, 159},
            {0, 0, 0, 0, 0, 0, 273}, {0, 0, 0, 0, 0, 0, 92}, {126, 223, 112, 192, 65, 0, 0}, {0, 0, 0, 0, 0, 20, 0},};

    private int r3 = 333;
    private float[] mu3 = new float[]{1.31f, 2f, 1.42f, 1.63f, 1.28f, 1f, 4f};
    private float[][] matrixP3 = {{0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0.25f, 0.2f, 0.15f, 0.2f, 0.2f, 0, 0}, {0, 0, 0, 0, 0, 1, 0},};
    private float[][] matrixR3 = {{0, 0, 0, 0, 0, 0, 221}, {0, 0, 0, 0, 0, 0, 245}, {0, 0, 0, 0, 0, 0, 126},
            {0, 0, 0, 0, 0, 0, 216}, {0, 0, 0, 0, 0, 0, 140}, {154, 172, 89, 152, 98, 0, 0}, {0, 0, 0, 0, 0, 20, 0},};


    private int r4 = 310;
    private float[] mu4 = new float[]{1f, 1.5f, 1f, 1.32f, 1f, 0.5f, 3f};
    private float[][] matrixP4 = {{0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0.1f, 0.35f, 0.1f, 0.35f, 0.1f, 0, 0}, {0, 0, 0, 0, 0, 1, 0},};
    private float[][] matrixR4 = {{0, 0, 0, 0, 0, 0, 212}, {0, 0, 0, 0, 0, 0, 295}, {0, 0, 0, 0, 0, 0, 193},
            {0, 0, 0, 0, 0, 0, 255}, {0, 0, 0, 0, 0, 0, 155}, {149, 207, 133, 187, 127, 0, 0}, {0, 0, 0, 0, 0, 20, 0},};

    private int r5 = 368;
    private float[] mu5 = new float[]{1.31f, 1.5f, 1f, 1f, 1f, 1f, 5f};
    private float[][] matrixP5 = {{0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0.2f, 0.3f, 0.15f, 0.3f, 0.05f, 0, 0}, {0, 0, 0, 0, 0, 1, 0},};
    private float[][] matrixR5 = {{0, 0, 0, 0, 0, 0, 198}, {0, 0, 0, 0, 0, 0, 257}, {0, 0, 0, 0, 0, 0, 216},
            {0, 0, 0, 0, 0, 0, 315}, {0, 0, 0, 0, 0, 0, 210}, {139, 180, 152, 221, 147, 0, 0}, {0, 0, 0, 0, 0, 20, 0},};

    private int r6 = 457;
    private float[] mu6 = new float[]{1.68f, 2f, 1.5f, 1.68f, 1.5f, 1f, 5f};
    private float[][] matrixP6 = {{0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0.18f, 0.25f, 0.18f, 0.25f, 0.14f, 0, 0}, {0, 0, 0, 0, 0, 1, 0},};
    private float[][] matrixR6 = {{0, 0, 0, 0, 0, 0, 185}, {0, 0, 0, 0, 0, 0, 220}, {0, 0, 0, 0, 0, 0, 189},
            {0, 0, 0, 0, 0, 0, 287}, {0, 0, 0, 0, 0, 0, 174}, {128, 154, 133, 201, 122, 0, 0}, {0, 0, 0, 0, 0, 20, 0},};

    public int getR1() {
        return r1;
    }

    public float[] getMu1() {
        return mu1;
    }

    public float[][] getMatrixP1() {
        return matrixP1;
    }

    public float[][] getMatrixR1() {
        return matrixR1;
    }

    public int getR2() {
        return r2;
    }

    public float[] getMu2() {
        return mu2;
    }

    public float[][] getMatrixP2() {
        return matrixP2;
    }

    public float[][] getMatrixR2() {
        return matrixR2;
    }

    public int getR3() {
        return r3;
    }

    public float[] getMu3() {
        return mu3;
    }

    public float[][] getMatrixP3() {
        return matrixP3;
    }

    public float[][] getMatrixR3() {
        return matrixR3;
    }

    public int getR4() {
        return r4;
    }

    public float[] getMu4() {
        return mu4;
    }

    public float[][] getMatrixP4() {
        return matrixP4;
    }

    public float[][] getMatrixR4() {
        return matrixR4;
    }

    public int getR5() {
        return r5;
    }

    public float[] getMu5() {
        return mu5;
    }

    public float[][] getMatrixP5() {
        return matrixP5;
    }

    public float[][] getMatrixR5() {
        return matrixR5;
    }

    public int getR6() {
        return r6;
    }

    public float[] getMu6() {
        return mu6;
    }

    public float[][] getMatrixP6() {
        return matrixP6;
    }

    public float[][] getMatrixR6() {
        return matrixR6;
    }

    //    private int r1 = 428;
//    private float[] mu1 = new float[]{1.31f, 1.68f, 1.41f, 1.5f};
//    private double[][] matrixP1 = {
//            {0, 0, 0, 1},
//            {0, 0, 0, 1},
//            {0.4, 0.6, 0, 0},
//            {0, 0, 1, 0},};
//    private int[][] matrixR1 = {
//            {0, 0, 0, 217},
//            {0, 0, 0, 399},
//            {207, 139, 0, 0},
//            {0, 0, 20, 0},};
//
//    private int r2 = 130;
//    private float[] mu2 = new float[]{0.91f, 1.1f, 0.82f, 1f};
//    private double[][] matrixP2 = {
//            {0, 0, 0, 1},
//            {0, 0, 0, 1},
//            {0.3, 0.7, 0, 0},
//            {0, 0, 1, 0},};
//    private int[][] matrixR2 = {
//            {0, 0, 0, 180},
//            {0, 0, 0, 318},
//            {192, 65, 0, 0},
//            {0, 0, 20, 0},};
//
//    private int r3 = 333;
//    private float[] mu3 = new float[]{1.31f, 2f, 1.42f, 1.63f};
//    private double[][] matrixP3 = {
//            {0, 0, 0, 1},
//            {0, 0, 0, 1},
//            {0.5, 0.5, 0, 0},
//            {0, 0, 1, 0},};
//    private int[][] matrixR3 = {
//            {0, 0, 0, 221},
//            {0, 0, 0, 245},
//            {152, 98, 0, 0},
//            {0, 0, 20, 0},};
//
//
//    private int r4 = 310;
//    private float[] mu4 = new float[]{1f, 1.5f, 1f, 1.32f};
//    private double[][] matrixP4 = {
//            {0, 0, 0, 1},
//            {0, 0, 0, 1},
//            {0.4, 0.6, 0, 0},
//            {0, 0, 1, 0},};
//    private int[][] matrixR4 = {
//            {0, 0, 0, 212},
//            {0, 0, 0, 295},
//            {187, 127, 0, 0},
//            {0, 0, 20, 0},};
//
//    private int r5 = 368;
//    private float[] mu5 = new float[]{1.31f, 1.5f, 1f, 1f};
//    private double[][] matrixP5 = {
//            {0, 0, 0, 1},
//            {0, 0, 0, 1},
//            {0.45, 0.55, 0, 0},
//            {0, 0, 1, 0},};
//    private int[][] matrixR5 = {
//            {0, 0, 0, 198},
//            {0, 0, 0, 257},
//            {221, 147, 0, 0},
//            {0, 0, 20, 0},};
//
//    private int r6 = 457;
//    private float[] mu6 = new float[]{1.68f, 2f, 1.5f, 1.68f};
//    private double[][] matrixP6 = {
//            {0, 0, 0, 1},
//            {0, 0, 0, 1},
//            {0.5, 0.5, 0, 0},
//            {0, 0, 1, 0},};
//    private int[][] matrixR6 = {
//            {0, 0, 0, 185},
//            {0, 0, 0, 220},
//            {201, 122, 0, 0},
//            {0, 0, 20, 0},};
}
