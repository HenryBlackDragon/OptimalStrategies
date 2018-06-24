package Methods;

import Utils.HDEUtil.CreateStrategies;
import Utils.MatrixUtil.InverseMatrix;
import Utils.States.CreateState;

import java.util.ArrayList;
import java.util.List;

import static Utils.OtherUtilClass.maxStrategy;
import static Utils.OtherUtilClass.maxValue;

public class Howard {
    private CreateState state;
    private CreateStrategies strategies;

    public Howard(CreateStrategies strategies, CreateState createState) {
        state = createState;
        this.strategies = strategies;
    }

    public void getResultHoward() {
        List<Integer> firtst = firstChooseOptimalStrategy();
        InverseMatrix inverseMatrix = new InverseMatrix();

        float[][] matrixFirst = inverseMatrix.getInverseMatrix(
                matrixDifference(strategies.getFirstStrategy().getMatrixA(), unitMatrix()));
        float[][] matrixSecond = inverseMatrix.getInverseMatrix(
                matrixDifference(strategies.getSecondStrategy().getMatrixA(), unitMatrix()));
        float[][] matrixThird = inverseMatrix.getInverseMatrix(
                matrixDifference(strategies.getThirdStrategy().getMatrixA(), unitMatrix()));
        float[][] matrixFourth = inverseMatrix.getInverseMatrix(
                matrixDifference(strategies.getForthStrategy().getMatrixA(), unitMatrix()));
        float[][] matrixFive = inverseMatrix.getInverseMatrix(
                matrixDifference(strategies.getFiveStrategy().getMatrixA(), unitMatrix()));
        float[][] matrixSix = inverseMatrix.getInverseMatrix(
                matrixDifference(strategies.getSixStrategy().getMatrixA(), unitMatrix()));

        float[][] vectorG = firstVectorG();

        while (true) {
            float[][] vectorFirst = vectorDifference(strategies.getFirstStrategy().getVectorQ(), vectorG);
            float[][] vectorSecond = vectorDifference(strategies.getSecondStrategy().getVectorQ(), vectorG);
            float[][] vectorThird = vectorDifference(strategies.getThirdStrategy().getVectorQ(), vectorG);
            float[][] vectorFourth = vectorDifference(strategies.getForthStrategy().getVectorQ(), vectorG);
            float[][] vectorFive = vectorDifference(strategies.getFiveStrategy().getVectorQ(), vectorG);
            float[][] vectorSix = vectorDifference(strategies.getSixStrategy().getVectorQ(), vectorG);

            float[][] vectorIncomeFirst = multiplyMatrixAndVector(matrixFirst, vectorFirst);
            float[][] vectorIncomeSecond = multiplyMatrixAndVector(matrixSecond, vectorSecond);
            float[][] vectorIncomeThird = multiplyMatrixAndVector(matrixThird, vectorThird);
            float[][] vectorIncomeFourth = multiplyMatrixAndVector(matrixFourth, vectorFourth);
            float[][] vectorIncomeFive = multiplyMatrixAndVector(matrixFive, vectorFive);
            float[][] vectorIncomeSix = multiplyMatrixAndVector(matrixSix, vectorSix);

            float[][] vectorGFirst = getVectorG(
                    strategies.getFirstStrategy().getVectorQ(),
                    multiplyMatrixAndVector(strategies.getFirstStrategy().getMatrixA(), vectorIncomeFirst),
                    vectorIncomeFirst);
            float[][] vectorGSecond = getVectorG(
                    strategies.getSecondStrategy().getVectorQ(),
                    multiplyMatrixAndVector(strategies.getSecondStrategy().getMatrixA(), vectorIncomeSecond),
                    vectorIncomeSecond);
            float[][] vectorGThird = getVectorG(
                    strategies.getThirdStrategy().getVectorQ(),
                    multiplyMatrixAndVector(strategies.getThirdStrategy().getMatrixA(), vectorIncomeThird),
                    vectorIncomeThird);
            float[][] vectorGFourth = getVectorG(
                    strategies.getForthStrategy().getVectorQ(),
                    multiplyMatrixAndVector(strategies.getForthStrategy().getMatrixA(), vectorIncomeFourth),
                    vectorIncomeFourth);
            float[][] vectorGFive = getVectorG(
                    strategies.getFiveStrategy().getVectorQ(),
                    multiplyMatrixAndVector(strategies.getFiveStrategy().getMatrixA(), vectorIncomeFive),
                    vectorIncomeFive);
            float[][] vectorGSix = getVectorG(
                    strategies.getSixStrategy().getVectorQ(),
                    multiplyMatrixAndVector(strategies.getSixStrategy().getMatrixA(), vectorIncomeSix),
                    vectorIncomeSix);

            List<Integer> list = otherChooseOptimalStrategy(vectorGFirst, vectorGSecond, vectorGThird,
                    vectorGFourth, vectorGFive, vectorGSix);

            List<Boolean> tets = check(firtst, list);

            if (allTrue(tets)) {
                list.forEach(System.out::println);
                break;
            } else {
                vectorG = otherVectorG(vectorGFirst, vectorGSecond, vectorGThird,
                        vectorGFourth, vectorGFive, vectorGSix);
                firtst = list;
            }
        }
    }

    private float[][] otherVectorG(float[][] vectorGFirst, float[][] vectorGSecond, float[][] vectorGThird,
                                   float[][] vectorGFourth, float[][] vectorGFive, float[][] vectorGSix) {
        float[][] vectorG = new float[state.getCountState()][1];

        for (int i = 0; i < state.getCountState(); i++) {
            vectorG[i][0] = maxValue(vectorGFirst[i][0], vectorGSecond[i][0],
                    vectorGThird[i][0], vectorGFourth[i][0],
                    vectorGFive[i][0], vectorGSix[i][0]);

        }

        return vectorG;
    }

    private boolean allTrue(List<Boolean> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(0)) {
                return false;
            }
        }

        return true;
    }

    private float[][] getVectorG(float[][] vectorQ, float[][] vectorMult, float[][] vectorIncome) {
        float[][] fectorG = new float[state.getCountState()][1];

        for (int i = 0; i < state.getCountState(); i++) {
            fectorG[i][0] = vectorQ[i][0] + vectorMult[i][0] - vectorIncome[i][0];
        }

        return fectorG;
    }

    private List<Integer> firstChooseOptimalStrategy() {
        List<Integer> firstListStrategy = new ArrayList<>();

        for (int i = 0; i < state.getCountState(); i++) {
            firstListStrategy.add(maxStrategy(strategies.getFirstStrategy().getVectorQ()[i][0],
                    strategies.getSecondStrategy().getVectorQ()[i][0],
                    strategies.getThirdStrategy().getVectorQ()[i][0],
                    strategies.getForthStrategy().getVectorQ()[i][0],
                    strategies.getFiveStrategy().getVectorQ()[i][0],
                    strategies.getSixStrategy().getVectorQ()[i][0]));
        }

        return firstListStrategy;
    }

    private List<Integer> otherChooseOptimalStrategy(float[][] vectorGFirst, float[][] vectorGSecond,
                                                     float[][] vectorGThird, float[][] vectorGFourth,
                                                     float[][] vectorGFive, float[][] vectorGSix) {
        List<Integer> otherListStrategy = new ArrayList<>();

        for (int i = 0; i < state.getCountState(); i++) {

            otherListStrategy.add(maxStrategy(vectorGFirst[i][0], vectorGSecond[i][0],
                    vectorGThird[i][0], vectorGFourth[i][0],
                    vectorGFive[i][0], vectorGSix[i][0]));
        }

        return otherListStrategy;
    }

    private List<Boolean> check(List<Integer> first, List<Integer> other) {
        List<Boolean> che = new ArrayList<>();

        for (int i = 0; i < first.size(); i++) {
            if (first.get(i).equals(other.get(i))) {
                che.add(true);
            } else che.add(false);
        }

        return che;
    }

    private float[][] firstVectorG() {
        float[][] vectorG = new float[state.getCountState()][1];

        for (int i = 0; i < state.getCountState(); i++) {
            vectorG[i][0] = maxValue(strategies.getFirstStrategy().getVectorQ()[i][0],
                    strategies.getSecondStrategy().getVectorQ()[i][0],
                    strategies.getThirdStrategy().getVectorQ()[i][0],
                    strategies.getForthStrategy().getVectorQ()[i][0],
                    strategies.getFiveStrategy().getVectorQ()[i][0],
                    strategies.getSixStrategy().getVectorQ()[i][0]);

        }

        return vectorG;
    }


    private float[][] vectorDifference(float[][] vectorQ, float[][] vectorG) {
        float[][] newVectorAfterSum = new float[state.getCountState()][1];

        for (int i = 0; i < state.getCountState(); i++) {
            newVectorAfterSum[i][0] = vectorQ[i][0] - vectorG[i][0];
        }

        return newVectorAfterSum;
    }

    private float[][] unitMatrix() {
        float[][] unit = new float[state.getCountState()][state.getCountState()];

        for (int i = 0; i < state.getCountState(); i++) {
            for (int j = 0; j < state.getCountState(); j++) {
                unit[i][i] = 1;
            }
        }

        return unit;
    }

    private float[][] matrixDifference(float[][] matrixA, float[][] unitMatrix) {
        float[][] newMatrix = new float[state.getCountState()][state.getCountState()];

        for (int i = 0; i < state.getCountState(); i++) {
            for (int j = 0; j < state.getCountState(); j++) {
                newMatrix[i][j] = unitMatrix[i][j] - matrixA[i][j];
            }
        }

        return newMatrix;
    }

    private float[][] multiplyMatrixAndVector(float[][] matrix, float[][] vector) {
        float[][] newVector = new float[state.getCountState()][1];

        for (int i = 0; i < state.getCountState(); i++) {
            for (int j = 0; j < state.getCountState(); j++) {
                newVector[i][0] += matrix[i][j] * vector[j][0];
            }
        }

        return newVector;
    }
}
