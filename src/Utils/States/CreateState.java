package Utils.States;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CreateState {
    private int k;
    private List<String> strategy;

    public CreateState(int k) {
        this.k = k;
        strategy = state(k).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public int getK() {
        return k;
    }

    public int getCountState() {
        return strategy.size();
    }

    public List<String> getStrategy() {
        return strategy;
    }

    // метод находит все возможные состояния
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

//    // метод находит все возможные состояния для метода Ховарда
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
}
