package prKWIC;

import java.util.Scanner;

public class KwicStatementReplace extends KwicStatement {

   public KwicStatementReplace(String s, String w){
       super(s);
       this.statement = replace(s,w);
   }



    private static String replace(String statement, String word){
        Scanner sc = new Scanner(statement);
        String stringToReturn = "";
        sc.useDelimiter(" ");
        while(sc.hasNext()){
            String newWord = sc.next();
            if(newWord.toLowerCase().equals(word.toLowerCase())){
                stringToReturn += " ... ";
            }
            else
                stringToReturn = stringToReturn + " " + newWord;
        }
        return stringToReturn;
    }
}
