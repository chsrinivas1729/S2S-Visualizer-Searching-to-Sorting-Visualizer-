import java.util.*;

public class BinarySearch {
  public static class SearchStep {
    public int[] array;
    public int mid;
    public boolean found;
    public int low;
    public int high;

    public SearchStep(int[] array, int mid, boolean found, int low, int high) {
      this.array = array;
      this.mid = mid;
      this.found = found;
      this.low = low;
      this.high = high;
    }
  }

  public static List<SearchStep> getBinarySearch(int[] arr, int target) {
    int a[] = arr.clone();
    List<SearchStep> search = new ArrayList<>();
    int n = a.length;
    int low = 0;
    int high = n - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      
      if (a[mid] == target) {
        search.add(new SearchStep(a.clone(), mid, true, low, high));
        break;
      } else {
        search.add(new SearchStep(a.clone(), mid, false, low, high));
        if (a[mid] > target) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
    }

    return search;
  }
}
//doing some chnages