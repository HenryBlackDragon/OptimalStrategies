package Utils.HDEUtil;

import Utils.States.CreateState;

import java.util.ArrayList;
import java.util.List;

public class CreateMatrixAVectorQ {
    private int countQS;
    private float[][] matrixP;
    private float[][] matrixR;
    private float[] mu;

    private List<String> states;
    private List<String> listI;

    private float[][] matrixA;
    private float[][] vectorQ;

    public CreateMatrixAVectorQ(int countQS, List<String> states, float[][] matrixP, float[][] matrixR, float[] mu, int r) {
        this.countQS = countQS;
        this.matrixP = matrixP;
        this.matrixR = matrixR;
        this.mu = mu;
        this.states = states;

        listI = createListI();
        matrixA = new float[states.size()][states.size()];
        vectorQ = new float[states.size()][1];

        setVectorQ(r);
        createMatrixAandVectorQ();
    }

    // create first element of HDE
    private void firstElem(String state, int numState) {
        float elementFirst = 0;

        for (int i = 0; i < countQS; i++) {
            elementFirst += mu[i] * heaviside(state, i);
        }

        matrixA[numState][numState] += (-1) * elementFirst;
    }

    // create second element of HDE
    private void secondElem(String state, int numState) {
        float elementSecondPart1 = 0;
        float elementSecondPart2;

        if (heaviside(state, countQS - 1) > 0) {
            for (int i = 0; i < countQS - 1; i++) {
                elementSecondPart1 += mu[countQS - 1] * matrixP[countQS - 1][i] * matrixR[countQS - 1][i];
            }

            vectorQ[numState][0] += elementSecondPart1;

            for (int i = 0; i < countQS - 1; i++) {
                elementSecondPart2 = mu[countQS - 1] * matrixP[countQS - 1][i];
                matrixA[numState][findNumState(state, getI(countQS - 1), getI(i))] += elementSecondPart2;
            }
        }
    }

    // create third element of HDE
    private void thirdElem(String state, int numState) {
        float elementThirdPart1 = 0;
        float elementThirdPart2;

        for (int i = 0; i < countQS - 1; i++) {
            if (heaviside(state, i) > 0) {
                elementThirdPart1 += mu[i] * (-1) * matrixR[i][countQS - 1];
            }
        }

        vectorQ[numState][0] += elementThirdPart1;

        for (int i = 0; i < countQS - 1; i++) {
            if (heaviside(state, i) > 0) {
                elementThirdPart2 = mu[i];
                matrixA[numState][findNumState(state, getI(i), getI(countQS - 1))] += elementThirdPart2;
            }
        }
    }

    // create fourth element of HDE
    private void fourthElem(String state, int numState) {
        float fourthElem;

        for (int i = 0; i < countQS - 1; i++) {
            for (int j = 0; j < countQS - 1; j++) {
                if (heaviside(state, i) > 0) {
                    fourthElem = mu[i] * matrixP[i][j];
                    matrixA[numState][findNumState(state, getI(i), getI(j))] += fourthElem;
                }
            }
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

        return states.indexOf(builder.toString());
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

    // create matrix A and vector Q
    private void createMatrixAandVectorQ() {
        for (int i = 0; i < states.size(); i++) {
            firstElem(states.get(i), i);
            secondElem(states.get(i), i);
            thirdElem(states.get(i), i);
            fourthElem(states.get(i), i);
        }
    }

    public float[][] getMatrixA() {
        return matrixA;
    }

    public float[][] getVectorQ() {
        return vectorQ;
    }

    private void setVectorQ(int r) {
        for (int i = 0; i < vectorQ.length; i++) {
            vectorQ[i][0] = r;
        }
    }

    private String getI(int num) {
        return listI.get(num);
    }

    public static void main(String[] args) {
        float[][] matrixP = new float[][]{{0, 0, 1f}, {0, 0, 1f}, {0.5f, 0.5f, 0}};
        float[][] matrixR = new float[][]{{0, 0, 1f}, {0, 0, 1f}, {1f, 2f, 0}};
        float[] mu = new float[]{1f, 1f, 1f};

        CreateState state = new CreateState(2);

        CreateMatrixAVectorQ createHDE = new CreateMatrixAVectorQ(3,
                state.getStrategy(), matrixP, matrixR, mu, 3);


        for (int i = 0; i < state.getStrategy().size(); i++) {
            for (int j = 0; j < state.getStrategy().size(); j++) {
                System.out.print(createHDE.getMatrixA()[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < state.getStrategy().size(); i++) {
            System.out.println(createHDE.getVectorQ()[i][0]);
        }
    }
}
