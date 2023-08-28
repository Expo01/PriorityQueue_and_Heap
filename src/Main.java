import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        // priority queue is a FIFO data structure that serves elements witha the highest priorities
        // before elements of lower priorities where priority is defined by some ascending/descending value

//        Queue<Double> test = new PriorityQueue<>();  // decreasing order
        Queue<Double> test = new PriorityQueue<>(Collections.reverseOrder()); // increasing order

        test.offer(3.0);
        test.offer(2.5);
        test.offer(4.0);
        test.offer(1.5);
        test.offer(2.0);

        while(!test.isEmpty()){
            System.out.println(test.poll());
        }

        //////////////////////////////////////////

        // a heap is often called binary heap because it is just an incomplete tree where the last row is not complete
        // is used in heapsort and priority queues
        //
        // max-heap is when a both child nodes of a parents node are <= than the parent, but doesn't mandate lowest
        // on the left or anything like that. result is greatest value node at top
        // max-heap is used in heapsort

        // min- heap is opposite of max with min at top and is used for priority queue

        // a heap written as an array would be just going left to right so first node starts at 1 (not 0), left child is
        // index 2, right child 3, next row on left starts with 4, etc.
        // equation for obtaining L child is 2*root index.
        // for R child is 2*root + 1
        // to get parent from child = floor(childIndex/2)

        //max-heapify
        // build max heap



    }
// example method of how a maxHeap is built from an array
    public void myMaxHepify(int[] a, int heapSize, int i){
         int l = 2*i;
         int R = 2*i + 1;

         int largest = i;

         if(l < heapSize && a[l] > a[i]){
             largest=l;
         }
        if (R < heapSize && a[R] > a[largest]) {
            largest = R;
        }
        if(largest != i){ // floats the parent node value down by swapping it with the higher value of a child node
            int temp = a[i];
            a[i] = largest;
            largest = temp;  // note that largest does NOT change position to = a[i] as parent node so we have descended the tree
            myMaxHepify(a,heapSize,largest); // now when we recursively call, largest is now 'i' and a new largest will be
            // established if the current parent node is not the largest
            // only problem is then this returns because one set of parent/child nodes was accurate but doesn't descend
            // to check lower levels?
        }
    }
}