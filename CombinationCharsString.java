/*
 * Find combination of all characters in string where characters can be repeated.
 * Example : Input : AABC
 * Output : 
 * ""
 * A
 * AA
 * AAB
 * AABC
 * AAC
 * AB
 * ABC
 * AC
 * B
 * BC
 * C
 */

import java.util.*;

public class CombinationCharsString {

	void combination(String str)
	{
		Map<Character, Integer> map = new TreeMap<>();	//sorted order
		for(char ch : str.toCharArray())
		{
			map.compute(ch, (key, val) ->
			{
				if(val == null)
					return 1;
				else
					val++;
				
				return val;
			});			
		}
		int size = map.size();
		int[] count = new int[size];	//count of each char
		char[] uniqueChars = new char[size];	//no dups in this
		int index = 0;
		for(Map.Entry<Character, Integer> e : map.entrySet())
		{
			uniqueChars[index] = e.getKey();
			count[index++] = e.getValue();
		}
		char[] result = new char[str.length()];
		List<String> finalResult = new ArrayList<>();
		combinationUtil(uniqueChars, count, result, 0, 0, finalResult);	// 0 = pos to start, 0 = level of recursion
		System.out.println(finalResult);
	}
	
	void combinationUtil(char[] uniqueChars, int[] count, char[] result, int pos, int level, List<String> finalResult)
	{
		finalResult.add(new String(result).trim());
		
		for(int i = pos; i < uniqueChars.length; i++)
		{
			if(count[i] <= 0)
				continue;
			
			result[level] = uniqueChars[i];
			count[i]--;
			combinationUtil(uniqueChars, count, result, i, level + 1, finalResult);
			result[level] = '\0';
			count[i]++;			
		}
	}

    public static void main(String args[]){
    	CombinationCharsString c = new CombinationCharsString();
        c.combination("a abc");        
    }

}
