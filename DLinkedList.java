package PR;

public class DLinkedList {
	private DLN v;
	private DLN Head=null;
	private DLN Tail=null;
	private int size=0;
	private class DLN{
		private Object element;
		private DLN Next,Prev;
		private DLN(Object element,DLN Next, DLN Prev) {this.element=element;
		this.Next=Next;this.Prev=Prev;}}
	public void add(int index, Object element) {
		if(index<0) {}
		else {
			v= Head;
			if((size==0)) {if(index==1) {DLN r=new DLN(element,null,null);Head=r;Tail=r;size++;}
			else{}}
			else if(size==1) {if(index==1) {size++;DLN r=new DLN(element,v,null);
			v.Next=null;v.Prev=r;
			Head=r;Tail=v;}
			else if(index==2) {size++;DLN r=new DLN(element,null,v);
			v.Next=r;v.Prev=null;Head=v;Tail=r;}
			else{}}
			else {int i=1;
			if(index==1) {size++;DLN r=new DLN(element,v,null);v.Prev=r;Head=r;}
			else {if(index==0) {}
			else {
			while((i<index)&&(v.Next!=null)) {v=v.Next;i++;}
			if(i<index) {if(index==(i+1)){size++;DLN r=new DLN(element,null,v);v.Next=r;Tail=r;}}
			else
			{size++;
			DLN r=new DLN(element,v,v.Prev);
			v.Prev.Next=r;v.Prev=r;}}}
			}
		}
	}
	
	public void add(Object element) {if(size==0) {DLN r=new DLN(element,null,null);Head=r;Tail=r;size++;}
	else {
		v= Head;
		while(v.Next!=null) {v=v.Next;}
		size++;
		DLN r=new DLN(element,null,v);
		v.Next=r;
		Tail=r;
	}
	}
	
	public Object get(int index) {if(size==0) {return null;}
	else if(index<1) {return null;}
	else if(size==1) {if(index==1) {return Head.element;}
	else{return null;}}
	else{
		int i=1;v=Head;
		while((i<index)&&(v.Next!=null)) {v=v.Next;i++;}
		if(i<index) {return null;}
		else
		{return v.element;}
	}
	}
	
	public void set(int index, Object element) {if(index<1) {}
	else if(size==0) {}
	else if(size==1) {if(index==1) {DLN r=new DLN(element,null,null);Head=r;Tail=r;}
	else{}}
	else {v=Head;int i=1;
	if(index==1) {DLN r=new DLN(element,v.Next,null);v.Next.Prev=r;Head=r;}
	else {while((i<index)&&(v.Next!=null)) {v=v.Next;i++;}
	if(i<index) {}
	else if(i==size) {DLN r=new DLN(element,null,v.Prev);v.Prev.Next=r;Tail=r;}
	else {DLN r=new DLN(element,v.Next,v.Prev);
	v.Next.Prev=r;
	v.Prev.Next=r;}
	}}
	}
	
	public void clear() {Head=null;Tail=Head;size=0;}
	
	public boolean isEmpty() {return (Head==null);}
	
	public void remove(int index) {if(index<1) {}
	else if(size==0) {}
	else if(size==1) {if(index==1) {clear();}
	else{}}
	else {
		v=Head;int i=1;if(index==0) {}
		else if(index==1) {size--;Head=v.Next;v.Next=null;Head.Prev=null;}
		else {
			while((i<index)&&(v.Next!=null)) {v=v.Next;i++;}
			if(i<index) {}
			else if((v.Next==null)&&(i==index)) {size--;Tail=v.Prev;v.Prev=null;Tail.Next=null;}
			else {size--;v.Prev.Next=v.Next;v.Next.Prev=v.Prev;v.Next=null;v.Prev=null;}
		}
	}
	}
	
	public int size() {
		v=Head;
		int size=0;
		while(v!=null) {size++;v=v.Next;}
                v=Head;
		return size;
	}
	
	public DLinkedList sublist(int fromIndex, int toIndex) {
		if(fromIndex>toIndex) {return null;}
	else if(fromIndex>this.size||toIndex>this.size) {return null;}
	else if(fromIndex<1) {return null;}
	else
	  {DLinkedList sub=new DLinkedList();
	  if(size==0) {return null;}
	  else if(size==1) {if((fromIndex==1)&&(toIndex==1)) {
	  DLN v=Head;sub.add(v.element);return sub;}else {}}
	  else {int i=1;DLN v=Head;
		  while((v.Next!=null)&&(i<fromIndex)) {i++;v=v.Next;}
		  for(int j=0;j<(toIndex-fromIndex)+1;j++) {sub.add(v.element);
		  v=v.Next;}
		  return sub;
	  } return sub;
	  }

	}
	
	public boolean contains(Object o) {if(size==0) {return false;}
	else{
		v=Head;
		while(v!=null) {if(v.element==o) {return true;}v=v.Next;}
		return false;
	}
	}
}
