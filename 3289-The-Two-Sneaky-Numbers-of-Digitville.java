import java.util.HashSet;

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] res = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for(int i=0,j=0;i<n;i++){
            if(!set.isEmpty() && set.contains(nums[i])){
                res[j] = nums[i];
                j++;
            } else{
                set.add(nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example inputs to test
        int[] test1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2};
        int[] test2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 2, 3};
        int[] test3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 3, 4};

        // Call the method and print results
        int[] res1 = solution.getSneakyNumbers(test1);
        int[] res2 = solution.getSneakyNumbers(test2);
        int[] res3 = solution.getSneakyNumbers(test3);
        System.out.println(res1[0] + " " + res1[1]); // Expected: 1 1
        System.out.println(res2[0] + " " + res2[1]); // Expected: 2 2
        System.out.println(res3[0] + " " + res3[1]); // Expected: 3 3
    }  
}