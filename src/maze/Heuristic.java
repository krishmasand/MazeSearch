package maze;

/*
Heuristic object that calculates Heuristics for A* Search and Greedy Best First Search
 */

import java.lang.*;

public class Heuristic {

    public int distanceHeuristic;
    public int startHeuristic;
    public int astarHeuristic;


    public Heuristic(Point point, Maze maze) {
        distanceHeuristic = Math.abs(point.x - maze.end.x) + Math.abs(point.y - maze.end.y);
        startHeuristic = Math.abs(point.x-maze.start.x) + Math.abs(point.y - maze.end.y);
        astarHeuristic = distanceHeuristic + startHeuristic;
    }
}
