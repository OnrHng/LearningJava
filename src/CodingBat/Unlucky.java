package CodingBat;

public class Unlucky {
//
//  We'll say that a 1 immediately followed by a 3 in an array is an "unlucky" 1.
//  Return true if the given array contains an unlucky 1 in the first 2 or last 2 positions in the array.
//
//
//  unlucky1([1, 3, 4, 5]) → true
//  unlucky1([2, 1, 3, 4, 5]) → true
//  unlucky1([1, 1, 1]) → false

  public static void main(String[] args) {
    int[] arr1 = {1,3,4,5};
    int[] arr2 = {2, 1, 3, 4, 5};
    int[] arr3 = {1, 1, 1};
    int[] arr4 = {0,0,1, 3,1, 1};
    int[] arr5 = {1, 1, 1, 3, 1};
    int[] arr6 = {1};
    System.out.println(unlucky1(arr1));
    System.out.println(unlucky1(arr2));
    System.out.println(unlucky1(arr3));
    System.out.println(unlucky1(arr4));
    System.out.println(unlucky1(arr5));
    System.out.println(unlucky1(arr6));

  }

  public static boolean unlucky1(int[] nums) {

    for (int i = 0; i < nums.length - 1; i++) {
      if ((nums[i] == 1 && nums[i+1] == 3) && (i == 0 || i == 1 || i == nums.length - 2)) {
        return true;
      }
    }
    return false;

//    if (nums.length>2){
//      if ((
//              (nums[0]==1 && nums[1]==3) || (nums[1]==1 && nums[2]==3))
//              || ((nums[nums.length-2]==1 && nums[nums.length-1]==3)
//      )){
//        return true;
//      }else{
//        return false;
//      }
//    }else if (nums.length==2) {
//      if ((nums[0] == 1) && (nums[1] == 3)) {
//        return true;
//      } else
//        return false;
//    }
//
//    return false;
//
  }

}
