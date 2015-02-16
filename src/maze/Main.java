package maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void main(String [] args) throws FileNotFoundException, IOException{
		
		//Print Small Maze
		Maze m = new Maze("smallMaze");
		System.out.print(m);
		
		//Print Small Maze
		Maze m2 = new Maze("mediumMaze");
		System.out.print(m2);
		
		
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
