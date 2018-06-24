package Methods;

import Utils.HDEUtil.CreateMatrixAVectorQ;
import Utils.HDEUtil.CreateStrategies;
import Utils.MatrixUtil.MatrixUtil;
import Utils.OtherUtilClass;
import Utils.States.CreateState;

import java.util.ArrayList;
import java.util.List;

public class FullSearch {
    private int time;
    private CreateState state;
    private CreateStrategies strategies;

    public FullSearch(int time, CreateStrategies strategies, CreateState createState) {
        state = createState;
        this.strategies = strategies;
        this.time = time;
    }

    private float[][] createVectorV(CreateMatrixAVectorQ numStrategy, float[][] oldVectorV) {
        float[][] vectorV = new float[state.getCountState()][1];
        float[][] vectorMult = MatrixUtil.matrixMultiply(numStrategy.getMatrixA(), oldVectorV);

        for (int i = 0; i < state.getCountState(); i++) {
            vectorV[i][0] = numStrategy.getVectorQ()[i][0] + vectorMult[i][0];

        }

        return vectorV;
    }

    private List<Integer> getResultStrategy() {
        List<Integer> result = new ArrayList<>();

        float[][] firstVectorV = new float[state.getCountState()][1];
        float[][] secondVectorV = new float[state.getCountState()][1];
        float[][] thirdVectorV = new float[state.getCountState()][1];
        float[][] forthVectorV = new float[state.getCountState()][1];
        float[][] fiveVectorV = new float[state.getCountState()][1];
        float[][] sixVectorV = new float[state.getCountState()][1];

        for (int i = 0; i < time; i++) {
            firstVectorV = createVectorV(strategies.getFirstStrategy(), firstVectorV);
            secondVectorV = createVectorV(strategies.getSecondStrategy(), secondVectorV);
            thirdVectorV = createVectorV(strategies.getThirdStrategy(), thirdVectorV);
            forthVectorV = createVectorV(strategies.getForthStrategy(), forthVectorV);
            fiveVectorV = createVectorV(strategies.getFiveStrategy(), fiveVectorV);
            sixVectorV = createVectorV(strategies.getSixStrategy(), sixVectorV);
        }

        for (int i = 0; i < state.getCountState(); i++) {
            result.add(OtherUtilClass.maxStrategy(firstVectorV[i][0], secondVectorV[i][0],
                    thirdVectorV[i][0], forthVectorV[i][0], fiveVectorV[i][0], sixVectorV[i][0]));
        }

        return result;
    }

    public void printResultFullSearch() {
        getResultStrategy().forEach(System.out::println);
    }
}
