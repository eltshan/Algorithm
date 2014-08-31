package array;

public class Longest_Palindromic_Sub_String {
	static public String longestPalindrome(String s) {
        assert(s!=null);
        int start = 0;
        int end = 0;
        int n = s.length();
        if(n <= 1)
            return s;

        int j = 0;
        for(int i = 0; i < n*2; i++){
            j = 1;
            if(i%2 == 0)//even
            {
                while((i/2-j) >= 0 && (i/2+j) < n && s.charAt(i/2-j) == s.charAt(i/2+j)){
                    j++;
                }
                j--;
                if(j*2+1 >= (end-start)){
                    start = i/2 - j;
                    end = i/2 + j;
                    
                }
            }else{//odd
                while( (i/2 +1 - j) >= 0 && (i/2+j) < n && s.charAt(i/2 + 1 - j) == s.charAt(i/2 + j)){
                    j++;
                } 
                j--;
                if(j*2 >= (end-start)){
                    start = i/2 - j + 1;
                    end = i/2 + j;
                    
                }                
            }
        }//end for loop
        return s.substring(start, end+1);
    }
	
	public static void main(String args[]){
		String s = new String("bb");
		System.out.println("result is " + longestPalindrome(s));
	}

}
