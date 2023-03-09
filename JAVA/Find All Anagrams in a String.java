class Solution {
  
    public List<Integer> findAnagrams(String s, String p) {
        int A = s.length();
        int B = p.length();
        List<Integer> res = new ArrayList<>();
        if (A<=0 || B<=0) 
            return res;
        int[] bArr = new int[26];
        for (int i=0; i<B; i++) {
            char c = p.charAt(i);
            bArr[(int)(c-'a')]
                ++;
        }
        for (int i=0; i<=A-B; i++) {
            char c = s.charAt(i);
            if (bArr[(int)(c-'a')] == 0)
                continue;
            if (isAnagram(s, i, i+B-1, bArr)) {
                res.add(i);
            }
        }
        return res;
    }
    private boolean isAnagram(String s, int start, int end, int[] bArr) {
        int[] aArr = new int[26];
        for (int i=start; i<=end; i++) {
            char c = s.charAt(i);
            if (bArr[(int)(c-'a')] == 0)
                return false;
            aArr[(int)(c-'a')]
                ++;
            if (bArr[(int)(c-'a')] < aArr[(int)(c-'a')])
                return false;
        }
        return true;
    }
}


_____________________________


class Solution {

    public List<Integer> findAnagrams(String s,String p){
        List<Integer> result = new ArrayList<>();
        if (s==null || s.length()==0 || p==null || p.length()==0 || s.length() < p.length()) {
            return result;
        }
        int[] freq = new int[26];
        for (char c:p.toCharArray()) {
            freq [c-'a']++;
        }
        int left = 0, right = 0;
        while (right < s.length()) {
            if (right-left == p.length()) {
                if (Arrays.equals(freq,new int[26])) {
                    result.add(left);
                }
                freq [s.charAt(left++) - 'a']++;
            } else {
                freq [s.charAt(right++) - 'a']--;
            }
        }
        if (Arrays.equals(freq, new int[26])) {
            result.add(left);
        }
        return result;
    }
}
