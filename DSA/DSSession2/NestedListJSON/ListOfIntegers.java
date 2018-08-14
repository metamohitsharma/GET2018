package GET2018.DSA.DSSession2.NestedListJSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
	public boolean addList(String fileName) throws ParseException, IOException {
		if (fileName == null) {
			throw new NullPointerException("FileName Can't be Empty");
		}
		try {
			JSONObject rootJSON = (JSONObject) new JSONParser()
					.parse(new FileReader(fileName));
			JSONArray dataList = (JSONArray) rootJSON.get("Integers");
			for (int i = 0; i < dataList.size(); i++) {
				JSONArray intArray = (JSONArray) dataList.get(i);
				LinkedList<Integer> integerList = new LinkedList<>();
				for (int j = 0; j < intArray.size(); j++) {
					integerList.add(Integer
							.parseInt(intArray.get(j).toString()));
				}
				nestedList.add(integerList);
			}
			return true;
		} catch (FileNotFoundException ex) {
			throw new FileNotFoundException("File not Found in addList");
		}
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
