/**
* @author  Hashed
* @version 1.0
* @since   2022-05-05 
*/
import java.util.HashMap;

public class HashTable {

	static private class ListNode {
		// Keys that have the same hash code are placed together
		// in a linked list. A ListNode
		// holds a (key,value) pair.
		Object key;
		Object value;
		ListNode next; // Pointer to next node in the list

	}

	private ListNode[] table; // The hash table, represented as
								// an array of linked lists.
	private int count;

	public HashTable() {
		// Create a hash table
		table = new ListNode[64];
	}

	public HashTable(int initialSize) {
		table = new ListNode[initialSize];
	}

	public HashMap put(Object key, Object value, int hashtableno, HashMap sizeMap) {

		int[] bucketList = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

		int bucket = hash(key, hashtableno);// calculating the bucket in which the value should go
		int counter = sizeMap.get(bucket) != null ? (int) sizeMap.get(bucket) : 0;
		for (int i : bucketList) {
			if (i == bucket) {
				counter++; //getting bucket size
			}
		}

		sizeMap.put(bucket, counter);
		ListNode list = table[bucket];
		while (list != null) {
			// Search the nodes in the list, to see if the key already exists.
			if (list.key.equals(key))
				break;
			list = list.next;
		}
		if (list != null) {
			// Since list is not null, we have found the key.
			// Just change the associated value.
			list.value = value;
		} else {
			ListNode newNode = new ListNode();
			newNode.key = key;
			newNode.value = value;
			newNode.next = table[bucket];
			table[bucket] = newNode;
			count++; // Count the newly added key.
		}
		return sizeMap;
	}

	//return hashcode for each hashtable based on the digits
	private int hash(Object key, int hashtableno) {
		int hashCode = 0;
		if (hashtableno == 1) {
			hashCode = Util.hashfct1((String) key);
		}
		if (hashtableno == 2) {
			hashCode = Util.hashfct2((String) key);
		}
		if (hashtableno == 3) {
			hashCode = Util.hashfct3((String) key);
		}
		if (hashtableno == 4) {
			hashCode = Util.hashfct4((String) key);
		}
		if (hashtableno == 5) {
			hashCode = Util.hashfct5((String) key);
		}
		if (hashtableno == 6) {
			hashCode = Util.hashfct6((String) key);
		}
		return hashCode;
	}

}
