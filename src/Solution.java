import Methods.FullSearch;
import Methods.Howard;
import Utils.HDEUtil.CreateStrategies;
import Utils.States.CreateState;

public class Solution {

    public static void main(String[] args) {
        int countQS = 4;
        int k = 2;
        int time = 22;

        CreateState state = new CreateState(k);
        CreateStrategies createStrategies = new CreateStrategies(countQS, state);

//        FullSearch fullSearch = new FullSearch(time, createStrategies, state);
//        fullSearch.printResultFullSearch();

        Howard howard = new Howard(createStrategies, state);
        howard.getResultHoward();
    }
}
