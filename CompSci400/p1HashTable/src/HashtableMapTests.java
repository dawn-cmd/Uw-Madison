// --== CS400 Project One File Header ==--
// Name: HuaiYuan Jing
// CSL Username: huaiyuan
// Email: hjing7@wisc.edu
// Lecture #: lec001
// Notes to Grader: <any optional extra notes to your grader>
import java.util.NoSuchElementException;
public class HashtableMapTests {
	/**
	 * Test initialize
	 * @return true if work, false otherwise
	 */
	public static boolean test1() {
		try {
			HashtableMap<Integer, Integer> test = new HashtableMap<>();
			if (test.getCapacity() != 8 || test.getSize() != 0) {
				return false;
			}
			HashtableMap<Integer, Integer> test2 = new HashtableMap<>(100);
			if (test2.getCapacity() != 100 || test.getSize() != 0) {
				return false;
			}
			return true;
		}
		catch (Exception e) {
			System.out.println(23);
			return false;
		}
	}
	/**
	 * Test put and get
	 * @return true if work, false otherwise
	 */
	public static boolean test2() {
		try {
			HashtableMap<Integer, Integer> test = new HashtableMap<>(10);
			test.put(1, 1);
			if (test.getSize() != 1 || test.get(1) != 1) {
				return false;
			}
			
			boolean pass = false;
			try {
				test.put(1, 2);
			}
			catch (IllegalArgumentException e) {
				pass = true;
			}
			if (!pass || test.getSize() != 1) {
				return false;
			}
			test.put(2, 2);
			test.put(3, 3);
			test.put(4, 4);
			test.put(5, 5);
			test.put(6, 6);
			test.put(7, 7);
			if (test.getCapacity() != 20) {
				return false;
			}
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	/**
	 * Test get invalid item
	 * @return true if work, false otherwise
	 */
	public static boolean test3() {
		try {
			HashtableMap<Integer, Integer> test = new HashtableMap<>(100);
			boolean pass = false;
			try {
				test.get(9);
			}
			catch (NoSuchElementException e) {
				pass = true;
			}
			return pass;
		}
		catch (Exception e) {
			return false;
		}
	}
	/**
	 * Test remove
	 * @return true if work, false otherwise
	 */
	public static boolean test4() {
		try {
			HashtableMap<Integer, Integer> test = new HashtableMap<>();
			test.put(1, 2);
			test.remove(1);
			boolean pass = false;
			try {
				test.get(1);
			}
			catch (NoSuchElementException e) {
				pass = true;
			}
			return pass && test.getSize() == 0;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Test containsKey and clear
	 * @return true if work, false otherwise
	 */
	public static boolean test5() {
		try {
			HashtableMap<Integer, Integer> test = new HashtableMap<>(10);
			test.put(1, 1);
			test.put(2, 2);
			test.put(3, 3);
			if (!test.containsKey(1) || test.containsKey(4)) {
				return false;
			}
			test.clear();
			if (test.getSize() != 0 || test.containsKey(1)) {
				return false;
			}
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	public static void main(String[] args) {
		System.out.println("Test 1: " + test1());
		System.out.println("Test 2: " + test2());
		System.out.println("Test 3: " + test3());
		System.out.println("Test 4: " + test4());
		System.out.println("Test 5: " + test5());
	}
}
