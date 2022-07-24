package com.greatlearning.TreesLab;

import java.util.HashSet;

public class FindPairWithGivenSum
{
	static class Node
	{
		int data;
		Node left, right;
	};

	static Node NewNode(int data)
	{
		Node node = new Node();
		node.data = data;
		node.left = null;
		node.right = null;

		return node;
	}

	static Node insert(Node root, int data)
	{
		if (root == null)
			return NewNode(data);
		if (data < root.data)
			root.left = insert(root.left, data);
		else
			root.right = insert(root.right, data);

		return root;
	}

	private static boolean findPair(Node root, int sum, HashSet<Integer> set) 
	{
		if (root == null)
		{
			return false;
		}

		if (findPair(root.left, sum, set))
		{
			return true;
		}

		if (set.contains(sum - root.data)) 
		{
			System.out.println("Pair is found: (" + (sum - root.data) + ", " + root.data + ")");
			return true;
		}
		else
		{
			set.add(root.data);
		}

		return findPair(root.right, sum, set);
	}

	public static void main(String[] args)
	{
		int[] dataValues = { 40, 20, 60, 10, 30, 50, 70 };

		Node root = null;
		for (int data: dataValues)
		{
			root = insert(root, data);
		}

		int sum = 130;
		HashSet<Integer> set = new HashSet<>();

		if (!findPair(root, sum, set)) 
		{
			System.out.println("Pair does not exist");
		}
	}
}
