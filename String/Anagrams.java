//Given an array of strings, return all groups of strings that are anagrams.

//Note: All inputs will be in lower-case.

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        HashMap<String, ArrayList<String>> keyGroup = new HashMap<String, ArrayList<String>>();
        ArrayList<String> result = new ArrayList<String>();
        for(int i = 0; i < strs.length; i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if(!keyGroup.containsKey(key)){
                keyGroup.put(key, new ArrayList<String>());
            }
            keyGroup.get(key).add(strs[i]);
        }
        for(String k : keyGroup.keySet()){
            if(keyGroup.get(k).size() > 1){
                for(String s : keyGroup.get(k)){
                    result.add(s);
                }
            }
        }
        return result;
    }
}