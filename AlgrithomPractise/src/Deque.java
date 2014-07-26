import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

	@SuppressWarnings("hiding")
	public class ItemNode<Item> {
		// Iteam currentIteam;
		Item value;
		ItemNode<Item> preIteam;
		ItemNode<Item> nextIteam;

		public ItemNode(Item val) {
			// TODO Auto-generated constructor stub
			this.value = val;
		}
	}

	private ItemNode<Item> FirstListNode;
	private ItemNode<Item> lastListNode;
	private int size;

	public Deque() // construct an empty deque
	{
		FirstListNode = null;
		lastListNode = null;
		size = 0;
	}

	public boolean isEmpty() // is the deque empty?
	{
		return size == 0 ? true : false;
	}

	public int size() // return the number of items on the deque
	{
		return size;
	}

	public void addFirst(Item item) // insert the item at the front
	{
		ItemNode<Item> newFirstNode = new ItemNode<Item>(item);
		newFirstNode.nextIteam = this.FirstListNode;
		this.FirstListNode.preIteam = newFirstNode;
		this.FirstListNode = this.FirstListNode.preIteam;
		size++;
	}

	public void addLast(Item item) // insert the item at the end
	{
		ItemNode<Item> newLastNode = new ItemNode<Item>(item);
		newLastNode.preIteam = this.FirstListNode;
		this.lastListNode.nextIteam = newLastNode;
		this.lastListNode = this.lastListNode.nextIteam;
		size++;
	}

	public Item removeFirst() // delete and return the item at the front
	{
		Item tmp = this.FirstListNode.value;
		this.FirstListNode = this.FirstListNode.nextIteam;
		this.FirstListNode.preIteam = null;
		size--;
		return tmp;
	}

	public Item removeLast() // delete and return the item at the end
	{
		Item tmp = this.lastListNode.value;
		this.lastListNode = this.lastListNode.preIteam;
		this.lastListNode.nextIteam = null;
		size--;
		return tmp;
	}

	public Iterator<Item> iterator() // return an iterator over items in order
										// from front to end
	{
		return null;

	}

	public static void main(String[] args) // unit testing
	{

	}
}