package codes.ComplexNumberMultiply537;

public class Solution{
    public String complexNumberMultiply(String num1, String num2) {
        int[] number1 = getCount(num1);
        int[] number2 = getCount(num2);
        int a = number1[0]*number2[0] - number1[1]*number2[1];
        int b = number1[0]*number2[1] + number1[1]*number2[0];
        String ans = a + "+" + b + "i";
        return ans;
    }

    public int[] getCount(String num){
        num = num.substring(0,num.length()-1);
        String[] sNums = num.split("\\+");
        int[] nums = new int[sNums.length];
        for(int i = 0; i<sNums.length; i++){
            nums[i] = Integer.parseInt(sNums[i]);
        }
        return nums;
    }

    public static void main(String[] args) {
        String x1 = "1+1i";
        String x2 = "1+1i";
        Solution solution = new Solution();
        System.out.println(solution.complexNumberMultiply(x1,x2));
    }
}