package maze;

import java.util.Comparator;

/*
 * Comparator for the Astar PriorityQueue. The compare method of the Comparator<T> class is overriden
 */
public class AstarComparator implements Comparator<Point> {

    /* This comparator sorts the elements of the PriorityQueue by their Astar Heuristic */
    @Override
    public int compare(Point x, Point y) {
        if(x.heuristic.astarHeuristic > y.heuristic.astarHeuristic) return 1;
        else if (x.heuristic.astarHeuristic < y.heuristic.astarHeuristic) return -1;
        else return 0;
    }
}
