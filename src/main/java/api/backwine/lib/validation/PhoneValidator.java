package api.backwine.lib.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
    private static final String PHONE_PATTERN = "^[+]+[0-9]+$";

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        return phone != null && pattern.matcher(phone).matches();
    }
}
