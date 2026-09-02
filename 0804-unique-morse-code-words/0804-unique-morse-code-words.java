class Solution {
    public int uniqueMorseRepresentations(String[] words) {

        String[] storage = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-", "..-",
            "...-", ".--", "-..-", "-.--", "--.."
        };

        HashSet<String> set = new HashSet<>();

        for (String word : words) {

            StringBuilder temp = new StringBuilder();

            for (char ch : word.toCharArray()) {
                temp.append(storage[ch - 'a']);
            }

            set.add(temp.toString());
        }

        return set.size();
    }
}