package maze;
//only exception needed, covers a broad range
import java.io.IOException;

public class Main {
	
	public static void main(String [] args) throws IOException{
        /*******/
        /* 1.1 */
        /*******/
		
		/* Create Mazes */
		Maze maze1 = new Maze("smallMaze");
		Maze maze2 = new Maze("smallMaze");
		Maze maze3 = new Maze("smallMaze");
        Maze maze4 = new Maze("smallMaze");
        
        BFS solution = new BFS(maze1);
        DFS solution2 = new DFS(maze2);
        Greedy solution3 = new Greedy(maze3);
        Astar solution4 = new Astar(maze4);
	
		/* Print Mazes */
        System.out.println("Breadth First Search");
		System.out.println(maze1);
        System.out.println("Depth First Search");
        System.out.println(maze2);
        System.out.println("Greedy Best First Search");
		System.out.println(maze3);
        System.out.println("A* Search");
        System.out.println(maze4);
				
		System.out.println("BFS Nodes Expanded = " + solution.nodesExpanded);
        System.out.println("DFS Nodes Expanded = " + solution2.nodesExpanded);
        System.out.println("Greedy Best-First Nodes Expanded = " + solution3.nodesExpanded);
        System.out.println("A* Nodes Expanded = " + solution4.nodesExpanded);
        System.out.println();
        System.out.println("BFS Solution Distance = " + solution.solutionDistance);
        System.out.println("DFS Solution Distance = " + solution2.solutionDistance);
        System.out.println("Greedy Best-First Solution Distance = " + solution3.solutionDistance);
        System.out.println("A* Solution Distance = " + solution4.solutionDistance);
        System.out.println();
	
        /*******/
        /* 1.2 */
        /*******/
        System.out.println("----------------------");
        System.out.println("Tests for Section 1.2");
        System.out.println("----------------------");
        
        /* Greedy */
        Maze maze_5_greedy = new Maze("goodForAStar");
        Greedy maze_5_greedySolution = new Greedy(maze_5_greedy);
 
        System.out.println("Special Maze: Should be BAD for Greedy Search");
        System.out.print(maze_5_greedy);
        System.out.println("Nodes Expanded = " + maze_5_greedySolution.nodesExpanded);
        System.out.println("Solution Distance = " + maze_5_greedySolution.solutionDistance);
        System.out.println();
        
        /* A-star */
        Maze maze_5_astar = new Maze("goodForAStar");
        Astar maze_5_astarSolution = new Astar(maze_5_astar);
 
        System.out.println("Special Maze: Should be GOOD for Astar Search");
        System.out.print(maze_5_astar);
        System.out.println("Nodes Expanded = " + maze_5_astarSolution.nodesExpanded);
        System.out.println("Solution Distance = " + maze_5_astarSolution.solutionDistance);
        System.out.println();
        
        /* Greedy */
        Maze maze_6_greedy = new Maze("goodForGreedy");
        Greedy maze_6_greedySolution = new Greedy(maze_6_greedy);
 
        System.out.println("Special Maze: Should be GOOD for Greedy Search");
        System.out.print(maze_6_greedy);
        System.out.println("Nodes Expanded = " + maze_6_greedySolution.nodesExpanded);
        System.out.println("Solution Distance = " + maze_6_greedySolution.solutionDistance);
        System.out.println();
        
        /* A-star */
        Maze maze_6_astar = new Maze("goodForGreedy");
        Astar maze_6_astarSolution = new Astar(maze_6_astar);
 
        System.out.println("Special Maze: Should be BAD for Astar Search");
        System.out.print(maze_6_astar);
        System.out.println("Nodes Expanded = " + maze_6_astarSolution.nodesExpanded);
        System.out.println("Solution Distance = " + maze_6_astarSolution.solutionDistance);
        System.out.println();
        
        /*******/
        /* 1.3 */
        /*******/
        System.out.println("----------------------");
        System.out.println("Tests for Section 1.3");
        System.out.println("----------------------");
        
        /* smallSearch.txt */
        Maze maze7 = new Maze("smallSearch");
        AstarPacman solution7 = new AstarPacman(maze7);
        
        System.out.print(maze7);
        System.out.println("Nodes Expanded = " + solution7.nodesExpanded);
        System.out.println("Solution Distance = " + solution7.solutionDistance);
        System.out.println();
        
        /* trickySearch.txt */
        Maze maze8 = new Maze("trickySearch");
        AstarPacman solution8 = new AstarPacman(maze8);
        
        System.out.print(maze8);
        System.out.println("Nodes Expanded = " + solution8.nodesExpanded);
        System.out.println("Solution Distance = " + solution8.solutionDistance);
        System.out.println();
        
        /* mediumSearch.txt */
        Maze maze9 = new Maze("mediumSearch");
        AstarPacman solution9 = new AstarPacman(maze8);
        
        System.out.print(maze9);
        System.out.println("Nodes Expanded = " + solution9.nodesExpanded);
        System.out.println("Solution Distance = " + solution9.solutionDistance);
        System.out.println();
        
        
        /* bigSearch.txt */
	}	
}
