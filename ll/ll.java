import java.util.*;

public class ll {
    public static void main(String[] args) {
        LLtoStackAdapter x = new LLtoStackAdapter();
        x.push(10);
        x.push(20);
        x.push(30);
        x.push(40);
        x.pop();
        x.print();

    }

}

class node {
    int data;
    node next;

    // sort 2 ll
    public void merge(linkedlist l1, linkedlist l2) {
        node link = new node();
        node h = link;
        link.data = 0;
        while (l1.head != null && l2.head != null) {
            if (l1.head.data <= l2.head.data) {
                link.next = l1.head;
                l1.head = l1.head.next;
            } else {
                link.next = l2.head;
                l2.head = l2.head.next;
            }
            link = link.next;
        }
        while (l1.head != null) {
            link.next = l1.head;
            l1.head = l1.head.next;
            link = link.next;
        }
        while (l2.head != null) {
            link.next = l2.head;
            l2.head = l2.head.next;
            link = link.next;
        }
        h = h.next;
        while (h != null) {
            System.out.print(h.data + " ");
            h = h.next;
        }
    }
}

class linkedlist {
    int size;
    node tail;
    node head;

    //
    // add last
    //
    public void addLast(int val) {
        node temp = new node();
        temp.data = val;
        temp.next = null;
        if (size == 0) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    //
    // add first
    //
    public void addFirst(int val) {
        node temp = new node();
        temp.data = val;
        temp.next = head;
        head = temp;
        if (size == 0)
            tail = temp;
        size++;
    }

    //
    // add at
    //
    public void addAt(int idx, int val) {
        if (idx < 0 || idx > size) {
            System.out.println("invalid arguments");
        } else if (idx == 0) {
            addFirst(val);
        } else if (idx == size) {
            addLast(val);
        } else {
            node temp = head;
            node newNode = new node();
            newNode.data = val;
            for (int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }
            node x = temp.next;
            temp.next = newNode;
            newNode.next = x;

        }
    }

    //
    // remove first
    //
    public int removeFirst() {
        int x = -99;
        if (size == 0)
            System.out.println("list is empty");
        else if (size == 1) {
            x = head.data;
            head = tail = null;
            size = 0;
        } else {
            x = head.data;
            head = head.next;
            size--;
        }
        return x;
    }

    //
    // remove last
    //
    public void removeLast() {
        if (size == 0)
            System.out.println("list is empty");
        else if (size == 1) {
            head = tail = null;
            size = 0;
        } else {
            // node temp=head;
            // for(int i=0;i<size-2;i++){
            // temp=temp.next;
            // }
            // tail=temp;
            // temp.next=null;
            node temp1 = head, temp2 = head.next;
            while (temp2.next != null) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            tail = temp1;
            temp1.next = null;

        }
    }

    //
    // remove idx
    //
    public void removeIdx(int idx) {
        if (idx < 0 || idx >= size) {
            System.out.println("invalid idx");
        } else if (idx == 0) {
            removeFirst();
        } else if (idx == size - 1)
            removeLast();
        else {
            node temp = head;
            for (int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }

    }

    //
    // get first
    //
    public int getFirst() {
        if (size == 0)
            return -1;
        else
            return head.data;
    }

    //
    // get last
    //
    public int getLast() {
        if (size == 0)
            return -1;
        else
            return tail.data;
    }

    //
    // get at
    //
    public int getAt(int idx) {
        if (size == 0)
            return -1;
        else if (idx >= size || idx < 0)
            return -1;
        else {
            node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp.data;
        }
    }

    //
    // print
    //
    public void display() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    //
    // get node(this is private u can use only in class)
    //
    private node getNode(int idx) {
        if (size == 0)
            return null;
        else if (idx >= size || idx < 0)
            return null;
        else {
            node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp;
        }
    }

    //
    // reverse data iterative
    //
    public void reverseDI() {
        int l = 0;
        int r = size - 1;
        while (l < r) {
            node temp1 = getNode(l);
            node temp2 = getNode(r);
            int swap = temp1.data;
            temp1.data = temp2.data;
            temp2.data = swap;
            l++;
            r--;
        }
    }

    //
    // reverse pointer iterative
    //
    public void reversePI() {
        node prev = null;
        node curr = head;
        while (curr != null) {
            node Next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = Next;
        }
        // head=prev;
        node temp = head;
        head = tail;
        tail = temp;
    }

    //
    // kth ele from end
    //
    public int ktheleFromLast(int k) {
        node slow = head, fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }

    //
    // get mid
    //
    public int mid() {
        node slow = head;
        node fast = head;
        // fast.next for odd
        // fast.next.next for even
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    //
    // merge 2 sorted ll
    //
    public linkedlist mergeLinkedlist(linkedlist l1, linkedlist l2) {
        node one = l1.head;
        node two = l2.head;

        linkedlist res = new linkedlist();

        while (one != null && two != null) {
            if (one.data <= two.data) {
                res.addLast(one.data);
                one = one.next;
            } else {
                res.addLast(two.data);
                two = two.next;
            }
        }
        while (one != null) {
            res.addLast(one.data);
            one = one.next;
        }
        while (two != null) {
            res.addLast(two.data);
            two = two.next;
        }
        // this.head=res.head;
        // this.tail=res.tail;
        // this.size=res.size;
        return res;

        // int val=sc.nextInt();
        // linkedlist list1=new linkedlist();
        // while(val!=-1){
        // list1.addLast(val);
        // val=sc.nextInt();
        // }
        // list1.display();
        // val=sc.nextInt();
        // linkedlist list2=new linkedlist();
        // while(val!=-1){
        // list2.addLast(val);
        // val=sc.nextInt();
        // }
        // list2.display();

        // linkedlist list3=new linkedlist();
        // linkedlist list4 =list3.mergeLinkedlist(list1,list2);
        // list4.display();
    }

    //
    // mid node
    //
    public node midNode(node head, node tail) {
        node f = head;
        node s = head;
        while (f != tail && f.next != tail) {
            f = f.next.next;
            s = s.next;
        }
        return s;
    }

    //
    // merge sort a ll
    //
    public linkedlist mergeSort(node head, node tail) {
        if (head == tail) {
            linkedlist br = new linkedlist();
            br.addLast(head.data);
            return br;
        }
        node mid = midNode(head, tail);
        linkedlist fsh = mergeSort(head, mid);
        linkedlist ssh = mergeSort(mid.next, tail);
        return mergeLinkedlist(fsh, ssh);

        // list1=list1.mergeSort(list1.head,list1.tail);
        // list1.display();
    }

    //
    // remove duplicates
    //
    public void removeDuplicates() {
        linkedlist res = new linkedlist();
        while (this.size > 0) {
            int val = this.getFirst();
            this.removeFirst();

            if (res.size == 0 || res.tail.data != val) {
                res.addLast(val);
            }

        }
        this.size = res.size;
        this.head = res.head;
        this.tail = res.tail;

        // linkedlist res=new linkedlist();
        // int dataLast=-1;
        // while(this.head.next!=null){
        // if(this.head.data!=this.head.next.data){
        // res.addLast(this.head.data);
        // System.out.println(this.head.data);
        // }
        // this.head=this.head.next;
        // dataLast=this.head.data;
        // }
        // res.addLast(dataLast);
        // this.size=res.size;
        // this.head=res.head;
        // this.tail=res.tail;

    }

    //
    // odd even
    //
    public void oddEven() {
        linkedlist odd = new linkedlist();
        linkedlist even = new linkedlist();

        while (this.size > 0) {
            int val = this.getFirst();
            this.removeFirst();

            if (val % 2 == 0) {
                even.addLast(val);
            } else {
                odd.addLast(val);
            }
        }

        if (even.size != 0 && odd.size != 0) {
            odd.tail.next = even.head;
            this.head = odd.head;
            this.tail = even.tail;
            this.size = odd.size + even.size;
        } else if (odd.size != 0) {
            this.head = odd.head;
            this.tail = odd.tail;
            this.size = odd.size;
        } else {
            this.head = even.head;
            this.tail = even.tail;
            this.size = even.size;
        }
    }

    //
    // k reverse
    //
    public void kReverse(int k) {
        linkedlist prev = null;

        while (this.size > 0) {
            linkedlist curr = new linkedlist();
            if (this.size >= k) {
                for (int i = 0; i < k; i++) {
                    int val = this.getFirst();
                    this.removeFirst();
                    curr.addFirst(val);
                }
            } else {
                int s = this.size;
                for (int i = 0; i < s; i++) {
                    int val = this.getFirst();
                    this.removeFirst();
                    curr.addLast(val);
                }
            }

            if (prev == null)
                prev = curr;
            else {
                prev.tail.next = curr.head;

                prev.tail = curr.tail;
                prev.size += curr.size;
            }
        }
        this.head = prev.head;
        this.size = prev.size;
        this.tail = prev.tail;
    }

    //
    // recursively
    // display reverse (actually it is not reverse)
    //
    private void displayReverseHelper(node head) {
        if (head == null) {
            return;
        }
        displayReverseHelper(head.next);
        System.out.print(head.data + " ");
    }

    public void displayReverse() {
        displayReverseHelper(head);
        System.out.println();
    }

    //
    // reverse actually
    // recursively
    //
    private void reverseRecursivelyPI_helper(node head) {
        if (head == null)
            return;
        reverseRecursivelyPI_helper(head.next);
        if (head == tail) {
            // do nothing
            return;
        } else {
            head.next.next = head;
        }
    }

    public void reverseRecursivelyPI() {
        reverseRecursivelyPI_helper(head);
        head.next = null;
        node temp = head;
        this.head = tail;
        this.tail = temp;
    }

    //
    // merge 2 ll
    // and return it to any list
    //
    public void merge(linkedlist l1, linkedlist l2) {
        node temp = l1.head;
        while (l1.head.next != null) {
            l1.head = l1.head.next;
        }
        l1.head.next = l2.head;
        this.head = temp;
        this.tail = l2.tail;
        this.size = l1.size + l2.size;
    }

    //
    // is ll a palindrome
    //
    private boolean isPalindromeHelper(node right) {
        if (right == null)
            return true;
        boolean recursionRes = isPalindromeHelper(right.next);
        if (recursionRes == false)
            return false;
        else if (right.data != pLeft.data)
            return false;
        else {
            pLeft = pLeft.next;
            return true;
        }
    }

    node pLeft;// sibbling of size,head,tail

    public boolean isPalindrome() {
        pLeft = head;
        return isPalindromeHelper(head);
    }

    //
    // fold a linked list using recursion
    //
    private void isFoldedHelper(node right, int floor) {
        if (right == null)
            return;
        isFoldedHelper(right.next, floor + 1);
        if (floor > size / 2) {
            node temp = fleft.next;
            fleft.next = right;
            right.next = temp;
            fleft = temp;
        } else if (floor == size / 2) {
            tail = right;
            tail.next = null;
        }
    }

    node fleft;// sibbling of size,head,tail

    public void isFold() {
        fleft = head;
        isFoldedHelper(head, 0);
    }

    //
    // addTwoList
    //
    private int addTwoListHelper(node one, int pv1, node two, int pv2, ArrayList<Integer> list, linkedlist res) {
        if (one == null && two == null) {
            return 0;
        }
        int data = 0;
        if (pv1 > pv2) {
            int oc = addTwoListHelper(one.next, pv1 - 1, two, pv2, list, res);
            data = one.data + oc;
        } else if (pv1 < pv2) {
            int oc = addTwoListHelper(one, pv1, two.next, pv2 - 1, list, res);
            data = two.data + oc;
        } else {
            int oc = addTwoListHelper(one.next, pv1 - 1, two.next, pv2 - 1, list, res);
            data = one.data + two.data + oc;
            // System.out.println(one.data+" "+two.data);
        }
        int nd = data % 10;
        int nc = data / 10;
        // System.out.println("added at pv1 "+pv1+" add at pv2 "+pv2);
        res.addFirst(nd);
        list.add(nd);
        return nc;
    }

    public void addTwoList(linkedlist l1, linkedlist l2) {
        ArrayList<Integer> list = new ArrayList<>();
        linkedlist res = new linkedlist();
        int oc = addTwoListHelper(l1.head, l1.size, l2.head, l2.size, list, res);
        if (oc > 0)
            res.addFirst(oc);
        System.out.println(list);
        this.head = res.head;
        this.tail = res.tail;
        this.size = res.size;

        // int val=sc.nextInt();
        // linkedlist list1=new linkedlist();
        // while(val!=-1){
        // list1.addLast(val);
        // val=sc.nextInt();
        // }
        // list1.display();

        // val=sc.nextInt();
        // linkedlist list2=new linkedlist();
        // while(val!=-1){
        // list2.addLast(val);
        // val=sc.nextInt();
        // }
        // list2.display();

        // linkedlist list3=new linkedlist();
        // list3.addTwoList(list1, list2);
        // list3.display();
    }

}

// ******LLtoStackAdapter
class LLtoStackAdapter {
    linkedlist x = new linkedlist();

    // size
    public int size() {
        return x.size;
    }

    // push
    public void push(int val) {
        x.addFirst(val);
    }

    // pop
    public int pop() {
        if (size() == 0) {
            System.out.println("stack underflow");
            return -1;
        }
        return x.removeFirst();
    }

    // top
    public int top() {
        if (size() == 0) {
            System.out.println("stack underflow");
            return -1;
        }
        return x.getFirst();
    }

    // print
    public void print() {
        x.display();
    }
    // LLtoStackAdapter x=new LLtoStackAdapter();
    // x.push(10);
    // x.push(20);
    // x.push(30);
    // x.push(40);
    // x.pop();
    // x.print();
}

// ******LLtoQueueAdapter
class LLtoQueueAdapter {
    linkedlist x = new linkedlist();

    // size
    public int size() {
        return x.size;
    }

    // add
    public void add(int val) {
        x.addLast(val);
    }

    // remove
    public int remove() {
        if (size() == 0) {
            System.out.println("queue underflow");
            return -1;
        }
        return x.removeFirst();
    }

    // peek
    public int peek() {
        if (size() == 0) {
            System.out.println("queue underflow");
            return -1;
        }
        return x.getFirst();
    }

    // print
    public void print() {
        x.display();
    }
    // LLtoQueueAdapter x=new LLtoQueueAdapter();
    // x.add(10);
    // x.add(20);
    // x.add(30);
    // x.add(40);
    // x.remove();
    // x.print();
}