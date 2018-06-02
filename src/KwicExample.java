import java.io.*;
import prKWIC.*;

public class KwicExample 
{
	public static void main(String[] args) 
	{
		try {
			Kwic k = new Kwic();
			k.noSignificantWords("noSignificant.txt");
			k.createIndex("statements.txt");
			
			System.out.println("Basic index, no replacing words ...");
			System.out.println("-----------------------------------");
			PrintWriter pw = new PrintWriter(System.out, true);
			k.printIndex(pw);
			
			k.printIndex("output.txt");
			
			KWICReplacement krep = new KWICReplacement();
			krep.noSignificantWords("noSignificant.txt");
			krep.createIndex("statements.txt");

			System.out.println("\n\nExtended index, with word replacement");
			System.out.println("------------------------------------------");			
			krep.printIndex(pw);
					
			krep.printIndex("replacement-output.txt");
	
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
