package maze;

import java.util.Comparator;

/*
 * Comparator for the Astar PriorityQueue
 */
public class AstarComparator implements Comparator<Point> {

    @Override
    public int compare(Point x, Point y) {
        if(x.heuristic.astarHeuristic > y.heuristic.astarHeuristic) return 1;
        else if (x.heuristic.astarHeuristic < y.heuristic.astarHeuristic) return -1;
        else return 0;
    }
}
