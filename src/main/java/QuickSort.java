import java.util.*;

public class QuickSort {
  public static List<int[]> getQuickSort(int[] arr) {
    int[] a = arr.clone();
    List<int[]> sorted = new ArrayList<>();
    sorted.add(a.clone());
    quickSort(a, 0, a.length - 1, sorted);
    return sorted;
  }

  private static void quickSort(int[] a, int low, int high, List<int[]> sorted) {
    if (low < high) {
      int pi = partition(a, low, high, sorted);
      quickSort(a, low, pi - 1, sorted);
      quickSort(a, pi + 1, high, sorted);
    }
  }

  private static int partition(int[] a, int low, int high, List<int[]> sorted) {
    int pivot = a[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (a[j] < pivot) {
        i++;
        swap(a, i, j);
        sorted.add(a.clone());
      }
    }

    swap(a, i + 1, high);
    sorted.add(a.clone());
    return i + 1;
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
