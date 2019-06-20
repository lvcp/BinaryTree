package BinaryTree;

public class BinaryNode<T> 
{
	public T data;
	BinaryNode<T> left,right;
	public BinaryNode(T data,BinaryNode<T> left,BinaryNode<T> right)
	{
		this.data=data;
		this.left=left;
		this.right=right;
	}
	public BinaryNode(T data)
	{
		this(data,null,null);
	}
	public BinaryNode() {
		this(null,null,null);
	}
	public String toString()
	{
		return this.data.toString();
	}
	public boolean isLeaf()
	{
		return this.left==null&&this.right==null;
	}
	public boolean equals(BinaryNode<T> t)
	{
		if(this!=null&&t!=null&&this.data==t.data)
			return true;
		else
			return false;
	}
}
