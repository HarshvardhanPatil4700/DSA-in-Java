public class MajorityElement {
    public static int majorityEleCount (int a[]) {
        // 1. Brute force - TC = O(n^2) 
        // int n = a.length;
        // for(int i=0;i<n;i++) {
        //     int cnt = 0;
        //     for(int j=0;j<n;j++) {
        //         if(a[j] == a[i]) {
        //             cnt++;
        //         }
        //     }
        //     if(cnt > (n/2)) 
        //         return a[i];
        // }
        // return -1;

        // 2. Better soln : TC = O(n logn) + O(n). SC = O(n)
        // int n = a.length; 
        // HashMap<Integer,Integer> hash = new HashMap<>();

        // // Store elements and its count in Hashtable
        // for(int i=0;i<a.length;i++) {
        //     hash.put(a[i], hash.getOrDefault(a[i], 0) + 1); // get the count of a[i] if its not present take it as 0 else increment it (+1)
        // }

        // // Iterate in Hash table to get ele with max count
        // for (Map.Entry<Integer, Integer> it : hash.entrySet()) {
        //     if (it.getValue() > n / 2) {
        //         return it.getKey();
        //     }
        // }
        // return -1;

        // 3. Optimal Soln : Moore's Voting Algorithm - TC = O(n) + O(n)=>this O(n) is used if majority el may exist in arr and IF it says at majority el definitely exists in arr then TC = O(n)
        int n = a.length;
        int cnt = 0;
        int el = 0; 
        for(int i=0;i<n;i++) { // iterate through the array
            // At start if no element is selected choose the first ele as el and inc its cnt. Also, if after iterating the cnt of el choosen becomes 0 due to dec by other elements then choose the next element as el
            if(cnt == 0) { 
                cnt = 1;
                el = a[i];
            }
            // if next element is same as el then inc count. Eg: [7,7,2,7,3,4]=> cnt = 1,2,1,2,1,0
            else if(a[i] == el) {
                cnt++;
            }
            // if next element is other than el then decr count
            else{
                cnt--;
            }
        }

        // After iterating complete arr verify the majority element by linear search if cnt of majority element (el) is greater than n/2
        int cnt1 = 0;
        for(int i=0;i<n;i++) {
            if(a[i] == el) 
                cnt1++;
        }
        if (cnt1 > (n/2)) {
            return el;
        }

        return -1;
    }
    
    public static void main(String[] args) {
        int a[] = {7,7,7,7,2,7,7};
        System.out.println(majorityEleCount(a));
    }
}

/*
Moore's Voting Algo : To find element that appears more than n/2 times in array i.e majority element in array
Idea :
1.Keep a candidate (el)
2.Keep a count (cnt)
3.Same element → increase count
4.Different element → decrease count
5.Majority element will survive at the end */