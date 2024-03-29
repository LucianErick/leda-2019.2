package adt.rbtree;

import adt.bst.BSTImpl;
import adt.bt.Util;
import adt.rbtree.RBNode.Colour;

public class RBTreeImpl<T extends Comparable<T>> extends BSTImpl<T>
		implements RBTree<T> {

	public RBTreeImpl() {
		this.root = new RBNode<T>();
	}

	protected int blackHeight() {
		return this.blackHeight((RBNode<T>) this.root);
	}

	private int blackHeight(RBNode<T> node) {
		int returnHeight = -1;

		if (!node.isEmpty() && this.isBlack(node)) {
			if (this.isBlack(node)) {
				returnHeight ++;
			}
			returnHeight = Math.max(this.blackHeight((RBNode<T>) node.getRight()), this.blackHeight((RBNode<T>) node.getLeft()));
		}
		return returnHeight;
	}

	protected boolean verifyProperties() {
		boolean resp = verifyNodesColour() && verifyNILNodeColour()
				&& verifyRootColour() && verifyChildrenOfRedNodes()
				&& verifyBlackHeight();

		return resp;
	}

	/**
	 * The colour of each node of a RB tree is black or red. This is guaranteed
	 * by the type Colour.
	 */
	private boolean verifyNodesColour() {
		return true; // already implemented
	}

	/**
	 * The colour of the root must be black.
	 */
	private boolean verifyRootColour() {
		return ((RBNode<T>) root).getColour() == Colour.BLACK; // already
		// implemented
	}

	/**
	 * This is guaranteed by the constructor.
	 */
	private boolean verifyNILNodeColour() {
		return true; // already implemented
	}

	/**
	 * Verifies the property for all RED nodes: the children of a red node must
	 * be BLACK.
	 */
	private boolean verifyChildrenOfRedNodes() {
		return this.verifyChildrenOfRedNodes((RBNode<T>) this.root);
	}

	private boolean verifyChildrenOfRedNodes(RBNode<T> node) {
		boolean result = true;

		if (!node.isEmpty()) {

			if (this.isBlack(node)) {
				result = this.verifyChildrenOfRedNodes((RBNode<T>) node.getLeft()) &&
						this.verifyChildrenOfRedNodes((RBNode<T>) node.getRight());
			}

			else if (this.isRed(node)) {

				if (this.isBlack((RBNode<T>) node.getLeft()) && this.isBlack((RBNode<T>) node.getRight())) {
					result = this.verifyChildrenOfRedNodes((RBNode<T>) node.getLeft()) &&
							this.verifyChildrenOfRedNodes((RBNode<T>) node.getRight());
				}

				else {
					result = false;
				}
			}
		}
		return result;
	}

	/**
	 * Verifies the black-height property from the root.
	 */
	private boolean verifyBlackHeight() {
		if (this.blackHeight((RBNode<T>) this.root.getLeft()) != this.blackHeight((RBNode<T>) this.root.getRight())) {
			throw new RuntimeException();
		}
		return true;
	}

	@Override
	public void insert(T value) {
		if (value != null) {
			this.insert((RBNode<T>) this.getRoot(), value);
		}
	}

	private void insert(RBNode<T> node, T value) {
		if (node.isEmpty()) {
			this.setNewNode(node, value);
			this.fixNode(node);
		}

		else if (node.getData().compareTo(value) > 0) {
			this.insert((RBNode<T>) node.getLeft(), value);
		}

		else if (node.getData().compareTo(value) < 0) {
			this.insert((RBNode<T>) node.getRight(), value);
		}
	}


	@Override
	@SuppressWarnings("unchecked")
	public RBNode<T>[] rbPreOrder() {
		RBNode<T>[] auxArray = new RBNode[this.size()];
		this.preOrder((RBNode<T>) this.getRoot(), auxArray);

		return auxArray;
	}

	private void preOrder(RBNode<T> node, RBNode<T>[] auxArray) {
		if (!node.isEmpty()) {
			this.addElementToArray(auxArray, node);
			this.preOrder((RBNode<T>) node.getLeft(), auxArray);
			this.preOrder((RBNode<T>) node.getRight(), auxArray);
		}
	}

	// FIXUP methods
	protected void fixUpCase1(RBNode<T> node) {
		if (node.getParent() == null) {
			node.setColour(Colour.BLACK);
		}
	}

	protected void fixUpCase2(RBNode<T> node) {
		node.setColour(Colour.RED);
	}

	protected void fixUpCase3(RBNode<T> node) {
		node.setColour(Colour.RED);
		((RBNode<T>) node.getParent().getParent().getLeft()).setColour(Colour.BLACK);
		((RBNode<T>) node.getParent().getParent().getRight()).setColour(Colour.BLACK);
		((RBNode<T>) node.getParent().getParent()).setColour(Colour.RED);

		this.fixUpCase1((RBNode<T>) node.getParent().getParent());
	}

	protected void fixUpCase4(RBNode<T> node) {
		if (node.getParent().getParent().getLeft().equals(node.getParent()) && node.getParent().getRight().equals(node)) {
			Util.leftRotation((RBNode<T>) node.getParent());
		}

		else if (node.getParent().getParent().getRight().equals(node.getParent()) && node.getParent().getLeft().equals(node)) {
			Util.rightRotation((RBNode<T>) node.getParent());
		}

		this.fixUpCase5(node);
	}

	protected void fixUpCase5(RBNode<T> node) {
		((RBNode<T>) node.getParent().getParent()).setColour(Colour.BLACK);
		((RBNode<T>) node.getParent()).setColour(Colour.RED);

		if (node.getParent().getParent().getLeft().equals(node.getParent())) {
			Util.leftRotation((RBNode<T>) node.getParent().getParent());
		}

		else if (node.getParent().getParent().getRight().equals(node.getParent())) {
			Util.rightRotation((RBNode<T>) node.getParent().getParent());
		}
	}

	//PRIVATE METHODS

	private boolean isRed(RBNode<T> node) {
		return node.getColour().equals(Colour.RED);
	}

	private boolean isBlack(RBNode<T> node) {
		return node.getColour().equals(Colour.BLACK);
	}

	private void setNewNode(RBNode<T> node, T value) {
		node.setData(value);
		node.setLeft(new RBNode<>());
		node.getLeft().setParent(node);
		node.setRight(new RBNode<>());
		node.getRight().setParent(node);
	}

	private void fixNode(RBNode<T> node) {
		if (node.getParent() == null) {
			this.fixUpCase1(node);
		}

		else if (this.isBlack((RBNode<T>) node.getParent())) {
			this.fixUpCase2(node);
		}

		else if (this.isRed((RBNode<T>) node.getParent().getParent().getLeft()) && this.isRed((RBNode<T>) node.getParent().getParent().getRight())) {
			this.fixUpCase3(node);
		}

		else if (this.isCase4(node)) {
			this.fixUpCase4(node);
		}
	}

	private boolean isCase4(RBNode<T> node) {
		boolean result = false;

		if (node.getParent().getParent().getLeft().equals(node.getParent()) && node.getParent().getRight().equals(node)) {
			result = true;
		}

		else if (node.getParent().getParent().getRight().equals(node.getParent()) && node.getParent().getLeft().equals(node)) {
			result = true;
		}
		return result;
	}

	private void addElementToArray(RBNode<T>[] auxArray, RBNode<T> node) {
		int i = 0;

		while (auxArray[i] != null) {
			i++;
		}
		auxArray[i] = node;
	}
}

