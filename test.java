package BinaryTree;

public class test 
{
	public static void main(String[] args)
	{
		/**
		 * ���������
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
		System.out.print("bitree �ȸ�����������ж�������  "); bitree.preorder();
//		System.out.print("bitree2 �ȸ�����������ж�������  "); bitree2.preorder();
//		System.out.print("bitree3 �ȸ�����������ж�������  "); bitree3.preorder();
		System.out.print("subtree �ȸ�����������ж�������  "); subtree.preorder();
//		System.out.print("pattern �ȸ�����������ж�������  "); pattern.preorder();
		System.out.print("subtree2 �ȸ�����������ж�������  "); subtree2.preorder();
//		System.out.print("subtree3 �ȸ�����������ж�������  "); subtree3.preorder();
		//equals(BinaryNode<T>,BinaryTree<T>)
//		System.out.println(bitree.equals(new BinaryNode<String>("C"),subtree));
		//equasl(BinaryTree<T>)��������
//		System.out.println(bitree.equals(pattern));
		//equals(BinaryNode<T> p,BinaryTree<T> pattern,Boolean left)
//		System.out.println(bitree.equals(new BinaryNode<String>("A"),subtree,false));
		//ʵ��6-11����ĳ�ڵ�ĸ��׽ڵ㣨L652��
//		current=bitree2.root.left.left;
//		System.out.println(bitree2.parent(current));
//		//bitreeɾ��pattern
//		bitree.removeAllMatcheds(subtree);
//		System.out.print("ɾ��pattern��bitree �ȸ�����������ж�������  "); bitree.preorder();
//	
////		//bitree2ɾ��pattern
//		bitree2.removeAllMatcheds(subtree);
//		System.out.print("ɾ��pattern��bitree2 �ȸ�����������ж�������  "); bitree2.preorder();
//		
////		//bitree3ɾ��pattern
//		bitree3.removeAllMatcheds(subtree);
//		System.out.print("ɾ��pattern��bitree3 �ȸ�����������ж�������  "); bitree3.preorder();
		System.out.println("**********************************************************************");
		
//		//���Ը����ȸ����и����������������
//		String[] preList= {"A","B","D","G","C","E","F","H"};
//		String[] inList= {"D","G","B","A","E","C","H","F"};
//		BinaryTree<String> tree=new BinaryTree<String>(preList,inList);
//		System.out.print("���ȸ����и�������Ķ�����tree�ȸ������� "); tree.preorder();
//		System.out.print("���ȸ����и�������Ķ�����tree�и������� "); tree.inorder();
		
		//replaceAll����
		bitree.replaceAll(subtree, subtree2);
		System.out.print("bitree �ȸ�����������ж�������  "); bitree.preorder();
		//���Ҹ��ڵ����
//		System.out.println(bitree.searchPar(subtree));
//		System.out.println(bitree.searchPar(subtree2));
//		System.out.println(bitree.searchPar(subtree3));
			
//		System.out.print("�и�����������ж�������  "); bitree.inorder();
//		System.out.print("�������������ж�������  "); bitree.postorder();
//		System.out.println("bitree���Ľڵ����Ϊ�� "+bitree.size());
//		System.out.println("bitree���ĸ߶�Ϊ�� "+bitree.height());
//		System.out.println("����Ϊ�գ�   "+bitree.isEmpty());
//		bitree.insert(bitree.root.left,"X",true);
//		System.out.print("����X���ȸ�����������ж�������  "); bitree.preorder();
//		bitree.remove(bitree.root.left, true);
//		System.out.print("ɾ��X�ȸ�����������ж�������  "); bitree.preorder();//ɾ����XΪ���ڵ������
//		BinaryTree<String> bitree_2=new BinaryTree(bitree);
//		bitree_2.remove(bitree_2.root.left.left, false);
//		System.out.print("bitree  �ȸ�����������ж�������  "); bitree.preorder();
//		System.out.print("bitree_2�ȸ�����������ж�������  "); bitree_2.preorder();
//		System.out.println(bitree.contains("C"));                
//		System.out.println(bitree.search("H").toString());
//		System.out.println(bitree.contains(subtree));
		//search�����ǶԵģ����ҵ�����Ӧ�Ľڵ㣬removeAllMatched�������ܽ�ĳ���ڵ�ֱ�Ӹ�ֵΪnull,���ǽ��丸�ڵ����/�ҽڵ㸳ֵΪ�ա�
//		BinaryNode<String> subRoot=bitree.search(subtree.root.data);
//		System.out.println("bitree �в���subtree �ĸ��ڵ㣺  "+subRoot.toString());
	}
}
