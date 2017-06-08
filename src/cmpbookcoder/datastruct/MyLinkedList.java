package cmpbookcoder.datastruct;
import java.util.*;

public class MyLinkedList  {
	class Node{
		Node next=null;
		int data;
		public Node(int data){
			this.data=data;
		}			
	}
    Node head=null;//����ͷ������
    /**�������������
     * @param d:�������ݵ�����
     */
    public void addNode(int d){
    	Node newnode=new Node(d);
    	if(head==null){
    		head=newnode;
    		return;
    	}
    	Node temp=head;
    	while(temp.next!=null){
    		temp=temp.next;
    	}
    	//add node to end
    	temp.next=newnode;
    }	
    /**
     * @param index ��ɾ����index�����
     * @return �ɹ�����true,ʧ�ܷ���false
     */
    public boolean deleteNode(int index){
    	if(index<1 || index>length()){
    		return false;
    	}
    	//ɾ�������һ��Ԫ��
    	if(index==1){
    		head=head.next;
    		return true;
    	}
    	int i=2;
    	Node prenode=head;
    	Node curnode=prenode.next;
    	while(curnode!=null){
    		if(i==index){
    			prenode.next=curnode.next;
    			return true;
    		}
    		prenode=curnode;
    		curnode=curnode.next;
    		i++;
    	}
    	return true;
    }
    /**
     * @return��������ĳ���
     */
    public int length(){
    	int len=0;
    	Node tmp=head;
    	while(tmp!=null){
    		len++;
    		tmp=tmp.next;
    	}
    	return len;
    }
    /**
     **�����������������
     *����������ͷ���*/
    public Node orderList(){
    	Node nextnode=null;
    	int tmp=0;
    	Node curnode=head;
    	while(curnode!=null){
    		nextnode=curnode.next;
    		while(nextnode!=null){
    			if(curnode.data>nextnode.data){
    				tmp=curnode.data;
    				curnode.data=nextnode.data;
    				nextnode.data=tmp;
    			}
    			nextnode=nextnode.next;
    		}
    		curnode=curnode.next;
    	}
    	return head;   			
    }
    /**��ӡ����
     */
    public void printList(){
    	Node tmp=head;
    	while(tmp!=null){
    		System.out.println(tmp.data);
    		tmp=tmp.next;
    	}
    }
    /**ɾ�������е��ظ����ݣ���1��ʱ�临�Ӷȵͣ��ռ临�Ӷȸߣ�
     * ���������ѱ�����ֵ�洢��һ��Hashtable�У��ڱ��������У�
     * ����ǰ���ʵ�ֵ��Hashtable���Ѿ����ڣ���˵������������ظ��ģ�Ӧɾ��
     **/
    public void deleteDuplecate1(Node head){
    	Hashtable<Integer,Integer> table=new Hashtable<Integer,Integer>();
    	Node tmp=head;
    	Node pre=null;
    	while(tmp!=null){
    		if(table.containsKey(tmp.data)){
                pre.next=tmp.next;
    		}else{
    			 table.put(tmp.data, 1);
    			 pre=tmp;
    		}
    	  tmp=tmp.next;
    	}
    }
    /**ɾ�������ظ����ݣ���2��ʱ�临�Ӷȸߣ��ռ临�Ӷȵͣ�
     * ���������˫��ѭ����������ѭ��������������������ѭ����ǰ�����Ľڵ�Ϊcur,��ѭ����cur��ʼ����
     * ��������cur��ָ��Ľڵ�ֵ��ͬ����ɾ������ظ��ڵ�*/
    public void deleteDuplecate2(Node head){
    	Node cur=head;
    	while(cur!=null){
    		Node tmp=cur;
    		while(tmp.next!=null){
    			if(cur.data==tmp.next.data){
    				tmp.next=tmp.next.next;
    			}else{
    				tmp=tmp.next;
    			}
    		}
    		cur=cur.next;                               
    	}
    }
    /**�ҳ��������еĵ�����k��Ԫ�أ�
     * ��1���ȱ���һ�鵥�����������ĳ���n,
     * Ȼ�󽫵�����k��Ԫ��ת��Ϊ������n-k(��0��ʼǰ��n-k��),����ȥ����һ�ξͿ��Եõ������ע��������0��ʼ������
     * ��2������1������ش�ͷ��β�ķ���������е�ĳ��Ԫ�ؿ�ʼ������k��Ԫ�غ�ǡ��ֵΪnull������˵����k-1��Ԫ�غ�ǡ�õ�������β����node.next==null��,
     * ��ô��Ԫ�ؾ���Ҫ�ҵĵ�����k��Ԫ�ء�˼·���£���ͷ�ڵ㿪ʼ�����ζ������ÿһ���ڵ�Ԫ�ؽ��������Ĳ��ԣ�����k��Ԫ�غ�鿴��ǰֵ�Ƿ�Ϊnull,
     * ֱ���ҵ��Ǹ�������k��Ԫ��
     * ��3����Ч��ʽ��ֻ�����1�μ����ҵ�������k��Ԫ�أ�˼·���£���������ָ�룬������һ��ָ�����һ��ָ����ǰ��k-1����Ȼ������ָ����ǰ�ƶ���
     * ѭ��ֱ�����е�ָ��node.next==nullʱ����һ��ָ����ָλ�þ���Ҫ�ҵ�λ�á�*/
    public Node findElem(Node head,int k){
    	if(k<1){
    		return null;
    	}
    	Node p1=head;
    	Node p2=head;
    	//ǰ��k-1��
    	for(int i=0;i<k-1 && p1!=null;i++){
    		p1=p1.next;
    	}
    	if(p1==null){
    		System.out.println("k���Ϸ�");
    		return null;
    	}
    	while(p1.next!=null){
    		p1=p1.next;
    		p2=p2.next;
    	}
    	return p2;
    }
    /**��ת���������ǵ���ָ���ָ������i��m��n,Ϊ��������Ͽ�����Ҫ�ڵ���m��next֮ǰ��n����������
     * �����������ҵ���ת�������ͷ��㣬Ҳ����ԭʼ�����β�ڵ㣬��nextΪ�յĽڵ�*/
    public void reverseIteratively(Node head){
    	Node reversehead=head;
    	Node curnode=head;
    	Node prenode=null;
    	while(curnode!=null){
    		Node nextnode=curnode.next;
    		if(nextnode==null)
    			reversehead=curnode;
    		curnode.next=prenode;
    		prenode=curnode;
    		curnode=nextnode;
    		
    	}
    	this.head=reversehead;   	
    }
    /**��β��ͷ���������
     * ��1����ͷ��β����������ÿ����һ���ڵ㣬�Ѹýڵ����һ��ջ�У�����ջ�Ƚ�������ص㣬��������
     * ����������ʱ���ٴ�ջ������ڵ��ֵ��
     * ��2���ݹ�ı�����һ��ջ�ṹ��ÿ����һ���ڵ㣬�ȵݹ����������Ľڵ㣬������ýڵ㱾��;�ŵ��ǲ���Ҫά�������ջ�ռ�*/
    public void printListReversely(Node phead){
    	if(phead!=null){
    		printListReversely(phead.next);
    		System.out.println(phead.data);
    	}
    }
    /**Ѱ��������м�ڵ㣿
     * ��1����������ĳ���length,Ȼ�����length/2�ľ��뼴���ҵ�������м�ڵ㣬ȱ������Ҫ������������
     * ��2������˫ָ�룬��ָ���ͷ��ʼ������һ����ָ��һ����������һ����ָ��һ����һ��������ָ�뵽������β��ʱ����ָ��ǡ����������в�
     * ����������Ϊ����������ָ�뵽������β��ʱ����ָ��ָ��ļ��������м�ڵ㣻��������Ϊż��ʱ����ָ��ָ��Ľڵ����ָ��ָ��ڵ����һ���ڵ�
     * ����������м�ڵ㣩*/
    public Node searchMid(Node head){
    	Node p=head;
    	Node q=head;
    	while(p!=null && p.next!=null && p.next.next!=null){
    		p=p.next.next;//��ָ��
    		q=q.next;//��ָ��
    	}
    	return q;
    }
    /**���һ�������Ƿ��л���
     *��������ָ�룬��ָ��fast����ָ��slow,��ʼֵ��ָ������ͷ��slowÿ��ǰ��1����fastÿ��ǰ��2����ͬʱ��ǰ�ƶ�����ָ��ÿ�ƶ�һ��
     *��Ҫ����ָ��Ƚϣ�ֱ����ָ�������ָ��Ϊֹ�������˵������л������򣬴������޻���fast�ȵ�β��Ϊnullʱ�����޻�����*/
    public boolean isLoop(Node head){
    	Node fast=head;
    	Node slow=head;
    	if(fast==null)
    		return false;
    	while(fast!=null && fast.next!=null){
    		fast=fast.next.next;
    		slow=slow.next;
    		if(fast==slow)
    			return true;
    	}
    	return !(fast==null || fast.next==null);
    }
    /**����ҵ�������ڵ��أ�
     * ������ΪL����ڻ���������ľ���Ϊx,��㵽����ڵ�ľ���Ϊa,����Ϊr,�����㣺
     * a+x=nr;
     * a+x=(n-1)r+r=(n-1)r+L-a;
     * a=(n-1)r+(L-a-x);
     * ����(L-a-x)Ϊ�����㵽����ڵ�ľ��룬������ͷ��������ֱ���һ��ָ�룬ÿ�θ���1��������ָ��ض��������������ĵ�һ��Ϊ����ڵ�*/
    public Node findLoopPort(Node head){
    	Node slow=head;
    	Node fast=head;
    	if(fast==null)
    		return null;
    	while(fast!=null && fast.next!=null){
    		slow=slow.next;
    		fast=fast.next.next;
    		if(fast==slow)
    			break;
    	}
    	if(fast==null || fast.next==null)
    		return null;
    	slow=head;
    	while(slow!=fast){
    		slow=slow.next;
    		fast=fast.next;
    	}
    	return slow;
    }
  /**����ڲ�֪��ͷ�ڵ�������ɾ��ָ���ڵ㣿
   * ��Ϊ����������ۣ�1������ɾ���ڵ�Ϊ����β�ڵ㣬���޷�ɾ������Ϊɾ�����޷�ʹ��ǰ���ڵ��nextָ����Ϊ�գ�
   * 2������ɾ���Ľڵ㲻��β�ڵ㣬�����ͨ����������ڵ������̽ڵ��ֵ��Ȼ��ɾ����̽ڵ�ﵽɾ��ָ���ڵ��Ŀ��*/  
    public boolean deleteNode(Node n){
    	if(n==null || n.next==null)
    		return false;
    	int tmp=n.data;
    	n.data=n.next.data;
    	n.next.data=tmp;
    	n.next=n.next.next;
    	return true;
    }
    /**����ж����������Ƿ��ཻ��
     * �����������ཻ��������һ������ͬ��β�ڵ㣬˼·Ϊ���ֱ��������������¼���ǵ�β�ڵ㣬
     * �����ǵ�β�ڵ���ͬ���������������ཻ�������ཻ*/
    public boolean isIntersect(Node n1,Node n2){
    	if(n1==null || n2==null)
    		return false;
    	Node tail1=n1;
    	Node tail2=n2;
    	//�ҵ�����n1�����һ���ڵ�
    	while(tail1.next!=null){
    		tail1=tail1.next;
    	}
    	//�ҵ�����n2�����һ���ڵ�
    	while(tail2.next!=null){
    		tail2=tail2.next;
    	}
    	return tail1==tail2;
    }
    /**�����������ཻ������ҵ������ཻ�ĵ�һ���ڵ㣿
     * �ֱ������������head1��head2�ĳ���len1��len2(����len1>len2),�����ȶ�����head1����(len1-len2)���ڵ㵽�ڵ�p,��ʱ�ڵ�p��head��
     * �����ཻ�ڵ�ľ�����ͬ����ʱͬʱ������������ֱ��������ͬ�Ľڵ�Ϊֹ������ڵ�����ཻ�Ľڵ㣻
     * ע�⣺Ӧ�����ж����������Ƿ��ཻ���ٽ��к�������*/
    public static Node getFirstMeetNode(Node h1,Node h2){
    	if(h1==null || h2==null)
    		return null;
    	Node tail1=h1;
    	Node tail2=h2;
    	int len1=1;
    	int len2=2;
    	while(tail1.next!=null){
    		tail1=tail1.next;
    		len1++;
    	}
    	while(tail2.next!=null){
    		tail2=tail2.next;
    		len2++;
    	}
    	//�������ཻ
    	if(tail1!=tail2){
    		return null;
    	}
    	Node t1=h1;
    	Node t2=h2;
    	//�ҳ��ϳ��������ȱ���
    	if(len1>len2){
    		int d=len1-len2;
    		while(d!=0){
    			t1=t1.next;
    			d--;
    		}
    	}else{
    		int d=len2-len1;
    		while(d!=0){
    			t2=t2.next;
    			d--;
    		}
    	}
    	while(t1!=t2){
    		t1=t1.next;
    		t2=t2.next;
    	}
    	return t1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MyLinkedList list=new MyLinkedList();
        list.addNode(5);
        list.addNode(3);
        list.addNode(1);
        list.addNode(3);
        System.out.println("listLen= "+list.length());
        System.out.println("before order");
        list.printList();
        list.orderList();
        System.out.println("after order");
        list.printList();
	}

}
