package GET2018.DSA.DSSession2.InfixToPostfix;

import java.util.ArrayList;
import java.util.List;

/**
 * This class describes the implementation of Stack using array.
 * 
 * @author Mohit Sharma
 *
 */
public class StackArray implements Stack {
	int topElement = -1;
	String stackArray[] = new String[5];

	@Override
	public boolean push(String newElement) throws StackArrayException {
		if (newElement == null) {
			throw new NullPointerException("Element to be Added Can't be Null");
		}
		if (topElement == STACK_SIZE) {
			throw new StackArrayException("Element can't be Add, Stack is Full");
		}
		topElement++;
		stackArray[topElement] = newElement;
		return true;
	}

	@Override
	public String pop() throws StackArrayException {
		String deletedItem;
		if (topElement == -1) {
			throw new StackArrayException("Stack Underflow");
		}
		deletedItem = stackArray[topElement];
		topElement--;
		return deletedItem;
	}

	@Override
	public boolean isEmpty() {
		return (topElement == -1 ? true : false);
	}

	@Override
	public String top() throws StackArrayException {
		if (topElement == -1) {
			throw new StackArrayException("Stack Underflow");
		} else {
			return stackArray[topElement];
		}
	}

	/**
	 * Converts Infix to Postfix
	 * 
	 * @param infix
	 * @return
	 * @throws StackArrayException
	 * @throws InfixToPostfixException
	 */
	public String infixToPostfix(String infix) throws StackArrayException {
		if (infix == null) {
			throw new NullPointerException("Infix Can't be Null");
		}
		List<String> tokens = tokenize(infix);
		String postfix = "";
		for (int i = 0, j = tokens.size(); i < j; i++) {
			String token = tokens.get(i);

			// Checking Every Token if it is Operator or Operand
			if (!isOperator(token)) {
				postfix += token;
			} else if ("(".equals(token)) {
				push(token);
			} else if (")".equals(token)) {

				// Checking for close bracket
				while (!isEmpty() && !"(".equals(top())) {
					postfix += pop();
				}

				if (!isEmpty() && "(".equals(top())) {
					pop();
				} else {
					throw new StackArrayException("Wrong Infix Expression");
				}

			} else {

				// <= is providing left to right associativity
				while (!isEmpty() && precedence(token) <= precedence(top())) {
					postfix += pop();
				}
				push(token);
			}
		}

		while (!isEmpty()) {
			postfix += pop();
		}

		return postfix;
	}

	/**
	 * List of String Tokens
	 * 
	 * @param infix
	 * @return
	 * 
	 */
	private List<String> tokenize(String infix) {
		List<String> word = new ArrayList<String>();
		String wordTaker = "";
		for (int i = 0, j = infix.length(); i < j; i++) {
			if ((char) infix.charAt(i) == ' ' || i == infix.length() - 1) {

				if (i == infix.length() - 1) {
					wordTaker = wordTaker + infix.charAt(infix.length() - 1);
					word.add(wordTaker);
				} else {
					word.add(wordTaker);
				}
				wordTaker = "";
			} else {
				wordTaker = wordTaker + infix.charAt(i);
			}
		}
		return word;
	}

	/**
	 * precedence Order of Operators
	 * 
	 * @param operator
	 * @return precedence value
	 */
	private int precedence(String operator) {
		int precedence = 0;
		switch (operator) {
		case "||":
			precedence = 1;
			break;

		case "&&":
			precedence = 2;
			break;

		case "==":
		case "!=":
			precedence = 3;
			break;

		case "<":
		case ">":
		case "<=":
		case ">=":
			precedence = 4;
			break;

		case "+":
		case "-":
			precedence = 5;
			break;

		case "*":
		case "/":
			precedence = 6;
			break;
		}
		return precedence;
	}

	/**
	 * Checks Operators is valid or not
	 * 
	 * @param operator
	 * @return
	 */
	private boolean isOperator(String operator) {
		switch (operator) {
		case "||":
		case "&&":
		case "==":
		case "!=":
		case "<":
		case ">":
		case "<=":
		case ">=":
		case "+":
		case "-":
		case "*":
		case "/":
		case "(":
		case ")":
			return true;
		}
		return false;
	}
}
