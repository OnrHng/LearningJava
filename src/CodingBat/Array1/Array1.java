package CodingBat.Array1;

import java.util.Arrays;

public class Array1 {


  public static void main(String[] args) {
//    int re = 11/2;
//    int mod = 11%2;
//    System.out.println(re);
//    System.out.println(mod);
//
//    int[] result = middleWay2(new int[]{1,2,3,4,5,6,67,7,8,9,10,11});
//    System.out.println(Arrays.toString(result));

    int[] result2 = make2(new int[] {}, new int[] {});
    System.out.println(result2);
  }

  public boolean firstLast6(int[] nums) {

    /*
    Given an array of ints, return true if 6 appears as either the first or last element in the array. The array will be length 1 or more.
    firstLast6([1, 2, 6]) → true
    firstLast6([6, 1, 2, 3]) → true
    firstLast6([13, 6, 1, 2, 3]) → false
     */

    return nums[0] == 6 || nums[nums.length - 1] == 6;



  }

  public int[] makePi() {
    return new int[]{3,1,4};
  }

  public boolean commonEnd(int[] a, int[] b) {
    return ( a[0]==b[0] || a[a.length-1]==b[b.length-1] );

  }

  public int sum3(int[] nums) {
    return nums[0]+nums[1]+nums[2];
  }

  public int[] rotateLeft3(int[] nums) {
    int first = nums[0];

    int[] result = new int[nums.length];

    for (int i = 1; i < nums.length ; i++) {
      result[i-1] = nums[i];
    }
    result[nums.length-1] = first;

    return result;

 }

  public int[] reverse3(int[] nums) {
//    return new int[] {nums[2], nums[1], nums[0]};

    int[] result = new int[nums.length];
    int j = 0;
    for (int i = nums.length-1; i >= 0 ; i--) {
      result[j++] = nums[i];
    }
    return result;
  }


  public int sum2(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    return nums[0] + nums[1];
  }


  // [1,2,3,4,5,6,67,7,8,9,10] //11
  // [1,2,3,4,5,6,67,7,8,9,10,11] //12
  public int[] middleWay(int[] a, int[] b) {
//    return new int[] {a[1], b[1]};


    int[] result = new int[2];
    int[] resultCift = new int[4];
    if (a.length % 2 == 1 && b.length % 2 == 1){
      result[0] = a[a.length /2 ];
      result[1] = b[b.length /2 ];
      return result;

    } else {
      resultCift[0] = a[a.length /2 - 1];
      resultCift[1] = a[a.length /2 ];
      resultCift[2] = a[b.length /2 - 1];
      resultCift[3] = a[b.length /2 ];
      return resultCift;
    }

  }

  public static int[] middleWay2(int[] a) {
    int[] result = new int[2];
    if (a.length % 2 == 0){
      result[0] = a[a.length /2 - 1];
      result[1] = a[a.length /2 ];
    }
    return result;

  }


  public int[] makeLast(int[] nums) {
    int[] result = new int[nums.length * 2];
    result[result.length -1] = nums[nums.length -1];
    return result;
  }


  public int[] makeMiddle(int[] nums) {
    int[] result = new int[2];
    if (nums.length % 2 == 0){
      result[0] = nums[nums.length /2 - 1];
      result[1] = nums[nums.length /2 ];
    }
    return result;
  }


  public int[] plusTwo(int[] a, int[] b) {

    return new int[] {a[0], a[1], b[0], b[1]};

  }

  public int[] swapEnds(int[] nums) {
    int first = nums[0];
    nums[0] = nums[nums.length-1];
    nums[nums.length-1] = first;
    return nums;
  }

  public int[] midThree(int[] nums) {
    //([8, 6, 7, 5, 3, 0, 9]) → [7, 5, 3]
//    int[] result = new int[3];
//    result[0] = nums[nums.length / 2 - 1];
//    result[1] = nums[nums.length / 2];
//    result[2] = nums[nums.length / 2 + 1];
//    return result;


    int mid = nums.length / 2;
    return new int[] {nums[mid-1], nums[mid], nums[mid+1]} ;

  }


  public int maxTriple(int[] nums) {
    // first middle last
    return Math.max(nums[0], Math.max(nums[nums.length / 2], nums[nums.length-1]));

  }

  public int[] frontPiece(int[] nums) {
//    if(nums.length < 2) {
//      return nums;
//    } else {
//      return new int[] {nums[0], nums[1]};
//    }
    return nums.length < 2 ? nums : new int[] {nums[0], nums[1]};
  }


  public static int[] make2(int[] a, int[] b) {
    int[] result = new int[2];

    if(a.length>=2){
      return new int[] {a[0], a[1]};
    }else if (a.length==1){
      return new int[] {a[0], b[0]};
    }else {
      return new int[] {b[0], b[1]};
    }



  }




}
