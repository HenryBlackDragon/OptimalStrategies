package Utils.MatrixUtil;

public class MatrixUtil {

    public static float[][] matrixMultiply(float[][] matrixA, float[][] vectorV) {
        float[][] vector = new float[vectorV.length][1];
        for (int i = 0; i < vectorV.length; i++) {
            for (int j = 0; j < vectorV.length; j++) {
                vector[i][0] += matrixA[i][j] * vectorV[i][0];
            }
        }

        return vector;
    }
}
