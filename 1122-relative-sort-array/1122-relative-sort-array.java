class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max_value = Integer.MIN_VALUE ;
        for(int n =0; n < arr1.length ; n++){
            if(arr1[n] > max_value){
                max_value = arr1[n];
            }
        }
        int[] freq_count_arr = new int[max_value+1];
        for(int i = 0 ; i < arr1.length ; i++){
            int val = arr1[i];
            freq_count_arr[val] = freq_count_arr[val]+1 ;
        }
        int index = 0 ;
        for(int i = 0 ; i < arr2.length ; i++){
            int val = arr2[i];
            while(freq_count_arr[val]> 0 ){
                arr1[index]=val ;
                index++ ;
                freq_count_arr[val] -= 1 ;
            }
        }
        for(int i = 0 ; i<freq_count_arr.length ; i++){
            if(freq_count_arr[i] > 0){
                int count = freq_count_arr[i] ;
                while(count > 0){
                    arr1[index]= i ;
                    index++;
                    count--;
                }
            }
        }

        return arr1 ;

    }
}