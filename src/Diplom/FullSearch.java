package Diplom;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static Utils.OtherUtilClass.maxStrategy;

public class FullSearch {

    private Value val = new Value();
    private Strategy getFromStrategy = new Strategy();

    private Map<Integer, String> mapOfResultFirst = val.getFirst().resultODY();
    private Map<Integer, String> mapOfResultSecond = val.getSecond().resultODY();
    private Map<Integer, String> mapOfResultThird = val.getThird().resultODY();
    private Map<Integer, String> mapOfResultForth = val.getFourth().resultODY();
    private Map<Integer, String> mapOfResultFive = val.getFive().resultODY();
    private Map<Integer, String> mapOfResultSix = val.getSix().resultODY();

    private int[] rezultBest = getFromMap();

    private int[] getFromMap() {
        float[][] vectorIncomeOne = new float[1][getFromStrategy.getMp().size()];
        float[][] vectorIncomeTwo = new float[1][getFromStrategy.getMp().size()];
        float[][] vectorIncomeThree = new float[1][getFromStrategy.getMp().size()];
        float[][] vectorIncomeFour = new float[1][getFromStrategy.getMp().size()];
        float[][] vectorIncomeFive = new float[1][getFromStrategy.getMp().size()];
        float[][] vectorIncomeSix = new float[1][getFromStrategy.getMp().size()];
        String str1 = mapOfResultFirst.get(getFromStrategy.getTime() - 1);
        //  System.out.println(str1);
        String str2 = mapOfResultSecond.get(getFromStrategy.getTime() - 1);
        String str3 = mapOfResultThird.get(getFromStrategy.getTime() - 1);
        String str4 = mapOfResultForth.get(getFromStrategy.getTime() - 1);
        String str5 = mapOfResultFive.get(getFromStrategy.getTime() - 1);
        String str6 = mapOfResultSix.get(getFromStrategy.getTime() - 1);
        String[] parts1 = (str1 + " ").split("\\p{P}?[ |\\t\\n\\r]");
        String[] parts2 = (str2 + " ").split("\\p{P}?[ |\\t\\n\\r]");
        String[] parts3 = (str3 + " ").split("\\p{P}?[ |\\t\\n\\r]");
        String[] parts4 = (str4 + " ").split("\\p{P}?[ |\\t\\n\\r]");
        String[] parts5 = (str5 + " ").split("\\p{P}?[ |\\t\\n\\r]");
        String[] parts6 = (str6 + " ").split("\\p{P}?[ |\\t\\n\\r]");
        int[] rezultBest = new int[getFromStrategy.getMp().size()];

        for (int i = 0; i < parts1.length; i++) {
            vectorIncomeOne[0][i] = Float.parseFloat(parts1[i]);
            vectorIncomeTwo[0][i] = Float.parseFloat(parts2[i]);
            vectorIncomeThree[0][i] = Float.parseFloat(parts3[i]);
            vectorIncomeFour[0][i] = Float.parseFloat(parts4[i]);
            vectorIncomeFive[0][i] = Float.parseFloat(parts5[i]);
            vectorIncomeSix[0][i] = Float.parseFloat(parts6[i]);
            rezultBest[i] = maxStrategy(vectorIncomeOne[0][i],
                    vectorIncomeTwo[0][i], vectorIncomeThree[0][i], vectorIncomeFour[0][i],
                    vectorIncomeFive[0][i], vectorIncomeSix[0][i]);
        }

        return rezultBest;
    }

    public void write(String state) {
        Map<Integer, String> valueFromMap;
        int key = 0;
        for (HashMap.Entry<Integer, String> pair : getFromStrategy.getMp().entrySet()
                ) {
            //   System.out.println(pair.getKey() + " " + pair.getValue());
            if (state.equals(pair.getValue()))
                key = pair.getKey();

        }
        if (rezultBest[key] == 1) valueFromMap = mapOfResultFirst;
        else if (rezultBest[key] == 2) valueFromMap = mapOfResultSecond;
        else if (rezultBest[key] == 3) valueFromMap = mapOfResultThird;
        else if (rezultBest[key] == 4) valueFromMap = mapOfResultForth;
        else if (rezultBest[key] == 5) valueFromMap = mapOfResultFive;
        else valueFromMap = mapOfResultSix;

        String[] str = new String[getFromStrategy.getTime()];
        for (int i = 0; i < getFromStrategy.getTime(); i++) {

            String str2 = valueFromMap.get(i);
            String[] parts1 = (str2 + " ").split("\\p{P}?[ |\\t\\n\\r]");
            str[i] = parts1[key];
        }

        try {
            File fileDir = new File("E:\\Test.txt");

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

    public void printRezultFullSearch() {
//        HashMap<String, Integer> qqqqq = getFromMap();
//        for (HashMap.Entry<String,Integer> pair: qqqqq.entrySet()
//             ) {
//            System.out.println("------------");
//            System.out.println(pair.getKey() + " | " + pair.getValue() + "|");
//           // System.out.println("-----------------------");
//        }
        for (int i = 0; i < getFromStrategy.getMp().size(); i++) {
            System.out.println("------------------");
            System.out.println(getFromStrategy.getMp().get(i) + " | " + rezultBest[i] + "|");

        }
    }
}
