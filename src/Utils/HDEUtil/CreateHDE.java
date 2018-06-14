package Utils.HDEUtil;

public class CreateHDE {

    private int countQS;

    public CreateHDE(int countQS) {
        this.countQS = countQS;
    }

    private String firstElem(String state, int numState, float[] mu) {
        float elementFirst = 0;

        for (int i = 0; i < countQS; i++) {
            elementFirst += mu[i] * heaviside(state, i);
        }

        return "(" + String.valueOf(numState) + ")" + elementFirst;
    }

    // функция Хевисайду, возвращает 1 или 0
    private int heaviside(String state, int iter) {
        int[] integerState = getIntegerState(state);

        if (integerState[iter] > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private int[] getIntegerState(String value) {
        int[] elem = new int[countQS];
        String[] strings = (value).split("\\p{P}?[ ,\\t\\n\\r]");

        for (int i = 0; i < strings.length; i++) {
            elem[i] = Integer.parseInt(strings[i]);
        }

        return elem;
    }

    public static void main(String[] args) {
        CreateHDE createHDE = new CreateHDE(4);
        float[] mu = new float[]{1f, 2f, 0, 1};

        System.out.println(createHDE.firstElem("1,0,0,2", 1, mu));

    }
}
