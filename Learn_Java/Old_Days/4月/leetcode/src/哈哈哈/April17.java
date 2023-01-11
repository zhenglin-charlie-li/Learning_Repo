package 哈哈哈;

public class April17 {
    public static void main(String[] args) {
        int[] nums={3,2,1,0,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int isOrNot=1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]==0){
                for(int j=i-1;j>=0;j--){
                    if(nums[j]<=i-j){
                        isOrNot=0;
                    }
                }
            }
        }
        if(isOrNot==1){
            return true;
        }
        return false;
    }
}

