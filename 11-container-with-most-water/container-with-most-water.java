class Solution {
    public int maxArea(int[] height) {
        int l=0,h=height.length-1;
        int mw=0;
        while(l<h){
            int sh=Math.min(height[l],height[h]);
            int cm=(h-l)*sh;
            mw=Math.max(mw,cm);
            if(height[h]>height[l]){
                l++;
            }
            else{
                h--;
            }
            
        }
        return mw;
    }
}