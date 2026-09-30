
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n =0 ;
        ListNode temp = head ;
        while(temp != null){
            n++ ;
            temp = temp.next ;

        }
        ListNode [] ans = new ListNode[k] ;
        int size = n / k ;
        int extra = n% k ;
        temp = head ;
        for(int i= 0  ; i< k ;i++){
            ans[i] = temp ;

            int currentSize = size ;
            if(extra > 0){
                currentSize ++ ;
                extra -- ;
            }
            for(int j= 1 ;j<currentSize ; j++){
                temp = temp.next ;

            }
            if(temp != null){
                ListNode nextpart = temp.next ;
                temp.next = null ;
                temp = nextpart ;
            }
        }
        return ans ;
    }
}