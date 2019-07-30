
public class Solution {

    /**
     * @param args
     */
    public static int last(char Char, String pattern) {
        
        for (int i = pattern.length() - 1; i >= 0; i--) {
            if (Char == pattern.charAt(i)) {
                return i;
            }
        }
        return -1;
    }
    
    public static int findPattern(String text, String pattern) {
        int i = pattern.length() - 1;
        int j = pattern.length() - 1;
        
        while (true){
            if (text.charAt(i) == pattern.charAt(j)) {
                i--;
                j--;
                if (j == 0) {
                    return i;
                }
            } else {
                i+= pattern.length() - Math.min(j, 1 - last(text.charAt(i), pattern));
                j = pattern.length() - 1;
            }
            if (i >= text.length() - 1) {
                break;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String text = "hopefully today I get to eat a great lunch and then play some videogames";
        String pattern = "unc";
        
        int position = findPattern(text, pattern);
        
        System.out.println("Found match in position " + position);
    }

}
