package maze;

import java.util.Comparator;

/*
 * Comparator for the Greedy Best-First PriorityQueue. The compare method of the Comparator<T> class is overriden
 */
public class PointComparator implements Comparator<Point> {

    /* this comparator will sort the elements in the priority queue by their distance from the endpoint */
    @Override
    public int compare(Point x, Point y) {
        if(x.heuristic.distanceHeuristic > y.heuristic.distanceHeuristic) return 1;
        else if (x.heuristic.distanceHeuristic < y.heuristic.distanceHeuristic) return -1;
        else return 0;
    }
}
