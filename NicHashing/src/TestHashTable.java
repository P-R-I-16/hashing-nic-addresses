/**
* This the starting execution point which calls the main function to calculate the most balanced hashtable
*
* @author  Hashed
* @version 1.0
* @since   2022-05-05 
*/
import java.util.HashMap;
import java.util.Map;

public class TestHashTable {

	public static void main(String[] args) {
		int i1 = Util.hashfct1("123456");
		System.out.println("hash function 1 on item 123456 returns:: " + i1);
		int i2 = Util.hashfct2("123456");
		System.out.println("hash function 2 on item 123456 returns:: " + i2);
		int i3 = Util.hashfct3("123456");
		System.out.println("hash function 3 on item 123456 returns:: " + i3);
		int i4 = Util.hashfct4("123456");
		System.out.println("hash function 4 on item 123456 returns:: " + i4);
		int i5 = Util.hashfct5("123456");
		System.out.println("hash function 5 on item 123456 returns:: " + i5);
		int i6 = Util.hashfct6("123456");
		System.out.println("hash function 6 on item 123456 returns:: " + i6);

		Map<String, String> nicMap = new HashMap<String, String>();
		Util.addItem(nicMap, "123456", "Velocity sensor");
		Util.addItem(nicMap, "234567", "Particle sensor");
		System.out.println(
				"New network. Size is 2 after adding two NICs: Velocity sensor 123456 and Particle sensor 234567"
						+ nicMap.size());
		Map<String, String> nicMap1 = Util.readFile("in1.txt");
		System.out.println("Size is 30 after reading in1.txt " + nicMap1.size());
		System.out.println("***********calling best hashing for in1.txt********");
		int balancedhashtable1 = BestHashing.bestHashing(nicMap1);
		System.out.println("BestHashing() for the file in1.txt returns::" + balancedhashtable1);

		Map<String, String> nicMap2 = Util.readFile("in2.txt");
		System.out.println("***********calling best hashing for in2.txt********");
		int balancedhashtable2 = BestHashing.bestHashing(nicMap2);
		System.out.println("BestHashing() for the file in2.txt returns:: " + balancedhashtable2);
		Util.removeItem(nicMap2, "Euro-XP-Puck-Rotary-Position-Sensor", "110987");
		Util.removeItem(nicMap2, "Flow-sensor", "210FED");
		System.out.println("New network then read in2.txt. Then remove two NICs: 110987 and 210FED. Size becomes "
				+ nicMap2.size());
		int balancedhashtable3 = BestHashing.bestHashing(nicMap2);
		System.out.println("BestHashing() for the changed network returns:: " + balancedhashtable3);
	}

}
