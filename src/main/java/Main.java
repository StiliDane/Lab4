public class Main {

    /** Returns trues if all the numbers in the list are below 100, false if otherwise */
    public static boolean lessThan100(int[] nums){
        for (int i : nums)
            if (i >= 100)
                return false;
        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{5, 10, 15};
        int[] nums3 = new int[]{10, 20, 30};
    }
}
