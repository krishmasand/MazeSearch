package maze;

import java.util.Comparator;

/*
 * Comparator for the Greedy Best-First PriorityQueue
 */
public class PointComparator implements Comparator<Point> {

    @Override
    public int compare(Point x, Point y) {
        if(x.heuristic.distanceHeuristic > y.heuristic.distanceHeuristic) return 1;
        else if (x.heuristic.distanceHeuristic < y.heuristic.distanceHeuristic) return -1;
        else return 0;
    }
}
