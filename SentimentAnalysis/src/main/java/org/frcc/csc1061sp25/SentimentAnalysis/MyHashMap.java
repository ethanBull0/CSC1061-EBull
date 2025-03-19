package org.frcc.csc1061sp25.SentimentAnalysis;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
/*
 * Sentiment Analysis' version of MyHashMap
 * Implements load factor to rehash table 
 * Rehashes upon size doubling
 */
public class MyHashMap<K, V> implements Map<K, V> {
	
	public static final int INITIAL_NUM_BUCKETS = 4;
	private static double Load_Factor_Threshold = 0.5;
	
	private LinkedList<Entry<K, V>>[] buckets;
	private int size;

	public class Entry<K, V> implements Map.Entry<K, V> {
		K key;
		V value;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			this.value = value;
			return value;
		}
	}
	
	public MyHashMap() {
		buckets = new LinkedList[INITIAL_NUM_BUCKETS];
	}
	
	public MyHashMap(double Load_Factor_Threshold) {
		this.Load_Factor_Threshold = Load_Factor_Threshold;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
		LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];
		for(Entry<K,V> entry : bucket) {
			if (entry.getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				LinkedList<Entry<K, V>> bucket = buckets[i];
				for (Entry<K, V> entry : bucket) {
					if (entry.getValue().equals(value)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public V get(Object key) {
		int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
		LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];
		for(Entry<K,V> entry : bucket) {
			if (entry.getKey().equals(key)) {
				return entry.getValue();
			}
		}
		return null;
	}

	public int getNumBuckets() {
		return buckets.length;
	}
	
	private void rehash() { /* part 1 */
		double ratio = 0.0;
		int numBuckets = INITIAL_NUM_BUCKETS;
		double loadFactor = size / buckets.length;
		if (ratio >= loadFactor) {
			LinkedList<Entry<K, V>>[] newBuckets = new LinkedList[numBuckets *= 2];
			LinkedList<Entry<K, V>>[] oldBuckets = buckets;
			buckets = newBuckets;
			for (LinkedList<Entry<K, V>> bucket : oldBuckets) {
				for (int i = 0; i < bucket.size(); i++) {
				 put(bucket.get(i).getKey(), bucket.get(i).getValue());
				}
			}
		}
		
	}
	
	@Override
	public V put(K key, V value) {
		int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
		LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];
		
		if (buckets[bucketIndex] == null) {
			buckets[bucketIndex] = new LinkedList<Entry<K, V>>();
		}
		
		for (Entry<K, V> entry : buckets[bucketIndex]) {
			if (entry.key.equals(key)) {
				V oldVal = entry.getValue();
				entry.value = value;
				return oldVal;
			}
		}
		
		//load factor
		//load factor = size / buckets.length
		//if (load factor > Load_Factor_Threshold) { rehash() }
		
		
		buckets[bucketIndex].add(new Entry<K, V>(key, value));
		size++;
		return null;
	}
	

	@Override
	public V remove(Object key) { /* dont remove while traversing */
		int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
		//LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];
		
		
		if (buckets[bucketIndex] != null) {
			int listIndex = -1;
			for (Entry<K, V> entry : buckets[bucketIndex]) {
				listIndex++;
				if (entry.key.equals(key)) {
					break;
				}
				V oldVal = buckets[bucketIndex].get(listIndex).value;
				buckets[bucketIndex].remove(buckets[bucketIndex].get(listIndex));
				size--;
				return oldVal;
			}

		}
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> otherMap) { //get otherMap entries, set each val to this map
		for (int i = 0; i < otherMap.size(); i++) {
			Set<? extends Map.Entry<? extends K, ? extends V>> mySet = otherMap.entrySet();
			for (Map.Entry<? extends K, ? extends V> entry : mySet) {
				put(entry.getKey(), entry.getValue());
			}
		}
		
	}

	@Override
	public void clear() {
		size = 0;
		for (int i = 0; i < buckets.length; ++i) {
			buckets[i] = null;
		}
		
	}

	@Override
	public Set<K> keySet() {
		Set<K> keySet = new HashSet<K>();
		for (int i = 0; i < buckets.length; i++) { //exhaustive search (containsValue)
			if (buckets[i] != null) {
				LinkedList<Entry<K, V>> bucket = buckets[i];
				for (Entry<K, V> entry : bucket) {
					keySet.add(entry.getKey());
				}
			}
		}
		return keySet;
	}

	@Override
	public Collection<V> values() {
		Collection<V> valueList = new LinkedList<>();
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				LinkedList<Entry<K, V>> bucket = buckets[i];
				for (Entry<K, V> entry : bucket) {
					valueList.add(entry.getValue());
				}
			}
		}
		return valueList;
	}

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> mySet = new HashSet<Map.Entry<K, V>>();
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				LinkedList<Entry<K, V>> bucket = buckets[i];
				for (Entry<K, V> entry : bucket) {
					mySet.add(entry);
				}
			}
		}
		return mySet;
	}

}
