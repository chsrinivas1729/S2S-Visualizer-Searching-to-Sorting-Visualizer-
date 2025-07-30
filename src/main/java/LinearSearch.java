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
            int[] marked = a.clone();
            // Mark current index being checked by making it negative
            marked[i] = -Math.abs(marked[i]);
            sorted.add(new Sorted(marked, i, false));

            if (a[i] == target) {
                // Mark found value by multiplying with 10000
                marked[i] = target * 10000;
                sorted.add(new Sorted(marked, i, true));
                break;
            }
        }

        return sorted;
    }
}
