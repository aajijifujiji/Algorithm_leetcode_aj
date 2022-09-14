package leetcode.editor.practise;

import java.util.Arrays;

public class BinaryHeap {
    public static  void upAdjust(int[] array){
        int childrenIndex = array.length - 1;
        int parentIndex = (childrenIndex - 1)/2;
        int temp = array[childrenIndex];
        while (childrenIndex >0 && temp > array[parentIndex]){
            array[childrenIndex] = array[parentIndex];
            childrenIndex = parentIndex;
            parentIndex = (parentIndex - 1)/2;
        }
        array[childrenIndex] = temp;
    }
    public static void downAdjust(int index,int[] array){
        int parentIndex = index;
        int childrenIndex = 2 * parentIndex + 1;
        int temp = array[parentIndex];
        while (childrenIndex<= array.length -1){
            //找比较大的那个
            if(childrenIndex+1 <= array.length -1 && array[childrenIndex+1] > array[childrenIndex]){
                childrenIndex++;
            }
            //子结点和父节点比较，如果子结点大干父节点那么不动
            if(array[childrenIndex] <= temp ){
                break;
            }
            array[parentIndex] = array[childrenIndex];
            parentIndex = childrenIndex;
            childrenIndex = 2 * childrenIndex + 1;
        }
        array[parentIndex] = temp;
    }

    public static void buildBinaryHeap(int[] array){
        for (int i = array.length / 2  -1; i >=0 ; i--) {
            downAdjust(i,array);
        }
    }

    public static void main(String[] args) {
//        int [] arr01 = {5, 3, 6, 9, 8, 6, 7, 2, 4, 6, 3};
//        buildBinaryHeap(arr01);
//        System.out.println(Arrays.toString(arr01));
        int[] arr02 = {9, 8, 7, 4, 6, 6, 6, 2, 3, 5, 3, 20};
        upAdjust(arr02);
        System.out.println(Arrays.toString(arr02));
        int[] arr03 = {3, 8, 7, 4, 6, 6, 6, 2, 3, 5};
        downAdjust(0, arr03);
        System.out.println(Arrays.toString(arr03));

    }
}
