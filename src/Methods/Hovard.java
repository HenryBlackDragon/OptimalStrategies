//package Methods;
//
//import Utils.MatrixUtil.InverseMatrix;
//
//import java.util.*;
//
//import static Utils.OtherUtilClass.maxStrategy;
//
//public class Hovard {
//
//    private static Value val = new Value();
//
//    public static void main(String[] args) {
//        List<Integer> firtst = firstChooseOptimalStrategy();
//        InverseMatrix inverseMatrix = new InverseMatrix();
//
//        Map<Integer, String> mapOfResultFirst = val.getFirst().resultODY();
//        Map<Integer, String> mapOfResultSecond = val.getSecond().resultODY();
//        Map<Integer, String> mapOfResultThird = val.getThird().resultODY();
//        Map<Integer, String> mapOfResultForth = val.getFourth().resultODY();
//        Map<Integer, String> mapOfResultFive = val.getFive().resultODY();
//        Map<Integer, String> mapOfResultSix = val.getSix().resultODY();
//
//        float[][] matrixFirst = inverseMatrix.getInverseMatrix(
//                matrixDifference(val.getFirst().getMatrixA(), unitMatrix()));
//        float[][] matrixSecond = inverseMatrix.getInverseMatrix(
//                matrixDifference(val.getSecond().getMatrixA(), unitMatrix()));
//        float[][] matrixThird = inverseMatrix.getInverseMatrix(
//                matrixDifference(val.getThird().getMatrixA(), unitMatrix()));
//        float[][] matrixFourth = inverseMatrix.getInverseMatrix(
//                matrixDifference(val.getFourth().getMatrixA(), unitMatrix()));
//        float[][] matrixFive = inverseMatrix.getInverseMatrix(
//                matrixDifference(val.getFive().getMatrixA(), unitMatrix()));
//        float[][] matrixSix = inverseMatrix.getInverseMatrix(
//                matrixDifference(val.getSix().getMatrixA(), unitMatrix()));
//
//        float[][] vectorG = firstVectorG();
//
//        while (true) {
//            float[][] vectorFirst = vectorDifference(val.getFirst().getVectorQ(), vectorG);
//            float[][] vectorSecond = vectorDifference(val.getSecond().getVectorQ(), vectorG);
//            float[][] vectorThird = vectorDifference(val.getThird().getVectorQ(), vectorG);
//            float[][] vectorFourth = vectorDifference(val.getFourth().getVectorQ(), vectorG);
//            float[][] vectorFive = vectorDifference(val.getFive().getVectorQ(), vectorG);
//            float[][] vectorSix = vectorDifference(val.getSix().getVectorQ(), vectorG);
//
//            float[][] vectorIncomeFirst = multiplyMatrixAndVector(matrixFirst, vectorFirst);
//            float[][] vectorIncomeSecond = multiplyMatrixAndVector(matrixSecond, vectorSecond);
//            float[][] vectorIncomeThird = multiplyMatrixAndVector(matrixThird, vectorThird);
//            float[][] vectorIncomeFourth = multiplyMatrixAndVector(matrixFourth, vectorFourth);
//            float[][] vectorIncomeFive = multiplyMatrixAndVector(matrixFive, vectorFive);
//            float[][] vectorIncomeSix = multiplyMatrixAndVector(matrixSix, vectorSix);
//
//            float[][] vectorGFirst = getVectorG(
//                    val.getFirst().getVectorQ(),
//                    multiplyMatrixAndVector(val.getFirst().getMatrixA(), vectorIncomeFirst),
//                    vectorIncomeFirst);
//            float[][] vectorGSecond = getVectorG(
//                    val.getSecond().getVectorQ(),
//                    multiplyMatrixAndVector(val.getSecond().getMatrixA(), vectorIncomeSecond),
//                    vectorIncomeSecond);
//            float[][] vectorGThird = getVectorG(
//                    val.getThird().getVectorQ(),
//                    multiplyMatrixAndVector(val.getThird().getMatrixA(), vectorIncomeThird),
//                    vectorIncomeThird);
//            float[][] vectorGFourth = getVectorG(
//                    val.getFourth().getVectorQ(),
//                    multiplyMatrixAndVector(val.getFourth().getMatrixA(), vectorIncomeFourth),
//                    vectorIncomeFourth);
//            float[][] vectorGFive = getVectorG(
//                    val.getFive().getVectorQ(),
//                    multiplyMatrixAndVector(val.getFive().getMatrixA(), vectorIncomeFive),
//                    vectorIncomeFive);
//            float[][] vectorGSix = getVectorG(
//                    val.getSix().getVectorQ(),
//                    multiplyMatrixAndVector(val.getSix().getMatrixA(), vectorIncomeSix),
//                    vectorIncomeSix);
//
//            List<Integer> list = otherChooseOptimalStrategy(vectorGFirst, vectorGSecond, vectorGThird,
//                    vectorGFourth, vectorGFive, vectorGSix);
//
//            List<Boolean> tets = check(firtst, list);
//
//            if (allTrue(tets)) {
//                list.forEach(System.out::println);
//                break;
//            } else {
//                tets.forEach(System.out::println);
//                System.out.println("--------------------");
//                vectorG = otherVectorG(vectorGFirst, vectorGSecond, vectorGThird,
//                        vectorGFourth, vectorGFive, vectorGSix);
//                firtst = list;
//            }
//
//        }
//
//    }
//
//    public static float[][] otherVectorG(float[][] vectorGFirst, float[][] vectorGSecond, float[][] vectorGThird,
//                                         float[][] vectorGFourth, float[][] vectorGFive, float[][] vectorGSix) {
//        float[][] vectorG = new float[1][val.getFirst().getCountState()];
//
//        for (int i = 0; i < 1; i++) {
//            for (int j = 0; j < val.getFirst().getCountState(); j++) {
//                vectorG[i][j] = maxValue(vectorGFirst[0][i], vectorGSecond[0][i],
//                        vectorGThird[0][i], vectorGFourth[0][i],
//                        vectorGFive[0][i], vectorGSix[0][i]);
//
//            }
//        }
//
//        return vectorG;
//    }
//
//    public static boolean allTrue(List<Boolean> list) {
//        for (int i = 0; i < list.size(); i++) {
//            if (!list.get(0)) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
////    public static float[][] toVectorG(List<Integer> list) {
////        float[][] vectorG = new float[1][list.size()];
////
////        for (int i = 0; i < list.size(); i++) {
////            vectorG[0][i] = list.get(i);
////        }
////
////        return vectorG;
////    }
//
//    public static float[][] getVectorG(float[][] vectorQ, float[][] vectorMult, float[][] vectorIncome) {
//        float[][] fectorG = new float[1][val.getFirst().getCountState()];
//
//        for (int i = 0; i < 1; i++) {
//            for (int j = 0; j < val.getFirst().getCountState(); j++) {
//                fectorG[i][j] = vectorQ[i][j] + vectorMult[i][j] - vectorIncome[i][j];
//            }
//        }
//
//        return fectorG;
//    }
//
//    public static List<Integer> firstChooseOptimalStrategy() {
//        List<Integer> firstListStrategy = new ArrayList<>();
//
//        for (int i = 0; i < val.getFirst().getCountState(); i++) {
//
//            firstListStrategy.add(maxStrategy(val.getFirst().getVectorQ()[0][i], val.getSecond().getVectorQ()[0][i],
//                    val.getThird().getVectorQ()[0][i], val.getFourth().getVectorQ()[0][i],
//                    val.getFive().getVectorQ()[0][i], val.getSix().getVectorQ()[0][i]));
//        }
//
//        return firstListStrategy;
//    }
//
//    public static List<Integer> otherChooseOptimalStrategy(float[][] vectorGFirst, float[][] vectorGSecond,
//                                                           float[][] vectorGThird, float[][] vectorGFourth,
//                                                           float[][] vectorGFive, float[][] vectorGSix) {
//        List<Integer> otherListStrategy = new ArrayList<>();
//
//        for (int i = 0; i < val.getFirst().getCountState(); i++) {
//
//            otherListStrategy.add(maxStrategy(vectorGFirst[0][i], vectorGSecond[0][i],
//                    vectorGThird[0][i], vectorGFourth[0][i],
//                    vectorGFive[0][i], vectorGSix[0][i]));
//        }
//
//        return otherListStrategy;
//    }
//
//    public static List<Boolean> check(List<Integer> first, List<Integer> other) {
//        List<Boolean> che = new ArrayList<>();
//
//        for (int i = 0; i < first.size(); i++) {
//            if (first.get(i).equals(other.get(i))) {
//                che.add(true);
//            } else che.add(false);
//        }
//
//        return che;
//    }
//
//    public static float[][] firstVectorG() {
//        float[][] vectorG = new float[1][val.getFirst().getCountState()];
//
//        for (int i = 0; i < 1; i++) {
//            for (int j = 0; j < val.getFirst().getCountState(); j++) {
//                vectorG[i][j] = maxValue(val.getFirst().getVectorQ()[0][i], val.getSecond().getVectorQ()[0][i],
//                        val.getThird().getVectorQ()[0][i], val.getFourth().getVectorQ()[0][i],
//                        val.getFive().getVectorQ()[0][i], val.getSix().getVectorQ()[0][i]);
//
//            }
//        }
//
//        return vectorG;
//    }
//
//    public static float maxValue(float first, float second,
//                                 float third, float fourth, float five, float six) {
//        List<Float> list = Arrays.asList(first, second, third, fourth, five, six);
//
//        return Collections.max(list);
//    }
//
//    private static float[][] vectorDifference(float[][] vectorQ, float[][] vectorG) {
//        float[][] newVectorAfterSum = new float[1][val.getFirst().getCountState()];
//
//        for (int i = 0; i < 1; i++) {
//            for (int j = 0; j < val.getFirst().getCountState(); j++) {
//                newVectorAfterSum[i][j] = vectorQ[i][j] - vectorG[i][j];
//            }
//        }
//
//        return newVectorAfterSum;
//    }
//
//    private static float[][] unitMatrix() {
//        float[][] unit = new float[val.getFirst().getCountState()][val.getFirst().getCountState()];
//
//        for (int i = 0; i < val.getFirst().getCountState(); i++) {
//            for (int j = 0; j < val.getFirst().getCountState(); j++) {
//                unit[i][i] = 1;
//            }
//        }
//
//        return unit;
//    }
//
//    private static float[][] matrixDifference(float[][] matrixA, float[][] unitMatrix) {
//        float[][] newMatrix = new float[val.getFirst().getCountState()][val.getFirst().getCountState()];
//
//        for (int i = 0; i < val.getFirst().getCountState(); i++) {
//            for (int j = 0; j < val.getFirst().getCountState(); j++) {
//                newMatrix[i][j] = unitMatrix[i][j] - matrixA[i][j];
//            }
//        }
//
//        return newMatrix;
//    }
//
//    private static float[][] multiplyMatrixAndVector(float[][] matrix, float[][] vector) {
//        float[][] newVector = new float[1][val.getFirst().getCountState()];
//
//        for (int i = 0; i < 1; i++) {
//            for (int j = 0; j < val.getFirst().getCountState(); j++) {
//                for (int k = 0; k < val.getFirst().getCountState(); k++) {
//                    newVector[i][j] += matrix[j][k] * vector[i][k];
//                }
//            }
//        }
//
//        return newVector;
//    }
//}
