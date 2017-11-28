package easy.done;

//动态规划，问题从屋子数为1开始扩展，计算出每一次扩展后，最后一排屋刷不同颜色时的最低价格，计算当前的不同颜色的最低价格需要上一步中各种不同颜色的最低价格
public class PaintHouse256 {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        
        int[] currentMinCost = new int[]{costs[0][0], costs[0][1], costs[0][2]};
        for(int i = 1; i < costs.length; i++) {
            int a = costs[i][0] + Math.min(currentMinCost[1], currentMinCost[2]); 
            int b = costs[i][1] + Math.min(currentMinCost[0], currentMinCost[2]); 
            int c = costs[i][2] + Math.min(currentMinCost[0], currentMinCost[1]); 
            
            currentMinCost[0] = a; 
            currentMinCost[1] = b; 
            currentMinCost[2] = c; 
        }
        
        return Math.min(currentMinCost[0], Math.min(currentMinCost[1], currentMinCost[2]));
    }
}
