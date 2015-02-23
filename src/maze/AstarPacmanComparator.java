package maze;

import java.util.Comparator;

/*
 * Comparator for the PriorityQueue. The compare method of the Comparator<T> class is overriden
 */
public class AstarPacmanComparator implements Comparator<Point> {

    @Override
    public int compare(Point x, Point y) {
        if(x.pacmanHeuristic.pacmanHeuristic > y.pacmanHeuristic.pacmanHeuristic) return 1;
        else if (x.pacmanHeuristic.pacmanHeuristic < y.pacmanHeuristic.pacmanHeuristic) return -1;
        else return 0;
    }
}