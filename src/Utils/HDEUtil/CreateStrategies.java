package Utils.HDEUtil;

import Methods.Value;
import Utils.States.CreateState;

import java.util.*;

public class CreateStrategies {
    private CreateMatrixAVectorQ firstStrategy;
    private CreateMatrixAVectorQ secondStrategy;
    private CreateMatrixAVectorQ thirdStrategy;
    private CreateMatrixAVectorQ forthStrategy;
    private CreateMatrixAVectorQ fiveStrategy;
    private CreateMatrixAVectorQ sixStrategy;

    public CreateStrategies(int countQS, CreateState state) {
        Value val = new Value();
        List<String> listStates = state.getStrategy();

        firstStrategy = new CreateMatrixAVectorQ(countQS, listStates,
                val.getMatrixP1(), val.getMatrixR1(), val.getMu1(), val.getR1());
        secondStrategy = new CreateMatrixAVectorQ(countQS, listStates,
                val.getMatrixP2(), val.getMatrixR2(), val.getMu2(), val.getR2());
        thirdStrategy = new CreateMatrixAVectorQ(countQS, listStates,
                val.getMatrixP3(), val.getMatrixR3(), val.getMu3(), val.getR3());
        forthStrategy = new CreateMatrixAVectorQ(countQS, listStates,
                val.getMatrixP4(), val.getMatrixR4(), val.getMu4(), val.getR4());
        fiveStrategy = new CreateMatrixAVectorQ(countQS, listStates,
                val.getMatrixP5(), val.getMatrixR5(), val.getMu5(), val.getR5());
        sixStrategy = new CreateMatrixAVectorQ(countQS, listStates,
                val.getMatrixP6(), val.getMatrixR6(), val.getMu6(), val.getR6());
    }

    public CreateMatrixAVectorQ getFirstStrategy() {
        return firstStrategy;
    }

    public CreateMatrixAVectorQ getSecondStrategy() {
        return secondStrategy;
    }

    public CreateMatrixAVectorQ getThirdStrategy() {
        return thirdStrategy;
    }

    public CreateMatrixAVectorQ getForthStrategy() {
        return forthStrategy;
    }

    public CreateMatrixAVectorQ getFiveStrategy() {
        return fiveStrategy;
    }

    public CreateMatrixAVectorQ getSixStrategy() {
        return sixStrategy;
    }
}
