package maze;

import java.util.Comparator;

public class StateComparator implements Comparator<State> {

    @Override
    public int compare(State x, State y) {
        if(x.heuristic.heuristic > y.heuristic.heuristic) return 1;
        else if (x.heuristic.heuristic < y.heuristic.heuristic) return -1;
        else return 0;
    }
}