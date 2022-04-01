package codes.CanReorderDoubled954;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnts = new HashMap<Integer, Integer>();
        List<Integer> absList = new ArrayList<Integer>();
        for(int i : arr) {
            cnts.put(i, cnts.getOrDefault(i, 0) + 1);
        }
        if (cnts.getOrDefault(0,0)%2 != 0) return false;
        for(int key : cnts.keySet()) {
            absList.add(key);
        }
        
        Collections.sort(absList,(a ,b)->(Math.abs(a)-Math.abs(b)));

        for(int i : absList) {
            if( cnts.get(i) > cnts.getOrDefault(2 * i, 0)) {return false;}
            cnts.put(2 * i, cnts.getOrDefault(2 * i,0) - cnts.getOrDefault(i,0));
        }
        return true;
    }
}
