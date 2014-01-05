//Given a collection of numbers, return all possible permutations.

//For example,
//[1,2,3] have the following permutations:
//[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList();

        if(num.length == 1){
           ArrayList<Integer> aa= new ArrayList();
           aa.add(num[0]);
           lists.add(aa);
           return lists;
        }

        for(int i=0; i < num.length; i++){
            int [] subarray = find (num, i);
            ArrayList<ArrayList<Integer>> temp = permute(subarray);
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

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        Arrays.sort(num);
        boolean[] use = new boolean[num.length];
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        DFS(num, use, cur, res);
        return res;
    }
    private void DFS(int[] num, boolean[] use,
        ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> res){
        if(cur.size() == num.length){
            res.add(new ArrayList(cur));
            return;
        }
        for(int i = 0; i < num.length; i++){
            if(!use[i]){
                cur.add(num[i]);
                use[i] = true;
                DFS(num, use, cur, res);
                cur.remove(cur.size() - 1);
                use[i] = false;
            }
        }
    }
}