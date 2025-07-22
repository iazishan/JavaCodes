
public class Node {

	String name;
	int age;
	Node head;
	Node next;

	Node(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void insertAtStart(String name, int age) {
		Node d = new Node(name, age);
		if (head == null) {
			head = d;
		} else {
			d.next = head;
			head = d;
		}
	}

	public void insertAtEnd(String name, int age) {
		Node d = new Node(name, age);
		if (head == null) {
			head = d;
		} else {
			Node loop = head;
			while (loop.next != null) {
				loop = loop.next;
			}
			loop.next = d;
		}
	}

	public void insertAftername(String afname, String name, int age) {
		Node d = new Node(name, age);
		if (head == null) {
			System.out.println("List is empty.....");
		} else if (head.name == afname) {
			d.next = head.next;
			head.next = d;
		} else {
			Node loop = head;
			while (loop != null) {
				if (loop.name == afname) {
					d.next = loop.next;
					loop.next = d;
				}
				loop = loop.next;
			}
		}
	}

	public void insertBeforename(String bfname, String name, int age) {
		Node d = new Node(name, age);
		if (head == null) {
			System.out.println("List is empty.....");
		} else if (head.name == bfname) {
			d.next = head;
			head = d;
		} else if (head.next.name == bfname) {
			d.next = head.next;
			head.next = d;
		} else {
			Node loop = head;
			while (loop.next.next != null && loop.next != null) {
				if (loop.next.next.name == bfname) {
					d.next = loop.next.next;
					loop.next = d;
				}
				loop = loop.next;
			}
		}
	}

	public void delAtStart() {
		if (head == null) {
			System.out.println("List is empty.....");
		} else {
			head = head.next;
		}
	}

	public void delAtEnd() {
		if (head == null) {
			System.out.println("List is empty.....");
		} else if (head.next == null) {
			head = null;
		} else {
			Node loop = head;
			while (loop != null) {
				if (loop.next.next == null) {
					loop.next = null;
				}
				loop = loop.next;
			}
		}
	}

	public void delAftername(String afname) {
		if (head == null) {
			System.out.println("List is empty.....");
		} else {
			Node loop = head;
			while (loop != null) {
				if (loop.name.equalsIgnoreCase(afname)) {
					loop.next = loop.next.next;
				}
				loop = loop.next;
			}
		}
	}

	public void delBeforenmae(String bfname) {
		if (head == null) {
			System.out.println("List is empty.....");
		} else if (head.name.equalsIgnoreCase(bfname)) {
			System.out.println("No data found.....");
		} else if (head.next.name.equalsIgnoreCase(bfname)) {
			head = head.next;
		} else {
			Node loop = head;
			while (loop.next.next != null && loop.next != null) {
				if (loop.next.next.name.equalsIgnoreCase(bfname)) {
					loop.next = loop.next.next;
				}
				loop = loop.next;
			}
		}
	}

}