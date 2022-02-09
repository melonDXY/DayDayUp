package codes.DayDayUp.codes.gridIllumination1001;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
    	int[] ans = new int[queries.length]; //要记录每次查询结果，长度为需要查询的次数
    	//用四个HashMap存储光亮情况，因为数据是稀疏的，只存储有效点节省空间
    	Map<Integer, Integer> rows = new HashMap<Integer, Integer>(); //行
    	Map<Integer, Integer> cols = new HashMap<>(); //列
    	Map<Integer, Integer> ant = new HashMap<>(); //正对角线
    	Map<Integer, Integer> deAnt = new HashMap<>(); //反对角线
    	// 使用hasSet来存点亮的灯泡，集合Set有不存储重复元素的特性即可以去重
    	Set<String> bulbs = new HashSet<>();
    	
    	//存储灯泡
    	for(int[] lamp : lamps){
    		//set的特性没有重复值，有重复值add方法返回是boolean
    		if(!bulbs.add(lamp[0] + "," + lamp[1])){
    			continue;
    		}
    		//点亮区域:
    		//以x坐标代替横线，
    		rows.put(lamp[0], rows.getOrDefault(lamp[0], 0)+1);
    		//y坐标代替竖线，
    		cols.put(lamp[1], cols.getOrDefault(lamp[1], 0)+1);
    		//x-y(过灯泡点与y=x平行的直线在x轴的交点横坐标代表正对角线），
    		ant.put(lamp[0]-lamp[1], ant.getOrDefault(lamp[0]-lamp[1], 0)+1);
    		//x+y（过灯泡点与y=-x平行的直线在y轴的交点横坐标代表反对角线）
    		deAnt.put(lamp[0]+lamp[1], deAnt.getOrDefault(lamp[0]+lamp[1], 0)+1);
    	}
    	
    	//进入查询，熄灯只能熄灭set里点亮的灯泡而不能扑灭map里的亮光
    	for(int i =0; i<queries.length;i++){
    		//储存查询点坐标
    		int x = queries[i][0], y = queries[i][1];
    		//检测是否有亮光记录状态
    		if(rows.getOrDefault(x, 0)>0 || cols.getOrDefault(y, 0)>0 || ant.getOrDefault(x-y, 0)>0 || deAnt.getOrDefault(x+y, 0)>0){
    			ans[i] = 1;
    		}
    		//这里没有亮光的情况没考虑（数组默认为0）
    		
    		//关灯
    		for(int p = x-1;p <= x+1; p++){
    			for(int q = y-1;q <= y+1; q++){
    				//判断边界
    				if(p<0 || q<0 || p>=n || q >= n){
    					continue;
    				}
    				//有灯泡移除更新map
    				if(bulbs.remove(p+ "," +q)){
    					if(rows.get(p) != null){
    						rows.put(p, rows.get(p)-1);
    						if(rows.get(p)==0){
    							rows.remove(p);
    						}
    					}
    					if(cols.get(q) != null){
    						cols.put(q, cols.get(q)-1);
    						if(cols.get(q)==0){
    							cols.remove(q);
    						}
    					}
    					if(ant.get(p-q) != null){
    						ant.put(p-q, ant.get(p-q)-1);
    						if(ant.get(p-q)==0){
    							ant.remove(p-q);
    						}
    					}
    					if(deAnt.get(p+q) != null){
    						deAnt.put(p+q, deAnt.get(p+q)-1);
    						if(deAnt.get(p+q)==0){
    							deAnt.remove(p+q);
    						}
    					}
    				}
    			}
    		}
    	}
    	
    	
    	return ans;
    }
    
    public static void main(String[] args) {
		int n = 5;
		int[][] lamps={{0,0},{0,4}};
		int[][] queries={{0,4},{0,1},{1,4}};
		Solution solution = new Solution();
		int[] out = solution.gridIllumination(n, lamps, queries);
		
		System.out.println(Arrays.toString(out));
	}
//        //四个哈希表分别表示行、列、正对角线、反对角线的灯的数量
//        Map<Integer, Integer> rows = new HashMap<>();  
//        Map<Integer, Integer> columns = new HashMap<>(); 
//        Map<Integer, Integer> diagonal = new HashMap<>(); 
//        Map<Integer, Integer> antiDiagonal = new HashMap<>(); 
//        //一个set存放所有的点，记录开灯情况，便于在查询过程中检查周围8个是否开灯
//        Set<String> points = new HashSet<>();
//        //遍历lamps二维数组，对四个map进行填充，对set中开灯情况进行记录
//        for(int[] lamp : lamps){
//            //如果这个lamp坐标值已经被记录在points集合中，跳过
//            if(!points.add(lamp[0] + "+" + lamp[1])) continue; 
//            //否则对四个哈希表进行操作
//            rows.put(lamp[0], rows.getOrDefault(lamp[0],0) + 1);
//            columns.put(lamp[1], columns.getOrDefault(lamp[1],0) + 1);
//            //这里采取对角线与x轴交点的坐标值作为该条对角线的key值
//            diagonal.put(lamp[0]-lamp[1], diagonal.getOrDefault(lamp[0] - lamp[1], 0) + 1);
//            antiDiagonal.put(lamp[0]+lamp[1], antiDiagonal.getOrDefault(lamp[0] + lamp[1], 0) + 1);
//        }
//        //开始查询
//        int[] res = new int[queries.length];
//        for(int i = 0; i < queries.length; i++){
//            int row = queries[i][0], column = queries[i][1];
//            //判断该点的行、列、两条对角线是否有灯，只要有一条线上有灯亮就置1
//            if(rows.getOrDefault(row, 0) > 0) res[i] = 1;
//            else if(columns.getOrDefault(column,0) > 0) res[i] = 1;
//            else if(diagonal.getOrDefault(row - column, 0) > 0) res[i] = 1;
//            else if(antiDiagonal.getOrDefault(row + column, 0) > 0) res[i] = 1;
//            //判断该点的周围8点是否有灯打开，执行关灯操作 3*3数组
//            for(int x = row - 1; x <= row + 1; x++){
//                for(int y = column - 1; y <= column + 1; y++){
//                    //越界判断，注意点在最外面一圈的情况
//                    if(x < 0 || y < 0 || x >= n || y >= n) continue;
//                    //如果set中该点是开着的，移除，将该点所在行、列、两条对角线的值都减1
//                    if(points.remove(x + "+" + y)){
//                        //行
//                        rows.put(x,rows.get(x) - 1);
//                        if(rows.get(x) == 0) rows.remove(x); //如果灯亮的次数清为0了，直接从map中移除
//                        //列
//                        columns.put(y,columns.get(y) - 1);
//                        if(columns.get(y) == 0) columns.remove(y); 
//                        //正对角线
//                        diagonal.put(x-y,diagonal.get(x-y) - 1);
//                        if(diagonal.get(x-y) == 0) diagonal.remove(x-y); 
//                        //反对角线
//                        antiDiagonal.put(x+y,antiDiagonal.get(x+y) - 1);
//                        if(antiDiagonal.get(x+y) == 0) antiDiagonal.remove(x+y);
//                    }
//                    //完成hashmap和set的更新，进行下一个坐标的判断
//                }
//            }
//        }
//        return res;
//    }
}
