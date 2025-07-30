import java.util.*;
public class InsertionSort{
  public static List<int[]> getInsertionSort(int[] arr){
    int a[] = arr.clone();
    int n = a.length;
    List<int[]> sorted = new ArrayList<int[]>();
    sorted.add(a.clone());
    for(int i =1;i<n;i++){
      for(int j =i; j>0;j--){
        if(a[j]<a[j-1]){
          int t = a[j];
          a[j] = a[j-1];
          a[j-1] = t;
          sorted.add(a.clone());
        }else{
          break;
        }
      }
    }
    return sorted;
  }
}