package beans;

import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//custom validation logic for class IsValidDate
public class DateValidator implements ConstraintValidator <IsValidDate, Date > {

	@Override
	public void initialize(IsValidDate isValidDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Date data, ConstraintValidatorContext ctx) {
		
		//convert Date data to String
		String dateString=data.toString();
		
		//format dd/MM/yyyy
		String regex="(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
		
		
		if (dateString.matches(regex)){
			return true;
		}
		
		//if date doesn't match regex, return error message from IsValidDate
		else {
			return false;
		}
	}

}
