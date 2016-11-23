

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Constraint;
import javax.validation.Payload;

//custom validation class for Articolo.data

@Documented //mandatory
@Constraint (validatedBy= DateValidator.class) //this class contains the validation logic
@Retention (RetentionPolicy.RUNTIME) //mandatory
public @interface IsValidDate {
	
	//error message
	String message() default "Please insert date in format dd/mm/yyyy";
	
	Class <?>[] groups() default {}; //mandatory
	
	Class <? extends Payload> [] payload () default {}; //mandatory
}
