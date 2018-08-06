package GET2018.DSA.DSSession2.Tree;

import java.util.List;

/**
 * This class implements methods in NestedList Interface
 * 
 * @author Mohit Sharma
 *
 */
public class ListOfIntegers implements NestedList {
	static int sumOfAllIntegers = 0;
	static int largestNumber;
	static int counterInteger = 0;
	static boolean searchElement = false;
	static int integerAtPosition;

	public ListOfIntegers() {
		nestedList.clear();
	}

	@Override
	public boolean addList(Object obj) {
		if (obj == null) {
			throw new NullPointerException("List to be Add Can't be Empty");
		}
		nestedList.add(obj);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object addAllIntegers(List<Object> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof Integer) {
				sumOfAllIntegers += (Integer) list.get(i);
			} else if (list.get(i) instanceof List) {
				addAllIntegers((List<Object>) list.get(i));
			}
		}
		return sumOfAllIntegers;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object largestInteger(List<Object> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof Integer) {
				counterInteger++;
				if (counterInteger == 1) {
					largestNumber = (Integer) list.get(i);
				} else if (largestNumber < (Integer) list.get(i)) {
					largestNumber = (Integer) list.get(i);
				}
			} else if (list.get(i) instanceof List) {
				largestInteger((List<Object>) list.get(i));
			}
		}
		return largestNumber;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean searchList(List<Object> list, int elementToSearch) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof Integer) {
				if (((Integer) list.get(i)).equals(elementToSearch)) {
					searchElement = true;
				}
			} else if (list.get(i) instanceof List) {
				searchList((List<Object>) list.get(i), elementToSearch);
			}
		}
		return searchElement;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getValue(List<Object> list, String position) throws NestedListException {
		if (position.charAt(0) == 'T' && position.length() == 1) {
			throw new NestedListException("List found at Tail");
		} else if (position.charAt(0) == 'H' && position.length() == 1) {
			if (list.get(0) instanceof List) {
				throw new NestedListException("List found at Head");
			} else {
				integerAtPosition = (Integer) list.get(0);
			}
		} else if (position.charAt(0) == 'T') {
			list.remove(0);
			getValue((List<Object>) list, position.substring(1, position.length()));
		} else if (position.charAt(0) == 'H') {
			getValue((List<Object>) list.get(0), position.substring(1, position.length()));
		}
		return integerAtPosition;
	}
}
