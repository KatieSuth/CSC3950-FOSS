/*
 *  You are free to use this code anywhere, copy, modify and redistribute at your
 *  own risk.
 *  Your are solely responsibly for any damage that may occur by using this code.
 *  This code is not tested for all boundary conditions. Use it at your own risk.
 *  Original code: http://www.newthinktank.com/2013/03/binary-tree-in-java/
 * @author <a href='mailto:alexey@zhokhov.com'>Alexey Zhokhov</a>
 */
package com.zhokhov.interview.data;
import java.util.Scanner;

public class BinaryTree {
   private class Node {
      int key;
      String name;
      Node leftChild;
      Node rightChild;
      //Node parent;
      Node(int key, String name){
         this.key = key;
         this.name = name;
      }
   
      public String toString(){
         return name + " has the key " + key;
      //* return name + " has the key " + key + "\nLeft Child: " + leftChild +"\nRight Child: " + rightChild + "\n";
      }
   }

   Node root;

   public void addNode(int key, String name) {
      Node newNode = new Node(key, name);// Create a new Node and initialize it
      if (root == null){// If there is no root this becomes root
         root = newNode;
      } 
      else{
         Node focusNode = root;// Set root as the Node we will start with as we traverse the tree
         Node parent;// Future parent for our new Node
         while(true){
            parent = focusNode;// root is the top parent so we start there
            if (key < focusNode.key){// Check if the new node should go on the left side of the parent node
               focusNode = focusNode.leftChild;// Switch focus to the left child
               if (focusNode == null) {// If the left child has no children
                  parent.leftChild = newNode; // then place the new node on the left of it
                  return;
               }
            } 
            else{ // If we get here put the node on the right
               focusNode = focusNode.rightChild;
               if (focusNode == null) {// If the right child has no children
                  // then place the new node on the right of it
                  parent.rightChild = newNode;
                  return; // All Done
               }
            }
         }
      }
   }
   
   /* All nodes are visited in ascending order
      Recursion is used to go to one node and
      then go to its child nodes and so forth
   */
   public void inOrderTraverseTree(Node focusNode){
      if (focusNode != null){
         inOrderTraverseTree(focusNode.leftChild); // Traverse the left node
         System.out.println(focusNode);            // Visit the currently focused on node
         inOrderTraverseTree(focusNode.rightChild);// Traverse the right node
      }
   }

   public void preorderTraverseTree(Node focusNode) {
      if (focusNode != null){
         System.out.println(focusNode);
         preorderTraverseTree(focusNode.leftChild);
         preorderTraverseTree(focusNode.rightChild);
      }
   }

   public void postOrderTraverseTree(Node focusNode) {
      if (focusNode != null){
         postOrderTraverseTree(focusNode.leftChild);
         postOrderTraverseTree(focusNode.rightChild);
         System.out.println(focusNode);
      }
   }

   public Node findNode(int key){
      Node focusNode = root;// Start at the top of the tree
      while (focusNode.key != key){// While we haven't found the Node keep looking  
         if (key < focusNode.key){// If we should search to the left 
            focusNode = focusNode.leftChild;// Shift the focus Node to the left child
         } 
         else{
            focusNode = focusNode.rightChild;// Shift the focus Node to the right child
         }
         if (focusNode == null){// The node wasn't found
            return null;
         }
      }
      return focusNode;
   }

   // TODO
   /*
   int depth(Node u) {
       int d = 0;
       while (u != r) {
           u = u.parent;
           d++;
       }
       return d;
   }
   */

   int size(Node u){
      if (u == null) 
         return 0;
      return 1 + size(u.leftChild) + size(u.rightChild);
   }

   //Katie - renamed this function since Menu.java is the new main
   public void BinaryTreeStart(Scanner scanBT){
      BinaryTree theTree = new BinaryTree();
      int BTintInput = 0;         //Ring:for storing user input int
      String BTstringInput;   //Ring:for storing user input string
      while(BTintInput!=-999){ 
         System.out.println("Enter the number for this node(-999 to exit)");
         BTintInput = scanBT.nextInt();
         if(BTintInput!=-999){
            System.out.println("Enter the string for this node.");
            BTstringInput = scanBT.next();
            theTree.addNode(BTintInput, BTstringInput);
         }   
      }
      System.out.println("What's the number of the node that you want to find?");
      BTintInput=scanBT.nextInt();
      System.out.println("Node with the key: "+BTintInput+"/n");
      System.out.println(theTree.findNode(BTintInput));
      theTree.inOrderTraverseTree(theTree.root);
      theTree.preorderTraverseTree(theTree.root);
      theTree.postOrderTraverseTree(theTree.root);
   }
}