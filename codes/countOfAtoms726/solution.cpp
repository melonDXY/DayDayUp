class Solution {
public:
    string countOfAtoms(string formula) {
        int i = 0, l = formula.length();
        stack<unordered_map<string, int>> atom_list_stack;
        atom_list_stack.push({});

        // 遍历的逻辑
        while(i < l){
            // 进入括号，则新建一个哈希表,准备进行统计
            if(formula[i] == '('){
                atom_list_stack.push({});
                ++ i;
            } else if(formula[i] == ')'){
                // 走出括号，那么括号内的已经统计完，要进行整合，并且乘以外面的数字
                ++ i;
                int n = getAtomNum(i, formula);
                auto atom_map = atom_list_stack.top();// 获取当前括号内统计
                atom_list_stack.pop();
                for(auto & [atom, v] : atom_map){
                    atom_list_stack.top()[atom] += v * n;
                }
            } else{
                string atom = getAtom(i, formula);
                int n = getAtomNum(i, formula);
                atom_list_stack.top()[atom] += n;
            }
        }
        auto maps = atom_list_stack.top();
        atom_list_stack.pop();
        vector<pair<string, int>> pairs;
        for(auto &[atom, v] : maps){
            pairs.emplace_back(atom, v);
        }
        sort(pairs.begin(), pairs.end());

        string ans;
        for(auto &p : pairs){
            ans += p.first;
            if(p.second > 1){
                ans += to_string(p.second);
            }
        }
        return ans;
    }

    int getAtomNum(int &i, string &formula){
        if(!isdigit(formula[i]) || i == formula.length()){
            return 1;
        }
        int num = 0;
        while(i < formula.length() && isdigit(formula[i])){
            num = num * 10 + (formula[i] - '0');
            ++ i;
        }
        return num;
    }

    string getAtom(int &i, string &formula){
        int beginIdx = i;
        ++ i;
        while(i < formula.length() && islower(formula[i])) ++ i;
        return formula.substr(beginIdx, i - beginIdx);
    }

};