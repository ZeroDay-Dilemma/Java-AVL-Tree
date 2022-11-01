package tempPackage;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TempMain {

	public static void main(String[] args) {
		BST tree = new BST();
		Random r = new Random();
//		tree.insert(6);
//		tree.insert(3);
//		tree.insert(7);
//		tree.insert(3);
//		tree.insert(2);
		
//		tree.insert(22);
//		tree.insert(12);
//		tree.insert(11);
//		tree.insert(14);
//		tree.insert(17);
//		tree.insert(13);
//		tree.insert(19);
//		tree.insert(11);
//		tree.insert(6);
//		tree.insert(20);
//		tree.demoinsert(5);
		
//			tree.insert(2);
//			tree.insert(28);
//			tree.insert(13);
//			tree.insert(3);
//			tree.insert(10);
//			tree.insert(5);
//			tree.insert(8);
//			tree.insert(9);
//			tree.insert(24);
//			tree.insert(33);
//			tree.insert(31);
//			tree.insert(34);
//			tree.insert(36);
//		
//			tree.insert(20);
//			tree.insert(10);
//			tree.insert(40);
//			
//			
//			tree.insert(11);
////			tree.insert(12);
//			
//			tree.insert(5);
//			tree.insert(2);
//			
//			
//			//tree.insert(15);
//			//tree.insert(3);
//			tree.insert(7);
//			tree.insert(1);
		
		
		
//		tree.insert(100);
//		tree.insert(50);
//		tree.insert(25);
		
		
//		
//		tree.insert(12);
//		tree.insert(8);
//		tree.insert(18);
//		tree.insert(17);
//		tree.insert(5);
//		tree.insert(11);
//		tree.insert(4);
//		tree.insert(7);
//		tree.insert(2);
		
//		tree.insert(1);
//		tree.insert(7);
//		tree.insert(49);
//		tree.insert(71);
//		tree.insert(17);
//		tree.insert(8);
//		tree.insert(4);
//		
//		tree.insert(100);
//
//		tree.insert(50);
//
//		tree.insert(200);
//		
//		tree.insert(150);
//		
//		tree.insert(125);
//
//		tree.insert(175);
//
//		tree.insert(250);
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> arrlist = new ArrayList<Integer>(21);
		for (int j=0; j<20; j++) {
			arrlist.clear();
			for (int i = 0; i < 20; i++) {
				arrlist.add(r.nextInt(1000) -500);
				tree.insert(arrlist.get(i));
				System.out.println("\n\n");
				tree.printTree();
			}
			System.out.println("\nis a BST? " + tree.isBSTOrNot());
			System.out.println("\nis an AVL? " + tree.isAVL());
			Boolean isBST1=tree.isBSTOrNot();
			Boolean isAVL1=tree.isAVL();
			System.out.println(arrlist.stream().map(Object::toString).collect(Collectors.joining(", ")));
			
			
			
			tree.remove(arrlist.get(r.nextInt(20)));
			tree.printTree();
			tree.remove(arrlist.get(r.nextInt(20)));
			tree.printTree();
			tree.remove(arrlist.get(r.nextInt(20)));
			tree.printTree();
			tree.remove(arrlist.get(r.nextInt(20)));
			tree.printTree();
			tree.remove(arrlist.get(r.nextInt(20)));
			tree.printTree();
			tree.remove(arrlist.get(r.nextInt(20)));
			tree.printTree();
			tree.remove(arrlist.get(r.nextInt(20)));
			tree.printTree();
			tree.remove(arrlist.get(r.nextInt(20)));
			tree.printTree();
			tree.remove(arrlist.get(r.nextInt(20)));
			tree.printTree();
		System.out.println("\nis a BST? " + tree.isBSTOrNot());
		System.out.println("\nis an AVL? " + tree.isAVL());
		Boolean isBST2=tree.isBSTOrNot();
		Boolean isAVL2=tree.isAVL();
		//tree.betaTestingClear();
		tree.printTree();
		
		System.out.println("Results:\nInital filling:\n\tisBST: "+ isBST1 + "\n\tisAVL: "+isAVL1+"\nAfter Removals:\n\tisBST: "+ isBST2 + "\n\tisAVL: "+isAVL2);
		System.out.println("\nNext attempt?");
		System.out.println(tree.search(arrlist.get(r.nextInt(20))));

		String line = scanner.nextLine();

		
		
		}
//		int aList[] = {370, -274, 347, -320, 261, 319, -317, 161, 401, 346, -63, 487, -273, -435, -346, 363, 403, -175, 358, -386};
//		//tree.setBal(false);
		
//		tree.setBal(true);
//		for (int i = 0; i < 20; i++) {
//			tree.insert(aList[i]);
//			System.out.println("\n\n");
//			tree.printTree();
//			
//		}
		//System.out.println(tree.isAVL());
		//tree.balanceLeft(tree.search_Alt(346).getNode());
		//tree.printTree();
		//tree.root.right=tree.balanceMe(tree.root.right);
		//System.out.println(tree.balanceValue(tree.search_Alt(347).getNode()));
		//tree.printTree();

		
		
		
		//tree.autoBalanceDemo(tree.search_Alt(80).getNode());
		
		
		//tree.root=tree.balanceMe(tree.root);
		
		
		
		//balance at root????
		////balance at root????
		//balance at root????
		
		
		
		
		//for (int i = 0; i < 20; i++) {
		//	tree.insert(r.nextInt(40-1) + 1);
		//}
		//tree.toString();
		//System.out.println(tree.betaGetheight(tree.root.left.left.left.left));
			
		//System.out.println(tree.updateDepthSingle(tree.root.left));
			//tree.toString();
		//tree.printTree();
		//System.out.println(tree.balanceValue(tree.root));
		//System.out.println(tree.balanceValue(tree.root.right));
		//System.out.println(tree.balanceValue(tree.root.left));
		//System.out.println(tree.balanceValue(tree.search_Alt(10).getNode()));
		//System.out.println(tree.maxDepth(tree.search_Alt(40).getNode()));
		//tree.rRight(10);
		//tree.balanceRight();
			
			//tree.autoBalanceDemo(tree.root.right);
			//System.out.println("\n\n");
			//tree.printTree();
			//tree.autoBalanceDemo(tree.root);
		//tree.rightRotate(tree.search_Alt(10).getNode());
		System.out.println("\n\n");
		//tree.toString();
		//System.out.println(tree.root.key);
		//tree.printTree();
		
		//tree.ttt();
		//System.out.println(tree.remove(12));
		//System.out.println(tree.remove(tree.root.key));
		//tree.toString();
		//tree.grabKeys(tree.root.left);
		//System.out.println(tree.root.left.key);
		//System.out.println(tree.root.right.key);
//		System.out.println(tree.search(2));
//		System.out.println(tree.search(19));
//		System.out.println(tree.search(7));
//		
//		System.out.println(tree.search(4));
//		System.out.println(tree.search(5));
//		
	}
}
