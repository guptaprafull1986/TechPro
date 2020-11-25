package _techlead_coderpro;

public class SortString {
    public static void main(String[] args) {
        System.out.println(hash("abgffhrhfrjfrh"));
        System.out.println(hash("abhfhrhfgfjfrr"));
        System.out.println(hash("hfabgfjfrhrhfr"));
        System.out.println(hash("abgfjfrhfhrhfr"));
        System.out.println(hash("arbgfjfrhfhrhf"));
    }

    private static String hash(String str) {
        int[] arr = new int[26];
        for (char c : str.toCharArray()) {
            arr[c - 'a']++;
        }
        String s = "";
        for (int i = 0; i < 26; i++) {
            s += arr[i];
        }
        return s;
    }
}
