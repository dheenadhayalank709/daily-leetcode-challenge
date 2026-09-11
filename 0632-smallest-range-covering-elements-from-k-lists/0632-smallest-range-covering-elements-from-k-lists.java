class Pair<F, S> {
    F first;
    S second;
    
    Pair (F first, S second) {
        this.first = first;
        this.second = second;
    }

    public static <F, S> Pair of (F first, S second) {
        return new Pair(first, second);
    }
}

class Solution {
    private List<Pair<Integer, Integer>> transform(List<Integer> a, int k) {
        List<Pair<Integer, Integer>> ans = new ArrayList<>();
        for (int x : a) {
            ans.add(Pair.of(x, k));
        }
        return ans;
    }

    private List<Pair<Integer, Integer>> merge(List<Pair<Integer, Integer>> a, List<Pair<Integer, Integer>> b) {
        List<Pair<Integer, Integer>> ans = new ArrayList<>();

        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i).first < b.get(j).first) {
                ans.add(a.get(i));
                i += 1;
            } else {
                ans.add(b.get(j));
                j += 1;
            }
        }

        while (i < a.size()) {
            ans.add(a.get(i));
            i += 1;
        }

        while (j < b.size()) {
            ans.add(b.get(j));
            j += 1;
        }

        return ans;
    }

    private List<Pair<Integer, Integer>> merge(List<List<Integer>> lists, int beg, int end) {
        if (beg > end) return new ArrayList<>();
        if (beg == end) {
            return transform(lists.get(beg), beg);
        }

        int mid = (beg + end) / 2;

        return merge(merge(lists, beg, mid), merge(lists, mid + 1, end));
    }

    private List<Pair<Integer, Integer>> merge(List<List<Integer>> lists) {
        return merge(lists, 0, lists.size() - 1);
    }

    public int[] smallestRange(List<List<Integer>> lists) {
        int k = lists.size();
        List<Pair<Integer, Integer>> mergedList = merge(lists);
        
        int[] ans = new int[]{(int)-1e5, (int)1e5};
        Map<Integer, Integer> freq = new HashMap<>();

        int l = 0;
        for (int r = 0; r < mergedList.size(); r++) {
            freq.put(mergedList.get(r).second, freq.getOrDefault(mergedList.get(r).second, 0) + 1);

            while (freq.size() == k) { 
                if (mergedList.get(r).first - mergedList.get(l).first < ans[1] - ans[0]) {
                    ans[0] = mergedList.get(l).first;
                    ans[1] = mergedList.get(r).first;
                }

                if (freq.get(mergedList.get(l).second) == 1) {
                    freq.remove(mergedList.get(l).second);
                } else {
                    freq.put(mergedList.get(l).second, freq.get(mergedList.get(l).second) - 1);
                }

                l += 1;
            }
        }

        return ans;
    }
}