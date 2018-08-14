package GET2018.DSA.DSSession2.EvaluatePostfix;

import java.util.ArrayList;

/**
 * This class describes the implementation of Stack using array.
 * 
 * @author Mohit Sharma
 *
 */
public class StackArray implements Stack {
	int topElement = -1;
	int stackArray[] = new int[20];

	@Override
	public boolean push(int newElement) throws StackException {
		if (topElement == STACK_SIZE) {
			throw new StackException("Element can't be Add, Stack is Full");
		}
		topElement++;
		stackArray[topElement] = newElement;
		return true;
	}

	@Override
	public int pop() throws StackException {
		int deletedItem;
		if (topElement == -1) {
			throw new StackException("Stack Underflow");
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
	public int top() throws StackException {
		if (topElement == -1) {
			throw new StackException("Stack Underflow");
		} else {
			return stackArray[topElement];
		}
	}

	/**
	 * Evaluates Postfix Expression
	 * 
	 * @param postfix
	 * @return
	 * @throws StackException
	 */
	public int evaluatePostfix(String postfix) throws StackException {
		if (postfix == null) {
			throw new NullPointerException("Postfix Expression can't be Null");
		}

		StackArray stack = new StackArray();
		ArrayList<String> tokens = tokenize(postfix);
		try {
			for (int i = 0, j = tokens.size(); i < j; i++) {
				if ("+".equals(tokens.get(i)) || "-".equals(tokens.get(i)) || "*".equals(tokens.get(i))
						|| "/".equals(tokens.get(i))) {
					int secondOperand = stack.pop();
					int firstOperand = stack.pop();
					int result = evaluate(firstOperand, secondOperand, tokens.get(i));
					stack.push(result);
				} else {
					stack.push(Integer.parseInt(tokens.get(i)));
				}
			}
		} catch (NumberFormatException ex) {
			throw new NumberFormatException("Postfix Expression Wrong");
		}
		return stack.pop();
	}

	/**
	 * Splits input Postfix Expression to Tokens
	 * 
	 * @param postfix
	 * @return
	 */
	private ArrayList<String> tokenize(String postfix) {
		ArrayList<String> word = new ArrayList<String>();
		String wordTaker = "";
		for (int i = 0; i < postfix.length(); i++) {
			if ((char) postfix.charAt(i) == ' ' || i == postfix.length() - 1) {
				if (i == postfix.length() - 1) {
					wordTaker = wordTaker + postfix.charAt(postfix.length() - 1);
					word.add(wordTaker);
				} else {
					word.add(wordTaker);
				}
				wordTaker = "";
			} else {
				wordTaker = wordTaker + postfix.charAt(i);
			}
		}
		return word;
	}

	/**
	 * Evaluates two operands on the basis of Operation
	 * 
	 * @param firstOperand
	 * @param secondOperand
	 * @param operator
	 * @return
	 * @throws StackException
	 */
	private int evaluate(int firstOperand, int secondOperand, String operator) throws StackException {
		switch (operator) {
		case "+":
			return firstOperand + secondOperand;
		case "-":
			return firstOperand - secondOperand;
		case "*":
			return firstOperand * secondOperand;
		case "/":
			try {
				return firstOperand / secondOperand;
			} catch (Exception ex) {
				throw new NumberFormatException("/ by Zero Not Allowed");
			}
		default:
			throw new StackException("Postfix Expression Wrong");
		}
	}
}