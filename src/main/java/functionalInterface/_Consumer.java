package functionalInterface;

import java.util.function.Consumer;

// Consumer: Accepts a single input argument and returns no result.
public class _Consumer {

	public static void main(String[] args) {
		// Normal Java
		Customer maria = new Customer("Maria", "999999");
		greetCustomer(maria);

		// Consumer Functional interface
		greetCustomerConsumer.accept(maria);
	}

	static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println(
			"Hello, " + customer.customerName +
					"thanks for registering phone number " + customer.customerPhoneNumber);

	static void greetCustomer(Customer customer) {
		System.out.println(
				"Hello, " + customer.customerName +
						"thanks for registering phone number " + customer.customerPhoneNumber);
	}


	static class Customer {
		private final String customerName;
		private final String customerPhoneNumber;

		public Customer(String customerName, String customerPhoneNumber) {
			this.customerName = customerName;
			this.customerPhoneNumber = customerPhoneNumber;
		}
	}
}
