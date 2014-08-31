package array;

public class MutiplyString {
    static public String multiply(String num1, String num2) {
        assert(num1!=null && num2!=null);
        int n1 = num1.length();
        if(n1 == 0)
            return num2;
        int n2 = num2.length();
        if(n2 == 0)
            return num1;
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int carry = 0;
        int tmp = 0;
        int current = 0;
        int total = 0;
        StringBuffer bf = new StringBuffer();
        for(int i = 0; i < n1; i++){
            for(int j = 0; j < n2; j++){
                tmp = Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
                if(bf.length() <= (i+j))
                    bf.append('0');
                //assume totalValue is < 99. will come back and test other cases
                total = tmp+carry+ Character.getNumericValue(bf.charAt(i+j));
                current = (total )% 10; 
                carry = (total )/10;
                System.out.println("total:" + total + "  current:" + current + " carry:" + carry);

                bf.setCharAt(i+j, (char)(current + '0'));
                
            }
            if(carry > 0)
            {
                bf.append((char)(carry + '0'));
            }
            carry = 0;
            
        }
        
        if(carry > 0)
        {
            bf.append((char)(carry + '0'));
        }
        
        return bf.reverse().toString();
        
    }
    
    
    static public void main(String [] args){
    	String num1= "123";
    	String num2 = "456";
    	System.out.println(multiply(num1, num2));
    }
}
