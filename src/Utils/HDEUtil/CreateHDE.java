package Utils.HDEUtil;

import Diplom.Strategy;

import java.util.ArrayList;
import java.util.List;

public class CreateHDE {

    private int countQS;
    private int state;
    private float[][] matrixP;
    private float[][] matrixR;
    private float[] mu;
    private Strategy strategy;

    private List<String> listI;

    public CreateHDE(int countQS, int state, float[][] matrixP, float[][] matrixR, float[] mu) {
        this.countQS = countQS;
        this.state = state;
        this.matrixP = matrixP;
        this.matrixR = matrixR;
        this.mu = mu;

        listI = createListI();
        strategy = new Strategy();
    }

    // create first element of HDE
    private String firstElem(String state, int numState) {
        float elementFirst = 0;

        for (int i = 0; i < countQS; i++) {
            elementFirst += mu[i] * heaviside(state, i);
        }

        return "(" + String.valueOf(numState) + ")" + elementFirst;
    }

    // create second element of HDE
    private String secondElem(String state) {
        float elementSecondPart1 = 0;
        float elementSecondPart2;
        String resultPart2;
        StringBuilder builder = new StringBuilder();

        if (heaviside(state, countQS - 1) > 0) {
            for (int i = 0; i < countQS - 1; i++) {
                elementSecondPart1 += mu[countQS - 1] * matrixP[countQS - 1][i] * matrixR[countQS - 1][i];
            }

            for (int i = 0; i < countQS - 1; i++) {
                elementSecondPart2 = mu[countQS - 1] * matrixP[countQS - 1][i];
                resultPart2 = elementSecondPart2 + "(" + findNumState(state, getI(countQS - 1), getI(i)) + ")";

                if (i != countQS - 2) {
                    builder.append(resultPart2).append("+");
                } else {
                    builder.append(resultPart2);
                }
            }

            return elementSecondPart1 + "+" + builder.toString();
        } else {
            return "";
        }
    }

    // find in list of state the right and return his index
    private int findNumState(String state, String firstI, String secondI) {
        int[] intState = getIntegerState(state);
        int[] intFirstI = getIntegerState(firstI);
        int[] intSecondI = getIntegerState(secondI);
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < countQS; i++) {
            int result = intState[i] - intFirstI[i] + intSecondI[i];

            if (i != countQS - 1) {
                builder.append(result).append(",");
            } else {
                builder.append(result);
            }
        }

        return strategy.getStrategy().indexOf(builder.toString());
    }

    // function Heaviside, return 1 ore 0
    private int heaviside(String state, int iter) {
        int[] integerState = getIntegerState(state);

        if (integerState[iter] > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    // change String state to int Array, and return array
    private int[] getIntegerState(String value) {
        int[] elem = new int[countQS];
        String[] strings = (value).split("\\p{P}?[ ,\\t\\n\\r]");

        for (int i = 0; i < strings.length; i++) {
            elem[i] = Integer.parseInt(strings[i]);
        }

        return elem;
    }

    // create list of I (state with 0 and 1, 1 on main diagonal)
    private List<String> createListI() {
        List<String> listI = new ArrayList<>();

        for (int i = 0; i < countQS; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < countQS; j++) {

                if (j == countQS - 1 && i == countQS - 1) {
                    stringBuilder.append("1");
                } else if (j == countQS - 1 && i != countQS - 1) {
                    stringBuilder.append("0");
                } else if (j == i) {
                    stringBuilder.append("1,");
                } else {
                    stringBuilder.append("0,");
                }

            }
            listI.add(stringBuilder.toString());
        }

        return listI;
    }

    private String getI(int num) {
        return listI.get(num);
    }

    public static void main(String[] args) {

        float[][] matrixP = new float[][]{{0, 0, 1f}, {0, 0, 1f}, {0.5f, 0.5f, 0}};
        float[][] matrixR = new float[][]{{0, 0, 1f}, {0, 0, 1f}, {1f, 2f, 0}};
        float[] mu = new float[]{1f, 1f, 1f};

        CreateHDE createHDE = new CreateHDE(3, 2, matrixP, matrixR, mu);

        System.out.println(createHDE.secondElem("0,0,2"));

    }
}
