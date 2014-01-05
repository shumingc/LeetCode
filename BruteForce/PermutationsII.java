//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//For example,
//[1,1,2] have the following unique permutations:
//[1,1,2], [1,2,1], and [2,1,1].
public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i++){
            if(!map.containsKey(num[i])){
                map.put(num[i], 0);
            }
            map.put(num[i], map.get(num[i]) + 1);
        }
        Arrays.sort(num);
        int[] newNum = new int[map.size()];
        newNum[0] = num[0];
        for(int i = 1, j = 1; i < num.length; i++){
            if(num[i] != num[i-1]){
                newNum[j] = num[i];
                j++;
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        permute(newNum, num.length, map, cur, res);
        return res;
    }
    private void permute(int[] num, int len, HashMap<Integer, Integer> map,
                    ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> res){
        if(cur.size() == len){
            res.add(new ArrayList(cur));
            return;
        }
        for(int i = 0; i < num.length; i++){
            int count = 0;
            for(Integer e : cur){
                if(e.intValue() == num[i]){
                    count++;
                }
            }
            if(count < map.get(num[i])){
                cur.add(num[i]);
                permute(num, len, map, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num){

        ArrayList<ArrayList<Integer>> lists = new ArrayList();

        if(num.length == 1){
            ArrayList<Integer> aa= new ArrayList();
            aa.add(num[0]);
            lists.add(aa);
            return lists;
        }

        HashSet<Integer> hs = new HashSet();

        for(int i=0; i < num.length; i++){
            if(hs.contains(num[i])){
                continue;
            }
            else{
                hs.add(num[i]);
            }

            int [] subarray = find (num, i);

            ArrayList<ArrayList<Integer>> temp = permuteUnique(subarray);

            for(ArrayList<Integer> a : temp){
                a.add(num[i]);
            }
            lists.addAll(temp);
        }

        return lists;
    }

    public int[] find(int[] num, int i){
        int [] newarray =  new int [num.length-1];
        for(int j =0; j < i; j++){
            newarray[j] = num[j];
        }

        for(int j = i+1; j < num.length; j++){
            newarray[j-1] = num[j];
        }

        return newarray;
    }
}