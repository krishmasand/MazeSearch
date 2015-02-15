package maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void main(String [] args) throws FileNotFoundException, IOException{
		
		String everything = "hi";
		
		File file = new File("smallMaze.txt");
		if ( file.exists() )
		    System.out.println( "Exists" );

		BufferedReader br = new BufferedReader(new FileReader("smallMaze.txt"));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	
	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	        everything = sb.toString();
	    } finally {
	        br.close();
	    }
	    
	    
	   System.out.println(everything);
	    
	}
	
}
