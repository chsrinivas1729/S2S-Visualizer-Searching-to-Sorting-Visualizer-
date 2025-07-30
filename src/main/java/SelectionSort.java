import java.util.*;
public class SelectionSort{
  public static List<int[]> getSelectionSort(int[] arr){
    int a[] = arr.clone();
    List<int[]> sorted = new ArrayList<int[]>();
    int n = a.length;
    sorted.add(a.clone());
    int min = Integer.MAX_VALUE;
    int k = 0;
    for(int i =0 ;i<n;i++){
      for(int j = i;j<n;j++){
        min = Math.min(min,a[j]);
        if(a[j] == min){
          k = j;
        }
      }
      int temp = a[i];
      a[i] = min;
      a[k] = temp;
      sorted.add(a.clone());
      min = Integer.MAX_VALUE;
    }
    return sorted;
  }
}