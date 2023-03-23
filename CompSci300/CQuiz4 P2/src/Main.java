public class Main {
	public static void main(String[] args) {
		String[] names = new String[]{"A", "B", "C", "D"};
		HolidayPrizeIterator iterator = new HolidayPrizeIterator(names);
		for (HolidayPrizeIterator it = iterator; it.hasNext(); ) {
			String s = (String) it.next();
			System.out.println(s);
		}
	}
}