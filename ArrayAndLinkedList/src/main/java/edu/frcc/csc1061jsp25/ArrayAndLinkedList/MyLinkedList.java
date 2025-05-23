package edu.frcc.csc1061jsp25.ArrayAndLinkedList;


import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.w3c.dom.Node;

public class MyLinkedList<T> implements List<T> {
	private Node head;
	private int size;

	private class Node {
		T data;
		Node next;
		
		public Node(T data) {
			this.data = data;
			next = null;
		}
	}
	
	public MyLinkedList() {
		head = null;
		size = 0;
	}
	
	@Override
	public int size() {
		/*int count = 0;
		for (Node node = head; node != null; node = node.next) {
			count++;
		}
		return count; */
		return size;
	}

	@Override
	public boolean isEmpty() {
		/* return size == 0; */
		return head == null;
	}

	@Override
	public boolean contains(Object o) {
		Node node = head;
		while (node.next != null) {
			if (node.equals(o)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	private class MyIterator implements Iterator<T> {

		Node node = head;
		
		@Override
		public boolean hasNext() {
			if (node != null) {
				return true;
			}
			return false;
		}

		@Override
		public T next() {
			T element = node.data;
			node = node.next;
			return element;
		}
		
	}
	
	
	@Override
	public Iterator<T> iterator() {
		//T[] array = (T[]) toArray();
		//return Arrays.asList(array).iterator();
		return new MyIterator();
	}

	@Override
	public Object[] toArray() {
		Node node = head;
		Object[] toArr = new Object[size];
		for (int i = 0; i < size && node.next != null; i++) {
			toArr[i] = node;
			node = node.next;
		}
		return toArr;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		Node node = head;
		Object[] toArr = new Object[size];
		for (int i = 0; i < size && node.next != null; i++) {
			toArr[i] = node;
			node = node.next;
		}
		return ((T[]) toArr);
	}

	@Override
	public boolean add(T e) {
		if (head == null) {
			head = new Node(e);
		}
		Node node = head;
		while (node.next != null) {
			node = node.next;
		}
		node.next = new Node(e);
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		Node node = head;
		while (node.next != null) {
			if (node.data.equals(o)) {
				node = null;
				size--;
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		Node node = head;
		for (int i = 0; i < size; i++) {
				if (!(c.contains(node.data))) {
					return false;
				}
			node = node.next;
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) { //use iterator
		// TODO Auto-generated method stub
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
		head = null;
		size = 0;
		
	}

	@Override
	public T get(int index) {
		check(index);
		Node node = getNode(index);
		return node.data;
	}

	@Override
	public T set(int index, T element) {
		check(index);
		Node node = getNode(index);
		T old = node.data;
		node.data = element;
		return old;
	}

	private void check(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	private Node getNode(int index) {
		check(index);
		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	
	@Override
	public void add(int index, T element) {
		Node newNode = new Node(element);
		if (index == 0) {
			newNode.next = head;
			head = newNode;
		}
		
		Node prevNode = getNode(index - 1);
		newNode.next = prevNode.next;
		prevNode.next = newNode;
		
	}

	@Override
	public T remove(int index) {
		if (index == 0) {
			head = head.next;
		}
		Node node = getNode(index);
		T data = node.data;
		
		Node prevNode = getNode(index - 1);
		prevNode.next = prevNode.next.next;
		
		return data;
	}

	@Override
	public int indexOf(Object o) { //TODO returns 0 not -1
		Node node = head;
		int count = 0;
		while (node.next != null && !(node.data.equals(o))) {
			node = node.next;
			count++;
		}
		return count;
	}

	@Override
	public int lastIndexOf(Object o) {
		Node node = head;
		int count = 0;
		int lastIndexFound = 0;
		while(node.next != null) {
			node = node.next;
			count++;
			if (node.data.equals(o)) {
				lastIndexFound = count;
			}
		}
		return lastIndexFound;
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
	
	/* class MyLinkedListIterator implements Iterator<T> {

		Node current = null;
		
		@Override
		public boolean hasNext() {
			if (current == null && head != null) {
				return true;
			} else if (current != null) {
				return current.next != null;
			}
			return false;
		}

		@Override
		public T next() {
			if (current == null) {
				current = head;
				return head.data;
			} else if (current != null){
				T e = current.data;
			 current = current.next;
			 return e;
			}
			throw new NoSuchElementException();
		}
		
	} */
}
