package dz.wta.ooredoo.simswap.validator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ReasonValidator implements ConstraintValidator<Reason, String> {

	List<String> reasons = Arrays.asList("SWAP", "REJET", "CHANGEMENT");

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		return reasons.contains(value);
	}

}
