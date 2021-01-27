package ListsAutoboxingUnboxing.Array;

import java.util.Arrays;

public class ReverseArray {
  public static void main(String[] args) {
    int[] arr = {1,2,3,4};
    reverse(arr);
    System.out.println(Arrays.toString(arr));
  }
  private static void reverse(int[] arr) {
    int lastIndex = arr.length - 1;
    for (int i = 0; i < arr.length/2; i++) {
      int temp = arr[i];
      arr[i] = arr[lastIndex - i];
      arr[lastIndex - i] = temp;
    }
  }
}
