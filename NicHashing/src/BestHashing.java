
/**
* @author  Hashed
* @version 1.0
* @since   2022-05-05 
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//This method calculates most balanced hashtable
public class BestHashing {

	public static int bestHashing(Map<String, String> nicMap) {
		// creating six hashtables1-6
		HashTable table1 = new HashTable(50);
		HashTable table2 = new HashTable(50);
		HashTable table3 = new HashTable(50);
		HashTable table4 = new HashTable(50);
		HashTable table5 = new HashTable(50);
		HashTable table6 = new HashTable(50);
		// creating bucket size maps for each hashtable
		HashMap<Integer, Integer> sizeMap1 = new HashMap();
		HashMap<Integer, Integer> sizeMap2 = new HashMap();
		HashMap<Integer, Integer> sizeMap3 = new HashMap();
		HashMap<Integer, Integer> sizeMap4 = new HashMap();
		HashMap<Integer, Integer> sizeMap5 = new HashMap();
		HashMap<Integer, Integer> sizeMap6 = new HashMap();
//adding values to hashtables1-6
		for (Map.Entry<String, String> entry : nicMap.entrySet()) {
			sizeMap1 = table1.put(entry.getValue(), entry.getValue(), 1, sizeMap1);
			sizeMap2 = table2.put(entry.getValue(), entry.getValue(), 2, sizeMap2);
			sizeMap3 = table3.put(entry.getValue(), entry.getValue(), 3, sizeMap3);
			sizeMap4 = table4.put(entry.getValue(), entry.getValue(), 4, sizeMap4);
			sizeMap5 = table5.put(entry.getValue(), entry.getValue(), 5, sizeMap5);
			sizeMap6 = table6.put(entry.getValue(), entry.getValue(), 6, sizeMap6);
		}
		// sorting bucket sizes for each hashtable
		List<Entry<Integer, Integer>> list1 = new ArrayList<>(sizeMap1.entrySet());
		list1.sort(Entry.comparingByValue());
		List<Entry<Integer, Integer>> list2 = new ArrayList<>(sizeMap2.entrySet());
		list2.sort(Entry.comparingByValue());
		List<Entry<Integer, Integer>> list3 = new ArrayList<>(sizeMap3.entrySet());
		list3.sort(Entry.comparingByValue());
		List<Entry<Integer, Integer>> list4 = new ArrayList<>(sizeMap4.entrySet());
		list4.sort(Entry.comparingByValue());
		List<Entry<Integer, Integer>> list5 = new ArrayList<>(sizeMap5.entrySet());
		list5.sort(Entry.comparingByValue());
		List<Entry<Integer, Integer>> list6 = new ArrayList<>(sizeMap6.entrySet());
		list6.sort(Entry.comparingByValue());

		// creating balancefactor maps hashtables1-6
		int balFactor1;
		HashMap<Integer, Integer> balanceFactorMap = new HashMap<Integer, Integer>();
		int minLoadFactor;
		// if none of the buckets in the hashtable is empty
		if (Util.getMinBucketSize(sizeMap1.keySet()) != 0) {
			balFactor1 = list1.get((list1.size() - 1)).getValue() - list1.get(0).getValue();

		}
		// if any one bucket in the hashtable is empty
		else {
			balFactor1 = list1.get((list1.size() - 1)).getValue() - 0;

		}
		minLoadFactor = balFactor1;
		balanceFactorMap.put(1, minLoadFactor);

		int balFactor2;
		if (Util.getMinBucketSize(sizeMap2.keySet()) != 0) {
			balFactor2 = list2.get((list2.size() - 1)).getValue() - list2.get(0).getValue();

		} else {
			balFactor2 = list2.get((list2.size() - 1)).getValue() - 0;

		}

		if (minLoadFactor > balFactor2) {
			balanceFactorMap.clear();
			minLoadFactor = balFactor2;
			balanceFactorMap.put(2, minLoadFactor);
		}

		int balFactor3;
		if (Util.getMinBucketSize(sizeMap3.keySet()) != 0) {
			balFactor3 = list3.get((list3.size() - 1)).getValue() - list3.get(0).getValue();

		} else {
			balFactor3 = list3.get((list3.size() - 1)).getValue() - 0;

		}
		if (minLoadFactor > balFactor3) {
			balanceFactorMap.clear();
			minLoadFactor = balFactor3;
			balanceFactorMap.put(3, minLoadFactor);
		}

		int balFactor4;
		if (Util.getMinBucketSize(sizeMap4.keySet()) != 0) {
			balFactor4 = list4.get((list4.size() - 1)).getValue() - list4.get(0).getValue();

		} else {
			balFactor4 = list4.get((list4.size() - 1)).getValue() - 0;

		}
		if (minLoadFactor > balFactor4) {
			balanceFactorMap.clear();
			minLoadFactor = balFactor4;
			balanceFactorMap.put(4, minLoadFactor);
		}

		int balFactor5;
		if (Util.getMinBucketSize(sizeMap5.keySet()) != 0) {
			balFactor5 = list5.get((list5.size() - 1)).getValue() - list5.get(0).getValue();

		} else {
			balFactor5 = list5.get((list5.size() - 1)).getValue() - 0;

		}

		if (minLoadFactor > balFactor5) {
			balanceFactorMap.clear();
			minLoadFactor = balFactor5;
			balanceFactorMap.put(5, minLoadFactor);
		}

		int balFactor6;
		if (Util.getMinBucketSize(sizeMap6.keySet()) != 0) {
			balFactor6 = list6.get((list6.size() - 1)).getValue() - list6.get(0).getValue();

		} else {
			balFactor6 = list6.get((list6.size() - 1)).getValue() - 0;

		}

		// getting minimum load factor
		if (minLoadFactor > balFactor6) {
			balanceFactorMap.clear();
			minLoadFactor = balFactor6;
			balanceFactorMap.put(6, minLoadFactor);
		}

		return balanceFactorMap.keySet().iterator().next(); // returning most balanced table no

	}

}
