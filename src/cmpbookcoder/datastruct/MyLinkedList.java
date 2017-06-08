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
    Node head=null;//链表头的引用
    /**向链表插入数据
     * @param d:插入数据的内容
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
     * @param index ：删除第index个结点
     * @return 成功返回true,失败返回false
     */
    public boolean deleteNode(int index){
    	if(index<1 || index>length()){
    		return false;
    	}
    	//删除链表第一个元素
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
     * @return返回链表的长度
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
     **对链表进行升序排序
     *返回排序后的头结点*/
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
    /**打印链表
     */
    public void printList(){
    	Node tmp=head;
    	while(tmp!=null){
    		System.out.println(tmp.data);
    		tmp=tmp.next;
    	}
    }
    /**删除链表中的重复数据：法1：时间复杂度低，空间复杂度高；
     * 遍历链表，把遍历的值存储到一个Hashtable中，在遍历过程中，
     * 若当前访问的值在Hashtable中已经存在，则说明这个数据是重复的，应删除
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
    /**删除链表重复数据：法2：时间复杂度高，空间复杂度低；
     * 对链表进行双重循环遍历，外循环正常遍历链表，假设外循环当前遍历的节点为cur,内循环从cur开始遍历
     * 若碰到与cur所指向的节点值相同，则删除这个重复节点*/
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
    /**找出单链表中的倒数第k个元素：
     * 法1：先遍历一遍单链表，获得链表的长度n,
     * 然后将倒数第k个元素转换为正数第n-k(从0开始前移n-k步),接下去遍历一次就可以得到结果（注意正数从0开始计数）
     * 法2：性质1；如果沿从头至尾的方向从链表中的某个元素开始，遍历k个元素后恰好值为null（或者说遍历k-1个元素后恰好到达链表尾，即node.next==null）,
     * 那么该元素就是要找的倒数第k个元素。思路如下：从头节点开始，依次对链表的每一个节点元素进行这样的测试，遍历k个元素后查看当前值是否为null,
     * 直到找到那个倒数第k个元素
     * 法3：高效方式，只需遍历1次即可找到倒数第k个元素；思路如下：设置两个指针，让其中一个指针比另一个指针先前移k-1步，然后两个指针向前移动，
     * 循环直到先行的指针node.next==null时，另一个指针所指位置就是要找的位置。*/
    public Node findElem(Node head,int k){
    	if(k<1){
    		return null;
    	}
    	Node p1=head;
    	Node p2=head;
    	//前移k-1步
    	for(int i=0;i<k-1 && p1!=null;i++){
    		p1=p1.next;
    	}
    	if(p1==null){
    		System.out.println("k不合法");
    		return null;
    	}
    	while(p1.next!=null){
    		p1=p1.next;
    		p2=p2.next;
    	}
    	return p2;
    }
    /**反转单链表：就是调整指针的指向，例如i、m、n,为避免链表断开，需要在调整m的next之前把n保存下来，
     * 接下来试着找到反转后链表的头结点，也就是原始链表的尾节点，即next为空的节点*/
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
    /**从尾到头输出单链表？
     * 法1：从头到尾遍历单链表，每经过一个节点，把该节点放入一个栈中，利用栈先进后出的特点，当遍历完
     * 整个单链表时，再从栈顶输出节点的值；
     * 法2：递归的本质是一个栈结构，每访问一个节点，先递归输出它后面的节点，再输出该节点本身;优点是不需要维护额外的栈空间*/
    public void printListReversely(Node phead){
    	if(phead!=null){
    		printListReversely(phead.next);
    		System.out.println(phead.data);
    	}
    }
    /**寻找链表的中间节点？
     * 法1：先求单链表的长度length,然后遍历length/2的距离即可找到链表的中间节点，缺点是需要遍历两次链表
     * 法2：采用双指针，两指针从头开始遍历，一个快指针一次走两步，一个慢指针一次走一步，当快指针到达链表尾部时，满指针恰好在链表的中部
     * （若链表长度为奇数，当快指针到达链表尾部时，慢指针指向的即是链表中间节点；当链表长度为偶数时，慢指针指向的节点和慢指针指向节点的下一个节点
     * 都是链表的中间节点）*/
    public Node searchMid(Node head){
    	Node p=head;
    	Node q=head;
    	while(p!=null && p.next!=null && p.next.next!=null){
    		p=p.next.next;//快指针
    		q=q.next;//慢指针
    	}
    	return q;
    }
    /**检测一个链表是否有环？
     *定义两个指针，快指针fast和慢指针slow,初始值都指向链表头，slow每次前进1步，fast每次前进2步，同时向前移动，快指针每移动一次
     *都要和慢指针比较，直到快指针等于慢指针为止，表明此单链表有环；否则，此链表无环（fast先到尾部为null时，是无环链表）*/
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
    /**如何找到环的入口点呢？
     * 设链表长为L，入口环与相遇点的距离为x,起点到环入口点的距离为a,环长为r,则满足：
     * a+x=nr;
     * a+x=(n-1)r+r=(n-1)r+L-a;
     * a=(n-1)r+(L-a-x);
     * 其中(L-a-x)为相遇点到环入口点的距离，在链表头和相遇点分别设一个指针，每次各走1步，两个指针必定相遇，且相遇的第一点为环入口点*/
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
  /**如何在不知道头节点的情况下删除指定节点？
   * 分为两种情况讨论：1、若待删除节点为链表尾节点，则无法删除，因为删除后无法使其前驱节点的next指针置为空；
   * 2、若待删除的节点不是尾节点，则可以通过交换这个节点与其后继节点的值，然后删除后继节点达到删除指定节点的目的*/  
    public boolean deleteNode(Node n){
    	if(n==null || n.next==null)
    		return false;
    	int tmp=n.data;
    	n.data=n.next.data;
    	n.next.data=tmp;
    	n.next=n.next.next;
    	return true;
    }
    /**如何判断两个链表是否相交？
     * 若两个链表相交，则它们一定有相同的尾节点，思路为：分别遍历两个链表，记录它们的尾节点，
     * 若它们的尾节点相同，则这两个链表相交，否则不相交*/
    public boolean isIntersect(Node n1,Node n2){
    	if(n1==null || n2==null)
    		return false;
    	Node tail1=n1;
    	Node tail2=n2;
    	//找到链表n1的最后一个节点
    	while(tail1.next!=null){
    		tail1=tail1.next;
    	}
    	//找到链表n2的最后一个节点
    	while(tail2.next!=null){
    		tail2=tail2.next;
    	}
    	return tail1==tail2;
    }
    /**若两个链表相交，如何找到它们相交的第一个节点？
     * 分别计算两个链表head1、head2的长度len1、len2(假设len1>len2),接着先对链表head1遍历(len1-len2)个节点到节点p,此时节点p与head到
     * 它们相交节点的距离相同，此时同时遍历两个链表，直到遇到相同的节点为止，这个节点就是相交的节点；
     * 注意：应该先判断两个链表是否相交，再进行后续操作*/
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
    	//两链表不相交
    	if(tail1!=tail2){
    		return null;
    	}
    	Node t1=h1;
    	Node t2=h2;
    	//找出较长的链表，先遍历
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
