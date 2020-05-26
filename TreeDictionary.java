package PR;

import PR.MiscUtils.BinaryTreeNode;

public class TreeDictionary<K extends Comparable<K>,V> implements IDictionary<K,V>{
	V z;
	BinaryTreeNode root;
	public class BinaryTreeNode {
		public V element;
		public K Key;
		public BinaryTreeNode left, right; 
		public BinaryTreeNode(V element,K Key) { 
			this.element = element; 
			this.Key=Key;
		}
	}
	
	
	public BinaryTreeNode insert(BinaryTreeNode root,BinaryTreeNode element) {
		// TODO Auto-generated method stub
		if(root==null) return element;
		if((element.Key).compareTo(root.Key)==0) {z=root.element;root.element=element.element;}
		if((element.Key).compareTo(root.Key)<0) root.left=insert(root.left,element);
		else if((element.Key).compareTo(root.Key)>0) root.right=insert(root.right,element);
		return root;
	}
	
	public void gets(BinaryTreeNode root,K key) {
		// TODO Auto-generated method stub
		if(root==null) return;
		if((key).compareTo(root.Key)==0) {z=root.element;}
		if((key).compareTo(root.Key)<0) gets(root.left,key);
		else if((key).compareTo(root.Key)>0) gets(root.right,key);
	}
	
	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		if(key==null)throw new IllegalStateException("Empty key");
		z=null;
		gets(root,key);
		return z;
	}

	@Override
	public V set(K key, V value) {
		// TODO Auto-generated method stub
		if(key==null||value==null) throw new IllegalStateException("Empty key or value");
		z=null;
        root=insert(root,new BinaryTreeNode(value,key));
		return z;
	}
	public BinaryTreeNode Remove(BinaryTreeNode root,K key) {
		// TODO Auto-generated method stub
		if(root==null) return null;
		if((key).compareTo(root.Key)<0) root.left=Remove(root.left,key);
		else if((key).compareTo(root.Key)>0) root.right=Remove(root.right,key);
		else {z=root.element;
			if (root.right == null) return root.left;
			if (root.left == null) return root.right;BinaryTreeNode zt=root.right;
            while(zt!=null&&zt.left!=null&&zt.left.left!=null) zt=zt.left;
            root.element=zt.left==null?zt.element:zt.left.element;
            root.Key=zt.left==null?zt.Key:zt.left.Key;
            if(zt.left==null)root.right=zt.right;
            else{zt.left=zt.left.right;}
		}
		return root;}
	@Override
	public V remove(K key) {
		if(key==null)throw new IllegalStateException("Empty key");
		if(root.left==null&&root.right==null) {if(root.Key.compareTo(key)==0) {V x=root.element;root=null;return x;} 
		  else return null;}
		z=null;root=(Remove(root,key));
		return z;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (root==null);
	} 
}
