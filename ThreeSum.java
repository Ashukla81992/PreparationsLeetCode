import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {

        int[] arr1 = new int[]{0,0,0};
        int[] arr2 = new int[]{-1,0,1,2,-1,-4};
        print(threeSum(arr2));

    }

    public static List<List<Integer>> threeSum(int[] nums)  {
        List<List<Integer>> threeSumList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < (nums.length - 1); i++) {

            int j = i+1;
            int k = nums.length-1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> sumArray = new ArrayList<>();
                    sumArray.add(nums[i]);
                    sumArray.add(nums[j]);
                    sumArray.add(nums[k]);
                    threeSumList.add(sumArray);
                    j++;
                }
                if(sum > 0){
                    k--;
                }
                if(sum < 0){
                    j++;
                }
            }
        }
        return threeSumList;
    }


    private static void print(List<List<Integer>> lists){
        int solNum = 1;
        for(List<Integer> listInt: lists){
            System.out.println("Sol: "+ solNum);
            solNum++;
            for(int i=0; i<listInt.size();i++){
                System.out.print(listInt.get(i) + " ");
            }
            System.out.println(" ");
        }
    }


}
