package BinaryTree;

abstract class abstractBinaryTree<T>//二叉树抽象数据类型 
{
	abstract boolean isEmpty();    //判断是否为空二叉树
	abstract int size();           //返回二叉树的节点个数
	abstract int height();         //返回二叉树的高度
	abstract void preorder();      //输出先根次序遍历序列
	abstract void inorder();       //输出中根次序遍历序列
	abstract void postorder();     //输出后根次序遍历序列
	abstract void levelorder();    //输出层次遍历序列
	abstract BinaryNode<T> insert(T x); //插入元素x作为根节点并返回
	abstract BinaryNode<T> insert(BinaryNode<T>p,T x,boolean leftChild);  //插入x作为p的左/右孩子
	abstract void remove(BinaryNode<T>parent,boolean leftChild);   //删除parent结点的左/右孩子
	abstract void clear();         //删除二叉树的所有结点
	abstract BinaryNode<T> search(T key);  //查找并返回关键字key的结点
	abstract boolean contains(T key);      //判断是否包含关键字为key的元素

	abstract int level(T key);             //返回关键字为key结点所在的层次
}
