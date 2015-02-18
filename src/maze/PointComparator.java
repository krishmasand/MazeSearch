package maze;

import java.util.Comparator;
import java.lang.Math;

/**
 * Created by Aravind on 2/17/15.
 */
public class PointComparator implements Comparator<Point> {

    @Override
    public int compare(Point x, Point y) {
        if(x.heuristic.heuristic > y.heuristic.heuristic) return 1;
        else if (x.heuristic.heuristic < y.heuristic.heuristic) return -1;
        else return 0;
    }
}
