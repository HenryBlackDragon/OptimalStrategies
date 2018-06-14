package Diplom;

import java.util.*;
import java.util.stream.Collectors;

public class Strategy {
    private int k = 2;
    private int countQS = 4;

    private int r;
    private float[] mu;
    private double[][] matrixP;
    private int[][] matrixR;
    private List<String> strategy = state(k).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    private Map<Integer, String> mp = toMap(strategy);

    private float[][] matrixA = inputMatrixA();
    private float[][] vectorQ = inputVectorQ();
    private float[][] vectorV = inputVectorV();

    //+1 день
    private int time = 23;
    private int deltaTime = 23;
    private float step = time / deltaTime;


    public int getCountState() {
        return strategy.size();
    }

    public float[][] getVectorQ() {
        return vectorQ;
    }

    public float[][] getMatrixA() {
        return matrixA;
    }

    public Map<Integer, String> getMp() {
        return mp;
    }

    public int getTime() {
        return time;
    }

    Strategy() {
    }

    Strategy(float[] mu, double[][] matrixP, int[][] matrixR, int r) {
        this.mu = mu;
        this.matrixP = matrixP;
        this.matrixR = matrixR;
        this.r = r;
    }

//    // метод находит все возможные состояния
//    private List<String> state(int k) {
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i <= k; i++) {
//            for (int j = 0; j <= k; j++) {
//                for (int l = 0; l <= k; l++) {
//                    for (int m = 0; m <= k; m++) {
//                        for (int n = 0; n <= k; n++) {
//                            for (int o = 0; o <= k; o++) {
//                                for (int p = 0; p <= k; p++) {
//                                    if (i + j + l + m + n + o + p == k)
//                                        list.add(i + "," + j + "," + l + "," + m + "," + n + "," + o + "," + p);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        return list;
//    }

    // метод находит все возможные состояния
    private List<String> state(int k) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= k; j++) {
                for (int l = 0; l <= k; l++) {
                    for (int m = 0; m <= k; m++) {
                        if (i + j + l + m == k)
                            list.add(i + "," + j + "," + l + "," + m);
                    }
                }
            }
        }

        return list;
    }

    // заносит состояния в колекцию HashMap
    private Map<Integer, String> toMap(List<String> list) {
        Map<Integer, String> forMap = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            forMap.put(i, list.get(i));
        }

        return forMap;
    }

    // состовление ОДУ и вектора Q
    private String[] dy() {
        String[] dy = new String[mp.size()];
        for (int i = 0; i < dy.length; i++) {
            dy[i] = (r + elSecond(i, mp) - elThird(i, mp)) + " + " + (elFirst(mp, i)) + " + " + elSecond(mp, i)
                    + " + (" + elThird(mp, i) + ") + (" + elFourth(mp, i) + ")";
            vectorQ[0][i] = (float) (r + elSecond(i, mp) - elThird(i, mp));
        }
        return dy;
    }

    // 1 элемент для ОДУ
    private String elFirst(Map<Integer, String> mp, int iter) {
        float elementFirst = 0;
        String valueMap = mp.get(iter);
        for (int i = 0; i < countQS; i++) {
            elementFirst -= mu[i] * hevisaida(valueMap, i);
        }
        matrixA[iter][iter] = matrixA[iter][iter] + elementFirst;
        return "(" + elementFirst + "v(" + iter + ",t))";
    }

    // 2_1 элемент для ОДУ
    private String elSecond(Map<Integer, String> mp, int iter) {
        float elementSecond = 0;
        String valueMap = mp.get(iter);
        String value7 = mapForI().get(countQS - 1);
        int[] elk = fromCharToInt(valueMap);
        int[] el7 = fromCharToInt(value7);

        int[] ansver = new int[countQS];
        for (int i = 0; i < countQS - 1; i++) {
            elementSecond += mu[countQS - 1] * hevisaida(valueMap) * matrixP[countQS - 1][i];
            if (hevisaida(valueMap) > 0 && matrixP[countQS - 1][i] != 0) {  // вроде прравильно)
                String valueFromLoop = mapForI().get(i);
                int[] elFromLoop = fromCharToInt(valueFromLoop);
                for (int j = 0; j < ansver.length; j++) {
                    ansver[j] = elk[j] - el7[j] + elFromLoop[j];
                }
            }
        }
        matrixA[iter][keyFromMap(mp, ansver)] = matrixA[iter][keyFromMap(mp, ansver)] + elementSecond;
        return elementSecond + "v(" + keyFromMap(mp, ansver) + ",t)";
    }

    // 2_2 элемент для ОДУ
    private double elSecond(int iter, Map<Integer, String> mp) {
        double elementSecond = 0;
        String valueMap = mp.get(iter);
        for (int i = 0; i < countQS - 1; i++) {
            elementSecond += mu[countQS - 1] * hevisaida(valueMap) * matrixP[countQS - 1][i] * matrixR[countQS - 1][i];
        }

        return elementSecond;
    }

    // 3_1 элемент для ОДУ
    private String elThird(Map<Integer, String> mp, int iter) {
        float[] elementThird = new float[countQS];
        String allResult = "";
        String valueMap = mp.get(iter);
        String value7 = mapForI().get(countQS - 1);
        int[] elk = fromCharToInt(valueMap);
        int[] el7 = fromCharToInt(value7);

        int[] ansver = new int[countQS];

        for (int i = 0; i < countQS - 1; i++) {
            elementThird[i] = mu[i] * hevisaida(valueMap, i);
            if (hevisaida(valueMap, i) > 0) {
                String valueFromLoop = mapForI().get(i);
                //  System.out.println(valueFromLoop);
                int[] elFromLoop = fromCharToInt(valueFromLoop);
                for (int j = 0; j < ansver.length; j++) {
                    ansver[j] = elk[j] - elFromLoop[j] + el7[j];
                }
                matrixA[iter][keyFromMap(mp, ansver)] = matrixA[iter][keyFromMap(mp, ansver)] + elementThird[i];
                allResult += "+" + elementThird[i] + "v(" + keyFromMap(mp, ansver) + ",t)";
            }
        }

        return allResult;
    }

    // 3_2 элемент для ОДУ
    private double elThird(int iter, Map<Integer, String> mp) {
        double elementThird = 0;
        String valueMap = mp.get(iter);

        for (int i = 0; i < countQS - 1; i++) {
            elementThird += mu[i] * hevisaida(valueMap, i) * matrixR[i][countQS - 1];
        }

        return elementThird;
    }

    // 4_1 элемент для ОДУ
    private String elFourth(Map<Integer, String> mp, int iter) {
//        float[] elementFourth = new float[]{0, 0, 0, 0, 0, 0};
        float[] elementFourth = new float[]{0, 0, 0};
        String allResult = "";
        String valueMap = mp.get(iter);
        int[] elk = fromCharToInt(valueMap);


        int[] ansver = new int[countQS];
        int sum = 0;

        for (int i = 0; i < countQS - 1; i++) {
            String valueFromLoopOne = mapForI().get(i);
            int[] eli = fromCharToInt(valueFromLoopOne);
            for (int j = 0; j < countQS - 1; j++) {
                elementFourth[i] = (float) (mu[i] * hevisaida(valueMap, i) * matrixP[i][j]);

                if (hevisaida(valueMap, i) > 0 && matrixP[i][j] != 0) {
                    String valueFromLoopTwo = mapForI().get(j);
                    int[] elFromLoop = fromCharToInt(valueFromLoopTwo);
                    for (int z = 0; z < ansver.length; z++) {
                        ansver[z] = elk[z] - eli[z] + elFromLoop[z];
                    }
                    matrixA[iter][keyFromMap(mp, ansver)] = matrixA[iter][keyFromMap(mp, ansver)] + elementFourth[i];
                    allResult += "+ " + elementFourth[i] + "v(" + keyFromMap(mp, ansver) + ",t)";
                }
            }
            sum += elementFourth[i];
        }

        return allResult;
    }

    // функция Хевисайду, возвращает 1 или 0, только при k<10, если надо при k>=10 необходимо дописать код!
    private int hevisaida(String valueMap, int iter) {
        int[] u = fromCharToInt(valueMap);
        if (u[iter] > 0)
            return 1;
        else return 0;
    }

    private int hevisaida(String valueMap) {
        int[] u = fromCharToInt(valueMap);
        if (u[countQS - 1] > 0)
            return 1;
        else return 0;
    }

    // преобразует массив Char(хранит значение состояние(берет из коллекции)) в Int массив
    private int[] fromCharToInt(String value) {
        int[] el = new int[countQS];
        String[] parts1 = (value + "").split("\\p{P}?[ ,\\t\\n\\r]");
        for (int i = 0; i < parts1.length; i++) {
            el[i] = Integer.parseInt(parts1[i]);
        }
        return el;
    }

    // ищет в коллекции(состояние) такуюже и возвращает ее ключ(номер состояние)
    private int keyFromMap(Map<Integer, String> mp, int[] ansver) {
        String str = "";
        int key = 0;
        for (int i = 0; i < ansver.length; i++) {
            str += ansver[i];
            if (i != ansver.length - 1)
                str += ",";
            else continue;
        }
        for (Map.Entry<Integer, String> pair : mp.entrySet()) {
            int ke = pair.getKey();                      //ключ
            String value = pair.getValue();        //значение
            if (value.equals(str))
                key = ke;
        }

        return key;
    }

//    // заполняет колекцию для символа I ( где все элементы равны 0, кроме i)
//    private Map<Integer, String> mapForI() {
//        Map<Integer, String> forI = new HashMap<>();
//        forI.put(0, "1,0,0,0,0,0,0");
//        forI.put(1, "0,1,0,0,0,0,0");
//        forI.put(2, "0,0,1,0,0,0,0");
//        forI.put(3, "0,0,0,1,0,0,0");
//        forI.put(4, "0,0,0,0,1,0,0");
//        forI.put(5, "0,0,0,0,0,1,0");
//        forI.put(6, "0,0,0,0,0,0,1");
//        return forI;
//    }

    // заполняет колекцию для символа I ( где все элементы равны 0, кроме i)
    private Map<Integer, String> mapForI() {
        Map<Integer, String> forI = new HashMap<>();
        forI.put(0, "1,0,0,0");
        forI.put(1, "0,1,0,0");
        forI.put(2, "0,0,1,0");
        forI.put(3, "0,0,0,1");
        return forI;
    }

    //заполняет матрицу A нулями
    private float[][] inputMatrixA() {
        matrixA = new float[mp.size()][mp.size()];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA.length; j++) {
                matrixA[i][j] = 0;
            }
        }
        return matrixA;
    }

    //заполняет вектора Q нулями
    private float[][] inputVectorQ() {
        vectorQ = new float[1][mp.size()];
        for (int i = 0; i < mp.size(); i++) {
            vectorQ[0][i] = 0;
        }
        return vectorQ;
    }

    //заполняет вектора V еденицами
    private float[][] inputVectorV() {
        vectorV = new float[1][mp.size()];
        for (int i = 0; i < mp.size(); i++) {
            vectorV[0][i] = 0;
        }
        return vectorV;
    }

    private float[][] solveODY(float[][] vectorNextV) {
        float[][] vectorAfterMatrixA = new float[1][mp.size()];
        float[][] vectorNextQ = vectorQ;
        // float[][] vectorNextV = vectorV;
        float[][] vectorNewNextV = new float[1][mp.size()];
        for (int i = 0; i < mp.size(); i++) {
            vectorNextQ[0][i] = vectorNextQ[0][i] * step;
            vectorAfterMatrixA[0][i] = vectorNextV[0][i] * step /* * 0.48f */; // с учетом переоценки
        }
        float[][] multiplayMatrix = matrixMultiplay(matrixA, vectorAfterMatrixA);

        for (int i = 0; i < mp.size(); i++) {
            vectorNewNextV[0][i] = multiplayMatrix[0][i] + vectorNextV[0][i] + vectorNextQ[0][i];
        }
        return vectorNewNextV;
    }

    public Map<Integer, String> resultODY() {
        dy();
        String[] rezz = new String[time];
        for (int i = 0; i < time; i++) {
            rezz[i] = "";
        }
        Map<Integer, String> mapOfResult = new HashMap<>();
        float[][] incomeSystem = vectorV;
        float[][] zzzz = new float[1][mp.size()];
        for (int i = 0; i < time; i++) {
            for (int j = 0; j < mp.size(); j++) {
                rezz[i] += incomeSystem[0][j] + "|";
            }
            mapOfResult.put(i, rezz[i]);

            String s = mapOfResult.get(i);
            String[] parts = (s + " ").split("\\p{P}?[ |\\t\\n\\r]");

            for (int l = 0; l < mp.size(); l++) {
                zzzz[0][l] = Float.parseFloat(parts[l]);
            }
            incomeSystem = solveODY(zzzz);
        }
        return mapOfResult;
    }

    private float[][] matrixMultiplay(float[][] newMatrixA, float[][] newVectorQ) {
        float[][] vector = new float[1][mp.size()];
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < mp.size(); j++) {
                for (int k = 0; k < mp.size(); k++) {
                    vector[i][j] += newMatrixA[j][k] * newVectorQ[i][k];
                }
            }
        }
        return vector;
    }

    // печатает на экран все состояние, которые храняться в колекции
    public void printMap() {

        for (Map.Entry<Integer, String> pair : mp.entrySet()
                ) {
            int key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " : " + value);
        }
    }

    // печатает на экран ОДУ
    public void printODY(String[] dy) {
        for (int i = 0; i < dy.length; i++) {
            System.out.println("dv(" + i + ",t)=" + dy[i]);
        }
    }

    // вывод матрицу A на экрна
    public void printMatrixA() {
        for (float[] aMatrixA : matrixA) {
            for (int j = 0; j < matrixA.length; j++) {
                System.out.print(aMatrixA[j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    // вывод вектора Q на экрна
    public void printVectorQ() {
        for (int i = 0; i < mp.size(); i++) {
            System.out.println(vectorQ[0][i]);
        }
    }

    public void printResult() {
        Map<Integer, String> mapOfResult = resultODY();
        for (HashMap.Entry<Integer, String> pair : mapOfResult.entrySet()
                ) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }
}
