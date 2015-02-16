package maze;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	
	public static void main(String [] args) throws FileNotFoundException, IOException{
		
		/* Create Mazes */
		Maze maze1 = new Maze("smallMaze");
		Maze maze2 = new Maze("mediumMaze");
		Maze maze3 = new Maze("bigMaze");
		

		BFS solution = new BFS(maze1);
		//System.out.println(solution.solutionDistance);
		
		/* Print Mazes */
		System.out.print(maze1);
		// System.out.print(maze2);
		// System.out.print(maze3);
				
		System.out.println(solution.nodesExpanded);
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
