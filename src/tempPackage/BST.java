package tempPackage;

class BST {
	
	//TODO like 90% of these classes are public for absolutly no good reason but like does that really matter
	//probably should fix b4 i submit tho
	//haha dont forget to do that will
	
	//TODO make a method that returns the depth of the tree

	//what needs to be public:
	//search
	//remove
	//insert (demoinsert?)
	//betaTestingClear
	//printTree
	//isBSTOrNot
	//isAVL


	//TODO i really should delete the commented out code i have like 700 lines of just dead commented out code
	// im sure it affects execution time too but like, im sure its probably fine, yeah.
	Node root=null;
	Boolean doBalance=true;
	public Boolean setBal(Boolean val) {
		doBalance=val;
		return doBalance;
	}
    public BST()
    {
        root = null;
    }
   
    public void betaTestingClear() {
    	root=null;
    	
    }
    public int deepestDepth=0;
    public void uDepth(int depth) {
    	if(depth>deepestDepth) {
    		deepestDepth=depth;
    	}
    }
    
    //Do I Still Need To Balance
    public boolean DoIStillNeedToBalance(Node target) {
    	if (balanceValue(target) != 0) {
    		return true;
    	}
    	return false;
    }
    //The younger and more resourceful brother of DoIStillNeedToBalance, as this one actually helps balance
   public Node balanceMe(Node target) {
	   	//Target is parent NOT
	   System.out.println("attempting to balance " + target.key);
	  
	   //sometimes i feel like i wrote a whole function to stop me having to repeat all these if statements to check for children
	   //its like i can still hear its voice sometimes...
	   
	   //TODO FIX THAT, DAMN....
	   
        if (balanceValue(target) < -1) {
        	//Negative Result
            if (balanceValue(target.right) > 0) {
            	target.right = balanceRight(target.right);
            }
            target=balanceLeft(target);
        }
        
        else if (balanceValue(target) > 1) {
        	//Positive Result
            if (balanceValue(target.left) < 0) {
            	target.left = balanceLeft(target.left);
            }
            target=balanceRight(target);
        }
        return target;
    }
   //god i gotta get better at naming things
   //getLeafNodes => finds all the leaf nodes below the target, and balance upwards
   public Node getLeafNodes(Node target)
   {
         
       if (target == null)
           return null;
       // If node is leaf node, print its data    
       if (target.left == null &&
    		   target.right == null)
       {
    	    leafBal(target);
    	   	return target;
       }
         
       // If left child exists, check for leaf
       // recursively
       if (target.left != null)
    	   getLeafNodes(target.left);
             
       // If right child exists, check for leaf
       // recursively
       if (target.right != null)
    	   getLeafNodes(target.right);
       return null;
   }
   
   
   
   //this is a little better but like, goodness
   	public Node leafBal(Node target) {
   		Node extraTmp= target;
   		do {
			Node tmpParent= search_Alt(extraTmp.key).getParent();
			if (tmpParent.key > target.key) {
				tmpParent.left=balanceMe(tmpParent.left);
			}
			else if (tmpParent.key < target.key){
				tmpParent.right=balanceMe(tmpParent.right);
			}
			extraTmp=tmpParent;
			root=balanceMe(root);
		} while(search_Alt(extraTmp.key).getNode().key!=root.key);
   		root=balanceMe(root);
   		return target;
   	}
   	
   	
   	//Like Nicotine to a West Virginian, insertHelpter is a critical part of the lifecycle of insert
   	//probably like the most scuffed code ive ever written
	//but it works
   	
   	//My seemingly arbitrary use of recursion vs regualar looping is still something that baffles me
   	//i probably should fix but it works rn so like...
    private void insertHelper(int key, Node node) {
    	//this entire thing feels really really dumb but it works so i mean, thats nice
    	
    	if (root == null) {
    		root = new Node(key,0);
    		root=balanceMe(root);
			//added root
    		return;
    	}
    	Node tempNode = node;
    	//Node tmpParent = tempNode;
    	if(findNode(key,node)) {
    		//duplicate, ignoring
    		//no adding dupe
    		//no adding repeats
    		return;
    	}
    	int tempDepth=node.depth+1;
    	while(true) {
			//if right, left -> need double
			//if left, right -> need double
	    	if(key < tempNode.key) { ///to theleft
	    		if(tempNode.left==null) {
	    			tempNode.left=new Node(key,tempDepth);
	    			uDepth(tempDepth);
	    			//System.out.println("added "+ tempNode.left.key+ " as left node to " + tempNode.key + ", depth: " + tempDepth);
	    			Node extraTmp= tempNode;
//	    			if(lastDir=="right") {
//	    				System.out.println("Swag right");
//	    				Node tmpParent= search_Alt(extraTmp.key).getParent();
//	    				//need to double, was "right -> left" case
//	    				tmpParent.right = balanceRight(tmpParent.right);
//	    				Node ejfiefe = search_Alt(tmpParent.key).getParent();

	    				///WTF. "wjfiefe".....
    			
//	    				if (ejfiefe.key > tmpParent.key) {
//	    					ejfiefe.left=balanceMe(ejfiefe.left);
//		    			}
//	    				else if (ejfiefe.key < tmpParent.key){
//	    					ejfiefe.right=balanceMe(ejfiefe.right);
//		    			}
//	    				//getLeafNodes(root);
//	    				root=balanceMe(root);
//		    			return;
//	    			}
//	    			
	    			if(doBalance) {
			    			do {
				    			Node tmpParent= search_Alt(extraTmp.key).getParent();
				    			if (tmpParent.key > tempNode.key) {
				    				tmpParent.left=balanceMe(tmpParent.left);
				    			}
				    			else if (tmpParent.key < tempNode.key){
				    				tmpParent.right=balanceMe(tmpParent.right);
				    			}
				    			extraTmp=tmpParent;
				    			root=balanceMe(root);
				    			
			    			}while(search_Alt(extraTmp.key).getNode().key!=root.key);
			    			getLeafNodes(root);
	    			}
	    			return;
	    		}
	    		else {
	    			//tmpParent=tempNode;
	    			tempNode=tempNode.left;
	    			tempDepth+=1;
	    		}
	    			
	    	}
	    	if(key > tempNode.key) { //to the right
	    		if(tempNode.right==null) {
	    			tempNode.right=new Node(key,tempDepth);
	    			uDepth(tempDepth);
	    			//System.out.println("added "+ tempNode.right.key+ " as right node " + tempNode.key + ", depth: " + tempDepth);
	    			Node extraTmp= tempNode;
	    			if(doBalance) {
			    			do {
				    			Node tmpParent= search_Alt(extraTmp.key).getParent();
				    			if (tmpParent.key > tempNode.key) {
				    				tmpParent.left=balanceMe(tmpParent.left);
				    			}
				    			else if (tmpParent.key < tempNode.key){
				    				tmpParent.right=balanceMe(tmpParent.right);
				    			}
				    			extraTmp=tmpParent;
				    			root=balanceMe(root);
			    			} while(search_Alt(extraTmp.key).getNode().key!=root.key);
			    			
			    			getLeafNodes(root);
			    			//getLeafNodes(root);
	    			}
	    			return;
	    		}
	    		else {
	    			//tmpParent=tempNode;
	    			tempNode=tempNode.right;
	    			tempDepth+=1;
	    		}

	    	}
    	}

    }
    void insert(int key){
    	insertHelper(key,root);
    }
    
    
	private boolean findNode(int key, Node node) {
		if(node == null)
			   return false;
		if(node.key==key) {
			return true;
		}
		
		if(key < node.key) {
			if(node.left!=null) {
			return findNode(key, node.left);
			}
		}
		if(key > node.key) {
			if(node.right!=null) {
			return findNode(key, node.right);
			}
		}
		

		return false;
	}
	
	private tmpReturner findNode_alt(int key, Node node, Node parent) {
		if(node == null)
			   return null;
		if(node.key==key) {
			return new tmpReturner(node, parent, true);
		}
		
		if(key < node.key) {
			if(node.left!=null) {
			return findNode_alt(key, node.left, node);
			}
		}
		if(key > node.key) {
			if(node.right!=null) {
			return findNode_alt(key, node.right,node);
			}
		}
		

		return null;
	}
	
//	public ArrayList<String> getKeys(Node node) {
//    	ArrayList<String> theKeys = new ArrayList<String>();
//    	theKeys=getKeysHelper(node, theKeys);
//    	//System.out.println("THE KEYS ::: " + theKeys.toString());
//    	return theKeys;
//    }
//	private ArrayList<String> getKeysHelper(Node node, ArrayList<String> keyList){
//    	if (node==null)
//			   return keyList;
//    			//ignore null node
//    	else {
//    		if(keyList.contains(node.key)) {
//    			return keyList;
//    			//ignore dupe
//    		}
//    		
//    			keyList.add(Integer.toString(node.key));
//				if(node.left!=null) {
//					keyList= getKeysHelper(node.left,keyList);
//				}
//				if(node.right!=null) {	
//					keyList= getKeysHelper(node.right,keyList);
//				}
//				
//    		}
//    	return keyList;
//    		
//    }
	
	
    boolean search(int key){
		System.out.println(root);
    	if(key==root.key) 
    		return true;
    	else 
    		return findNode(key,root);
    }
    //this code makes physically and viscerally ill. all the TODO 's and the FIXME 's in the world couldn't help
    //so i leave this comment as a reminder of my failures and wrongdoings, with the hope that one day such a
    //monstrosity never again rears its ugly head
    public tmpReturner search_Alt(int key){
    	System.out.println(key);
    	
    	//she functionin' on my oriented object till i execute successfully 
    	tmpReturner tmp = findNode_alt(key,root,root);
    	//System.out.println(tmp.getNode().key);
    	if(tmp.getNode().key==root.key) 
    		return tmp;
    	else 
    		return findNode_alt(key,root,root);
    }
    
    
    //hehe object in an object 
    final class tmpReturner {
        private final Node node;
        private final Node parent;
        private final Boolean tmp;

        public tmpReturner(Node node, Node parent, Boolean tmp) {
            this.node = node;
            this.parent = parent;
            this.tmp = tmp;
        }

        public Node getNode() {
            return node;
        }
        public Boolean getTmp() {
            return tmp;
        }

        public Node getParent() {
            return parent;
        }
    }
    
    
    
    // WHY WHY WHY WHY WHY WHY WHY WHY WHY WHY WHY WHY WHY WHY WHY WHY WHY WHY WHY WHY WHY 
    // AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGGGGGHHHHHHHHHH
	// WHAT HEINOUS AND APPALLING SINS MUST I HAVE COMMITTED IN A PAST LIFE TO WARRANT SUCH A CRUEL PUNISHMENT
	// AAAAAAAHHHHHH I HATE BINARY SEARCH TREES 
	
		//    private tmpReturner removeHelperFarRight(Node node,Node parent,Boolean tmp) {
		//    	System.out.println("____tmpReturner Run____");
		//    	System.out.println(node.key + " : Node ");
		//    	System.out.println(tmp + " : tmp");
		//    	if(tmp==true) {
		//    		System.out.println("returning A: " + node.key);
		//    		tmp=true;
		//    		System.out.println(node.key + " <--node key -->"+tmp);
		//    		return new tmpReturner(node, parent, tmp);
		//    	}
		//    	if(node.right==null) {
		//    		System.out.println(node.key + " <--node ___ key -->"+tmp);
		//    		//System.out.println(node.key + " far right node");
		//    		//System.out.println(parent.key + " far right node parent");
		//    		if(node.left!=null) {
		//    			//node.left.depth+=1;
		//    			parent.right=node.left;
		//    			//System.out.println(parent.left);
		//    			//System.out.println(parent.right.key);
		//    			//System.out.println("returning B: " + node.key);
		//    			tmp=true;
		//    			System.out.println(node.key + " <--node () key -->"+tmp);
		//    			return new tmpReturner(node, parent, tmp);
		//    		}
		//    		//System.out.println("returning C: " + node.key);
		//    		tmp=true;
		//    		System.out.println(node.key + " <--node key -->"+tmp);
		//    		return new tmpReturner(node, parent, tmp);
		//    	}
		//    	else
		//    	{
		//    		System.out.println(node.key + " <--node key -->"+tmp);
		//    		//hits here with 2 -- false
		//    		//recurs with 13, 2, false
		//    		//hits node right null and passes
		//    		//tmp=true
		//    		return removeHelperFarRight(node.right,node,tmp);
		//    	}
		//    	//System.out.println("YOU SHOULD NEVER SEE THIS!! (Actually you might still see this dont worry");
		//    	//System.out.println("returning D: " + node.key + " plus " + tmp);
		//    	
		//    	
		//    	//its ignoring the earlier returns
		//    	
		//    }
		//    
		//  |
		//  |
		// \|/ This one Actually works nicely, was just being dumb lol 

    //TODO balance after removal, shouldn't be too hard, right? 
    
    //right...?
    
    //its the helper to the remove function, idk what else there is to explain
	private int removeHelper(int key, Node node, Node parent) {
    	Node nodeLeft, nodeRight;
    	nodeLeft=node.left;
    	nodeRight=node.right;
    	boolean isRightChild=false;
    	
    	if(node!=root) {
    		if(parent.right==node) {
    			//is right Child
    			isRightChild=true;
    		}
    	}
    	if(nodeLeft==null && nodeRight==null) {
    		//System.out.println("no children node: removing... ");
    		//has no children
    		if(key==root.key){
    			//System.out.println("cleared root");
				root = null;
			
				//removeBalance(root);
				root=balanceMe(root);
				getLeafNodes(root);
				return key;
			}
    		else {
    			if(isRightChild) {
    				parent.right=null;
    				//removeBalance(parent);
    				root=balanceMe(root);
    				getLeafNodes(root);
    				return key;
    			}
    			else {
    				parent.left=null;
    				//removeBalance(parent);
    				root=balanceMe(root);
    				getLeafNodes(root);
    				return key;    				
    			}
    		}
    	} //end of no children
    	
    	else if(nodeLeft==null) {
    		//System.out.println("no left node: removing... ");
    		//has child on right
    		if(key==root.key){
    			//is root
    			//System.out.println("root replaced: no left");
    			root.depth=0;
				root = root.right;
				//removeBalance(root);
				root=balanceMe(root);
				getLeafNodes(root);
				
				return key;
			}
    		else {
    			if(isRightChild) {
    				node.right.depth--;
    				parent.right=node.right;
    				root=balanceMe(root);
    				getLeafNodes(root);
    				return key;
    			}
    			else {
    				node.right.depth--;
    				parent.left=node.right;
    				root=balanceMe(root);
    				getLeafNodes(root);
    				return key;    				
    			}
    		}
    	} //end of has right child
    	
    	else if(nodeRight==null) {
    		//System.out.println("no right node: removing... ");
    		//has child on left
    		if(key==root.key){
    			//is root
    			//System.out.println("root replaced: no right");
				root = root.left;
				root.depth=0;
				//removeBalance(root);
				root=balanceMe(root);
				getLeafNodes(root);
				return key;
			}
    		else {
    			
    			if(isRightChild) {
    				node.left.depth--;
    				parent.right=node.left;
    				root=balanceMe(root);
    				getLeafNodes(root);
    				return key;
    			}
    			else {
    				node.left.depth--;
    				parent.left=node.left;
    				root=balanceMe(root);
    				getLeafNodes(root);
    				return key;    				
    			}
    		}
    	} //end of has right child
    	
    	else if(nodeRight!=null && nodeLeft!=null) {
    		//System.out.println("2wo children node: removing... ");
    		//has 2 children
    		Node smallNode = smallestNodeRightSide(node);
    		if(key==root.key) {
    			//removing root
    			//Node tmp=root;
    			//System.out.println("root replaced");
    			root=smallNode;
    			root.depth=0;
    			smallNode.left=node.left;
    			//removeBalance(smallNode);
    			root=balanceMe(root);
    			getLeafNodes(root);
    			return key;
    		}
    		else {
    			
    			if(isRightChild) {
    				smallNode.depth=parent.depth+1;
    				parent.right=smallNode;
    				smallNode.left=node.left;
    				//removeBalance(smallNode);
    				root=balanceMe(root);
    				getLeafNodes(root);
    				return key;
    			}
    			else {
    				smallNode.depth=parent.depth+1;
    				parent.left=smallNode;
    				smallNode.left=node.left;
    				//removeBalance(smallNode);
    				root=balanceMe(root);
    				getLeafNodes(root);
    				return key;    				
    			}
    		}	
    	}
    	root=balanceMe(root);
    	getLeafNodes(root);
    	return -1;
    }
	
	public boolean isAVL() {
        return isAVL(root);
    }
	private boolean isAVL(Node x) {
        if (x == null) return true;
        int bf = balanceValue(x);
        if (bf > 1 || bf < -1) return false;
        return isAVL(x.left) && isAVL(x.right);
    }

	public Node removeBalance(Node tempNode) {
		Node extraTmp= tempNode;
		if(doBalance) {
				if(tempNode!=root) {
				do {
	    			Node tmpParent= search_Alt(extraTmp.key).getParent();
	    			if (tmpParent.key > tempNode.key) {
	    				tmpParent.left=balanceMe(tmpParent.left);
	    			}
	    			else if (tmpParent.key < tempNode.key){
	    				tmpParent.right=balanceMe(tmpParent.right);
	    			}
	    			extraTmp=tmpParent;
	//    			Node tempRoot=root;
	    			root=balanceMe(root);
				}while(search_Alt(extraTmp.key).getNode().key!=root.key);
				}
				getLeafNodes(root);
		}
		return extraTmp;
	}
			
	public Node smallestNodeRightSide(Node nodeToDel){
		Node smallNode =null;
		Node parent_ofSmallNode =null;
		Node workingNode = nodeToDel.right;
		while(workingNode != null){
			parent_ofSmallNode = smallNode;
				smallNode =workingNode;
			workingNode= workingNode.left;
		}

		//if has right child, make it left child of parent! :)
		if(smallNode!=nodeToDel.right){
			parent_ofSmallNode.left =smallNode.right;
			smallNode.right = nodeToDel.right;
		}
		return smallNode;
	}
	
    int remove(int key){
    	if (root==null){
    		//System.out.println("no tree, can't remove");
    		return -1;
    	}
    	else if(search(key)==false)  {
    		//System.out.println("key not in tree, can't remove");
    		return -1;
    	}
    	else {
    		//System.out.println(key + " was removed from the tree");
    		tmpReturner valuesIWant =search_Alt(key);
    		key = removeHelper(key,valuesIWant.getNode(),valuesIWant.getParent());
    		return key;
    	}
    	
    	
    }
  protected int updatedDepth(Node theNode) {
	  if (theNode.left!=null) {
		  return theNode.left.depth-1;
	  }
	  if (theNode.right!=null) {
		  return theNode.right.depth-1;
	  }
	  
	  return -5;
  }
  public Node balanceRootRight() {
	  Node bkupRoot = root;
	  if (root.left != null) {
	    root = root.left;
	    root.depth=0;
	  }
	  bkupRoot.left = root.right;
	  
	  root.right = bkupRoot;

	  refreshDepths();
	  
	  return bkupRoot;
	}
  
  public Node balanceRootLeft() {
	  Node bkupRoot = root;
	  if (root.right != null) {
	    root = root.right;
	    root.depth=0;
	  }
	  bkupRoot.right = root.left;
	  
	  root.left = bkupRoot;

	  refreshDepths();
	  
	  return bkupRoot;
	}
  
	 public Node balanceRight(Node targetNode) {
		  Node resultNode = targetNode.left;
		  //fake_root = fake_root.left;
		  Node temp = resultNode.right;
		  
		  resultNode.right=targetNode;
		  targetNode.left=temp;
		  
		  updateDepthSingle(targetNode);
		  updateDepthSingle(resultNode);
		  ///DOES ITS JOB I think but loses the stuff??
		  
		  return resultNode;
	}
	 
	public Node balanceLeft(Node targetNode) {
		  Node resultNode = targetNode.right;
		  //fake_root = fake_root.left;
	  Node temp = resultNode.left;
	  
	  resultNode.left=targetNode;
	  targetNode.right=temp;
	  
	  updateDepthSingle(targetNode);
	  updateDepthSingle(resultNode);
	  ///DOES ITS JOB I think but loses the stuff??
		  
		  return resultNode;
	}
  
 
  public int betaGetheight(Node n) {
	  if (n==null)
		  return -1;
	  else 
		  return n.depth;
	  
  }
  
  
  /*
   * If Positive: Left Side Too Heavy -> BalanceRight
   * If Negative: Right Side Too Heavy -> BalanceLeft
   * If 0: Balanced
   */
  public int balanceValue(Node x) {
	  System.out.println(maxDepth(x.left) - maxDepth(x.right));
      return maxDepth(x.left) - maxDepth(x.right);
  }
  
  
  public int maxDepth(Node node) 
  {
      if (node == null)
          return -1;
      else 
      {
          int leftDepth = maxDepth(node.left);
          int rightDepth = maxDepth(node.right);

          if (rightDepth > leftDepth)
              return (rightDepth + 1);
           else 
              return (leftDepth + 1);
      }
  }
  final class MauryHelper {
      private final Boolean hasChildren;
      private final Boolean rightChild;
      private final Boolean leftChild;

      public MauryHelper(Boolean hasChildren, Boolean rightChild, Boolean leftChild) {
          this.hasChildren = hasChildren;
          this.rightChild = rightChild;
          this.leftChild = leftChild;
      }
      
      public Boolean hasChildren() {
          return hasChildren;
      }
      
      public Boolean hasRight() {
          return rightChild;
      }

      public Boolean hasLeft() {
          return leftChild;
      }
  }

  
  protected MauryHelper theMauryShow(Node putativeFather) {
	  //The 21st century revival that absolutely no one wanted.... 
	  
	  Boolean hasAChild=false;
	  Boolean leftChild=false;
	  Boolean rightChild=false;
	  if(putativeFather !=null) {
		if(putativeFather.left !=null) {
			//in the case of little "Node.left", Node... YOU ARE THE FATHER!!
			hasAChild = true;
			leftChild = true;
		}
		if(putativeFather.right != null) {
			//in the case of young "Node.right", Node... YOU ARE THE FATHER!!
			hasAChild = true;
			rightChild = true;
		}
		//"Its not mine, im telling you!"
		
	  }
	  // "I told you it wasn't mine. I Told You!!"
	  MauryHelper theEnvelope = new MauryHelper(hasAChild,leftChild,rightChild);
	  return theEnvelope;
  }
  
  
  public int updateDepthSingle(Node toWorkOn) {
	  if(toWorkOn != null) {
		  
      //n.depth = 1 + Math.max(betaGetheight(n.left), betaGetheight(n.right));
		  if(theMauryShow(toWorkOn).hasChildren())
			  toWorkOn.depth = Math.max(betaGetheight(toWorkOn.left), betaGetheight(toWorkOn.right))-1;
		  else { //has no children, must reluctantly check parent's status
			  toWorkOn.depth = (search_Alt(toWorkOn.key).getParent()).depth + 1;
		  }
	  	return toWorkOn.depth;
	  }
	  return -1;
  }
  

  public void refreshDepths() {
	  depthHelper(root,root);

  }
  //the mere fact that this code was written and maybe executes still upsets me. But i cant delete it cause what if you know haha jkjkjk
  //unless?
  public void depthHelper(Node node, Node parent) {
	    if (node == null) {
	        return;
	    }
	    if(node!=root) {
	    	
	    	node.depth=parent.depth+1;
	    }
	    else {
	    	root.depth=0;
	    }
	    depthHelper(node.left,node);
	    depthHelper(node.right,node);
	}
    	
    //Add the following functions to your BST
    //Please use this code to verify your tree integrity
       public boolean isBSTOrNot() {
           return isBSTOrNot(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
       }

       private boolean isBSTOrNot(Node root, int minValue, int maxValue) {
           // check for root is not null or not
           if (root == null) {
               return true;
           }
           // check for current node value with left node value and right node value and recursively check for left sub tree and right sub tree
           if(root.key >= minValue && root.key <= maxValue && isBSTOrNot(root.left, minValue, root.key) && isBSTOrNot(root.right, root.key, maxValue)){
               return true;
           }
           return false;
       }

    

      // please use the following pieces of code to display your tree in a more easy to follow style (Note* you'll need to place the Trunk class in it's own file)
       public static void showTrunks(Trunk p)
       {
           if (p == null) {
               return;
           }
    
           showTrunks(p.prev);
           System.out.print(p.str);
       }
    
       public void printTree(){
           printTree(root, null, false);
       }

       private void printTree(Node root, Trunk prev, boolean isLeft)
       {
           if (root == null) {
               return;
           }
    
           String prev_str = "    ";
           Trunk trunk = new Trunk(prev, prev_str);
    
           printTree(root.right, trunk, true);
    
           if (prev == null) {
               trunk.str = "---";
           }
           else if (isLeft) {
               trunk.str = ".---";
               prev_str = "   |";
           }
           else {
               trunk.str = "`---";
               prev.str = prev_str;
           }
    
           showTrunks(trunk);
           System.out.println(" " + root.key);
    
           if (prev != null) {
               prev.str = prev_str;
           }
           trunk.str = "   |";
    
           printTree(root.left, trunk, false);
       }

   //this goes into it's own file
       class Trunk
      {
       Trunk prev;
       String str;
    
       Trunk(Trunk prev, String str)
       {
           this.prev = prev;
           this.str = str;
       }
      };
}