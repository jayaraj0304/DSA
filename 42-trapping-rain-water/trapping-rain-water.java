class Solution {
    public int trap(int[] height) {
        int l=0;int h=height.length-1;
        int[] rm=new int[h+1];
        int[] lm=new int[h+1];
        rm[0]=height[0];
        lm[h]=height[h];
        for(int i=1;i<height.length;i++){
            rm[i]=Math.max(rm[i-1],height[i]);
        }
        for(int i=h-1;i>=0;i--){
            lm[i]=Math.max(lm[i+1],height[i]);
        }
        int c=0;
        
       for (int i = 0; i <= h; i++) {
            c += Math.min(rm[i], lm[i]) - height[i];
        }
        return c;


    }
}