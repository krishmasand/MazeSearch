package maze;

/*
Heuristic object that calculates Heuristics for A* Search and Greedy Best First Search
 */

import java.lang.*;

public class Heuristic {

    public int distanceHeuristic;
    public int startHeuristic;
    public int astarHeuristic;

    /* this method calculates both the basic distance heuristic and the Astar Heuristic of a Point variable.
    * The distance heuristic is the distance the point is from the end, while the Astar heuristic is the sum of
    * the distance from the start to the point and the end to the point.
     */
    public Heuristic(Point point, Maze maze) {
        distanceHeuristic = Math.abs(point.x - maze.end.x) + Math.abs(point.y - maze.end.y);
        startHeuristic = Math.abs(point.x-maze.start.x) + Math.abs(point.y - maze.end.y);
        astarHeuristic = distanceHeuristic + startHeuristic;
    }
}
