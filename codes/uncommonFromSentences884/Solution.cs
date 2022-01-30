// 简单粗暴，效果8.88 8.88，感觉效率很低，得看看新方法，找好一点的思路
public class Solution {
    public string[] UncommonFromSentences(string s1, string s2) {
        // 使用dictionary作为存储的数据结构（类似于map）
        Dictionary<string, int> count = new Dictionary<string, int>();
        // 将s1、s2单词存入count中，写一个新方法 save
        Save(s1, count);
        Save(s2, count);

        // 使用List存储答案
        IList<string> ans = new List<string>();
        // 数据结构KeyValuePair<type, type>
        foreach(KeyValuePair<string, int> pair in count){
            if(pair.Value == 1){
                ans.Add(pair.Key);
            }
        }
        // 将list转为array输出
        return ans.ToArray();
    }

    // 存储字符串中的单词
    public void Save(string s, Dictionary<string, int> count){
        // 字符串分割函数
        string[] arrs = s.Split(" ");
        foreach(string word in arrs){
            if(!count.ContainsKey(word)){
                count.Add(word, 0);
            }
            ++ count[word];
        }
    }
}