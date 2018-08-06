package GET2018.DSA.DSSession2.NestedListJSON;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

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
	public boolean addList(String fileName) throws FileNotFoundException {
		if (fileName == null) {
			throw new NullPointerException("FileName Can't be Empty");
		}
		try {
			LinkedList<Integer> integerList = new LinkedList<>();
			File jsonInputFile = new File(fileName);
			InputStream input = new FileInputStream(jsonInputFile);
			JsonReader reader = Json.createReader(input);
			JsonObject jsonObj = reader.readObject();
			reader.close();
			JsonArray jsonArray = jsonObj.getJsonArray("Integers");
			for (JsonValue value : jsonArray) {
				integerList.add(Integer.parseInt(value.toString()));
			}
			nestedList.add(integerList);
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
