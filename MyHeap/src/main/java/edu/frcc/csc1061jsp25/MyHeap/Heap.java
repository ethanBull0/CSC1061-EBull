package edu.frcc.csc1061jsp25.MyHeap;

import java.util.List;
import java.util.LinkedList;
public interface Heap {
	List<Object> members = new LinkedList<>();
	boolean add(Object o);
	Object remove();
	void balance(Object o);
}
