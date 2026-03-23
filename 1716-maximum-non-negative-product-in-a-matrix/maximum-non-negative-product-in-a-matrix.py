from typing import List


class Solution:
    def maxProductPath(self, grid: List[List[int]]) -> int:
        modValue = 10 ** 9 + 7
        rowCount = len(grid)
        colCount = len(grid[0])

        
        # Initialize DP arrays for maximum and minimum products
        maxDp = [0] * colCount
        minDp = [0] * colCount

        
        # Initialize starting cell
        maxDp[0] = grid[0][0]
        minDp[0] = grid[0][0]

        
        # Initialize first row
        for colIndex in range(1, colCount):
            maxDp[colIndex] = maxDp[colIndex - 1] * grid[0][colIndex]
            minDp[colIndex] = maxDp[colIndex]

        
        # Iterate through remaining rows
        for rowIndex in range(1, rowCount):
            
            # Update first column separately (can only come from top)
            maxDp[0] = maxDp[0] * grid[rowIndex][0]
            minDp[0] = maxDp[0]

            
            # Process remaining columns
            for colIndex in range(1, colCount):
                currentValue = grid[rowIndex][colIndex]

                topMax = maxDp[colIndex]
                topMin = minDp[colIndex]
                leftMax = maxDp[colIndex - 1]
                leftMin = minDp[colIndex - 1]

                
                # Compute possible candidates from top and left
                candidates = (
                    topMax * currentValue,
                    topMin * currentValue,
                    leftMax * currentValue,
                    leftMin * currentValue,
                )

                maxDp[colIndex] = max(candidates)
                minDp[colIndex] = min(candidates)

        
        # Final result check
        resultValue = maxDp[colCount - 1]

        if resultValue < 0:
            return -1

        return resultValue % modValue
