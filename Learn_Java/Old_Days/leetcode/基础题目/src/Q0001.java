public class Q0001 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = 1;
        int[] result = new int[2];
        for (i = 0; i < nums.length; i++) {
            for (j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    // return result;
                }
            }
        }
        return result;
    }
}
