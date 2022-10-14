import java.util.Scanner;

public class CycleDetectionLinkedList{
    static class Node<E>{
        E data; Node next;
        public Node(E data){
            this.data = data;
            this.next = null;
        }
    }
    static Node<Integer> head,prev;
    public static void createLoop(int a[]){
    for(int i = 0; i<a.length; i++){
        Node<Integer> toadd = new Node<>(a[i]);
           if(head==null){
               head = toadd; prev = toadd;
           }else{
            prev.next = toadd;
            prev = prev.next;
           }
    }
    }
    public static int detectLoop(Node<Integer> head){
           Node<Integer> slow = head;
           Node<Integer> fast = head;
           while(fast!=null && slow.data!=fast.data){
                slow = slow.next;
                fast = fast.next.next;
                if(fast==null){
                    return -1;}
                }
            slow = head;
            while(slow.data!=fast.data){
                slow = slow.next; 
                fast = fast.next;
            }
           
    return slow.data;}
    public static void main(String args[]){
    Scanner sh = new Scanner(System.in);
    System.out.print("Enter the size of the Linked List : ");
    int n = sh.nextInt();
    System.out.println("Start entering data");
    int a[] = new int[n];
    for(int i = 0;i<n; i++){
        a[i] = sh.nextInt();
    }
    createLoop(a);
    int ans = detectLoop(head);
    System.out.println(ans);
    
    
    
    }
    }
