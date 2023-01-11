package decorated;

import java.util.ArrayList;
import java.util.List;

public class aaa {
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("apple");
        wordList.add("pen");
        System.out.println(wordBreak("applepenapple",wordList));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        char[] chars = s.toCharArray();
        for(int i=0; i<s.length()-1;i++){
            for(int j=i; j<s.length(); j++){
                String each = chars.toString().substring(i,j);
                for(String eachDict: wordDict){
                    if(each.equals(eachDict)){
                        for(int k=i;k<j;k++){
                            chars[k]='0';
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
