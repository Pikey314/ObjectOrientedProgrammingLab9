package prKWIC;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class KWICReplacement extends Kwic {

    protected void add(String statement) {
        Scanner sc = new Scanner(statement);

        while (sc.hasNext()) {

            String word = sc.next();
            KwicStatement kwicStatement = new KwicStatementReplace(statement,word);
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
}
