class Solution {
    public int removeElement(int[] nums, int val) {
        int indexstart=0;
        int count=0;

        for(int i=0;i<nums.length;i++){
            if( nums[i]!=val){
                count++;
                nums[indexstart++]=nums[i];
                
            }
        }
        return indexstart;
        
    }
}