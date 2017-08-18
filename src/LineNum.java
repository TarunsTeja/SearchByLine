import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LineNum {
	static Scanner sc = new Scanner(System.in);
	static String a ="";
	static String b ="";
    public static void main(String[] args) {
    	b = sc.nextLine();
        try {
            for (String line : searchWord(b)) {
                System.out.println(line);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public static List<String> searchWord(String key) throws Exception {
    	System.out.println("Enter the File path :");
    	System.out.println("Example:<D:/redis-unstable/src/modules/hellotype.c>");
    	a = sc.nextLine();
    	FileReader fr = new FileReader(new File(a));
        LineNumberReader lnr = new LineNumberReader(fr);

        return recursiveSearch(lnr.readLine(), key, lnr);
    }

    public static List recursiveSearch(String currentLineText, String key, LineNumberReader lnr)
                    throws Exception {

        List<String> results = new ArrayList<String>(25);
        if (currentLineText != null) {
            String lCase = currentLineText.toLowerCase();
            int a = currentLineText.indexOf(key);
            int b = key.length();
            a = a+b;
            if (lCase.contains(key.toLowerCase()) && currentLineText.charAt(a)== '(') {
            	
                results.add("Line " + lnr.getLineNumber() + ": Function");
            }
           
            else if(lCase.contains(key.toLowerCase())) {
            	results.add("Line " + lnr.getLineNumber() + " Parameter");
            }
            results.addAll(recursiveSearch(lnr.readLine(), key, lnr));
        }
        return results;
    }

}