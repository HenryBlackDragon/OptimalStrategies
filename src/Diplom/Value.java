package Diplom;

class Value {
//    private int r1 = 428;
//    private float[] mu1 = new float[]{1.31f, 1.68f, 1.41f, 1.5f, 1f, 1f, 4f};
//    private double[][] matrixP1 = {{0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1},
//            {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0.15, 0.3, 0.2, 0.25, 0.1, 0, 0}, {0, 0, 0, 0, 0, 1, 0},};
//    private int[][] matrixR1 = {{0, 0, 0, 0, 0, 0, 217}, {0, 0, 0, 0, 0, 0, 399}, {0, 0, 0, 0, 0, 0, 203},
//            {0, 0, 0, 0, 0, 0, 297}, {0, 0, 0, 0, 0, 0, 198}, {151, 279, 142, 207, 139, 0, 0}, {0, 0, 0, 0, 0, 20, 0},};
//
//
//    private int r2 = 130;
//    private float[] mu2 = new float[]{0.91f, 1.1f, 0.82f, 1f, 0.5f, 0.5f, 2f};
//    private double[][] matrixP2 = {{0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1},
//            {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0.1, 0.35, 0.15, 0.3, 0.1, 0, 0}, {0, 0, 0, 0, 0, 1, 0},};
//    private int[][] matrixR2 = {{0, 0, 0, 0, 0, 0, 180}, {0, 0, 0, 0, 0, 0, 318}, {0, 0, 0, 0, 0, 0, 159},
//            {0, 0, 0, 0, 0, 0, 273}, {0, 0, 0, 0, 0, 0, 92}, {126, 223, 112, 192, 65, 0, 0}, {0, 0, 0, 0, 0, 20, 0},};
//
//    private int r3 = 333;
//    private float[] mu3 = new float[]{1.31f, 2f, 1.42f, 1.63f, 1.28f, 1f, 4f};
//    private double[][] matrixP3 = {{0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1},
//            {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0.25, 0.2, 0.15, 0.2, 0.2, 0, 0}, {0, 0, 0, 0, 0, 1, 0},};
//    private int[][] matrixR3 = {{0, 0, 0, 0, 0, 0, 221}, {0, 0, 0, 0, 0, 0, 245}, {0, 0, 0, 0, 0, 0, 126},
//            {0, 0, 0, 0, 0, 0, 216}, {0, 0, 0, 0, 0, 0, 140}, {154, 172, 89, 152, 98, 0, 0}, {0, 0, 0, 0, 0, 20, 0},};
//
//
//    private int r4 = 310;
//    private float[] mu4 = new float[]{1f, 1.5f, 1f, 1.32f, 1f, 0.5f, 3f};
//    private double[][] matrixP4 = {{0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1},
//            {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0.1, 0.35, 0.1, 0.35, 0.1, 0, 0}, {0, 0, 0, 0, 0, 1, 0},};
//    private int[][] matrixR4 = {{0, 0, 0, 0, 0, 0, 212}, {0, 0, 0, 0, 0, 0, 295}, {0, 0, 0, 0, 0, 0, 193},
//            {0, 0, 0, 0, 0, 0, 255}, {0, 0, 0, 0, 0, 0, 155}, {149, 207, 133, 187, 127, 0, 0}, {0, 0, 0, 0, 0, 20, 0},};
//
//    private int r5 = 368;
//    private float[] mu5 = new float[]{1.31f, 1.5f, 1f, 1f, 1f, 1f, 5f};
//    private double[][] matrixP5 = {{0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1},
//            {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0.2, 0.3, 0.15, 0.3, 0.05, 0, 0}, {0, 0, 0, 0, 0, 1, 0},};
//    private int[][] matrixR5 = {{0, 0, 0, 0, 0, 0, 198}, {0, 0, 0, 0, 0, 0, 257}, {0, 0, 0, 0, 0, 0, 216},
//            {0, 0, 0, 0, 0, 0, 315}, {0, 0, 0, 0, 0, 0, 210}, {139, 180, 152, 221, 147, 0, 0}, {0, 0, 0, 0, 0, 20, 0},};
//
//    private int r6 = 457;
//    private float[] mu6 = new float[]{1.68f, 2f, 1.5f, 1.68f, 1.5f, 1f, 5f};
//    private double[][] matrixP6 = {{0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1},
//            {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0.18, 0.25, 0.18, 0.25, 0.14, 0, 0}, {0, 0, 0, 0, 0, 1, 0},};
//    private int[][] matrixR6 = {{0, 0, 0, 0, 0, 0, 185}, {0, 0, 0, 0, 0, 0, 220}, {0, 0, 0, 0, 0, 0, 189},
//            {0, 0, 0, 0, 0, 0, 287}, {0, 0, 0, 0, 0, 0, 174}, {128, 154, 133, 201, 122, 0, 0}, {0, 0, 0, 0, 0, 20, 0},};
//
//    private Strategy first = new Strategy(mu1, matrixP1, matrixR1, r1);
//    private Strategy second = new Strategy(mu2, matrixP2, matrixR2, r2);
//    private Strategy third = new Strategy(mu3, matrixP3, matrixR3, r3);
//    private Strategy fourth = new Strategy(mu4, matrixP4, matrixR4, r4);
//    private Strategy five = new Strategy(mu5, matrixP5, matrixR5, r5);
//    private Strategy six = new Strategy(mu6, matrixP6, matrixR6, r6);
//
//    public Strategy getFirst() {
//        return first;
//    }
//
//    public Strategy getSecond() {
//        return second;
//    }
//
//    public Strategy getThird() {
//        return third;
//    }
//
//    public Strategy getFourth() {
//        return fourth;
//    }
//
//    public Strategy getFive() {
//        return five;
//    }
//
//    public Strategy getSix() {
//        return six;
//    }

    private int r1 = 428;
    private float[] mu1 = new float[]{1.31f, 1.68f, 1.41f, 1.5f};
    private double[][] matrixP1 = {
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {0.4, 0.6, 0, 0},
            {0, 0, 1, 0},};
    private int[][] matrixR1 = {
            {0, 0, 0, 217},
            {0, 0, 0, 399},
            {207, 139, 0, 0},
            {0, 0, 20, 0},};

    private int r2 = 130;
    private float[] mu2 = new float[]{0.91f, 1.1f, 0.82f, 1f};
    private double[][] matrixP2 = {
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {0.3, 0.7, 0, 0},
            {0, 0, 1, 0},};
    private int[][] matrixR2 = {
            {0, 0, 0, 180},
            {0, 0, 0, 318},
            {192, 65, 0, 0},
            {0, 0, 20, 0},};

    private int r3 = 333;
    private float[] mu3 = new float[]{1.31f, 2f, 1.42f, 1.63f};
    private double[][] matrixP3 = {
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {0.5, 0.5, 0, 0},
            {0, 0, 1, 0},};
    private int[][] matrixR3 = {
            {0, 0, 0, 221},
            {0, 0, 0, 245},
            {152, 98, 0, 0},
            {0, 0, 20, 0},};


    private int r4 = 310;
    private float[] mu4 = new float[]{1f, 1.5f, 1f, 1.32f};
    private double[][] matrixP4 = {
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {0.4, 0.6, 0, 0},
            {0, 0, 1, 0},};
    private int[][] matrixR4 = {
            {0, 0, 0, 212},
            {0, 0, 0, 295},
            {187, 127, 0, 0},
            {0, 0, 20, 0},};

    private int r5 = 368;
    private float[] mu5 = new float[]{1.31f, 1.5f, 1f, 1f};
    private double[][] matrixP5 = {
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {0.45, 0.55, 0, 0},
            {0, 0, 1, 0},};
    private int[][] matrixR5 = {
            {0, 0, 0, 198},
            {0, 0, 0, 257},
            {221, 147, 0, 0},
            {0, 0, 20, 0},};

    private int r6 = 457;
    private float[] mu6 = new float[]{1.68f, 2f, 1.5f, 1.68f};
    private double[][] matrixP6 = {
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {0.5, 0.5, 0, 0},
            {0, 0, 1, 0},};
    private int[][] matrixR6 = {
            {0, 0, 0, 185},
            {0, 0, 0, 220},
            {201, 122, 0, 0},
            {0, 0, 20, 0},};

    private Strategy first = new Strategy(mu1, matrixP1, matrixR1, r1);
    private Strategy second = new Strategy(mu2, matrixP2, matrixR2, r2);
    private Strategy third = new Strategy(mu3, matrixP3, matrixR3, r3);
    private Strategy fourth = new Strategy(mu4, matrixP4, matrixR4, r4);
    private Strategy five = new Strategy(mu5, matrixP5, matrixR5, r5);
    private Strategy six = new Strategy(mu6, matrixP6, matrixR6, r6);

    public Strategy getFirst() {
        return first;
    }

    public Strategy getSecond() {
        return second;
    }

    public Strategy getThird() {
        return third;
    }

    public Strategy getFourth() {
        return fourth;
    }

    public Strategy getFive() {
        return five;
    }

    public Strategy getSix() {
        return six;
    }
}
