import prKWIC.KwicStatement;
import prKWIC.KwicStatementReplace;

public class KwicStatementTest {

	public static void main(String[] args) {
		
		String[] movies = {
				"Dog Day Afternoon",
				"One Flew Over the Cuckoo's Nest",
				"Network",
				"Rocky",
				"Star Wars A new Hope",
				"Star Wars The Empire Strikes Back",
				"Star Wars Return of the Jedi",
				"Coming Home",
				"Kramer vs Kramer",
				"Raging Bull",
				"Atlantic City",
				"ET the Extra-Terrestrial"};

		KwicStatement lowest = new KwicStatementReplace(movies[0], "City");
		for (String movie : movies) {
			KwicStatement current = new KwicStatementReplace(movie,"City");
			if (lowest.compareTo(current)>0)
				lowest = current;
			
		}
		System.out.println("Lowest Item = " + lowest.toString());
		
		KwicStatement highest = new KwicStatement(movies[0]);
		for (String movie : movies) {
			KwicStatement current = new KwicStatement(movie);
			if (highest.compareTo(current)<0)
				highest = current;
			
		}
		System.out.println("Highest item = " + highest.toString());
	}

}
