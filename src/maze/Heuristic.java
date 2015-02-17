package maze;

/**
 * Created by Aravind on 2/17/15.
 */

import java.util.*;
import java.lang.*;

public class Heuristic {

    public int heuristic;


    public Heuristic(Point point, Maze maze) {
        heuristic = Math.abs(point.x - maze.end.x) + Math.abs(point.y - maze.end.y);
    }
}
