
public class Solution {

    /**
     * @param args
     */
    
    public static int last(char currentChar, String pattern) {
        for (int i = pattern.length() - 1; i > 0; i--) {
            if (currentChar == pattern.charAt(i)) {
                return i;
            }
        }
        return -1;
    }
    
    public static int findPattern(String fullText, String pattern) {
        int i = pattern.length() - 1;
        int j = pattern.length() - 1;
        
        while (true) {
            if (fullText.charAt(i) == pattern.charAt(j)) {
                i--;
                j--;
                if (j == 0) {
                    return i;
                }
            } else {
                i += pattern.length() - Math.min(j, 1 - last(fullText.charAt(i), pattern));
                j = pattern.length() - 1;       
                
            }
        }
        
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        String fullText = "vacation is still three weeks away, how far";
        String pattern = "ee";
        
        int position = findPattern(fullText, pattern);
        System.out.println("Position of pattern is "+ position);
        
        
    }

}
