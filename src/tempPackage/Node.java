package tempPackage;

public class Node {
 int key;
    Node left, right;
    int depth=-5;
    public Node(int item)
    {
        key = item;
        left = right = null;
    }
    public Node(int item,int depthVal)
    {
        key = item;
        left = right = null;
        depth=depthVal;
    }
    
	}
