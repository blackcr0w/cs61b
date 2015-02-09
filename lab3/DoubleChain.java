
public class DoubleChain {
	
	private DNode head;
	
	public DoubleChain(double val) {
		head = new DNode (val); 
	}

	public DNode getFront() {
		return head;
	}

	/** Returns the last item in the DoubleChain. */		
	public DNode getBack() {
		/* your code here */
		DNode p = head;
		while (p.next != null) {
			p = p.next;
		}

		return p;
	}
	
	/** Adds D to the front of the DoubleChain. */	
	public void insertFront(double d) {
		/* your code here */
		
        if (head.next == null) {
        	DNode newFront = new DNode (head, head.val, null);
        	head.next = newFront;
        	head.val = d;
        	
        }
        else {
        	DNode oldFrontItem = head.next;
        	DNode newFrontItem = new DNode(head, head.val, oldFrontItem);
        	head.next = newFrontItem;
        	oldFrontItem.prev = newFrontItem;
        	head.val = d;
        }
        /********size = size + 1*/

	}
	
	/** Adds D to the back of the DoubleChain. */	
	public void insertBack(double d) {
		/* your code here */
        DNode p = head;

        while (p.next != null) {
            p = p.next;
        }

        p.next = new DNode(p, d, null);
        // p.next.prev=p;

	}
	
	/** Removes the last item in the DoubleChain and returns it. 
	  * This is an extra challenge problem. */
	public DNode deleteBack() {
		/* your code here */
		DNode p = head;
		while (p != null) {
			p = p.next;			
		}
		DNode newBack = p.prev;
		newBack.next = null;
		p.prev = null;
		return p;
	}
	
	/** Returns a string representation of the DoubleChain. 
	  *?????????????????????
	  *?????????????????????
	  * This is an extra challenge problem. */
	public String toString() {
		/* your code here */		
		return null;
	}

	public static class DNode {
		public DNode prev;
		public DNode next;
		public double val;
		
		/*important*/
		private DNode(double val) {
			this(null, val, null);
		}
		
		/*important*/

		private DNode(DNode prev, double val, DNode next) {
			this.prev = prev;
			this.val = val;
			this.next =next;
		}
	}
	
}

