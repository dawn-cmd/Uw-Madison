// --== CS400 Project One File Header ==--
// Name: HuaiYuan Jing
// CSL Username: huaiyuan
// Email: hjing7@wisc.edu
// Lecture #: lec001
// Notes to Grader: <any optional extra notes to your grader>
import java.util.NoSuchElementException;
public class HashtableMap<K, V> implements MapADT<K, V>{
	private double ratio = 0.7;
	private int size = 0;
	protected class Node {
		protected K key;
		protected V val;
		protected Node (K key, V val) {
			this.key = key;
			this.val = val;
		}
	}
	protected Object[] table;
	public HashtableMap(int capacity) {
		table = new Object[capacity];
	}
	public HashtableMap() {
		table = new Object[8];
	}
	private int linearPrompt(int id, Object[] table) {
		while (id < table.length && table[id] != null) {
			id += 1;
		}
		return id;
	}
	private void reHash() {
		int tmp = table.length * 2;
		Object[] newTable = new Object[tmp];
		for (int i = 0, id; i < table.length; ++i) {
			if (table[i] == null) {
				continue;
			}
			Node temp = (Node) table[i];
			id = linearPrompt(temp.key.hashCode() % newTable.length, newTable);
			newTable[id] = temp;
		}
		table = newTable;
	}
	@Override
	public void put(K key, V value) throws IllegalArgumentException {
		if (key == null || containsKey(key)) {
			throw new IllegalArgumentException();
		}
		Node tmp = new Node(key, value);
		int id = linearPrompt(key.hashCode() % table.length, table);
		if (id == table.length) {
			reHash();
			put(key, value);
			return;
		}
		size += 1;
		table[id] = tmp;
		while (size >= table.length * ratio) {
			reHash();
		}
	}
	@Override
	public boolean containsKey(K key) {
		int id = key.hashCode() % table.length;
		while (id < table.length) {
			if (table[id] == null) {
				id += 1;
				continue;
			}
			Node tmp = (Node) table[id];
			if (tmp.key.equals(key)) {
				return true;
			}
			id += 1;
		}
		return false;
	}
	@Override
	public V get(K key) throws NoSuchElementException {
		int id = key.hashCode() % table.length;
		while (id < table.length) {
			if (table[id] == null) {
				id += 1;
				continue;
			}
			Node tmp = (Node)table[id];
			if (tmp.key.equals(key)) {
				return tmp.val;
			}
			id += 1;
		}
		throw new NoSuchElementException();
	}
	@Override
	public V remove(K key) throws NoSuchElementException {
		int id = key.hashCode() % table.length;
		while (id < table.length) {
			if (table[id] == null) {
				id += 1;
				continue;
			}
			Node tmp = (Node)table[id];
			if (tmp.key.equals(key)) {
				V ans = tmp.val;
				table[id] = null;
				size -= 1;
				return ans;
			}
			id += 1;
		}
		throw new NoSuchElementException();
	}
	@Override
	public void clear() {
		for (int i = 0; i < table.length; ++i) {
			table[i] = null;
		}
		this.size = 0;
	}
	@Override
	public int getSize() {
		return size;
	}
	@Override
	public int getCapacity() {
		return table.length;
	}
}
