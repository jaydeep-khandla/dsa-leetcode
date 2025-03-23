import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            int absValue = Math.abs(nums[i]);
            if (nums[absValue - 1] < 0) {
                duplicates.add(absValue);  // If the value is already negative, it's a duplicate
            }
            nums[absValue - 1] = -nums[absValue - 1];  // Mark the element as visited by negating the value
        }

        return duplicates;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test case
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = solution.findDuplicates(nums);
        System.out.println("The duplicate numbers are: " + result); // Output: [2, 3]
    }
}
