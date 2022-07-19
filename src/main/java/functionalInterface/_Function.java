package functionalInterface;

import java.util.function.Function;

public class _Function {
	public static void main(String[] args) {
		int increment = incrementByOne(1);
		System.out.println(increment);

		int increment2 = incrementByOneFunction.apply(1);
		System.out.println(increment2);

		int multiply = multiplyBy10Function.apply(increment2);
		System.out.println(multiply);


		// Combines the two functions
		Function<Integer, Integer> addBy1AndThenMultipleBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
		System.out.println(addBy1AndThenMultipleBy10.apply(1));

	}

	// First Integer corresponds to input type and second Integer corresponds to return type.
	static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

	static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

	// Same as above.
	static int incrementByOne(int number) {
		return number + 1;
	}
}
