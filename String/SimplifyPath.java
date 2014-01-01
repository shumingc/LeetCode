//Given an absolute path for a file (Unix-style), simplify it.

//For example,
//path = "/home/", => "/home"
//path = "/a/./b/../../c/", => "/c"
//click to show corner cases.

//Corner Cases:
//Did you consider the case where path = "/../"?
//In this case, you should return "/".
//Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
//In this case, you should ignore redundant slashes and return "/home/foo".

public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return "/";
        Stack<String> dirs = new Stack<String>();
        String[] splits = path.trim().split("/");
        for(String s : splits){
            if(s == null || s.length() == 0 || s.equals(".")){

            }else if(s.equals("..")){
                if(!dirs.empty()) dirs.pop();
            }else{
                dirs.push(s);
            }
        }
        if(dirs.empty()) return "/";
        StringBuilder result = new StringBuilder();
        while(!dirs.empty()){
            result.insert(0, dirs.pop());
            result.insert(0,"/");
        }
        return result.toString();
    }
}