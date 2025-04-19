package edu.frcc.csc1061jsp25.MyAVL;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MyAVLTree<K, V> implements Map<K, V>, Iterable<edu.frcc.csc1061jsp25.MyAVL.MyAVLTree.Node> {

	private Node root = null;
	private int size = 0;
	private List<Node> path = new ArrayList<>();
	
	protected class Node {
		private K key;
		private V value;
		private Node left;
		private Node right;
		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		private int height;
		
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
			updateHeight(newNode);
			size++;
			return null;
		}
		
		Node parent = null;
		Node current = root;
		path.clear();
		Comparable<K> k = (Comparable<K>) key; //This is so we can call compareTo()
		while (current != null) {
			path.add(current);
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
		updateHeight(newNode);
		balancePath();
		size++;
		
		return null;
	}

	private void updateHeight(Node node) {
		if (node.left == null && node.right == null) {
			node.height = 0;
		} else if (node.left == null) {
			node.height = node.right.height + 1;
		} else if (node.right == null) {
			node.height = node.left.height + 1;
		} else {
			node.height = Math.max(node.left.height, node.right.height) + 1;
		}
	}
	
	private int balanceFactor(Node current) {
		if (current.left == null && current.right == null) {
			return 0;
		} else if (current.left == null) {
			return current.right.height;
		} else if (current.right == null) {
			return -current.left.height;
		} else {
		}
			return current.right.height - current.left.height;
		}
	
	private void balancePath() {
		for (int i = path.size() - 1; i >= 0; i--) {
			Node current = path.get(i);
			updateHeight(current);
			Node parent = null;
			if (i > 0) {
				parent = path.get(i - 1);
			}
			switch (balanceFactor(current)) {
			case -2:
				if (balanceFactor(current.left) <= 0) {
					balanceLL(current, parent);
					
				} else {
					balanceLR(current,parent);
				}
			case 2:
				if (balanceFactor(current.right) >= 0) {
					balanceRR(current,parent);
				} else {
					balanceRL(current,parent);
					
				}
			}
			
		}
	}
	
	private void balanceLL(Node node, Node parent) {
		Node ggp = parent;
		Node gp = node; 
		Node par = gp.left;
		Node ch = par.left;
		
		if (gp == root) {
			root = par;
		}
		if (ggp.right == node) {
			ggp.right = par;
		} else {
			ggp.left = par;
		}
		gp.left = gp.left.left;
		par.right = gp;
	
	}
	
	private void balanceRR(Node node, Node parent) {
		Node ggp = parent;
		Node gp = node; 
		Node par = gp.right;
		Node ch = par.right;
		
		if (gp == root) {
			root = par;
		}
		if (ggp.left == node) {
			ggp.left = par;
		} else {
			ggp.right = par;
		}
		node.right = node.right.right;
		node.right.left = node;
	}
	
	private void balanceLR(Node node, Node parent) {
		Node ggp = parent;
		Node gp = node;
		Node par = gp.left;
		Node ch = par.right;
		if (gp == root) {
			root = ch;
		}
		else {
			if (ggp.left == par) {
				ggp.left = ch;
			} else {
				ggp.right = ch;
			}
		}
		
		par.right = ch.left;
		gp.left = ch.right;
		
		ch.left = par;
		ch.right = gp;
		updateHeight(gp);
		updateHeight(par);
		updateHeight(ch);
	}
	
	private void balanceRL(Node node, Node parent) {
		
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
	public Iterator<edu.frcc.csc1061jsp25.MyAVL.MyAVLTree.Node> iterator() {
		// TODO Auto-generated method stub
		return new NonRecursiveIterator();
	}
	
	private class NonRecursiveIterator implements Iterator<edu.frcc.csc1061jsp25.MyAVL.MyAVLTree.Node> {
		
		private Deque<Node> stack = new ArrayDeque<>();
		
		public NonRecursiveIterator() {
			pushOnStack(root);
		}
		
		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public edu.frcc.csc1061jsp25.MyAVL.MyAVLTree.Node next() {
			Node node = stack.pop();
			pushOnStack(node.right); //push right node, then everything to the left
			return node;
			
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
