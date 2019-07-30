import java.util.Scanner;

class HashMember {
    String key;
    String value;
    HashMember (String key, String value) {
        this.key = key;
        this.value = value;
    }
}

class Hash {
    int size;
    HashMember [][] table;
    int [] appearanceCount;
    Hash(int size) {
        this.size = size;
        table = new HashMember[size][size];
        appearanceCount = new int[size];
    }
    
    int generateHash(String value) {
        int hash = 7;
        for (int i = 0; i < value.length(); i++) {
            hash+= 31* hash + value.charAt(i);
        }
        if (hash < 0) hash=-hash;
        return hash%size;
    }
    
    void addToTable(String key, String value) {
        int hash = generateHash(key);
        int appearances = appearanceCount[hash];
        HashMember hashMember = new HashMember(key, value);
        if (appearances == 0) {
            table[hash][0] = hashMember;
            appearanceCount[hash]++;
        } else {
            for (int i = 0; i < size; i++) {
                if (table[hash][i] == null) {
                    table[hash][i] = hashMember;
                    appearanceCount[hash]++;
                    break;
                } else {
                    HashMember currentHashMember  = table[hash][i];
                    if (currentHashMember.key.equals(key)) {
                        table[hash][i] = hashMember;
                        break;
                    }
                }
            }
        }
    }
    
    String removeFromTable(String key) {
        int hash = generateHash(key);
        int appearances = appearanceCount[hash];
        String result = "";
        for (int i = 0; i < appearances; i++) {
            HashMember hashMember = table[hash][i];
            if (hashMember != null) {
                if (hashMember.key == key) {
                    result = table[hash][i].value;
                    table[hash][i] = null;
                    break;
                }
            }
        }
        return result;
    }
    
    String getValue(String key) {
        int hash = generateHash(key);
        int appearances = appearanceCount[hash];
        String result = "";
        for (int i = 0; i < appearances; i++) {
            HashMember hashMember = table[hash][i];
            if (hashMember != null) {
                if (hashMember.key.equals(key)) {
                    result = table[hash][i].value;
                    break;
                }
            }
        }
        return result;
    }
}


public class HashTable {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int size = 128;
        Hash table = new Hash(128);
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases > 0) {
            String currentKey = scanner.next();
            String currentValue = scanner.next();
            table.addToTable(currentKey, currentValue);
            testCases--;
        }
        
        int consults = scanner.nextInt();
        while (consults > 0) {
            String currentKey = scanner.next();
            System.out.println("Current Value for key: " + table.getValue(currentKey));
        }
        
    }

}
