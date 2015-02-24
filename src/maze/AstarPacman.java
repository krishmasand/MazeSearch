package maze;
import java.util.*;

public class AstarPacman {

    /* Data */
    public PriorityQueue<State> frontier;
    HashMap<State, State> predecessor;
    public int solutionDistance;
    public int nodesExpanded;
    
    /* Constructor */
    public AstarPacman(Maze maze){
        //setHeuristics(maze); //we do not set heuristics for the maze yet.
        Comparator<State> comparator = new StateComparator();
        frontier    = new PriorityQueue<State>((maze.grid.length * maze.grid[1].length), comparator);
        predecessor = new HashMap<State, State>();
        State endState = findSolution(maze);
        solutionDistance = endState.costSoFar;
    }

    public State findSolution(Maze maze){
		/* Load Start State onto Frontier. Update stuff */
    	State initial = new State(maze.start, maze.dots, 0);
        frontier.add(initial);
        nodesExpanded = 0;
		
		/* Actual Algorithm */
        while( ! frontier.isEmpty())
        {
            State currentState = frontier.remove();
            setAdjacentHeuristics(maze, currentState); //need to implement
            nodesExpanded++;
            ArrayList<State> adjacentStates = currentState.getAdjacentStates(maze);  //need to implement
		
			/* Loop through adjacent points and update stuff */
            for(State state : adjacentStates){
            	predecessor.put(state, currentState);
            	frontier.add(state);
            	if (state.dots.size() == 0)
                	return state;
            }
        }
        return null;
    }

    public void setAdjacentHeuristics(Maze maze, State popped) {
        for(State state : popped.getAdjacentStates(maze)) {
        	state.heuristic = new StateHeuristic(state);
            state.heuristic.heuristic += state.costSoFar;
        }
    }

}


