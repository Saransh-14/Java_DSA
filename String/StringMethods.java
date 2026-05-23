public class StringMethods{
//REVERSING A STRING
    public static String reverseString(String s){
        char[] letters = s.toCharArray();
        for (int i=0, j=letters.length-1; i<j; i++,j--){
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }
        return new String(letters);
    }

//PALINDROME
    public static boolean palindrome(String s){
        for (int i=0, j=s.length()-1; i<j; i++,j--){
            if (s.charAt(i)!=s.charAt(j)) return false;
        }
        return true;
    }

//TOGGLE/SWITCH CASE
    public static String toggleCase(String s){
        char[] letters = s.toCharArray();
        for (int i=0; i<letters.length; i++){
            if ('A' <= letters[i] && letters[i] <= 'Z'){
                letters[i] = (char)(letters[i]+32);
            }
            else if('a' <= letters[i] && letters[i] <= 'z'){
                letters[i] = (char)(letters[i]-32);
            }
        }
        return new String(letters);
    }

//ANAGRAM CHECK
    public static boolean isAnagram(String s, String t){
        if (s.length() != t.length()) return false;
        int[] charCount = new int[26];
        for (int i=0; i<s.length(); i++){
            charCount[s.charAt(i)-'a']++;
            charCount[t.charAt(i)-'a']--;
        }
        for (int i=0; i<charCount.length; i++){
            if (charCount[i] != 0) return false;
        }
        return true;
    }

//REVERSING WORDS OF A STRING
    public static String reverseWords(String s){
        StringBuilder str = new StringBuilder();
        s = s.trim();
        String[] words = s.split(" ");
        for (int i=words.length-1; i>=0; i--){
            if (!words[i].equals("") && !words[i].equals(" ")){
                str.append(words[i]);
                if (i>0) str.append(" ");
            }
        }
        return str.toString();
    }
//MAIN FUNCTION
    public static void main(String[] args){
        // System.out.println(reverseString("hello"));

        //System.out.println(palindrome("raceca"));
        
        //System.out.println(toggleCase("MyVoiceIsNotNormal5"));
        
        //System.out.println(isAnagram("anagram", "nagabam"));
        
        System.out.println(reverseWords("     anagram         checking          is easy        "));
    }
}