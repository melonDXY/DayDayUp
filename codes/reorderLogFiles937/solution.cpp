class Solution {
public:
    vector<string> reorderLogFiles(vector<string>& logs) {
        stable_sort(logs.begin(), logs.end(), [&](const string & log1, const string & log2){
            int pos1 = log1.find_first_of(" ");
            int pos2 = log2.find_first_of(" ");
            bool isDigit1 = isdigit(log1[pos1 + 1]);
            bool isDigit2 = isdigit(log2[pos2 + 1]);
            if(isDigit1 && isDigit2){
                return false;
            }
            if(!isDigit1 && !isDigit2){
                string s1 = log1.substr(pos1);
                string s2 = log2.substr(pos2);
                if(s1 != s2){
                    // 字符大小
                    return s1 < s2;
                }
                // 标识符大小
                return log1 < log2;
            }
            // log1是否为数字（此时判断时，log2和log1的类型一定不同）
            // 所以是数字，则log2为字符，调换顺序
            // 不是数字则，log2为数字，不调换顺序
            return isDigit1 ? false : true;
        });
        return logs;
    }


};