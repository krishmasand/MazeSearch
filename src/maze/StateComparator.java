package maze;

import java.util.Comparator;

public class StateComparator implements Comparator<State> {

    @Override
    public int compare(State x, State y) {
        if(x.pacmanHeuristic.pacmanHeuristic > y.pacmanHeuristic.pacmanHeuristic) return 1;
        else if (x.pacmanHeuristic.pacmanHeuristic < y.pacmanHeuristic.pacmanHeuristic) return -1;
        else return 0;
    }
}