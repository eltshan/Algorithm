import java.util.HashMap;


public class Min_Win_String {
	public static String minWindow(String S, String T) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < T.length(); i++){
            if(map.containsKey(T.charAt(i)))
            {
                map.put(T.charAt(i), map.get(T.charAt(i))+1);
            }else{
                map.put(T.charAt(i),1);
            }
        }
        int sum = T.length();
        int start = -1;
        int end = -1;
        int minStart = 0;
        int minEnd = 0;
        int min = Integer.MAX_VALUE;
        char currentChar;
        for(int i = 0; i < S.length(); i++){
            currentChar = S.charAt(i);
            if(map.containsKey(currentChar)){
                if(start < 0)
                    start = i;
                map.put(currentChar, map.get(currentChar)-1);
                if(map.get(currentChar) >= 0)
                    sum--;
                if(sum ==  0){
                    end = i+1;
                    for(;start < end; start++){
                        currentChar = S.charAt(start);
                        if(map.containsKey(currentChar)){
                            if(sum > 0 && map.get(currentChar) >= 0){
                                break;
                            }
                            map.put(currentChar, map.get(currentChar)+1);
                            if(map.get(currentChar) > 0){
                                if(end-start < min){
                                    minStart = start;
                                    minEnd = end;
                                    min = minEnd-minStart;
                                }
                                sum++;
                            }
                        }
                    }
                }
            }//end if    
        }// end for
        if(start < 0 || end < 0)
            return "";
        return S.substring(minStart, minEnd);
    }
	
	static public void main(String args[]){
		System.out.println(minWindow("bba", "ab"));
	}
}
