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
        Maze maze11 = new Maze("smallMaze");
        Maze maze12 = new Maze("mediumMaze");
        Maze maze13 = new Maze("bigMaze");
        
        
        BFS solution = new BFS(maze1);
        DFS solution2 = new DFS(maze2);
        Greedy solution3 = new Greedy(maze3);
        Astar solution4 = new Astar(maze4);
        DFS solution11 = new DFS(maze11);
        DFS solution12 = new DFS(maze12);
        DFS solution13 = new DFS(maze13);
        
		/* Print Mazes */
        System.out.println("Small Maze");
        System.out.println(maze11);
        System.out.println("Nodes Expanded = " + solution11.nodesExpanded);
        System.out.println("Path Cost = " + solution11.solutionDistance);
        System.out.println("Medium Maze");
        System.out.println(maze12);
        System.out.println("Nodes Expanded = " + solution12.nodesExpanded);
        System.out.println("Path Cost = " + solution12.solutionDistance);
        System.out.println("Big Maze");
        System.out.println(maze13);
        System.out.println("Nodes Expanded = " + solution13.nodesExpanded);
        System.out.println("Path Cost = " + solution13.solutionDistance);
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

///////////////////////////// now for medium mazes
        
		/* Create Mazes */
		Maze maze1medium = new Maze("mediumMaze");
		Maze maze2medium = new Maze("mediumMaze");
		Maze maze3medium = new Maze("mediumMaze");
        Maze maze4medium = new Maze("mediumMaze");
        
        BFS solution1medium = new BFS(maze1medium);
        DFS solution2medium = new DFS(maze2medium);
        Greedy solution3medium = new Greedy(maze3medium);
        Astar solution4medium = new Astar(maze4medium);
	
		/* Print Mazes */
        System.out.println("Breadth First Search");
		System.out.println(maze1medium);
        System.out.println("Depth First Search");
        System.out.println(maze2medium);
        System.out.println("Greedy Best First Search");
		System.out.println(maze3medium);
        System.out.println("A* Search");
        System.out.println(maze4medium);
				
		System.out.println("BFS Nodes Expanded = " + solution1medium.nodesExpanded);
        System.out.println("DFS Nodes Expanded = " + solution2medium.nodesExpanded);
        System.out.println("Greedy Best-First Nodes Expanded = " + solution3medium.nodesExpanded);
        System.out.println("A* Nodes Expanded = " + solution4medium.nodesExpanded);
        System.out.println();
        System.out.println("BFS Solution Distance = " + solution1medium.solutionDistance);
        System.out.println("DFS Solution Distance = " + solution2medium.solutionDistance);
        System.out.println("Greedy Best-First Solution Distance = " + solution3medium.solutionDistance);
        System.out.println("A* Solution Distance = " + solution4medium.solutionDistance);
        System.out.println();

   
///////////////////////////// now for big mazes
        
        /* Create Mazes */
        Maze maze1big = new Maze("bigMaze");
        Maze maze2big = new Maze("bigMaze");
        Maze maze3big = new Maze("bigMaze");
        Maze maze4big = new Maze("bigMaze");

        BFS solution1big = new BFS(maze1big);
        DFS solution2big = new DFS(maze2big);
        Greedy solution3big = new Greedy(maze3big);
        Astar solution4big = new Astar(maze4big);

        /* Print Mazes */
        System.out.println("Breadth First Search");
        System.out.println(maze1big);
        System.out.println("Depth First Search");
        System.out.println(maze2big);
        System.out.println("Greedy Best First Search");
        System.out.println(maze3big);
        System.out.println("A* Search");
        System.out.println(maze4big);

        System.out.println("BFS Nodes Expanded = " + solution1big.nodesExpanded);
        System.out.println("DFS Nodes Expanded = " + solution2big.nodesExpanded);
		System.out.println("Greedy Best-First Nodes Expanded = " + solution3big.nodesExpanded);
		System.out.println("A* Nodes Expanded = " + solution4big.nodesExpanded);
		System.out.println();
		System.out.println("BFS Solution Distance = " + solution1big.solutionDistance);
		System.out.println("DFS Solution Distance = " + solution2big.solutionDistance);
		System.out.println("Greedy Best-First Solution Distance = " + solution3big.solutionDistance);
		System.out.println("A* Solution Distance = " + solution4big.solutionDistance);
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
        AstarPacman solution9 = new AstarPacman(maze9);
        
        System.out.print(maze9);
        System.out.println("Nodes Expanded = " + solution9.nodesExpanded);
        System.out.println("Solution Distance = " + solution9.solutionDistance);
        System.out.println();
        
        /* bigSearch.txt */
        Maze maze10 = new Maze("bigSearch");
        AstarPacman solution10 = new AstarPacman(maze10);
        
        System.out.print(maze10);
        System.out.println("Nodes Expanded = " + solution10.nodesExpanded);
        System.out.println("Solution Distance = " + solution10.solutionDistance);
        System.out.println();
	}	
}
