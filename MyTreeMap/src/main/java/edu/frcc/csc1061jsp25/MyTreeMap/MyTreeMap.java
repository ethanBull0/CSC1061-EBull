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
	
	public Node getNode(Object key) {
		Node current = root;
		Comparable<K> k = (Comparable<K>) key;
		
		while(current != null) {
			if (k.compareTo(current.key) < 0) {
				current = current.left;
			} else if (k.compareTo(current.key) > 0) {
				current = current.right;
			} else {
				return current;
			}
		}
		return null;
	}
	
	public Node getParentNode(Node n) {
		Deque<Node> stack = new LinkedList<>();
		Node current = root;
		stack.push(root);
		Comparable<K> k  = (Comparable<K>) n.key;
		while(current != null) {
			if (k.compareTo(current.key) < 0) {
				current = current.left;
			} else if (k.compareTo(current.key) > 0) {
				current = current.right;
			} else {
				if (stack.size() >= 2) {
				stack.pop();
				return stack.pop();
				} else {
					return stack.pop();
				}
			}
			stack.push(current);
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
	public V remove(Object key) {
		if (!containsKey(key)) {
			return null;
		}
		
		//Comparable<K> k = (Comparable<K>) key;
		Node searchNode = getNode(key);
		Node parentNode = getParentNode(searchNode);
		
		V oldVal = searchNode.value;
		if (searchNode.left == null && searchNode.right == null) {
			if (((Comparable<K>) searchNode.key).compareTo(parentNode.key) < 0) {
			parentNode.left = null;
			} else if (((Comparable<K>) searchNode.key).compareTo(parentNode.key) > 0) {
				parentNode.right = null;
			}
			return oldVal;
		}
		else if (!(searchNode.left == null) && !(searchNode.right == null)) {
			Node remNode = inOrderPredecessor(searchNode);
			if (((Comparable<K>) searchNode.key).compareTo(parentNode.key) < 0) {
				parentNode.left.value = remNode.value;
				parentNode.left.key = remNode.key;
				} else if (((Comparable<K>) searchNode.key).compareTo(parentNode.key) > 0) {
					parentNode.right.value = remNode.value;
					parentNode.right.key = remNode.key;
				}
			remNode = null;
			return oldVal;
		}
		else if (searchNode.left == null) {
		searchNode.value = searchNode.right.value;
		searchNode.key = searchNode.right.key;
		searchNode.right = null;
		return oldVal;
		}
	else if (searchNode.right == null) {
		searchNode.value = searchNode.left.value;
		searchNode.key = searchNode.left.key;
		searchNode.left = null;
		return oldVal;
		}
		
		return null;
	}
	
	public Node inOrderPredecessor(Node sNode) {
		Node theRoot = sNode;
		Node parent = sNode;
		if (sNode.left != null) {
			parent = sNode;
			sNode = sNode.left;
		}
		if (sNode.right == null) {
			if (!(parent.left.left == null)) {
				parent.left = sNode.left;
				parent.value = sNode.value;
				parent.key = sNode.key;
			}
			sNode = null;
			return parent;
		}
		while (sNode.right != null) {
			parent = sNode;
			sNode = sNode.right;
		}
		
		Node oldNode = sNode;
		
		
		if (theRoot == root) { //!todo
			root.value = sNode.value;
			root.key = sNode.key;
			parent.right = null;
		}
		sNode = null;
		return oldNode;
	}
	
	public int inOrderDepth(Node sNode) {
		int thisRoot = 0;
		if (sNode.left != null) {
			sNode = sNode.left;
			thisRoot++;
		}
		if (sNode.right == null) {
			thisRoot++;
			return thisRoot;
		}
		while (sNode.right.right != null) {
			sNode = sNode.right;
			thisRoot++;
		}
		return thisRoot;
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
