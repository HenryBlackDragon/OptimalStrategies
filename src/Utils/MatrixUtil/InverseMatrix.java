package Utils.MatrixUtil;

public class InverseMatrix {

    public InverseMatrix() {
    }

    // рекурсивная функция - вычисляет значение определителя.
    // Если на входе определитель 2х2 - просто вычисляем (крест-на-крест), иначе раскладываем на миноры.
    // Для каждого минора вычисляем его определитель, рекурсивно вызывая ту же функцию.
    private float calculateDeterminant(float[][] matrix) {
        float calcResult = 0.0f;
        if (matrix.length == 2) {
            calcResult = matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
        } else {
            int koeff;
            for (int i = 0; i < matrix.length; i++) {
                if (i % 2 == 1) {
                    koeff = -1;
                } else {
                    koeff = 1;
                }
                calcResult += koeff * matrix[0][i] * this.calculateDeterminant(this.getMinor(matrix, i));
            }
        }

        return calcResult;
    }

    // функция, к-я возвращает нужный нам минор.
    // На входе - определитель, из к-го надо достать минор и номера строк-столбцов, к-е надо вычеркнуть.
    private float[][] getMinor(float[][] matrix, int column) {
        int minorLength = matrix.length - 1;
        float[][] minor = new float[minorLength][minorLength];
        int dI = 0;
        int dJ;
        for (int i = 0; i <= minorLength; i++) {
            dJ = 0;
            for (int j = 0; j <= minorLength; j++) {
                if (i == 0) {
                    dI = 1;
                } else {
                    if (j == column) {
                        dJ = 1;
                    } else {
                        minor[i - dI][j - dJ] = matrix[i][j];
                    }
                }
            }
        }

        return minor;
    }

    private float[][] deleteRowAndColumn(int column, int row, float[][] matrix) {
        float[][] newMatrix = new float[matrix.length - 1][matrix.length - 1];

        for (int i = 0, ln = 0; ln < matrix.length - 1; ) {
            if (i != column) {
                for (int j = 0, cn = 0; cn < matrix.length - 1; j++, cn++) {
                    if (j == row) {
                        j++;
                    }
                    newMatrix[ln][cn] = matrix[i][j];
                }
                i++;
                ln++;
            } else {
                i++;
            }
        }

        return newMatrix;
    }

    private float[][] getConjugateMatrix(float[][] matrix) {
        float[][] conjugateMatrix = new float[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                conjugateMatrix[i][j] = (float) (Math.pow(-1, (i + j)) *
                        calculateDeterminant(deleteRowAndColumn(i, j, matrix)));
            }
        }


        return conjugateMatrix;
    }

    private float[][] getTransposedMatrix(float[][] matrix) {
        float[][] transposedMatrix = new float[matrix.length][matrix.length];
        float[][] conjugateMatrix = getConjugateMatrix(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                transposedMatrix[i][j] = conjugateMatrix[j][i];
            }
        }

        return transposedMatrix;
    }

    public float[][] getInverseMatrix(float[][] matrix) {
        float[][] inverseMatrix = new float[matrix.length][matrix.length];
        float[][] transposedMatrix = getTransposedMatrix(matrix);
        float determinant = calculateDeterminant(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                inverseMatrix[i][j] = transposedMatrix[i][j] / determinant;
            }
        }

        return inverseMatrix;
    }
}
