package combinatorPattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static combinatorPattern.CustomerRegistrationValidator.ValidationResult.*;

public interface CustomerRegistrationValidator
		extends Function<Customer, CustomerRegistrationValidator.ValidationResult> {

	// Combinator pattern allows us to chain all these functions together.

	static CustomerRegistrationValidator isEmailValid() {
		return customer -> customer.getEmail().contains("@") ? ValidationResult.SUCCESS : EMAIL_NOT_VALID;
	}

	static CustomerRegistrationValidator isPhoneNumberValid() {
		return customer -> customer.getPhoneNumber().startsWith("+0") ? ValidationResult.SUCCESS :
				PHONE_NUMBER_NOT_VALID;
	}

	static CustomerRegistrationValidator isAnAdult() {
		return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ? SUCCESS :
				IS_NOT_AN_ADULT;
	}

	default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
		return customer -> {
			ValidationResult result = this.apply(customer);
			return result.equals(SUCCESS) ? other.apply(customer) : result;
		};
	}

	enum ValidationResult {
		SUCCESS, PHONE_NUMBER_NOT_VALID, EMAIL_NOT_VALID, IS_NOT_AN_ADULT
	}
}
