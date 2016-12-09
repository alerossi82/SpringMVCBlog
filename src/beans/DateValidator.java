package beans;


import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//custom validation logic for class IsValidDate
public class DateValidator implements ConstraintValidator <IsValidDate, Date > {

	@Override
	public void initialize(IsValidDate isValidDate) {
		// TODO Auto-generated method stub
		System.out.println("Inizializzaione DateValidator completata");
		
	}

	@Override
	public boolean isValid(Date data, ConstraintValidatorContext ctx) {
		
		//convert Date to string using format dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		String dateString;
		
		try {
			dateString = dateFormat.format(data);
			System.out.println(dateString);
			
		} catch (Exception e) {
			System.out.println("failed to parse date");
			e.printStackTrace();
			return false;
		}
		
		
		String regex="(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
		
		//check if Date format is correct
		if (dateString.matches(regex)){
			System.out.println("Il formato della data e' ok");
			return true;
			
		}
		
		//if Date doesn't match regex, return error message from IsValidDate
		else {
			System.out.println("Il formato della data non e' corretto");
			return false;
		}
	}

}
