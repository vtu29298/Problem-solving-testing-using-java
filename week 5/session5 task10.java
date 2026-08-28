import java.util.ArrayList;

public class GFG {

    static ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> ans = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();

        if (m > n) return ans;

        // Step 1: Compute LPS (Longest Prefix Suffix) array
        int[] lps = new int[m];
        int len = 0;
        int i = 1;
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // Step 2: Search pattern in text using LPS
        i = 0; // index for txt
        int j = 0; // index for pat
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                ans.add(i - j);
                j = lps[j - 1]; // Skip redundant comparisons
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String txt = "aabaacaadaabaaba";
        String pat = "aaba";

        ArrayList<Integer> res = search(pat, txt);

        for (int it : res) {
            System.out.print(it + " ");
        }
    }
}