package functionalInterface;

import java.util.List;
import java.util.function.Supplier;

// Represents a supplier of results
public class _Supplier {
	static Supplier<List<String>> getDBConnectionUrlSupplier =
			() -> List.of("jbdc://localhost:5432/users", "jbdc://localhost:5432/users");

	public static void main(String[] args) {
		System.out.println(getDBConnectionUrl());
		System.out.println(getDBConnectionUrlSupplier.get());
	}

	static String getDBConnectionUrl() {
		return "jbdc://localhost:5432/users";
	}
}
