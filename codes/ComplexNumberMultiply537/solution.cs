public class Solution {
    public string ComplexNumberMultiply(string num1, string num2) {
        // 题目很简单，但是练习的api很多
        // 1. 字符串分割
        // 2. string和int转换
        // 3. 设定返回字符串的格式
        char[] splitChar = new char[]{'+', 'i'};
        string[] complex1 = num1.Split(splitChar);
        string[] complex2 = num2.Split(splitChar);
        int real1 = int.Parse(complex1[0]);
        int imaginary1 = int.Parse(complex1[1]);
        int real2 = int.Parse(complex2[0]);
        int imaginary2 = int.Parse(complex2[1]);

        return string.Format("{0}+{1}i", real1 * real2 - imaginary1 * imaginary2, real1 * imaginary2 + real2 * imaginary1);
    }
}