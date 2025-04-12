package edu.frcc.csc1061jsp25.MyTreeMap;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MyTreeMap<K, V> implements Map<K, V>, Iterable<V> {

	private Node root = null;
	private int size = 0;
	
	private class Node {
		private K key;
		private V value;
		private Node left;
		private Node right;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
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
		/*Node current = root;
		Comparable<K> k = (Comparable<K>) key;
		while (current != null) {
			if (current.left.equals(key)) {
				return true;
			}
			current = current.left;
		}
		current = root;
		while (current != null) {
			if (current.right.equals(key)) {
				return true;
			}
		}
		return root.equals(key); */
		if (get(key) != null) {
			return true;
		} 
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		Node current = root;
		Comparable<K> k = (Comparable<K>) key;
		
		while(current != null) {
			if (k.compareTo(current.key) < 0) {
				current = current.left;
			} else if (k.compareTo(current.key) > 0) {
				current = current.right;
			} else {
				return current.value;
			}
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		if (root == null) {
			Node newNode = new Node(key, value);
			root = newNode;
			size++;
			return null;
		}
		
		Node parent = null;
		Node current = root;
		Comparable<K> k = (Comparable<K>) key; //This is so we can call compareTo()
		while (current != null) {
			parent = current;
			if (k.compareTo(current.key) < 0) {
				current = current.left;
			} else if (k.compareTo(current.key) > 0){
				current = current.right;
			} else {
				V oldVal = current.value;
				current.value = value;
				return oldVal;
			}
		}
		
		Node newNode = new Node(key, value);
		if (k.compareTo(parent.key) < 0) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}
		size++;
		
		return null;
	}

	//homework
	@Override
	public V remove(Object key) {
		Node remNode = new Node((K)key, get(key));
		Deque<V> useNodes = new ArrayDeque<>();
		useNodes.push(root.value);
		V value = get(key);
		
		Node searchNode = root;
		Node parentNode = new Node(null, null);
		Comparable<K> k = (Comparable<K>) searchNode.key;
		while (searchNode != remNode) {
			parentNode = searchNode;
			if (k.compareTo((K) key) < 0) {
				searchNode = searchNode.left;
			} else if (k.compareTo((K) key) > 0) {
				searchNode = searchNode.right;
			}
		}
		if (searchNode.left.equals(null) && searchNode.right.equals(null)) {
			V oldVal = searchNode.value;
			searchNode = null;
			return oldVal;
		}
		else if (!(searchNode.left.equals(null)) && !(searchNode.right.equals(null))) {
			
		} 
		else if (searchNode.left.equals(null)) {
		
		}
	else if (searchNode.right.equals(null)) {
		
		}
		
		
		
		
		/*while (ri.hasNext()) {
			useNodes.push(ri.next());
			V testcase = useNodes.pop();
			V parentVal = useNodes.pop();
			useNodes.push(testcase);
			if (testcase.equals(value)) {
				
				if (myNode.left.equals(null) && myNode.right.equals(null)) { //case I
					myNode = null;
				} else if (!(myNode.left.equals(null) && !(myNode.right.equals(null)))) { //case II.  
					
				} else if (!(myNode.left.equals(null) || !(myNode.right.equals(null)))) { //case III Parent node = child node, child node = null
					myParent = myNode;
					myNode = null;
				}
			}
		} */
		
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() {
		
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<V> iterator() {
		// TODO Auto-generated method stub
		return new NonRecursiveIterator();
	}
	
	private class NonRecursiveIterator implements Iterator<V> {
		
		private Deque<Node> stack = new ArrayDeque<>();
		
		public NonRecursiveIterator() {
			pushOnStack(root);
		}
		
		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public V next() {
			Node node = stack.pop();
			V value = node.value;
			pushOnStack(node.right); //push right node, then everything to the left
			return value;
			
		}
		
		public void pushOnStack(Node n) {
			Node current = n;
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
		}
		
	}
	
	private class RecursiveIterator implements Iterator<V> {
		
		private Queue<V> list = new ArrayDeque<>();
		
		public RecursiveIterator() {
			preorder(root);
		}
		
		private void preorder(Node node) {
			if (node == null) {
				return;
			}
			list.add(node.value);
			preorder(node.left);
			preorder(node.right);
		}
		
		private void postorder(Node node) {
			if (node == null) {
				return;
			}
			list.add(node.value);
			preorder(node.left);
			preorder(node.right);
		}
		
		private void inorder(Node node) {
			if (node == null) {
				return;
			}
			inorder(node.left);
			list.add(node.value);
			inorder(node.right);
			
		}
		
		@Override
		public boolean hasNext() {
			return !list.isEmpty();
		}

		@Override
		public V next() {
			return list.remove(); //treat it like a queue
		}
		
	}

}
