package maze;
//only exception needed, covers a broad range
import java.io.IOException;

public class Main {
	
	public static void main(String [] args) throws IOException{
		
		/* Create Mazes */
		Maze maze1 = new Maze("smallMaze");
		Maze maze2 = new Maze("smallMaze");
		Maze maze3 = new Maze("smallMaze");
        Maze maze4 = new Maze("smallMaze");
		

		//BFS solution = new BFS(maze1);
        BFS solution = new BFS(maze1);
        DFS solution2 = new DFS(maze2);
        Greedy solution3 = new Greedy(maze3);
        Astar solution4 = new Astar(maze4);
        //Greedy solution2 = new Greedy(maze2);
        //Greedy solution3 = new Greedy(maze3);

        //BFS solution = new BFS(maze1);
		//System.out.println(solution.solutionDistance);
		
		/* Print Mazes */
        System.out.println("Breadth First Search");
		System.out.print(maze1);
        System.out.println("Depth First Search");
        System.out.print(maze2);
        System.out.println("Greedy Best First Search");
		System.out.print(maze3);
        System.out.println("A* Search");
        System.out.print(maze4);
				
		System.out.println("BFS Nodes Expanded = " + solution.nodesExpanded);
        System.out.println("DFS Nodes Expanded = " + solution2.nodesExpanded);
        System.out.println("Greedy Best-First Nodes Expanded = " + solution3.nodesExpanded);
        System.out.println("A* Nodes Expanded = " + solution4.nodesExpanded);
        System.out.println();
        System.out.println("BFS Solution Distance = " + solution.solutionDistance);
        System.out.println("DFS Solution Distance = " + solution2.solutionDistance);
        System.out.println("Greedy Best-First Solution Distance = " + solution3.solutionDistance);
        System.out.println("A* Solution Distance = " + solution4.solutionDistance);

//		//Print Small Maze
//		for(int j = 0; j < m.rows; j++){
//			for(int i = 0; i < m.columns; i++){
//				System.out.print(m.grid[i][j]);
//			}
//			System.out.println("");
//		}
//		
//		
//		Maze m2 = new Maze("mediumMaze");
//		
//		
//		//Print Medium Maze
//		for(int j = 0; j < m2.rows; j++){
//			for(int i = 0; i < m2.columns; i++){
//				System.out.print(m2.grid[i][j]);
//			}
//			System.out.println("");
//		}
		
//		String everything = "hi";
//		
//		File file = new File("smallMaze.txt");
//		if ( file.exists() )
//		    System.out.println( "Exists" );
//
//		BufferedReader br = new BufferedReader(new FileReader("smallMaze.txt"));
//	    try {
//	        StringBuilder sb = new StringBuilder();
//	        String line = br.readLine();
//	
//	        while (line != null) {
//	            sb.append(line);
//	            sb.append(System.lineSeparator());
//	            line = br.readLine();
//	        }
//	        everything = sb.toString();
//	    } finally {
//	        br.close();
//	    }
//	    
//	    
//	   System.out.println(everything);
	    
	}
	
	
}
