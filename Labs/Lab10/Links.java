
@SuppressWarnings("unchecked")

public class Links  
{
	public static void main(String[] args)
	{
          	Node pos1 = null;
    		Node pos2 = null;
    		pos1 = new Node(new Integer(13));
   		pos1.setNext(new Node(new Integer(15), null));
    		pos2 = new Node(new Integer(11), null);
		pos2.setNext(pos1);
		printList(pos2);
		System.out.println("The number of nodes in linked list is "+count(pos2));
		System.out.println(getMax(pos2));
	}

	private static void printList(Node head)
	{
		if (head != null)
		{
			System.out.println(head.getItem());
			printList(head.getNext());
		}
	}

	public static int count(Node head)
	{
		if(head==null)
		{
			return 0;
		}
		else
		{
			return 1+count(head.getNext());
		}
	}

	public static Object getMax(Node head )
	{
		Comparable  max = (Comparable)head.getItem();
		Node prev, curr = head;
		for(prev=null, curr = head; curr!=null; prev=curr,curr=curr.getNext())
		{
			if(max.compareTo(curr.getItem())<0)
			{
				max = (Comparable)curr.getItem();
			}

		}
		return max;
	}
	
}
