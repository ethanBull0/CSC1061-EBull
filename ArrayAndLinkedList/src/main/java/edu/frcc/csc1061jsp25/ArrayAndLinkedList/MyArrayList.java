package edu.frcc.csc1061jsp25.ArrayAndLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<T> implements List<T>{
	private T[] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		array = (T[]) new Object[4];
		size  = 0;
	}
	
	public MyArrayList(T[] array, int size) {
		super();
		this.array = array;
		this.size = size;
	}


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		for (Object t : array) {
			if (o.equals(t)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean add(T e) {
		if (size >= array.length) {
			T[] biggerArr = (T[]) new Object[array.length * 2];
			for (int i = 0; i < array.length; i++) {
				biggerArr[i] = array[i];
			}
			array = biggerArr;
		}
		array[size] = e;
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		int removeIndex = indexOf(o);
		if (array.length == 0 || removeIndex < 0) {
			return false;
		}
		T[] smallerArr = (T[]) new Object[array.length - 1];
		
		for (int i = 0; i < smallerArr.length - 1; i++) {
			if (i == removeIndex && i != smallerArr.length - 1) {
				i++;
			} else {
				break;
			}
			smallerArr[i] = array[i];
		}
		array = smallerArr;
			
		size--;
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		boolean match = false;
		for (int i = 0; i < size; i++) {
			if (c.contains(i)) {
				match = true;
			}
			if (match == false) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) { //need iterator and set
		Iterator<Collection<? extends T>> iterate = (Iterator<Collection<? extends T>>) c.iterator(); //looks sus
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		size = 0;
		
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		return array[index];
	}

	@Override
	public T set(int index, T element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		T old = array[index];
		array[index] = element;
		return array[index];
	}

	@Override
	public void add(int index, T element) {
		//create a new array, copy everything up to index, then copy index,
		//then copy everything from index to length-1
		if (index < 0 || index >= size) { //take care of exceptions for the end-user
			throw new IndexOutOfBoundsException();
		}
		add(element);
		for (int i = size - 1; i > index; i--) {
			array[i] = array[i - 1];
		}
		//insert element at index
		array[index] = element;
		
	}

	@Override
	public T remove(int index) { //TODO
		T element = get(index);
		
		return null;
	}

	@Override
	public int indexOf(Object o) {
		int index = -1;
		for (int i = 0; i < size; i++) { //TODO: is the for-each loop better?
			if (o.equals(array[i])) {
				index = i;
				break;
			}
		}
		return index;
	}

	@Override
	public int lastIndexOf(Object o) {
		int index = -1;
		for (int i = 0; i < size; i++) { //TODO: is the for-each loop better?
			if (o.equals(array[i])) {
				index = i;
			}
		}
		return index;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
