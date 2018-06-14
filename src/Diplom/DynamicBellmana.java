package Diplom;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static Utils.OtherUtilClass.maxStrategy;

public class DynamicBellmana {

    private Value val = new Value();
    private Strategy getFromStrategy = new Strategy();

    private Map<Integer, String> mapOfResultFirst = val.getFirst().resultODY();
    private Map<Integer, String> mapOfResultSecond = val.getSecond().resultODY();
    private Map<Integer, String> mapOfResultThird = val.getThird().resultODY();
    private Map<Integer, String> mapOfResultForth = val.getFourth().resultODY();
    private Map<Integer, String> mapOfResultFive = val.getFive().resultODY();
    private Map<Integer, String> mapOfResultSix = val.getSix().resultODY();

    public int[][] rezultBest = getFromMap();

    private int[][] getFromMap() {
        float[][] vectorIncomeOne = new float[1][getFromStrategy.getMp().size()];
        float[][] vectorIncomeTwo = new float[1][getFromStrategy.getMp().size()];
        float[][] vectorIncomeThree = new float[1][getFromStrategy.getMp().size()];
        float[][] vectorIncomeFour = new float[1][getFromStrategy.getMp().size()];
        float[][] vectorIncomeFive = new float[1][getFromStrategy.getMp().size()];
        float[][] vectorIncomeSix = new float[1][getFromStrategy.getMp().size()];
        int[][] rezultBest = new int[getFromStrategy.getMp().size()][getFromStrategy.getMp().size()];
        for (int i = 0; i < getFromStrategy.getTime(); i++) {
            String str1 = mapOfResultFirst.get(i);
            String str2 = mapOfResultSecond.get(i);
            String str3 = mapOfResultThird.get(i);
            String str4 = mapOfResultForth.get(i);
            String str5 = mapOfResultFive.get(i);
            String str6 = mapOfResultSix.get(i);
            String[] parts1 = (str1 + " ").split("\\p{P}?[ |\\t\\n\\r]");
            String[] parts2 = (str2 + " ").split("\\p{P}?[ |\\t\\n\\r]");
            String[] parts3 = (str3 + " ").split("\\p{P}?[ |\\t\\n\\r]");
            String[] parts4 = (str4 + " ").split("\\p{P}?[ |\\t\\n\\r]");
            String[] parts5 = (str5 + " ").split("\\p{P}?[ |\\t\\n\\r]");
            String[] parts6 = (str6 + " ").split("\\p{P}?[ |\\t\\n\\r]");

            for (int j = 0; j < parts1.length; j++) {
                vectorIncomeOne[0][j] = Float.parseFloat(parts1[j]);
                vectorIncomeTwo[0][j] = Float.parseFloat(parts2[j]);
                vectorIncomeThree[0][j] = Float.parseFloat(parts3[j]);
                vectorIncomeFour[0][j] = Float.parseFloat(parts4[j]);
                vectorIncomeFive[0][j] = Float.parseFloat(parts5[j]);
                vectorIncomeSix[0][j] = Float.parseFloat(parts6[j]);
                rezultBest[j][i] = maxStrategy(vectorIncomeOne[0][j],
                        vectorIncomeTwo[0][j], vectorIncomeThree[0][j], vectorIncomeFour[0][j],
                        vectorIncomeFive[0][j], vectorIncomeSix[0][j]);
            }
        }

        return rezultBest;
    }

    public void printRezultDynamicBellmana() {
        for (int i = 0; i < getFromStrategy.getMp().size(); i++) {
            System.out.println("------------------");
            System.out.println(getFromStrategy.getMp().get(i) + " | ");
            for (int j = 1; j < getFromStrategy.getTime(); j++) {
                System.out.print(rezultBest[i][j] + ",");
            }
            System.out.println();
        }
    }

    public void write(String state) {
        Map<Integer, String> valueFromMap;
        int key = 0;
        for (HashMap.Entry<Integer, String> pair : getFromStrategy.getMp().entrySet()
                ) {
            if (state.equals(pair.getValue()))
                key = pair.getKey();
        }

        String[] str = new String[getFromStrategy.getTime()];
        String str2 = "";
        int n = 0;

        for (int j = 0; j < getFromStrategy.getTime(); j++) {
            if (rezultBest[key][j] == 1) {
                valueFromMap = mapOfResultFirst;
            } else if (rezultBest[key][j] == 2) {
                valueFromMap = mapOfResultSecond;
            } else if (rezultBest[key][j] == 3) {
                valueFromMap = mapOfResultThird;
            } else if (rezultBest[key][j] == 4) {
                valueFromMap = mapOfResultForth;
            } else if (rezultBest[key][j] == 5) {
                valueFromMap = mapOfResultFirst;
            } else {
                valueFromMap = mapOfResultSix;
            }
            str2 = valueFromMap.get(n);
            String[] parts1 = (str2 + " ").split("\\p{P}?[ |\\t\\n\\r]");
            str[n] = parts1[key];
            n++;

        }
        try {
            File fileDir = new File("E:\\test2.txt");

            Writer out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileDir), "UTF8"));

            for (int i = 0; i < str.length; i++) {
                out.append(str[i]).append("\r\n");
            }
            out.flush();
            out.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
