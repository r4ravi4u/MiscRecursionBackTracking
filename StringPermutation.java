/*
 * Generate all permutations of string in lexicographically sorted order where repetitions of
 * character is possible in string.
 * Example :- 
 * Input : AABC
 * Output :- 
 * AABC
 * AACB
 * ABAC
 * ABCA
 * ACAB
 * ACBA
 * BAAC
 * BACA
 * BCAA
 * CAAB
 * CABA
 * CBAA
*/

import java.util.*;

public class StringPermutation {
	
	void permute(String str)
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
		permuteUtil(uniqueChars, count, result, 0, finalResult);	// 0 =level of recursion
		System.out.println(finalResult);
	}
	
	void permuteUtil(char[] uniqueChars, int[] count, char[] result, int level, List<String> finalResult)
	{
		//base condition
		if(level == result.length)
		{
			finalResult.add(new String(result));
			return;
		}
		
		for(int i = 0; i < uniqueChars.length; i++)
		{
			if(count[i] <= 0)
				continue;
			
			result[level] = uniqueChars[i];
			count[i]--;
			permuteUtil(uniqueChars, count, result, level + 1, finalResult);
			count[i]++;
		}
	}

	public static void main(String[] args) {
		StringPermutation sp = new StringPermutation();
        sp.permute("AABC");
	}

}
