package Assignment2;

public class Main {
    static boolean doesContainAllAlphabates(String str){
        boolean arr[] = new boolean[26]; //constant space
        // following loop is O(n)
        for(char c:str.toCharArray()){
            if(c>='a' && c<='z'){
                arr[c-'a'] = true;
            }else if(c>='A' && c<='Z'){
                arr[c-'A'] = true;
            }
        }
        // following loop is O(26) which is constant time
        for(int i=0; i<26; i++){
            if(!arr[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "abcdefefZ";
        String str2 = "abcDefGhiJKlmnopQrtStuVXYZw";
        System.out.println(doesContainAllAlphabates(str));
        System.out.println(doesContainAllAlphabates(str2));
    }
}
