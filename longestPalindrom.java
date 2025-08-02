public class longestPalindrom {
    public static void main(String[] args) {

        int[] arr1 = new int[]{0,0,0};
        int[] arr2 = new int[]{-1,0,1,2,-1,-4};
//        print(threeSum(arr2));

    }
    static int max = 0;
    static String maxString = null;
    public static String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        max = 0;
        Boolean[][] isPalindromArray = new Boolean[s.length()][s.length()];
        isPalindrom(start,end,isPalindromArray,charArray);

        return maxString;
    }

    private static void isPalindrom(int start, int end, Boolean[][] isPalindromArray, char[] charArray) {
        if(start>charArray.length || end<0 || start>end){
            isPalindromArray[start][end] = true;
            return;
        }
        if(start==end){
            isPalindromArray[start][end] = true;
            return;
        }
        if(end-start==1 && charArray[end]==charArray[start]){
            isPalindromArray[start][end] = true;
            return;
        }
        if(charArray[start]==charArray[end]){

            max = end-start;
        }
    }


}
