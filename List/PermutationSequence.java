//The set [1,2,3,…,n] contains a total of n! unique permutations.

//By listing and labeling all of the permutations in order,
//We get the following sequence (ie, for n = 3):

//"123"
//"132"
//"213"
//"231"
//"312"
//"321"
//Given n and k, return the kth permutation sequence.

//Note: Given n will be between 1 and 9 inclusive.
public class Solution {
    public String getPermutation(int n, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> factorial = new ArrayList<Integer>();
        int temp = 1;
        for(int i = 1; i <= n; i++){
            temp *= i;
            factorial.add(i);
        }
        StringBuffer sb = new StringBuffer();
        for(int i = n; i > 0; i--){
            temp = temp/i;
            int index = (k - 1)/temp;
            sb.append(factorial.get(index));
            factorial.remove(index);
            k = k-index*temp;
        }
        return sb.toString();
    }
}