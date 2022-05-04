package codes.huawei0413;

import java.util.Scanner;

/*
*
*
有M台服务器资源，每台服务器包含属性:编号(整数),CPU核数(1~100),内存(10~1000)、CPU架构(0~8)、否支持NP加速卡标识(0,1).
请根据资源分配要求分配N台,满足要求的服务器。资源分配要求:
CPU核数>=cpucount,内存>=memSize, CPU架构=cpuArch,是否支持NP卡=supportNP。其中，cpuCount、 memSize、 CpuArch、 supportNP
为输入的分配参数。分配时同时会指定优选级策略trategy,策略如下:

最大分配数量，分配策略，cpucount， memSize，cpuArch，SupportNP
*/
public class Solution {
    static int[][] NUMS = {{1,1,1,0,1,1,1},
                        {0, 0, 1, 0, 0, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1},
                        {1,0,1,1,0,1,1},
                        {0,1,1,1,0,1,0},
                        {1,1,0,1,0,1,1},
                        {1,1,0,1,1,1,1},
                        {1,0,1,0,0,1,0},
                        {1,1,1,1,1,1,1},
                        {1,1,1,1,0,1,1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nums = sc.nextLine();
        int result = 0;
        int[] temp = {0,0,0,0,0,0,0};
        for (int i = 0; i<nums.length(); i++) {
            int[] curr = NUMS[nums.charAt(i) - '0'];
            for (int j = 0; j < curr.length; j++) {
                if (curr[j] != temp[j]) {
                    result++;
                }
            }
            temp = curr;
        }
        System.out.println(result);
    }
    
}
