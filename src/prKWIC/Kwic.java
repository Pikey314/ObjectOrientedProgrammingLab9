package prKWIC;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Kwic {

	protected SortedMap<String, SortedSet<KwicStatement>> index;
	protected List<String> noSignificant;
	
	
	public Kwic() {
		this.index = new TreeMap<String, SortedSet<KwicStatement>>();
		this.noSignificant = new ArrayList<String>();
	}
	
	public void noSignificantWords(String fileName) throws FileNotFoundException{
		File file = new File(fileName);
		Scanner sc = new Scanner(file);
		noSignificantWords(sc);
		sc.close();

	}
	
	private void noSignificantWords(Scanner sc) {
		while(sc.hasNext()) {
			this.noSignificant.add(sc.next().toLowerCase());
		}
	}
	
	public void createIndex(String filename) throws FileNotFoundException {
		File file = new File(filename);
		Scanner sc = new Scanner(file);
		createIndex(sc);
		sc.close();
		
	}
	
	private void createIndex(Scanner sc) {
		while(sc.hasNextLine())
			add(sc.nextLine());
	}

	protected void add(String statement) {
		Scanner sc = new Scanner(statement);
		KwicStatement kwicStatement = new KwicStatement(statement);
		while (sc.hasNext()) {

			String word = sc.next();

			if(!this.noSignificant.contains(word.toLowerCase())) {
				if (!this.index.isEmpty()) {
					if (this.index.containsKey(word.toLowerCase())) {
						SortedSet<KwicStatement> newValue = this.index.get(word);
						if (newValue != null)
						if (!newValue.contains(kwicStatement)) {
							newValue.add(kwicStatement);
							this.index.put(word.toLowerCase(), newValue);
							}

					}
					else {
						SortedSet<KwicStatement> newValue = new TreeSet<KwicStatement>();
						newValue.add(kwicStatement);
						this.index.put(word.toLowerCase(),newValue);

					}


				} else {

					SortedSet<KwicStatement> newValue = new TreeSet<KwicStatement>();
					newValue.add(kwicStatement);
					this.index.put(word.toLowerCase(), newValue);
				}
			}
			}
		sc.close();
		}
	
	public void printIndex(String filename) throws IOException {
		Writer output;
		output = new BufferedWriter(new FileWriter(filename));
		for(Map.Entry<String,SortedSet<KwicStatement>> entry : this.index.entrySet()) {
			output.append(entry.getKey().toUpperCase());
			for (KwicStatement ks : entry.getValue())
				output.append(ks.toString());
		}
	}


	public void printIndex(PrintWriter pw){
		for(Map.Entry<String,SortedSet<KwicStatement>> entry : this.index.entrySet()) {
			pw.println(entry.getKey().toUpperCase());
			for (KwicStatement ks : entry.getValue())
				pw.println(ks.toString());
		}

	}
}


