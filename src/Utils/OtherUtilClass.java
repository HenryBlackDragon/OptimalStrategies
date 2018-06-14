package Utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OtherUtilClass {

    public static int maxStrategy(float first, float second,
                                  float third, float fourth, float five, float six) {
        List<Float> list = Arrays.asList(first, second, third, fourth, five, six);

        return list.indexOf(Collections.max(list)) + 1;
    }
}
