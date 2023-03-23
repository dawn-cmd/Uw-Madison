public class VendingMachine {
    public static String[][] items;
    public static int itemsCount;

    public static boolean containsItem(String itemName, String itemDate) {
        for (int i = 0; i < itemsCount; ++i) {
            if (items[i][0].equals(itemName) && items[i][1].equals(itemDate)) {
                return true;
            }
        }
        return false;
    }

    public static int getItemsOccurrences(String itemName) {
        int count = 0;
        for (int i = 0; i < itemsCount; ++i) {
            if (items[i][0].equals(itemName)) {
                count += 1;
            }
        }
        return count;
    }

    public static int getItemsOccurrencesByExpirationDate(String itemName, String itemDate) {
        int count = 0;
        for (int i = 0; i < itemsCount; ++i) {
            if (items[i][0].equals(itemName) && Integer.getInteger(items[i][1]) > Integer.getInteger(itemDate)) {
                count += 1;
            }
        }
        return count;
    }

    public static int getIndexNextItem(String itemName) {
        for (int i = 0; i < itemsCount; ++i) {
            if (items[i][0].equals(itemName)) {
                return;
            }
        }
    }

    public static void main(String[] args) {

    }
}
