// Winner Tree----------------------------------------------------------
import java.util.Arrays;
public class MinWinnerTree {
    private int[] tree;
    private int[] players;
public MinWinnerTree(int[] players) {
        this.players = players;
        int n = players.length;
        int treeSize = calculateTreeSize(n);
        tree = new int[2 * treeSize - 1];
        Arrays.fill(tree, -1);
        for (int i = 0; i < n; i++) {
            tree[treeSize - 1 + i] = i;
        }
        buildWinnerTree(0, 0, treeSize - 1);
    }
private int calculateTreeSize(int n) {
        int treeSize = 1;
        while (treeSize < n) {
            treeSize *= 2;
        }
        return treeSize;
    }
    private void buildWinnerTree(int node, int left, int right) {
        if (left == right) return;
        int mid = (left + right) / 2;
        buildWinnerTree(2 * node + 1, left, mid);
        buildWinnerTree(2 * node + 2, mid + 1, right);
        tree[node] = players[tree[2 * node + 1]] <= players[tree[2 * node + 2]] ? tree[2 * node + 1] : tree[2 * node + 2];
    }
public int getWinnerIndex() {
        return tree[0];
    }
public static void main(String[] args) {
        int[] players = {3, 7, 1, 9, 4, 2, 8, 5}; 
        MinWinnerTree winnerTree = new MinWinnerTree(players);
        int winnerIndex = winnerTree.getWinnerIndex();
        int winningScore = players[winnerIndex];
        System.out.println("The player with the lowest score is at index: " + winnerIndex);
        System.out.println("The score of the winning player is: " + winningScore);
    }
}

//Horizontal View---------------------------------------------------------------------------
import java.util.*;
class TreeNode {
 char val;
 TreeNode left;
 TreeNode right;
 public TreeNode(char val) {
 this.val = val;
 left = null;
 right = null;
 }}
public class Main {
 // Function to obtain the Horizontal 
View of a binary tree
 public static List<Character> 
horizontalView(TreeNode root) {
 List<Character> horizontalView = 
new ArrayList<>();
 if (root == null) {
 return horizontalView;
 }
 Queue<TreeNode> queue = new 
LinkedList<>();
 queue.offer(root);
 while (!queue.isEmpty()) {
 int levelSize = queue.size();
 for (int i = 0; i < 
levelSize; i++) {
 TreeNode node = 
queue.poll();
 horizontalView.add(node.val);
 if (node.left != null) {
 
queue.offer(node.left);
 }
 if (node.right != null) {
 
queue.offer(node.right);
 }
 }
 }
return horizontalView;
 }
 public static void main(String[] 
args) {
 // Sample binary tree input
 TreeNode root = new 
TreeNode('A');
 root.left = new TreeNode('B');
 root.right = new TreeNode('C');
 root.left.left = new 
TreeNode('D');
 root.left.right = new 
TreeNode('E');
 root.right.left = new 
TreeNode('F');
 root.right.right = new 
TreeNode('G');
List<Character> horizontalViewResult = 
horizontalView(root);
 // Printing the Horizontal View
 System.out.print("Horizontal 
View: ");
 for (char node : 
horizontalViewResult) {
 System.out.print(node + " ");
 }
 System.out.println();
 }
}

//Vertical View-----------------------------------------------------------------------------------
import java.util.*;
class TreeNode {
 char val;
 TreeNode left;
 TreeNode right;
 public TreeNode(char val) {
 this.val = val;
 left = null;
 right = null;
 }
}
public class Main {
 // Function to obtain the Vertical 
View of a binary tree
 public static List<Character> 
verticalView(TreeNode root) {
 List<Character> verticalView = 
new ArrayList<>();
if (root == null) {
 return verticalView;
 }
Map<Integer, List<Character>> verticalMap 
= new TreeMap<>();
 Queue<TreeNode> nodeQueue = new 
LinkedList<>();
 Queue<Integer> hdQueue = new 
LinkedList<>();
 nodeQueue.offer(root);
 hdQueue.offer(0);
while (!nodeQueue.isEmpty()) {
 TreeNode node = 
nodeQueue.poll();
 int hd = hdQueue.poll();
verticalMap.computeIfAbsent(hd, k -> new 
ArrayList<>()).add(node.val);
 if (node.left != null) {
 nodeQueue.offer(node.left);
 hdQueue.offer(hd - 1);
 }
if (node.right != null) {
 
nodeQueue.offer(node.right);
 hdQueue.offer(hd + 1);
 }
 }
 for (List<Character> values : 
verticalMap.values()) {
 verticalView.addAll(values);
 }
 return verticalView;
 }
 public static void main(String[] 
args) {
 // Sample binary tree input
 TreeNode root = new 
TreeNode('A');
 root.left = new TreeNode('B');
 root.right = new TreeNode('C');
 
root.left.left = new TreeNode('D');
 root.right.left = new 
TreeNode('E');
 root.right.right = new 
TreeNode('F');
 List<Character> 
verticalViewResult = verticalView(root);
 // Printing the Vertical View
 System.out.print("Vertical View: 
");
 for (char node : 
verticalViewResult) {
 System.out.print(node + " ");
 }
 System.out.println();
 }
}

//Left View------------------------------------------------------------------------------
import java.util.*;
class TreeNode {
 char val;
 TreeNode left;
 TreeNode right;
 public TreeNode(char val) {
 this.val = val;
 left = null;
 right = null;
 }
}
public class Main {
 // Function to obtain the Left View 
of a binary tree
 public static List<Character> 
leftView(TreeNode root) {
 List<Character> leftView = new 
ArrayList<>();
 
if (root == null) {
 return leftView;
 }
 Queue<TreeNode> nodeQueue = new 
LinkedList<>();
 nodeQueue.offer(root);
 while (!nodeQueue.isEmpty()) {
 int levelSize = 
nodeQueue.size();
 for (int i = 0; i < 
levelSize; i++) {
 TreeNode node = 
nodeQueue.poll();
 // Add the leftmost node 
at each level to the leftView list
 if (i == 0) {
leftView.add(node.val);
 }
 if (node.left != null) { 
nodeQueue.offer(node.left);
 }
if (node.right != null) {
 
nodeQueue.offer(node.right);
 }
 }
 }
 return leftView;
 }
 public static void main(String[] 
args) {
 // Sample binary tree input
 TreeNode root = new 
TreeNode('A');
 root.left = new TreeNode('B');
 root.right = new TreeNode('C');
 root.left.left = new 
TreeNode('D');
 root.left.right = new TreeNode('E');
 root.right.left = new 
TreeNode('F');
 root.right.right = new 
TreeNode('G');
 List<Character> leftViewResult = 
leftView(root);
 // Printing the Left View
 System.out.print("Left View: ");
 for (char node : leftViewResult) 
{
 System.out.print(node + " ");
 }
 System.out.println();
 }
}

//Right View------------------------------------------------------------------------------------
import java.util.*;
class TreeNode {
 char val;
 TreeNode left;
 TreeNode right;
 public TreeNode(char val) {
 this.val = val;
 left = null;
 right = null;
 }
}
public class Main {
 // Function to obtain the Right View 
of a binary tree
 public static List<Character> 
rightView(TreeNode root) {
 List<Character> rightView = new 
ArrayList<>();
 if (root == null) {
 return rightView;
 }
 Queue<TreeNode> queue = new 
LinkedList<>();
 queue.offer(root);
 while (!queue.isEmpty()) {
 int levelSize = queue.size();
 for (int i = 0; i < levelSize; 
i++) {
 TreeNode node = 
queue.poll();
 // Add the rightmost node 
at each level to the result
 if (i == levelSize - 1) {
 
rightView.add(node.val);
 }
if (node.left != null) 
{
queue.offer(node.left);
 }
if (node.right != null) {
 
queue.offer(node.right);
 }
 }
 }
 return rightView;
 }
 public static void main(String[] args) 
{
 // Sample binary tree input
 TreeNode root = new TreeNode('A');
 root.left = new TreeNode('B');
 root.right = new TreeNode('C');
 root.left.left = new 
TreeNode('D');
 root.left.right = new TreeNode('E');
 root.right.left = new 
TreeNode('F');
 root.right.right = new 
TreeNode('G');
 List<Character> rightViewResult = 
rightView(root);
 // Printing the Right View
 System.out.print("Right View: ");
 for (char node : rightViewResult) 
{
 System.out.print(node + " ");
 }
 System.out.println();
 }
}

//Top View---------------------------------------------------------------------------------
import java.util.*;
class TreeNode {
 char val;
 TreeNode left;
 TreeNode right;
 public TreeNode(char val) {
 this.val = val;
 left = null;
 right = null;
 }
}
class Pair {
 TreeNode node;
 int hd;
 public Pair(TreeNode node, int hd) {
 this.node = node;
 this.hd = hd;
 }
}
public class Main {
 // Function to obtain the Top View of 
a binary tree
 public static List<Character> 
topView(TreeNode root) {
 List<Character> topView = new 
ArrayList<>();
 if (root == null) {
 return topView;
 }
 Map<Integer, Character> 
verticalMap = new TreeMap<>();
 Queue<Pair> queue = new 
LinkedList<>();
 queue.offer(new Pair(root, 0));
 while (!queue.isEmpty()) {
 Pair pair = queue.poll();
 TreeNode node = pair.node;
 int hd = pair.hd;
 if 
(!verticalMap.containsKey(hd)) {
 verticalMap.put(hd, 
node.val);
 }
 if (node.left != null) {
 queue.offer(new 
Pair(node.left, hd - 1));
 }
 if (node.right != null) {
 queue.offer(new 
Pair(node.right, hd + 1));
 }
 }
 for (char nodeVal : 
verticalMap.values()) {
 topView.add(nodeVal);
 }
 return topView;
 }
 public static void main(String[] args) {
 // Sample binary tree input
 TreeNode root = new TreeNode('A');
 root.left = new TreeNode('B');
 root.right = new TreeNode('C');
 root.left.left = new 
TreeNode('D');
 root.right.left = new 
TreeNode('E');
 root.right.right = new 
TreeNode('F');
 List<Character> topViewResult = 
topView(root);
 // Printing the Top View
 System.out.print("Top View: ");
 for (char node : topViewResult) {
 System.out.print(node + " ");
 }
 System.out.println();
 }
}

//Bottom View---------------------------------------------------------------------
import java.util.*;
class TreeNode {
 char val;
 TreeNode left;
 TreeNode right;
 public TreeNode(char val) {
 this.val = val;
 left = null;
 right = null;
 }
}
class NodeInfo {
 TreeNode node;
 int hd;
 public NodeInfo(TreeNode node, int hd) 
{
 this.node = node;
 this.hd = hd;
 }
}
public class Main {
 // Function to obtain the Bottom View 
of a binary tree
 public static List<Character> 
bottomView(TreeNode root) {
 List<Character> bottomView = new 
ArrayList<>();
 if (root == null) {
 return bottomView;
 }
 Map<Integer, Character> bottomMap 
= new TreeMap<>();
 Queue<NodeInfo> nodeQueue = new 
LinkedList<>();
 nodeQueue.offer(new NodeInfo(root, 
0));
 while (!nodeQueue.isEmpty()) {
 NodeInfo info = 
nodeQueue.poll();
TreeNode node = info.node;
 int hd = info.hd;
 bottomMap.put(hd, node.val);
 if (node.left != null) {
 nodeQueue.offer(new 
NodeInfo(node.left, hd - 1));
 }
 if (node.right != null) {
 nodeQueue.offer(new 
NodeInfo(node.right, hd + 1));
 }
 }
 for (char value : 
bottomMap.values()) {
 bottomView.add(value);
 }
 return bottomView;
 }
 public static void main(String[] args) 
{
 
TreeNode root = new TreeNode('A');
 root.left = new TreeNode('B');
 root.right = new TreeNode('C');
 root.left.left = new 
TreeNode('D');
 root.right.left = new 
TreeNode('E');
 root.right.right = new 
TreeNode('F');
 root.right.right.right = new 
TreeNode('G');
 List<Character> bottomViewResult = 
bottomView(root);
 // Printing the Bottom View
 System.out.print("Bottom View: ");
 for (char node : bottomViewResult) 
{
 System.out.print(node + " ");
 }System.out.println();
 }}

//Vertical Order Traversal
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 public TreeNode(int val) {
 this.val = val;
 left = null;
 right = null;
 }
}
public class Main {
 // Function to perform Vertical Order 
Traversal of a binary tree
 public static List<List<Integer>> 
verticalOrderTraversal(TreeNode root) {
 List<List<Integer>> result = new 
ArrayList<>();
if (root == null) {
 return result;
 }
 Map<Integer, List<Integer>> 
verticalMap = new TreeMap<>();
 Queue<SimpleEntry<TreeNode, 
Integer>> nodeQueue = new LinkedList<>();
 nodeQueue.offer(new 
SimpleEntry<>(root, 0));
 while (!nodeQueue.isEmpty()) {
 SimpleEntry<TreeNode, 
Integer> entry = nodeQueue.poll();
 TreeNode node = 
entry.getKey();
 int col = entry.getValue(); 
verticalMap.computeIfAbsent(col, k -> new 
ArrayList<>()).add(node.val);
 if (node.left != null) {
 nodeQueue.offer(new 
SimpleEntry<>(node.left, col - 1));
 }
 if (node.right != null) {
    nodeQueue.offer(new 
   SimpleEntry<>(node.right, col + 1));
    }
    }
    for (List<Integer> values : 
   verticalMap.values()) {
    result.add(values);
    }
    return result;
    }
    public static void main(String[] args) {
    // Sample binary tree input
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
   root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    List<List<Integer>> 
   verticalOrderResult = 
   verticalOrderTraversal(root);
    // Printing the Vertical Order 
   Traversal result
    for (List<Integer> column : 
   verticalOrderResult) {
    for (int val : column) {
    System.out.print(val + " ");
    }
    System.out.println();
    }
    }
   }
   return horizontalView;
}
public static void main(String[] 
args) {
// Sample binary tree input
TreeNode root = new 
TreeNode('A');
root.left = new TreeNode('B');
root.right = new TreeNode('C');
root.left.left = new 
TreeNode('D');
root.left.right = new 
TreeNode('E');
root.right.left = new 
TreeNode('F');
root.right.right = new 
TreeNode('G');

List<Character> horizontalViewResult = 
horizontalView(root);
// Printing the Horizontal View
System.out.print("Horizontal 
View: ");
for (char node : 
horizontalViewResult) {
System.out.print(node + " ");
}
System.out.println();
}
}

//Hashset / Celebrity Problem -----------------------------------------------------------
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Creating a HashSet
        Set<String> set = new HashSet<>();

        // Adding elements
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");

        // Displaying the set
        System.out.println("Set elements: " + set);

        // Checking if set contains an element
        boolean containsBanana = set.contains("Banana");
        System.out.println("Contains 'Banana': " + containsBanana);
// Getting the size of the set
int setSize = set.size();
System.out.println("Set size: " + setSize);

// Checking if the set is empty
boolean isEmpty = set.isEmpty();
System.out.println("Is set empty: " + isEmpty);

// Iterating over elements in the set
System.out.println("Iterating over elements:");
for (String element : set) {
    System.out.println(element);
}

// Removing an element
set.remove("Orange");
System.out.println("Set elements after removal: " + set);
// Clearing the set
set.clear();
System.out.println("Set elements after clearing: " + set);

// Creating another set for set union, intersection, and difference
Set<String> set1 = new HashSet<>();
set1.add("Apple");
set1.add("Banana");

Set<String> set2 = new HashSet<>();
set2.add("Banana");
set2.add("Orange");

// Set Union
Set<String> union = new HashSet<>(set1);
union.addAll(set2);
System.out.println("Set Union: " + union);

// Set Intersection
Set<String> intersection = new HashSet<>(set1);
intersection.retainAll(set2);
System.out.println("Set Intersection: " + intersection);

// Set Difference
Set<String> difference = new HashSet<>(set1);
difference.removeAll(set2);
System.out.println("Set Difference: " + difference);
}
}


//Topological Sort - Kahn's Algo -  DAG-------------------------------------------
import java.util.*;
class Graph {
    private Map<Integer, List<Integer>> adjacencyList;
    private int vertices;
    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            this.adjacencyList.put(i, new ArrayList<>());
        }
    }
    public void createEdge(int u, int v) {
        this.adjacencyList.get(u).add(v);
    }
    public void topologicalSort() {
        int[] totalIndegree = new int[vertices];
       for (int i = 0; i < vertices; i++) {
            for (int j : adjacencyList.get(i)) {
                totalIndegree[j]++;
            }}
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < vertices; i++) {
                if (totalIndegree[i] == 0) {
                    queue.add(i);
                }
            }
            int visitedNodes = 0;
            List<Integer> order = new ArrayList<>();
    
            while (!queue.isEmpty()) {
                int u = queue.poll();
                order.add(u);
    
                for (int i : adjacencyList.get(u)) {
                    totalIndegree[i]--;
    
                    if (totalIndegree[i] == 0) {
                        queue.add(i);
                    }
                }
                visitedNodes++;
            }
            if (visitedNodes != vertices) {
                System.out.println("There's a cycle present in the Graph.\nGiven graph is not DAG");
            } else {
                System.out.println(order);
            }
        }
    
        public static void main(String[] args) {
            Graph graph = new Graph(6);
            graph.createEdge(0, 1);
            graph.createEdge(0, 2);
            graph.createEdge(1, 3);
            graph.createEdge(1, 5);
            graph.createEdge(2, 3);
            graph.createEdge(2, 5);
            graph.createEdge(3, 4);
            graph.createEdge(5, 4);
    
            graph.topologicalSort();
        }
    }

    //Recover BST - Morris
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
        this.val = val;
        }
       }
       public class Main {
        TreeNode firstIncorrectNode = null;
        TreeNode secondIncorrectNode = null;
        TreeNode prevNode = null;
        public void recoverTree(TreeNode 
       root) {
        TreeNode current = root;
        TreeNode temp;
        while (current != null) {
            if (current.left == null) {
            // Process current node
            if (prevNode != null && 
           prevNode.val >= current.val) {
            if 
           (firstIncorrectNode == null) {
            
           firstIncorrectNode = prevNode;
            }
            secondIncorrectNode 
           = current;
            }
            prevNode = current;
            current = current.right;
            } else {
            // Find the inorder predecessor
            temp = current.left;
 while (temp.right != 
null && temp.right != current) {
 temp = temp.right;
 }
 if (temp.right == null) 
{
 // Set the right 
pointer to enable returning to the 
current node
 temp.right = current;
 current = current.left;
 } else {
 // Restore the right 
pointer and process current node
 temp.right = null;
 if (prevNode != null && prevNode.val >= 
current.val) {
 if 
(firstIncorrectNode == null) {
 
firstIncorrectNode = prevNode;
 }
 
secondIncorrectNode = current;
 }
 prevNode = current;
 current = 
current.right;
 }
 }
 }
 // Swap the values of the two incorrectly placed nodes
 int tempVal = firstIncorrectNode.val;
 firstIncorrectNode.val = 
secondIncorrectNode.val;
 secondIncorrectNode.val = 
tempVal;
 }
 public static void main(String[] 
args) {
 // Create a sample binary search 
tree with 5 numbers (incorrect order)
 TreeNode root = new TreeNode(3);
 root.left = new TreeNode(1);
 root.right = new TreeNode(5);
 root.right.left = new 
TreeNode(2);
 root.right.right = new 
TreeNode(4);
Main solution = new Main();
 solution.recoverTree(root);
 // Print the inorder traversal 
of the recovered BST
 System.out.println("Inorder 
Traversal of Recovered BST:");
 printInorder(root);
 }
 // Helper function to print the 
inorder traversal of a tree
 private static void 
printInorder(TreeNode node) {
 if (node == null) return;
 printInorder(node.left);
 System.out.print(node.val + " 
");
 printInorder(node.right);
 }
}

//LCS--------------------------------------------------------------------------------------
public class LongestCommonSubsequence {

    public static String findLCS(String A, String B) {
        int m = A.length();
        int n = B.length();

        int[][] lcsLength = new int[m + 1][n + 1];
        // Build the lcsLength table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    lcsLength[i][j] = 0;
                } else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    lcsLength[i][j] = 1 + lcsLength[i - 1][j - 1];
                } else {
                    lcsLength[i][j] = Math.max(lcsLength[i - 1][j], lcsLength[i][j - 1]);
                }
            }
        }
// Reconstruct the LCS
        int i = m, j = n;
        StringBuilder lcs = new StringBuilder();
        while (i > 0 && j > 0) {
            if (A.charAt(i - 1) == B.charAt(j - 1)) {
        lcs.insert(0, A.charAt(i - 1));
                i--;
                j--;
            } else if (lcsLength[i - 1][j] > lcsLength[i][j - 1]) {
                i--;
            } else {
                j--;      }  }
                return lcs.toString();
            }
        
            public static void main(String[] args) {
                String A = "ABCD";
                String B = "ACEDF";
        
                String lcs = findLCS(A, B);
                System.out.println("Longest Common Subsequence: " + lcs);
            }
        }
        
//Heap Sort-----------------------------------------------------------------------------
class HeapSort {
    static void heapify(int a[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && a[left] > a[largest])
            largest = left;
        if (right < n && a[right] > a[largest])
            largest = right;
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            heapify(a, n, largest);
        }
    }
    static void heapSort(int a[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--)
                  heapify(a, n, i);
      
              for (int i = n - 1; i >= 0; i--) {
                  int temp = a[0];
                  a[0] = a[i];
                  a[i] = temp;
      
                  heapify(a, i, 0);
              }
          }
      
          static void printArr(int a[], int n) {
            for (int i = 0; i < n; ++i)
            System.out.print(a[i] + " ");
    }

    public static void main(String args[]) {
        int a[] = {35, 17, 10, 90, 24, -3, -8};
        int n = a.length;

        System.out.println("Original Array:");
        printArr(a, n);

        heapSort(a, n);

        System.out.println("\nSorted Array:");
        printArr(a, n);
    }
}


//Distributing items - brute ------------------------------------------------------------------------------
import java.io.*;

public class Main {

    static boolean checkCount(int[] arr, int n, int k) {
        int count;
   // Start traversing the elements
        for (int i = 0; i < n; i++) {

   // Count occurrences of current element
            count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == arr[i])
                    count++;
                    // If count of any element is greater than 2*k then return false
                if (count > 2 * k)
                return false;
        }
    }

    return true;
}

public static void main(String[] args) {
    int[] arr = { 1, 1, 2, 3, 1 };
    int n = arr.length;
    int k = 2;
System.out.println(checkCount(arr, n, k));
}
}


//Distributing items - optimised-----------------------------------------------------------------------------------
import java.util.HashMap;
import java.util.Map;
class Main
{
	static boolean checkCount(int arr[], int n, int k)
	{
	HashMap <Integer, Integer> hash = new HashMap<>();
		// Maintain a hash
		for (int i = 0; i < n; i++)
		{
			if (!hash.containsKey(arr[i]))
				hash.put(arr[i], 0);
			hash.put(arr[i], hash.get(arr[i]) + 1);
		}
// Check for each value in hash
for (Map.Entry x : hash.entrySet())
if ((int)x.getValue() > 2 * k)
    return false;

 return true;
}
public static void main(String []args)
{
    int []arr = { 1, 1, 2, 3, 1 };
    int n = arr.length;
    int k = 2;
System.out.println(checkCount(arr, n, k));
}
}

//Dial Algo-shortest path in weighted graph---------------------------------------------------------
import java.util.*;
class Graph {
    private int V;
    private List<List<Node>> adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }
    public void addEdge(int source, int destination, int weight) {
        Node node = new Node(destination, weight);
        adj.get(source).add(node);
    }
    public void dijkstra(int startVertex) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[startVertex] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(V, Comparator.comparingInt(node -> node.weight));
        pq.add(new Node(startVertex, 0));
while (!pq.isEmpty()) {
            int currentVertex = pq.poll().vertex;
            for (Node neighbor : adj.get(currentVertex)) {
                int newDist = distance[currentVertex] + neighbor.weight;
                if (newDist < distance[neighbor.vertex]) {
                    distance[neighbor.vertex] = newDist;
                       pq.add(new Node(neighbor.vertex, newDist));
                                  }
                              }
                          }
                  // Print the distances
                  System.out.println("Vertex\tDistance from Source");
                          for (int i = 0; i < V; i++) {
                              System.out.println(i + "\t" + distance[i]);
                          }
                      }
                  static class Node {
                          int vertex;
                          int weight;
                       public Node(int vertex, int weight) {
                        this.vertex = vertex;
            this.weight = weight;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int source = 0; // Source vertex
        Graph graph = new Graph(V);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 1);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(3, 4, 4);
        graph.addEdge(4, 2, 1);

        graph.dijkstra(source);
    }
}

//Boundary Traversal-----------------------------
class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int value) {
        val = value;
        left = right = null;
    }
}

public class BinaryTreeBoundaryTraversal {

    private static void printLeaves(TreeNode root) {
        if (root != null) {
            printLeaves(root.left);
            if (root.left == null && root.right == null) System.out.print(root.val + " ");
            printLeaves(root.right);
        }
    }
public static void boundaryTraversal(TreeNode root) {
    if (root != null) {
        System.out.print(root.val + " ");
        printLeaves(root.left);
printLeaves(root.right);
    }
}

public static void main(String[] args) {
    // Constructing the example tree
    TreeNode root = new TreeNode(8);
    root.left = new TreeNode(3);
    root.right = new TreeNode(10);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(6);
    root.left.right.left = new TreeNode(4);
    root.left.right.right = new TreeNode(7);
    root.right.right = new TreeNode(14);
    root.right.right.left = new TreeNode(13);

    // Calling the boundaryTraversal function
    boundaryTraversal(root);
}
}

//BFS-------------------------------------------------------
import java.util.*;
public class Graph {
  private int V;
  private LinkedList<Integer> adj[];
  // Create a graph
  Graph(int v) {
    V = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i)
      adj[i] = new LinkedList();
  }
  // Add edges to the graph
  void addEdge(int v, int w) {
    adj[v].add(w);
  }
  // BFS algorithm
  void BFS(int s) {
    boolean visited[] = new boolean[V];
    LinkedList<Integer> queue = new LinkedList();
    visited[s] = true;
    queue.add(s);
    while (queue.size() != 0) {
      s = queue.poll();
      System.out.print(s + " ");
      Iterator<Integer> i = adj[s].listIterator();
while (i.hasNext()) {
        int n = i.next();
        if (!visited[n]) {
          visited[n] = true;
          queue.add(n);
        }
      }
    }
  }
  public static void main(String args[]) {
    Graph g = new Graph(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

    g.BFS(2);
  }
}

//DFS----------------------------------------------------------
import java.util.*;
class Graph {
  private LinkedList<Integer> adjLists[];
  private boolean visited[];
  // Graph creation
  Graph(int vertices) {
    adjLists = new LinkedList[vertices];
    visited = new boolean[vertices];
    for (int i = 0; i < vertices; i++)
      adjLists[i] = new LinkedList<Integer>();
  }
     // Add edges
     void addEdge(int src, int dest) {
        adjLists[src].add(dest);
      }// DFS algorithm
      void DFS(int vertex) {
        visited[vertex] = true;
    System.out.print(vertex + " ");
        Iterator<Integer> ite = adjLists[vertex].listIterator();
        while (ite.hasNext()) {
          int adj = ite.next();
          if (!visited[adj])
            DFS(adj);
        }  }
        public static void main(String args[]) {
            Graph g = new Graph(4);
        
            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 2);
            g.addEdge(2, 3);
        
            System.out.println("Following is Depth First Traversal");
        
            g.DFS(2);
          }
        }

//Bellman Ford-negative edge weights------------------------------------------
public class Main {
    static class CreateGraph {
        class CreateEdge {
            int src, dest, weight;
            CreateEdge(int src, int dest, int weight) {
                this.src = src;
                this.dest = dest;
                this.weight = weight;
            }
        }
        int V, E;
        CreateEdge edge[];
        CreateGraph(int v, int e) {
            V = v;
            E = e;
            edge = new CreateEdge[e];
        }
        void BellmanFord(int src) {
            int dist[] = new int[V];
            for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;
            dist[src] = 0;
   for (int i = 1; i < V; ++i) {
    for (int j = 0; j < E; ++j) {
      int u = edge[j].src;
         int v = edge[j].dest;
            int w = edge[j].weight;
             if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
            dist[v] = dist[u] + w;
                }
            }
      for (int j = 0; j < E; ++j) {
                int u = edge[j].src;
                int v = edge[j].dest;
                int w = edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {                   System.out.println("Graph contains negative weight cycle");
                      return;
                      }
                  }
                  printSolution(dist);
              }
              void printSolution(int dist[]) {
                  System.out.println("Vertex Distance from Source");
                  for (int i = 0; i < V; ++i)
      System.out.println(i + "\t\t" + dist[i]);
              }
          }
      public static void main(String[] args) {
              int V = 5;
              int E = 7;
              CreateGraph graph = new CreateGraph(V, E);
        graph.edge[0] = graph.new CreateEdge(0, 1, 5);
        graph.edge[1] = graph.new CreateEdge(0, 2, 4);
        graph.edge[2] = graph.new CreateEdge(1, 3, 3);
        graph.edge[3] = graph.new CreateEdge(2, 1, 6);
        graph.edge[4] = graph.new CreateEdge(3, 2, 2);
        graph.edge[5] = graph.new CreateEdge(1, 4, -4);
        graph.edge[6] = graph.new CreateEdge(4, 2, 2);
        graph.BellmanFord(0); // 0 is the source vertex
    }}
//Fetch codes---------------------------------
import java.util.*;
import java.net.URL;

class Main{
    public static void main (String args[] ) throws Exception{
        Scanner s = new Scanner (new URL("https://bsts1.tiiny.site/").openStream());
        while (s.hasNextLine()){
            System.out.println(s.nextLine());
            
        }
      s.close();
}
}
