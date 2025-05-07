package edu.frcc.csc1061jsp25.MyHeap;

public class MaxHeap implements Heap {

	@Override
	public boolean add(Object o) {
		members.add(o);
		balance(o);
		return false;
	}

	@Override
	public Object remove() {
		
		return null;
	}

	@Override
	public void balance(Object o) { //check if the parent is unbalanced, if so recursively call balance()
		//use the formula to check value of
		Object oLeftChild = (2 * members.indexOf(o)) + 1;
		Object oRightChild = (2 * members.indexOf(o)) + 2;
		Object lParent = (members.indexOf(oLeftChild) - 1) / 2;
		Object rParent = (members.indexOf(oRightChild) - 2) / 2;
		
		if (oLeftChild.compareTo(lParent) > 0) {
			Object temp = lParent;
			lParent = oLeftChild;
		}
	}

}
