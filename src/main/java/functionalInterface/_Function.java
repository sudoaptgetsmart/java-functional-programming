package functionalInterface;

import java.util.function.Function;

public class _Function {
	public static void main(String[] args) {
		int increment = incrementByOne(1);
		System.out.println(increment);

		int increment2 = incrementByOneFunction.apply(1);
		System.out.println(increment2);

	}

	// First Integer corresponds to input type and second Integer corresponds to return type.
	static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

	// Same as above.
	static int incrementByOne(int number) {
		return number + 1;
	}
}
