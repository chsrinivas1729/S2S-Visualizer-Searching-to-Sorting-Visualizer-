import java.util.*;

public class BubbleSort {
  public static List<int[]> getBubbleSort(int[] arr) {
    List<int[]> sorted = new ArrayList<>();
    int[] a = arr.clone();
    int n = a.length;

    sorted.add(a.clone());

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        sorted.add(a.clone());
        if (a[j] > a[j + 1]) {
          int temp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = temp;
          sorted.add(a.clone());
        }
      }
    }

    return sorted;
  }
}
