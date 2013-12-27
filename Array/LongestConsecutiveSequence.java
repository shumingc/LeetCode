//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

//For example,
//Given [100, 4, 200, 1, 3, 2],
//The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

//Your algorithm should run in O(n) complexity.
public class Solution {
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for(int i = 0; i < num.length; i++){
            map.put(num[i], false);
        }
        int longest = 0;
        for(int i = 0; i < num.length; i++){
            if(map.get(num[i])) continue;
            map.put(num[i],true);
            int length = 1;
            for(int j = num[i] + 1; map.containsKey(j) && !map.get(j); j++){
                map.put(j, true);
                length++;
            }
            for(int j = num[i] - 1; map.containsKey(j) && !map.get(j); j--){
                map.put(j, true);
                length++;
            }
            longest = Math.max(length, longest);
        }
        return longest;
    }
}