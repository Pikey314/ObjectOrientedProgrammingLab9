package prKWIC;

public class KwicStatement implements Comparable {
	
	protected String statement;
	
	public KwicStatement(String statement) {
		this.statement = statement;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof KwicStatement) {
			if (this.statement.toLowerCase().equals(((KwicStatement) o).statement.toLowerCase()))
				return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.statement.hashCode();
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof KwicStatement) {
			if (this.statement.toLowerCase().compareTo(((KwicStatement)o).statement.toLowerCase()) > 0)
				return 1;
			else if (this.statement.equals(((KwicStatement)o).statement))
				return 0;
			else
				return -1;
		}
		else
			throw new RuntimeException("Wrong object");
	}
	
	@Override
	public String toString() {
		return this.statement;
	}





}


