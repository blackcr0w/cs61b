/* UserList.java */

import queue.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserList {

    private CatenableQueue<User> userQueue;
    private int size;

    /**
    * Creates empty UserList containing no users
    **/
    public UserList(){
        userQueue = new CatenableQueue<User>();
        size = 0;
    }

    /**
    *  addUser() adds a defensive copy of the specified user.
    **/
    public void add(User u){
        if (u.getPagesPrinted() < 0) {
            System.out.println("A user cannot have a negative number of pages printed.");
            return;
        }
        User uCopy = new User(u.getId(), u.getPagesPrinted());
        userQueue.enqueue(uCopy);
        size++;
    }

    /**
    *  getSize() returns the number of users in the UserList
    **/
    public int getSize(){
        return size;
    }

    /**
    * getUsers() returns the CatenableQueue<User> of Users.
    **/
    public CatenableQueue<User> getUsers(){
        return userQueue;
    }

    /**
    *  toString() prints out the id and pages printed of all users in the UserList.
    **/
    public String toString(){
        return userQueue.toString();
    }

    /**
    *  partition() partitions qUnsorted using the pivot integer.  On completion of
    *  this method, qUnsorted is empty, and its items have been moved to qLess,
    *  qEqual, and qGreater, according to their relationship to the pivot.
    *
    *   @param sortFeature is a string that tells us what we are sorting. If we are
    *       sorting user IDs, sortFeatures equals "id". If we are sorting pages
    *       printed, sortFeatures equals "pages".
    *   @param qUnsorted is a CatenableQueue<User> of User objects.
    *   @param pivot is an integer used for partitioning.
    *   @param qLess is a CatenableQueue<User>, in which all Users with sortFeature less than pivot
    *       will be enqueued.
    *   @param qEqual is a CatenableQueue<User>, in which all Users with sortFeature equal to the pivot
    *       will be enqueued.
    *   @param qGreater is a CatenableQueue<User>, in which all Users with sortFeature greater than pivot
    *       will be enqueued.  
    **/ 
    public static void partition(String sortFeature, CatenableQueue<User> qUnsorted, int pivot, 
        CatenableQueue<User> qLess, CatenableQueue<User> qEqual, CatenableQueue<User> qGreater){
        if (sortFeature.equals("id")) {
            while (qUnsorted.front() != null) {
                if (qUnsorted.front().getId() > pivot) {
                    qGreater.enqueue(qUnsorted.dequeue());
                } else if (qUnsorted.front().getId() == pivot) {
                    qEqual.enqueue(qUnsorted.dequeue());
                } else {
                    qLess.enqueue(qUnsorted.dequeue());
                }
            }
        } else if (sortFeature.equals("pages")) {
            while (qUnsorted.front() != null) {
                if (qUnsorted.front().getPagesPrinted() > pivot) {
                    qGreater.enqueue(qUnsorted.dequeue());
                } else if (qUnsorted.front().getPagesPrinted() == pivot) {
                    qEqual.enqueue(qUnsorted.dequeue());
                } else {
                    qLess.enqueue(qUnsorted.dequeue());
                }
            }
        } else {
            System.out.println("Unrecognized sorting feature");
        }
    }

    /**
    *   quickSort() sorts q from smallest to largest according to sortFeature using quicksort.
    *   @param sortFeature is a string that tells us what we are sorting. If we are
    *       sorting user IDs, sortFeatures equals "id". If we are sorting pages
    *       printed, sortFeatures equals "pages".
    *   @param q is an unsorted CatenableQueue containing User items.
    **/
    public static void quickSort(String sortFeature, CatenableQueue<User> q){ 
        CatenableQueue<User> less = new CatenableQueue<User>();
        CatenableQueue<User> equal = new CatenableQueue<User>();
        CatenableQueue<User> greater = new CatenableQueue<User>();
        if (sortFeature.equals("id")) {
            if (q.front() == null) {
                return;
            }
            partition(sortFeature, q, q.front().getId(), less, equal, greater);
            quickSort(sortFeature, less);
            quickSort(sortFeature, greater);
            less.append(equal);
            less.append(greater);
            while (less.front() != null) {
                q.enqueue(less.dequeue());
            }
        } else if (sortFeature.equals("pages")) {
            if (q.front() == null) {
                return;
            }
            partition(sortFeature, q, q.front().getPagesPrinted(), less, equal, greater);
            quickSort(sortFeature, less);
            quickSort(sortFeature, greater);
            less.append(equal);
            less.append(greater);
            while (less.front() != null) {
                q.enqueue(less.dequeue());
            }
        } else {
            System.out.println("Unrecognized sorting feature");
        }
    }

    /**
    *  quickSort() sorts userQueue from smallest to largest according to sortFeature, using quicksort.
    *  @param sortFeature is a string that equals "id" if we are sorting users by their IDs, or equals
    *  "pages" if we are sorting users by the number of pages they have printed.
    **/
    public void quickSort(String sortFeature){
        quickSort(sortFeature, userQueue);
    }


    /**
    *  makeQueueOfQueues() makes a queue of queues, each containing one User
    *  of userQueue.  Upon completion of this method, userQueue is empty.
    *  @return a CatenableQueue<CatenableQueue<User>>, where each CatenableQueue
    *    contains one User from userQueue.
    **/

    public CatenableQueue<CatenableQueue<User>> makeQueueOfQueues(){
        CatenableQueue<CatenableQueue<User>> toReturn = new CatenableQueue<CatenableQueue<User>>();
        while (userQueue.front() != null) {
            CatenableQueue<User> toInsert = new CatenableQueue<User>();
            toInsert.enqueue(userQueue.dequeue());
            toReturn.enqueue(toInsert);
        }
        return toReturn;
    }

    /**
    *  mergeTwoQueues() merges two sorted queues into one sorted queue.  On completion
    *  of this method, q1 and q2 are empty, and their Users have been merged
    *  into the returned queue. Assume q1 and q2 contain only User objects.
    *   @param sortFeature is a string that tells us what we are sorting. If we are
    *       sorting user IDs, sortFeatures equals "id". If we are sorting pages
    *       printed, sortFeatures equals "pages".
    *  @param q1 is CatenableQueue<User> of User objects, sorted from smallest to largest by their sortFeature.
    *  @param q2 is CatenableQueue<User> of User objects, sorted from smallest to largest by their sortFeature.
    *  @return a CatenableQueue<User> containing all the Users from q1 and q2 (and nothing else),
    *       sorted from smallest to largest by their sortFeature.
    **/
    public static CatenableQueue<User> mergeTwoQueues(String sortFeature, CatenableQueue<User> q1, CatenableQueue<User> q2){
        CatenableQueue<User> toReturn = new CatenableQueue<User>();
        if (sortFeature.equals("id")) {
            while (q1.front() != null && q2.front() != null) {
                if (q1.front().getId() <= q2.front().getId()) {
                    toReturn.enqueue(q1.dequeue());
                } else {
                    toReturn.enqueue(q2.dequeue());
                }
            }
            if (q1.front() == null) {
                while (q2.front() != null) {
                    toReturn.enqueue(q2.dequeue());
                }
            } else {
                while (q1.front() != null) {
                    toReturn.enqueue(q1.dequeue());
                }
            }
        } else if (sortFeature.equals("pages")) {
            while (q1.front() != null && q2.front() != null) {
                if (q1.front().getPagesPrinted() <= q2.front().getPagesPrinted()) {
                    toReturn.enqueue(q1.dequeue());
                } else {
                    toReturn.enqueue(q2.dequeue());
                }
            }
            if (q1.front() == null) {
                while (q2.front() != null) {
                    toReturn.enqueue(q2.dequeue());
                }
            } else {
                while (q1.front() != null) {
                    toReturn.enqueue(q1.dequeue());
                }
            }
        } else {
            System.out.println("Unrecognized sorting feature");
            return null;
        }
        return toReturn;
    }

    /**
    *   mergeSort() sorts this UserList from smallest to largest according to sortFeature using mergesort.
    *   You should complete this method without writing any helper methods.
    *   @param sortFeature is a string that tells us what we are sorting. If we are
    *       sorting user IDs, sortFeatures equals "id". If we are sorting pages
    *       printed, sortFeatures equals "pages".
    **/
    public void mergeSort(String sortFeature){
        CatenableQueue<CatenableQueue<User>> result = makeQueueOfQueues();
        while (result.size() > 1) {
            result.enqueue(mergeTwoQueues(sortFeature, result.dequeue(), result.dequeue()));
        }
        CatenableQueue<User> temp = result.dequeue();
        while (temp.front() != null) {
            userQueue.enqueue(temp.dequeue());
        }
    }

    /**
    *   sortByBothFeatures() sorts this UserList's userQueue from smallest to largest pages printed.
    *   If two Users have printed the same number of pages, the User with the smaller user ID is first.
    **/
    public void sortByBothFeatures(){
        quickSort("id", userQueue);
        quickSort("pages", userQueue);
    }


    @Test
    public void naivePartitionTest() {
        UserList list = new UserList();

        list.add(new User(0, 20));
        list.add(new User(1, 0));
        list.add(new User(2, 10));

        CatenableQueue<User> less = new CatenableQueue<User>();
        CatenableQueue<User> equal = new CatenableQueue<User>();
        CatenableQueue<User> greater = new CatenableQueue<User>();

        /* pivot on user 1 by id */
        list.partition("id", list.userQueue, 1, less, equal, greater);
        assertEquals(1, less.size());
        assertEquals(1, equal.size());
        assertEquals(1, greater.size());
        assertEquals(new User(0, 20), less.front());
        assertEquals(new User(1, 0), equal.front());
        assertEquals(new User(2, 10), greater.front());
    }

    @Test
    public void naiveQuickSortTest() {
        UserList list = new UserList();
        list.add(new User(2, 12));
        list.add(new User(0, 10));
        list.add(new User(1, 11));

        list.quickSort("id");

        String sorted =
         "[ User ID: 0, Pages Printed: 10,\n  User ID: 1, Pages Printed: 11,\n  User ID: 2, Pages Printed: 12 ]";

        assertEquals(sorted, list.toString());

        list.quickSort("pages");
        assertEquals(sorted, list.toString()); 
    }

    @Test
    public void naiveMakeQueuesTest(){
        UserList list = new UserList();

        list.add(new User(0, 20));
        list.add(new User(1, 0));
        list.add(new User(2, 10));
        list.add(new User(3, 20));

        CatenableQueue<CatenableQueue<User>> queues = list.makeQueueOfQueues();
        String queueOfQueues = 
        "[ [ User ID: 0, Pages Printed: 20 ],\n  [ User ID: 1, Pages Printed: 0 ],\n  [ User ID: 2, Pages Printed: 10 ]"
            + ",\n  [ User ID: 3, Pages Printed: 20 ] ]";

        assertEquals(queueOfQueues, queues.toString());        
    }

    @Test
    public void naiveMergeQueuesTest(){
        CatenableQueue<User> q1 = new CatenableQueue<User>();
        CatenableQueue<User> q2 = new CatenableQueue<User>();
        q1.enqueue(new User(0, 20));
        q2.enqueue(new User(1, 10));

        CatenableQueue<User> merged = mergeTwoQueues("pages", q1, q2);
        String mergeByPages = 
        "[ User ID: 1, Pages Printed: 10,\n  User ID: 0, Pages Printed: 20 ]";
        assertEquals(mergeByPages, merged.toString());        

        q1 = new CatenableQueue<User>();
        q2 = new CatenableQueue<User>();
        q1.enqueue(new User(0, 20));
        q2.enqueue(new User(1, 10));

        merged = mergeTwoQueues("id", q1, q2);
        String mergeById = 
        "[ User ID: 0, Pages Printed: 20,\n  User ID: 1, Pages Printed: 10 ]";
        assertEquals(mergeById, merged.toString());        
    }

    @Test
    public void naiveMergeSortTest() {
        UserList list = new UserList();
        list.add(new User(2, 12));
        list.add(new User(0, 10));
        list.add(new User(1, 11));

        list.mergeSort("id");

        String sorted =
         "[ User ID: 0, Pages Printed: 10,\n  User ID: 1, Pages Printed: 11,\n  User ID: 2, Pages Printed: 12 ]";

        assertEquals(sorted, list.toString());

        list.mergeSort("pages");
        assertEquals(sorted, list.toString()); 
    }

    @Test
    public void naiveSortByBothTest() {
        UserList list = new UserList();
        list.add(new User(2, 12));
        list.add(new User(1, 10));
        list.add(new User(0, 10));

        list.sortByBothFeatures();

        String sorted =
         "[ User ID: 0, Pages Printed: 10,\n  User ID: 1, Pages Printed: 10,\n  User ID: 2, Pages Printed: 12 ]";

        assertEquals(sorted, list.toString());
    }

    public static void main(String [] args) {
        // Naive right-idea tests. Just because these tests pass does NOT mean
        // your code is bug-free!

        // Uncomment the following line when ready
        jh61b.junit.textui.runClasses(UserList.class);
    }

}