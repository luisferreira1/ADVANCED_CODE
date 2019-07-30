
public class Solution {

    /**
     * @param args
     */
    public static int last(char charToFind, String pattern) {
        for (int j = pattern.length() - 1; j > 0; j--) {
            if (charToFind == pattern.charAt(j)) return j;
        }
        return -1;
    }
    
    public static int findMatch(String text, String pattern) {
        int i = pattern.length() - 1;
        int j = pattern.length() - 1;
        
        while (true) {
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == 0) return i;
                else {
                    i--;
                    j--;
                }
            } else {
                i += pattern.length() - Math.min(j, 1 + last(text.charAt(i), pattern));
                j = pattern.length() - 1;
            }
            if (i > text.length() -1) break;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        String text = "why are you doing this to me man";
        String pattern = "me ";
        
        int position = findMatch(text, pattern);
        System.out.println("pattern found in position " + position);
        
    }

}
