package PR;

import eg.edu.alexu.csd.datastructure.linkedList.cs.DLinkedList;

public class HashTableDictionary<K,V> implements IDictionary<K,V> {
DLinkedList []f;
int size;
HashTableDictionary(int size) {f=new DLinkedList[size];int i=0;
for(DLinkedList t:f)f[i++]=new DLinkedList();this.size=size;}

private class Pairs{
	K Key=null;
	V Element=null;
	Pairs(K key,V element){
		this.Key=key;
		this.Element=element;
	}
}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		if(key==null) throw new IllegalStateException("Empty key");
		int hashing=(Math.abs(key.hashCode()))%size;
		if(f[hashing]==null) {return null;}
		for(int i=1;i<=f[hashing].size();i++) {if(((Pairs)f[hashing].get(i)).Key.equals(key)) {
			return ((Pairs)f[hashing].get(i)).Element;}}
		return null;
	}
	
	@Override
	public V set(K key, V value) {
		// TODO Auto-generated method stub
		if(key==null||value==null) throw new IllegalStateException("Empty key or valur");
		int hashing=(Math.abs(key.hashCode()))%size;
		for(int i=1;i<=f[hashing].size();i++) {if(((Pairs)f[hashing].get(i)).Key.equals(key)) {
			V x=((Pairs)f[hashing].get(i)).Element;
			((Pairs)f[hashing].get(i)).Element=value;
			return x;}}
		f[hashing].add(new Pairs(key,value));
		return null;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		if(key==null)throw new IllegalStateException("Empty key");
		int hashing=(Math.abs(key.hashCode()))%size;
		V z=null;
		for(int i=1;i<=f[hashing].size();i++) {if(((Pairs)f[hashing].get(i)).Key.equals(key)) {
			z=((Pairs)f[hashing].get(i)).Element;
			f[hashing].remove(i);}}
		return z;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		for(DLinkedList num:f) if(num.size()!=0) return false;
		return true;
	}
}
