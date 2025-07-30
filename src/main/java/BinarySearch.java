import java.util.*;

public class BinarySearch {
  public static List<int[]> getBinarySearch(int[] arr, int target) {
    int a[] = arr.clone();
    List<int[]> search = new ArrayList<int[]>();
    int n = a.length;
    int low = 0;
    int high = n - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      search.add(markIndex(a, mid));

      if (a[mid] == target) {
        search.add(markFound(a, mid));
        break;
      } else if (a[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return search;
  }

  private static int[] markIndex(int[] a, int i) {
    int[] marked = a.clone();
    marked[i] = -marked[i];
    return marked;
  }

  private static int[] markFound(int[] a, int i) {
    int[] marked = a.clone();
    marked[i] = 100000 + marked[i];
    return marked;
  }
}
