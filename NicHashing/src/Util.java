
/**
* @author  Hashed
* @version 1.0
* @since   2022-05-05 
*/
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//utility class
public class Util {

	// returns first digit of nic
	public static int hashfct1(String nic) {
		char[] charArray = nic.toCharArray();
		return convertChartoDigit(charArray[0]);

	}

	// returns second digit of nic
	public static int hashfct2(String nic) {
		char[] charArray = nic.toCharArray();
		return convertChartoDigit(charArray[1]);

	}

	// returns third digit of nic
	public static int hashfct3(String nic) {
		char[] charArray = nic.toCharArray();
		return convertChartoDigit(charArray[2]);

	}

	// returns fourth digit of nic
	public static int hashfct4(String nic) {
		char[] charArray = nic.toCharArray();
		return convertChartoDigit(charArray[3]);

	}

	// returns fifth digit of nic
	public static int hashfct5(String nic) {
		char[] charArray = nic.toCharArray();
		return convertChartoDigit(charArray[4]);

	}

	// returns sixth digit of nic
	public static int hashfct6(String nic) {
		char[] charArray = nic.toCharArray();
		return convertChartoDigit(charArray[5]);

	}

	// converting char to digit function
	public static int convertChartoDigit(char i) {
		switch (i) {
		case 'A':
			return 10;
		case 'B':
			return 11;
		case 'C':
			return 12;
		case 'D':
			return 13;
		case 'E':
			return 14;
		case 'F':
			return 15;
		default:
			return Character.getNumericValue(i);
		}
	}

	// read file and create maps of the values stored inside the file
	public static Map<String, String> readFile(String textFile) {
		Map<String, String> nicItemMap = new HashMap<String, String>();

		InputStream stream = Util.class.getResourceAsStream("/" + textFile);
		InputStreamReader strrd = new InputStreamReader(stream);
		Scanner myReader = new Scanner(stream);
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			String[] columns = data.split(" ");

			nicItemMap.put(columns[0], columns[1]);
		}
		myReader.close();
		return nicItemMap;
	}

	// getting min bucket size
	public static int getMinBucketSize(Set<Integer> keySet) {
		int minBucketSize = 1;
		for (int i = 0; i < 15; i++) {
			if (!keySet.contains(i)) {
				minBucketSize = 0;
				break;
			}
		}
		return minBucketSize;
	}

	// adding new nic
	public static Map<String, String> addItem(Map<String, String> nicMap, String nicKey, String Value) {
		nicMap.put(nicKey, Value);
		return nicMap;
	}

	// removing new nic
	public static Map<String, String> removeItem(Map<String, String> nicMap2, String nicKey, String Value) {
		nicMap2.remove(nicKey, Value);
		return nicMap2;
	}

}
