package combinatorPattern;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		Customer customer = new Customer(
				"Alice",
				"alice@gmail.com",
				"+076979793",
				LocalDate.of(2000, 1, 1)
		);

		System.out.println(new CustomerValidatorService().isValid(customer));
	}
}
