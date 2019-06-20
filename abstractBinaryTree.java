package BinaryTree;

abstract class abstractBinaryTree<T>//������������������ 
{
	abstract boolean isEmpty();    //�ж��Ƿ�Ϊ�ն�����
	abstract int size();           //���ض������Ľڵ����
	abstract int height();         //���ض������ĸ߶�
	abstract void preorder();      //����ȸ������������
	abstract void inorder();       //����и������������
	abstract void postorder();     //�����������������
	abstract void levelorder();    //�����α�������
	abstract BinaryNode<T> insert(T x); //����Ԫ��x��Ϊ���ڵ㲢����
	abstract BinaryNode<T> insert(BinaryNode<T>p,T x,boolean leftChild);  //����x��Ϊp����/�Һ���
	abstract void remove(BinaryNode<T>parent,boolean leftChild);   //ɾ��parent������/�Һ���
	abstract void clear();         //ɾ�������������н��
	abstract BinaryNode<T> search(T key);  //���Ҳ����عؼ���key�Ľ��
	abstract boolean contains(T key);      //�ж��Ƿ�����ؼ���Ϊkey��Ԫ��

	abstract int level(T key);             //���عؼ���Ϊkey������ڵĲ��
}
