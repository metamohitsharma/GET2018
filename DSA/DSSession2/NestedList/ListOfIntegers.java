package GET2018.DSA.DSSession2.NestedList;

import java.util.ArrayList;

/**
 * This class implements methods in NestedList Interface
 * 
 * @author Mohit Sharma
 *
 */
public class ListOfIntegers implements NestedList {

	public ListOfIntegers() {
		nestedList.clear();
	}

	@Override
	public boolean addList(ArrayList<Integer> addList) {
		if (addList == null) {
			throw new NullPointerException("List to be Add Can't be Empty");
		}
		nestedList.add(addList);
		return true;
	}

	@Override
	public int addAllIntegers() {
		int sumOfAllIntegers = 0;
		for (int i = 0; i < nestedList.size(); i++) {
			for (int j = 0; j < nestedList.get(i).size(); j++) {
				sumOfAllIntegers += nestedList.get(i).get(j);
			}
		}
		return sumOfAllIntegers;
	}

	@Override
	public int largestInteger() {
		int largestNumber = nestedList.get(0).get(0);
		for (int i = 0; i < nestedList.size(); i++) {
			for (int j = 0; j < nestedList.get(i).size(); j++) {
				if (largestNumber < nestedList.get(i).get(j)) {
					largestNumber = nestedList.get(i).get(j);
				}
			}
		}
		return largestNumber;
	}

	@Override
	public boolean searchList(int elementToSearch) {
		for (int i = 0; i < nestedList.size(); i++) {
			for (int j = 0; j < nestedList.get(i).size(); j++) {
				if (elementToSearch == nestedList.get(i).get(j)) {
					return true;
				}
			}
		}
		return false;
	}

}
