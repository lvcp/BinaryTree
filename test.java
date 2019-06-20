package BinaryTree;

public class test 
{
	public static void main(String[] args)
	{
		/**
		 * 构造二叉树
		 *             A
		 *        B	        C
		 *     D         E     F
		 *        G          H     
		 */
		String prelist[]= {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
		String prelist2[]= {"A","B","D","C","E",null,null,"F","H",null,null,null,"G",null,null,null,"C","E",null,null,"F","H"};
		String prelist3[]= {"A","B","D","C","E",null,null,"F","H",null,null,null,"C","E",null,null,"F","H",null,null,null,null,"G"};
		String sublist[]= {"C","E",null,null,"F","H",null,null};
		String sublist2[]= {"x","y"};
		String sublist3[]= {"A"};
		BinaryNode<String> current;
		BinaryTree<String> bitree=new BinaryTree<String>(prelist);
		BinaryTree<String> bitree2=new BinaryTree<String>(prelist2);
		BinaryTree<String> bitree3=new BinaryTree<String>(prelist3);
		BinaryTree<String> subtree=new BinaryTree<String>(sublist);
		BinaryTree<String> subtree2=new BinaryTree<String>(sublist2);
		BinaryTree<String> subtree3=new BinaryTree<String>(sublist3);
		BinaryTree<String> pattern=new BinaryTree<String>(bitree);
		System.out.print("bitree 先跟次序遍历序列二叉树：  "); bitree.preorder();
//		System.out.print("bitree2 先跟次序遍历序列二叉树：  "); bitree2.preorder();
//		System.out.print("bitree3 先跟次序遍历序列二叉树：  "); bitree3.preorder();
		System.out.print("subtree 先跟次序遍历序列二叉树：  "); subtree.preorder();
//		System.out.print("pattern 先跟次序遍历序列二叉树：  "); pattern.preorder();
		System.out.print("subtree2 先跟次序遍历序列二叉树：  "); subtree2.preorder();
//		System.out.print("subtree3 先跟次序遍历序列二叉树：  "); subtree3.preorder();
		//equals(BinaryNode<T>,BinaryTree<T>)
//		System.out.println(bitree.equals(new BinaryNode<String>("C"),subtree));
		//equasl(BinaryTree<T>)方法测试
//		System.out.println(bitree.equals(pattern));
		//equals(BinaryNode<T> p,BinaryTree<T> pattern,Boolean left)
//		System.out.println(bitree.equals(new BinaryNode<String>("A"),subtree,false));
		//实验6-11查找某节点的父亲节点（L652）
//		current=bitree2.root.left.left;
//		System.out.println(bitree2.parent(current));
//		//bitree删除pattern
//		bitree.removeAllMatcheds(subtree);
//		System.out.print("删除pattern后bitree 先跟次序遍历序列二叉树：  "); bitree.preorder();
//	
////		//bitree2删除pattern
//		bitree2.removeAllMatcheds(subtree);
//		System.out.print("删除pattern后bitree2 先跟次序遍历序列二叉树：  "); bitree2.preorder();
//		
////		//bitree3删除pattern
//		bitree3.removeAllMatcheds(subtree);
//		System.out.print("删除pattern后bitree3 先跟次序遍历序列二叉树：  "); bitree3.preorder();
		System.out.println("**********************************************************************");
		
//		//测试根据先根、中跟次序构造二叉树方法
//		String[] preList= {"A","B","D","G","C","E","F","H"};
//		String[] inList= {"D","G","B","A","E","C","H","F"};
//		BinaryTree<String> tree=new BinaryTree<String>(preList,inList);
//		System.out.print("由先根、中跟次序构造的二叉树tree先根遍历： "); tree.preorder();
//		System.out.print("由先根、中跟次序构造的二叉树tree中根遍历： "); tree.inorder();
		
		//replaceAll测试
		bitree.replaceAll(subtree, subtree2);
		System.out.print("bitree 先跟次序遍历序列二叉树：  "); bitree.preorder();
		//查找根节点调试
//		System.out.println(bitree.searchPar(subtree));
//		System.out.println(bitree.searchPar(subtree2));
//		System.out.println(bitree.searchPar(subtree3));
			
//		System.out.print("中根次序遍历序列二叉树：  "); bitree.inorder();
//		System.out.print("后根次序遍历序列二叉树：  "); bitree.postorder();
//		System.out.println("bitree树的节点个数为： "+bitree.size());
//		System.out.println("bitree树的高度为： "+bitree.height());
//		System.out.println("该树为空？   "+bitree.isEmpty());
//		bitree.insert(bitree.root.left,"X",true);
//		System.out.print("插入X后先跟次序遍历序列二叉树：  "); bitree.preorder();
//		bitree.remove(bitree.root.left, true);
//		System.out.print("删除X先跟次序遍历序列二叉树：  "); bitree.preorder();//删除以X为根节点的子树
//		BinaryTree<String> bitree_2=new BinaryTree(bitree);
//		bitree_2.remove(bitree_2.root.left.left, false);
//		System.out.print("bitree  先跟次序遍历序列二叉树：  "); bitree.preorder();
//		System.out.print("bitree_2先跟次序遍历序列二叉树：  "); bitree_2.preorder();
//		System.out.println(bitree.contains("C"));                
//		System.out.println(bitree.search("H").toString());
//		System.out.println(bitree.contains(subtree));
		//search函数是对的，查找到了相应的节点，removeAllMatched函数不能将某个节点直接赋值为null,而是将其父节点的左/右节点赋值为空。
//		BinaryNode<String> subRoot=bitree.search(subtree.root.data);
//		System.out.println("bitree 中查找subtree 的根节点：  "+subRoot.toString());
	}
}
