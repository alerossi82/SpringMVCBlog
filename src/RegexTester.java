import java.util.regex.Pattern;
import beans.Articolo;


public class RegexTester {
	
	public static void main(String[] args) {
		
		String regex = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
		String test = "14/03/1982";
		boolean testResult=Pattern.compile(regex).matcher(test).find();
		
		System.out.println(testResult);

	}

}
