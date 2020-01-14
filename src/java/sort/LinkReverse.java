/**
 * Created by painsolace on 2017/4/25.
 * 要求： 反转一个单链表
 * 输入：
 *    1 -> 2 -> 3 -> 4 -> 5
 * 输出：
 *    5 -> 4 -> 3 -> 2 -> 1
 */
public class LinkReverse {
    class Entry{
        private int value;
        private Entry next;

        public Entry(int value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }

    public void reverse(Entry head){
        if(head.next == null)
            return;
        reverse(head.next);
        head.next.next = head;
        head.next =  null;
        //return temp;

    }

    public void noreverse(Entry head){
        Entry temp = null;
        while(head!= null){
            Entry e = head.next;
            head.next = temp;
            temp = head;
            head = e;
        }
    }

    public void printLink(Entry head){
        if(head == null)
            return;
        System.out.print(head.value);
        printLink(head.next);
    }

}
