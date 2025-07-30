import java.util.*;

public class LinearSearch {
    public static class Sorted {
        public int[] array;
        public int index;
        public boolean found;

        public Sorted(int[] array, int index, boolean found) {
            this.array = array;
            this.index = index;
            this.found = found;
        }
    }

    public static List<Sorted> getLinearSearch(int[] arr, int target) {
        List<Sorted> sorted = new ArrayList<>();
        int[] a = arr.clone();

        for (int i = 0; i < a.length; i++) {
            // Send original array with current index
            sorted.add(new Sorted(a.clone(), i, false));

            if (a[i] == target) {
                // Send original array with found index
                sorted.add(new Sorted(a.clone(), i, true));
                break;
            }
        }

        return sorted;
    }
}
