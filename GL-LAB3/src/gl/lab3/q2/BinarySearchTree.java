package gl.lab3.q2;


import java.io.*;
import java.util.*;

//A binary tree node
class Node {

 int data;
 Node left, right;

 Node(int val)
 {
     data = val;
     left = right = null;
 }
}

class BinarySearchTree {

 // Root of BST
 Node root;

 // Constructor
 BinarySearchTree() { root = null; }
 void insert(int key) { root = insertRec(root, key); }

 /* A recursive function to insert a new key in BST */
 Node insertRec(Node root, int data)
 {

     /* If the tree is empty, return a new node */
     if (root == null) {
         root = new Node(data);
         return root;
     }

     /* Otherwise, recur down the tree */
     if (data < root.data)
         root.left = insertRec(root.left, data);
     else if (data > root.data)
         root.right = insertRec(root.right, data);

     return root;
 }

 boolean isPairPresent(Node root, Node temp, int target)
 {
     if (temp == null)
         return false;

     return search(root, temp, target - temp.data)
         || isPairPresent(root, temp.left, target)
         || isPairPresent(root, temp.right, target);
     
 }

 boolean search(Node root, Node temp, int k)
 {

     if (root == null)
         return false;

     Node c = root;
     boolean flag = false;
     while (c != null && flag != true) {
         if (c.data == k && temp != c) {
             flag = true;
             System.out.println("Sum:"+(c.data+temp.data) );
             System.out.println("Pair:" +"("+ temp.data
                                + "," + c.data+")");
             return true;
         }
         else if (k < c.data)
             c = c.left;
         else
             c = c.right;
     }

     return false;
 }

 public static void main(String[] args)
 {
	 Scanner sc = new Scanner(System.in);
     BinarySearchTree tree = new BinarySearchTree();
     /*System.out.println("enter the number of nodes in the BST");
     int n= sc.nextInt();
     for (int i=0;i<n;i++) {
    	 System.out.println("Value of next node(int)");
    int j = sc.nextInt(); 
    tree.insert(j);}
     System.out.println("ENTER THE REQUIRED SUM (INT)");
     */ 
      tree.insert(40);
      tree.insert(20);
      tree.insert(60);
      tree.insert(10);
      tree.insert(30);
      tree.insert(50);
      tree.insert(70);
     //int sum=sc.nextInt();
      int sum=130;
     
     boolean test
         = tree.isPairPresent(tree.root, tree.root, sum);
     if (!test)
         System.out.println("Nodes are not  found!");
 }
}