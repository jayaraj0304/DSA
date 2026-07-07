class Solution {
public:
    int maxArea(vector<int>& height) {
        int i = 0;
        int j = height.size() - 1;
        int maxVol = -1;
        int vol;
        while (i < j)
        {
            if (height[i] < height[j])
            {
                vol = (j - i) * height[i];
                if (vol > maxVol)
                {
                    maxVol = vol;
                }
                i ++;
            }
            else
            {
                vol = (j - i) * height[j];
                if (vol > maxVol)
                {
                    maxVol = vol;
                }
                j --;
            }
        }
        return maxVol;
    }
};