package dz.wta.ooredoo.simswap.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MsisdnValidator implements ConstraintValidator<MsisdnConstraint, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		return value != null && value.matches("^5[0-9]{8}$");
	}

}
