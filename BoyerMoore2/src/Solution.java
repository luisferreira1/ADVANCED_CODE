
public class Solution {
    
    public static int last(char charToFind, String pattern) {
        for (int j = pattern.length() - 1; j >= 0; j--) {
            if (charToFind == pattern.charAt(j)) return j;
        }
        return -1;
    }

    public static int findPattern(String text, String pattern) {
        int i = pattern.length() - 1;
        int j = pattern.length() - 1;
        
        while (true) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i--;
                j--;
                if (j == 0) return i;
            } else {
                i+= pattern.length() - Math.min(j, 1 + last(text.charAt(i), pattern));
                j = pattern.length() - 1;
            }
            if (i > text.length() - 1) break;
        }
        return -1;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String text = "i love lord of the rings hopefully the amazon series is good";
        String pattern = "rie";
        
        int position = findPattern(text, pattern);
        System.out.println("position found in " + position);
                
    }

}
