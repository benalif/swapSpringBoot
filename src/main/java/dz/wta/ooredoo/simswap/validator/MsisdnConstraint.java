package dz.wta.ooredoo.simswap.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = MsisdnValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MsisdnConstraint {

	String message() default "Invalid msisdn";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
