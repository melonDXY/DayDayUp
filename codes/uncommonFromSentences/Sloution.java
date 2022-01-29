package codes.DayDayUp.codes.uncommonFromSentences;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sloution {
	
	public static void main(String[] args) {
		
		String s1 = "this apple is sweet";
		String s2 = "this apple is sour";
		
		Map<String, Integer> freq = new HashMap<String, Integer>();
		String s = s1 + " " + s2;
		String[] sList = s.split(" ");
		for(String word : sList){
			freq.put(word, freq.getOrDefault(word, 0) + 1);
		}
		
		List<String> wList = new ArrayList<String>();
		for(Map.Entry<String, Integer> entry : freq.entrySet()){
			if(entry.getValue() == 1){
				wList.add(entry.getKey());
			}
		}
		wList.toArray(new String[0]);
		System.out.println(wList);
	}
	
}
