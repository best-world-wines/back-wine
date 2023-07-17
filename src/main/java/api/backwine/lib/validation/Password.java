package api.backwine.lib.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String message() default "Password must contain at least one digit, "
            + "one special character, one lowercase and uppercase letter, "
            + "and the length should be between 8 and 60 characters.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
