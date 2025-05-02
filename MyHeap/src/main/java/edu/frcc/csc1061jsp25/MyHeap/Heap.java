package edu.frcc.csc1061jsp25.MyHeap;

import java.util.List;
import java.util.ArrayList;
public interface Heap {
	List<Object> members = new ArrayList<>();
	boolean add();
	Object remove();
	void balance();
}
