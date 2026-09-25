import java.util.List;
import java.util.NoSuchElementException;

public class DynArray {

    // Vars

    private int[] nums;

    private int count;

    //=================================================================================================================
    // Methods

    /** Create a Dynamic Array with a list of numbers */
    public DynArray(List<Integer> numsList){
        count = numsList.size();

        // Calculate the capacity threshold first
        int doubleThresh;
        if (count < 10)
            doubleThresh = 10;
        else
            doubleThresh = count * 2;

        // Initialize the array with the calculated capacity
        this.nums = new int[doubleThresh];

        // Loop through the list and copy elements
        for (int i = 0; i < count; i++) {
            this.nums[i] = numsList.get(i);
        }
    }

    /** Creates an empty Dynamic Array */
    public DynArray(){
        super();
    }

    /** Returns true if the Dynamic Array is the same as the given obj, false if otherwise */
    public boolean equals(Object obj){
        return equalElts(obj) && nums.length == ((DynArray) obj).nums.length;
    }


    /** Returns true if the Dynamic array ahs the same elements as the given obj, returns false if otherwise */
    public boolean equalElts(Object obj){
        if (!(obj instanceof DynArray arr))
            return false;

        if (count != arr.count)
            return false;

        for (int i = 0; i < count; i++)
            if (nums[i] != arr.nums[i])
                return false;

        return true;
    }

    /** Creates an empty Dynamic array and returns it */
    public static DynArray empty(){
        return new DynArray();
    }

    /** Returns the number of elements in the dynamic array */
    public int length(){
        return count;
    }

    /** Gets the element at the given index of the dynamic array, if out of bounds throws an exception */
    public int get(int index){
        testIndex(index);

        return nums[index];
    }

    /** Sets the element at the given index of the dynamic array, if out of bounds throws an exception */
    public void set(int index, int num){
        testIndex(index);

        nums[index] = num;
    }

    /** Inserts the element at the given index of the Dynamic array and shifts the rest of the elements, if out of bounds throws an exception */
    public void insert(int index, int num){
        testIndex(index);

        expandArray();

        for (int i = count; i > index; i--) {
            nums[i] = nums[i - 1];
        }

        nums[index] = num;
        count++;
    }

    /** Adds a number to the end of the list */
    public void addToEnd(int num){
        expandArray();

        nums[count] = num;
        count++;
    }

    /** Adds a number to the start of the list */
    public void addToStart(int num){
        expandArray();

        for (int i = count; i > 0; i--) {
            nums[i] = nums[i - 1];
        }

        nums[0] = num;
        count++;
    }

    /** Removes the element at the given index of the Dynamic array, if out of bounds throws an exception */
    public void remove(int index){
        testIndex(index);

        for (int i = index; i < count; i++){
            nums[i] = nums[i + 1];
        }

        nums[count] = 0;
        count--;
    }

    /** Tests whether the given index is a valid index */
    private void testIndex(int index){
        if (index < 0)
            throw new IndexOutOfBoundsException("Index is out of bounds of the internal array");

        if (index >= count)
            throw new NoSuchElementException();
    }

    /** If the array is full expand the array to double the length to allow it to fit new elements */
    private void expandArray(){
        if (count == nums.length){
            int[] temp = new int[count * 2];
            System.arraycopy(nums, 0, temp, 0, count);

            nums = temp;
        }
    }
}

/*
Answers to Question 4:

 - My array only takes numbers while the default java arrayList takes objects
 - My List grows by doubling while the java array list grows by 1.5
 - Most methods return true if it works, we did not do that


 */