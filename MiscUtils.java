package PR;

public class MiscUtils implements IMiscUtils{
	int []t;
	int i=0;
	public class BinaryTreeNode {
		public Object element;
		public BinaryTreeNode left, right; 
		public BinaryTreeNode(Object element) { 
			this.element = element; 
		}
	}
 
	@Override
	public BinaryTreeNode insert(BinaryTreeNode root, int element) {
		// TODO Auto-generated method stub
		if(root==null) return new BinaryTreeNode(element);
		if((int)root.element>element) root.left=insert(root.left,element);
		else if((int)root.element<element) root.right=insert(root.right,element);
		return root;
	}



	public int sumRange(BinaryTreeNode root, int low, int high) {
		int t=0;
		if(root==null) return 0;
		if(!((int)root.element>high||(int)root.element<low)) {t+=(int) root.element;
		}
		if(root.left!=null) {t+=sumRange(root.left,low,high);}
		if(root.right!=null) {t+=sumRange(root.right,low,high);}
		return t;
	}
	
	@Override
	public boolean isValidBST(BinaryTreeNode root) {
		// TODO Auto-generated method stub 
		if(root==null || (root.left==null && root.right ==null)) return true;
		int[]tr=ar(root);
		int min=tr[0];int max=tr[1];
		return (isValid(root,min,max));
	}
	public int[] ar(BinaryTreeNode root) {
		t=new int[size(root)];i=0;
		fill(root,0);
		int min=t[0];int max=min;
		for(int num : t) {if(num>max) max=num;
		if(num<min) min=num;}
		return new int[] {min,max};
		}
	
	public int size(BinaryTreeNode root) {
		if (root == null)  return 0;
		return 1+size(root.left)+size(root.right);}
	
	public void fill(BinaryTreeNode root,int i) {
		if (root==null) return;
		if(root!=null) t[this.i++]=(int)root.element;
		fill(root.left,this.i);
		fill(root.right,this.i);
	}
	public boolean isValid(BinaryTreeNode root,int min,int max) {
		// TODO Auto-generated method stub 
		if(root==null) return true;
		if((int)root.element>max || (int)root.element<min) return false;
		return(isValid(root.right,(int)root.element+1,max))&&(isValid(root.left,min,(int)root.element-1));
		
	}
	@Override
	public int[] nextSmallerNumber(int[] array) {
		if(array.length==0) throw new IllegalStateException();
		int arc[]=new int[array.length];
		Stack st=new Stack();
		int b=0;
		int arc1[][]=new int[array.length][3];
		st.push(new int[] {array[0],0,0});
		for(int i=1;i<array.length;i++) {
		    if(st.isEmpty()) {st.push(new int[] {array[i],i,0});}
		    else {
		    	while(!st.isEmpty()&&((int[]) st.peek())[0]>array[i]) {
		    	arc1[b][0]=((int[]) st.peek())[0];
		    	arc1[b][1]=((int[]) st.peek())[1];
		    	arc1[b][2]=i;
	            st.pop();
		    	b++;
		    	}
		    	st.push(new int[] {array[i],i,0});
		    }
		}
		
		while(!st.isEmpty()) {int[] p=(int[]) st.pop();
		arc1[b][0]= p[0];
		arc1[b][1]=p[1];
		arc1[b][2]=-1;
		b++;}
		
	    for(int i=0;i<arc1.length;i++) {arc[arc1[i][1]]=arc1[i][2];}
		return arc;
	}
	
}
