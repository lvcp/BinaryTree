package BinaryTree;
import 链式栈.LinkedStack;
import 链式队列.LinkedQueue;

public class BinaryTree<T> extends abstractBinaryTree<T>
{
	public BinaryNode<T> root;
	private int i;  
	public BinaryTree() {
		this.root=null;
	}
	 //构造二叉树，prelist数组指定二叉树标明空子树的先根遍历序列
	 //调用create方法来构造结点
	public BinaryTree(T[] prelist) {
		this.root=create(prelist);
	}
	//6-2  BinaryTree<T> create(T inlist[], T postlist[]) //以中根和后根次序遍历序列构造二叉树
	private BinaryNode<T> create(T[] prelist) {
		BinaryNode<T> p=null;
		if(i<prelist.length) {
			T elem=prelist[i];
			i++;
			if(elem!=null) {
				p=new BinaryNode<T>(elem);
				p.left=create(prelist);
				p.right=create(prelist);
			}
		}
		return p;
	}
	//递归以先根和中跟次序构造二叉树
	public BinaryTree(T[] prelist ,T[] inlist){
		this.root=create(prelist,inlist,prelist.length,0,0);
	}
	public BinaryNode<T> create(T[] a,T[] b,int len,int lowa,int lowb){
		T rootValue = a[lowa];
		BinaryNode<T> node = new BinaryNode<T>(rootValue,null,null);
		if(len==1)
			if(a[lowa]==b[lowb])
				return node;
		int i = lowb;
		while(i<lowb+len&&b[i]!=rootValue)
			i++;
		int leftlength = i-lowb;
		int rightlength = len-i+lowb-1;
		int aLeftStart = lowa+1;
		int aRightStart = leftlength+lowa+1;
		int bLeftStart = lowb;
		int bRightStart = i+1;
		if(leftlength>0)
			node.left = create(a,b,leftlength,aLeftStart,bLeftStart);
		if(rightlength>0)
			node.right = create(a,b,rightlength,aRightStart,bRightStart);
		return node;
	}

	// 非递归实现二叉树的深拷贝，使用栈  实验题6--16
//	public BinaryTree(BinaryTree<T> bitree)
//	{
//		this(); //构造空二叉树
//		LinkedStack<BinaryNode<T>> stack_1=new LinkedStack<BinaryNode<T>>();  //bitree栈
//		LinkedStack<BinaryNode<T>> stack_2=new LinkedStack<BinaryNode<T>>();  //this栈
//		BinaryNode<T> p1=bitree.root;
//		BinaryNode<T> p2=this.root;
//		while(p1!=null || !stack_1.isEmpty()) {
//			if(p1!=null)
//			{
//				p2.data=p1.data;
//				stack_2.push(p2);
//				stack_1.push(p1);
//				p1=p1.left;
//				if(p1!=null) {
//					p2.left=new BinaryNode<T>();
//					p2=p2.left;
//				}
//			} else {
//				p1=stack_1.pop().right;
//				if(p1!=null) {
//					p2=stack_2.pop();
//					p2.right=new BinaryNode<T>();
//					p2=p2.right;
//				}
//			}
//		}
//	}
	//深拷贝构造，递归实现实验题6-16
	public BinaryTree(BinaryTree<T> bitree){
		this.root=copy(bitree.root);
	}
	public BinaryNode<T> copy(BinaryNode<T> bitree){
		if(bitree==null)
			return null;
		BinaryNode<T> p=new BinaryNode(bitree.data);
		p.left=copy(bitree.left);
		p.right=copy(bitree.right);
		return p;
	} 
	
	public boolean isEmpty(){
		return this.root==null;
	}
	//插入x作为根节点，原根节点作为x的左孩子；返回插入结点
	public BinaryNode<T> insert(T x){
		return this.root=new BinaryNode<T>(x,this.root,null);
	}
	public BinaryNode<T> insert(BinaryNode<T>p,T x,boolean leftChild){
		if(x==null)
			return null;
		if(leftChild)
			return p.left=new BinaryNode<T>(x,p.left,null);
		return p.right=new BinaryNode<T>(x,p.right,null);
	}
	public void remove(BinaryNode<T> parent,boolean leftChild){
		if(leftChild)
			parent.left=null;
		else
			parent.right=null;
	}
	public void clear() {
		this.root=null;
	}

	//先根次序遍历二叉树
	public void preorder(){
		preorder(this.root);
		System.out.println();
	}
	public void preorder(BinaryNode<T> p){
		if(p==null)	return ;
		System.out.print(p.data.toString()+"");
		preorder(p.left);
		preorder(p.right);
		}
	}
	// 中跟遍历，先左子树，后根，再右子树
	public void inorder(){
		inorder(this.root);
		System.out.println();
	}
	public void inorder(BinaryNode<T> p){
		if(p==null) return ;
		inorder(p.left);
		System.out.print(p.data.toString()+"");
		inorder(p.right);
		}
	}
	//后根遍历，先左子树，后右子树，再根
	public void postorder(){
		postorder(this.root);
		System.out.println();
	}
	public void postorder(BinaryNode<T> p){
		if(p==null)	return ;
		postorder(p.left);
		postorder(p.right);
		System.out.print(p.data.toString()+"");
		}
	}
	
	// 以下为遍历二叉树的非递归算法
	public void preorderTraverse(){
		System.out.print("先跟次序遍历序列（非递归）： ");
		LinkedStack<BinaryNode<T>>stack=new LinkedStack<BinaryNode<T>>();//创建空栈
		BinaryNode<T> p=this.root;
		while(p!=null||!stack.isEmpty())
			if(p!=null){
				System.out.print(p.data+"");    //访问结点
				stack.push(p);					//p结点入栈
				p=p.left;                       //进入左子树
			}
			else{
				System.out.print("^");
				p=stack.pop();					//p指向出栈结点
				p=p.right;						//进入右子树
			}
		System.out.println();
	}
	//层次遍历
	public void levelorder()                  {
		System.out.print("层次遍历：  ");
		LinkedQueue<BinaryNode<T>>que=new LinkedQueue<BinaryNode<T>>(); //创建空队列
		BinaryNode<T> p=this.root;     //根节点没有入队
		while(p!=null){
			System.out.print(p.data+"");       //访问p结点
			if(p.left!=null)
				que.add(p.left);               //p的左孩子结点入队
			if(p.right!=null)
				que.add(p.right);              //p的右孩子结点入队
			p=que.poll();
	 	}
		System.out.println();
	}
	
	public int size(){
		return size(this.root);
	}
	public int size(BinaryNode<T> p){
		if(p==null)
			return 0;
		return 1+size(p.left)+size(p.right);
	}
	public int height(){
		return height(this.root);
	}
	public int height(BinaryNode<T> p){
		if(p==null)
			return 0;
		int l=height(p.left);
		int r=height(p.right);
		return (l>r)? l+1:r+1;
	}
	public boolean contains(T key) {     //判断是否包含关键字为key的元素
		if(this.root==null||key==null)
			return false;
		LinkedStack<BinaryNode<T>> stack=new LinkedStack<BinaryNode<T>>(); //创建空栈
		BinaryNode<T> current=this.root;
		while(current!=null||!stack.isEmpty()){
			//此处出错：缺少了current!=null，会出现空指向错误
			if((current!=null)&&(current.data==key))
				return true;
			if(current!=null){
				stack.push(current);         //当前节点入栈
				current=current.left;        //进入左子树 
			}
			else{
				current=stack.pop();                //p指向出栈节点
				current=current.right;
			}
		}
		return false;
	}
	
//查找该树中是否含有key节点，查找到返回该节点，否则返回null
	public BinaryNode<T> search(T key){
		if(this.root==null||key==null)
			return null;
		LinkedStack<BinaryNode<T>> stack=new LinkedStack<BinaryNode<T>>(); //创建空栈
		BinaryNode<T> current=this.root;
		while(current!=null||!stack.isEmpty()){
			//此处出错：缺少了current!=null，会出现空指向错误
			if((current!=null)&&(current.data==key))
				return current;
			if(current!=null){
				stack.push(current);         //当前节点入栈
				current=current.left;        //进入左子树 
			}else{
				current=stack.pop();                //p指向出栈节点
				current=current.right;
			}
		}
		return null;	
	}
	
	//比较两棵树是否相等
	public boolean equals(BinaryTree<T> pattern) {
		return this.equals(this.root,pattern);
	}
	//比较当前树中以P为根节点的子树与pattern是否匹配
	public boolean equals(BinaryNode<T> p,BinaryTree<T> pattern){
		if(p==null||this.isEmpty()||pattern.isEmpty())
			return false;
		BinaryNode<T> cur=this.search(p.data);
		BinaryNode<T> pat=pattern.root;
		LinkedStack<BinaryNode<T>> stack1=new LinkedStack<BinaryNode<T>>();  
		LinkedStack<BinaryNode<T>> stack2=new LinkedStack<BinaryNode<T>>();   //pattern树的栈
		while((cur!=null||!stack1.isEmpty())&&((pat!=null||!stack2.isEmpty()))){
			if(cur!=null&&pat!=null){
				if(cur.data.equals(pat.data)){
					stack1.push(cur);
					cur=cur.left;
					stack2.push(pat);
					pat=pat.left;
				} else return false;
			} else if(cur==null&&pat==null){
				cur=stack1.pop().right;
				pat=stack2.pop().right;
			} else return false;
		}
		return true;
	}
	//比较当前树P节点的左/右子树与pattern是否匹配
	public boolean equals(BinaryNode<T> p,BinaryTree<T> pattern,Boolean left){
		BinaryNode<T> rootParent=this.search(p.data);
		if(left){	
			return this.equals(rootParent.left, pattern);
		} else  {	
			return this.equals(rootParent.right, pattern);
		}
	}
	public void removeAllMatcheds(BinaryTree<T>pattern){
		if(this.isEmpty()||pattern.isEmpty())
			return;
		LinkedStack<BinaryNode<T>> stack=new LinkedStack<BinaryNode<T>>();
		BinaryNode<T> curPar=this.root;    
		BinaryNode<T> cur=this.root.left;
		Boolean left = true;
		if(this.root.data.equals(pattern.root.data))
			if(this.equals(pattern))
				this.root=null;
		stack.push(this.root);
		while(cur!=null||!stack.isEmpty()){
			if(cur!=null){
				if(cur.data.equals(pattern.root.data)){
					if(this.equals(curPar,pattern,left)){
						if(left){
							curPar.left=null;
							if(!stack.isEmpty()){
								cur=stack.pop().right;
								left=false;
							} 
						} else	{
							curPar.right=null;
							if(!stack.isEmpty()){
								curPar=stack.pop();
								cur=curPar.right;
								left=false;
							} else cur=null;
						}	
					}
				} else {
					stack.push(cur);
					curPar=cur;
					cur=cur.left;
					left=true;
				}
			} else {
				cur=stack.pop();
				curPar=cur;
				cur=cur.right;
				left=false;
			}
		}
	}
	//
	public void replaceAll(BinaryTree<T>pattern,BinaryTree<T>bitree){
		if(this.isEmpty()||pattern.isEmpty())
			return;
		LinkedStack<BinaryNode<T>> stack=new LinkedStack<BinaryNode<T>>();
		BinaryNode<T> curPar=this.root;    
		BinaryNode<T> cur=this.root.left;
		Boolean left = true;
		if(this.root.data.equals(pattern.root.data))
			if(this.equals(pattern))
				this.root=null;
		stack.push(this.root);
		while(cur!=null||!stack.isEmpty()){
			if(cur!=null){
				if(cur.data.equals(pattern.root.data)){
					if(this.equals(curPar,pattern,left)){
						if(left){
							curPar.left=bitree.root;
							if(!stack.isEmpty()){
								cur=stack.pop().right;
								left=false;
							} 
						} else	{
							curPar.right=bitree.root;
							if(!stack.isEmpty()){
								curPar=stack.pop();
								cur=curPar.right;
								left=false;
							} else cur=null;
						}	
					}
				} else {
					stack.push(cur);
					curPar=cur;
					cur=cur.left;
					left=true;
				}
			} else {
				cur=stack.pop();
				curPar=cur;
				cur=cur.right;
				left=false;
			}
		}
	}
	//查找树中是否有以key为根节点的子树
//	public BinaryNode<T> search(BinaryTree<T> pattern){
//		if(this.isEmpty()||pattern.isEmpty())
//			return null;
//		LinkedStack<BinaryNode<T>> stack=new LinkedStack<BinaryNode<T>>();
//		BinaryNode<T> cur=this.root;
//		BinaryNode<T> p=pattern.root;
//		while(cur!=null||!stack.isEmpty()){
//			if(cur!=null){
//				if(p.data.equals(cur.data))
//					if()
//			}
//		}
//	}
	//查找匹配子树，返回根节点
	public BinaryNode<T> search(BinaryTree<T>pattern) {
		if (pattern.isEmpty() || isEmpty()) {
			return null;
		}
		LinkedStack<BinaryNode<T>> parStack = new LinkedStack<BinaryNode<T>>();
		LinkedStack<BinaryNode<T>> Pstack = new LinkedStack<BinaryNode<T>>();
		LinkedStack<BinaryNode<T>> childstack = new LinkedStack<BinaryNode<T>>();
		BinaryNode<T> curRoot_parent=this.root;   //当前跟的父节点，用来删除子树
		BinaryNode<T> curRoot = this.root;
		BinaryNode<T> child;
		BinaryNode<T> P = pattern.root;
		while (curRoot != null || !parStack.isEmpty()) {
			if (curRoot != null) {
				child = curRoot;
				while ((child  !=null || !childstack.isEmpty())&&(!Pstack.isEmpty() || P !=  null)) {
					if (child != null&&P != null) {
						if (child.data.equals(P.data)) {
							childstack.push(child);
							child = child.left;
							Pstack.push(P);
							P = P.left;
						} else {
							childstack.clear();  //中间栈清空
							P=pattern.root;      //p回到子树的根节点
							Pstack.clear();      //子树的栈清空
							break;
						}
					} else {
						if (P == null) {
							child = childstack.pop().right;
							P = Pstack.pop().right;
						} else {
							childstack.clear();
							P = pattern.root;
							Pstack.clear();
							break;
						}
					}
				}
				if(P==null&&Pstack.isEmpty())
					return curRoot;
				parStack.push(curRoot);
				curRoot=curRoot.left;
			}else {
				curRoot=parStack.pop().right;
			}
		}
		return null;
	}
	//查找匹配子树，并直接将其删除 **********************************
//		public void removeAllMatcheds(BinaryTree<T>pattern) {
//			if (pattern.isEmpty() || this.isEmpty()) {
//				return;
//			}
//			LinkedStack<BinaryNode<T>> parStack = new LinkedStack<BinaryNode<T>>();
//			LinkedStack<BinaryNode<T>> Pstack = new LinkedStack<BinaryNode<T>>();
//			LinkedStack<BinaryNode<T>> childstack = new LinkedStack<BinaryNode<T>>();
//			BinaryNode<T> curRoot_parent=this.root;   //当前根的父节点数组，用来删除子树
//			BinaryNode<T> curRoot = this.root;
//			BinaryNode<T> child;
//			BinaryNode<T> P = pattern.root;
//			boolean left=true;                            //判断是否未左孩子
//			boolean tiao=false;                                 //已删除一颗子树的标记
//			while (curRoot != null || !parStack.isEmpty() || !Pstack.isEmpty()) {	
//				tiao=false;
//				if (curRoot != null) {
//					child = curRoot;
//					while ((child  !=null || !childstack.isEmpty())&&(!Pstack.isEmpty() || P !=  null)) {
//						if (child != null&&P != null) {
//							if (child.data.equals(P.data)) {
//								childstack.push(child);
//								child = child.left;
//								Pstack.push(P);
//								P = P.left;
//							} else {
//								childstack.clear();  //中间栈清空
//								P=pattern.root;      //p回到子树的根节点
//								Pstack.clear();      //子树的栈清空
//								break;
//							}
//						} else {
//							if (P == null) {
//								child = childstack.pop().right;
//								P = Pstack.pop().right;
//							} else {
//								childstack.clear();
//								P = pattern.root;
//								Pstack.clear();
//								break;
//							}
//						}
//					}
//					if(P==null&&Pstack.isEmpty()&&left) {
//						curRoot_parent.left=null;
//						childstack.clear();  //中间栈清空
//						P=pattern.root;      //p回到子树的根节点
//						Pstack.clear();      //子树的栈清空
//						if(!parStack.isEmpty()) {
//							curRoot=parStack.pop().right;
//							left=false;
//							tiao=true;
//						}
//					} 
//					if(P==null&&Pstack.isEmpty()&&!left) {
//						curRoot_parent.right=null;
//						childstack.clear();  //中间栈清空
//						P=pattern.root;      //p回到子树的根节点
//						Pstack.clear();      //子树的栈清空
//						if(!parStack.isEmpty()) {
//							parStack.pop();
//							curRoot_parent=parStack.pop();
//							curRoot=curRoot_parent.right;
//							left=false;
//							tiao=true;
//						}
//					}
//					if(!tiao) {
//						parStack.push(curRoot);
//						curRoot_parent=curRoot;
//						curRoot=curRoot.left;
//						left=true;
//					}
//				}else {
//					curRoot=parStack.pop();
//					curRoot_parent=curRoot;
//					left=false;
//					curRoot=curRoot.right;
//				}
//			}
//			return;
//		}
	//查找该树中node节点的父节点，若查找结点为根节点，则其父节点就是根节点
	BinaryNode<T> parent(BinaryNode<T> node){
		if(this.root==null||node.data==null)
			return null;
		LinkedStack<BinaryNode<T>> stack=new LinkedStack<BinaryNode<T>>(); //创建空栈
		BinaryNode<T> current=this.root;
		BinaryNode<T> curParent=this.root;
		while(current!=null||!stack.isEmpty()){
			//此处出错：缺少了current!=null，会出现空指向错误
			if((current!=null)&&(current.data==node.data))
				return curParent;
			if(current!=null){
				stack.push(current);         //当前节点入栈
				curParent=current;
				current=current.left;        //进入左子树 
			}else{
				current=stack.pop();                //p指向出栈节点
				curParent=current;
				current=current.right;
			}
		}
		return null;	
	}

	//判断key结点是其父节点的左孩子还是右孩子
	public Boolean leftChild(T key){
		if(this.root==null||key==null)
			return null;
		LinkedStack<BinaryNode<T>> stack=new LinkedStack<BinaryNode<T>>(); //创建空栈
		BinaryNode<T> current=this.root;
		Boolean leftChild=true;
		while(current!=null||!stack.isEmpty()){
			if((current!=null)&&(current.data==key))
				return leftChild;
			if(current!=null){
				stack.push(current);         //当前节点入栈
				current=current.left;        //进入左子树 
				leftChild=true;
			}else{
				current=stack.pop();                //p指向出栈节点
				current=current.right;
				leftChild=false;
			}
		}
		return null;	
	}
	public int level(T key)	{            //返回关键字为key结点所在的层次
		return -1;
	}
	//实验6-14
	public int height(int w) {
		int n=0,h=0,ch=0;
		BinaryNode<T> root;
		LinkedStack<BinaryNode<T>>stack=new LinkedStack<BinaryNode<T>>();
		LinkedStack<Integer>stack1=new LinkedStack<Integer>();
		BinaryNode<T> p=this.root;
		while(p!=null||!stack.isEmpty()){
			if(p.left!=null&&p.right!=null){
				ch=++n;
				stack.push(p);
				stack1.push(ch);
				p=p.left;
			}else if(p.left!=null&&p.right==null){
				p=p.left;
				n++;
			}else if(p.right!=null&&p.left==null){
				p=p.right;
				n++;
			}else if(p.left==null&&p.right==null){
				h=(h>(n+1))?h:n+1;
				if(!stack.isEmpty()){
					n=stack1.pop();
				    p=stack.pop();
				    p=p.right;
				}else{
					return h;
				}
			}
		}
		return h;
	}
}

