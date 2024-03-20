//利用快慢指针实现删除数组元素操作(注意:数组实际上不能删除元素,只能用新的数组覆盖原来的数组)
public class TwoPoints1 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1};//待删除元素的数组
        int target = 5;//要删除的目标元素
        int slowIndex = 0, fastIndex;
        for (fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != target) {   //将不需要删除的元素保留下来
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        System.out.println("删除目标元素后数组长度为:" + slowIndex);
        //循环输出删除目标元素后的数组
        for (int i = 0; i < slowIndex; i++) {
            System.out.print(nums[i] + "\t");
        }
    }
}
