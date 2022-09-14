package leetcode.editor.cn;

//给定一个整数数组 nums，求出数组从索引 i 到 j (i ≤ j) 范围内元素的总和，包含 i, j 两点。 
//
// update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。 
//
// 示例: 
//
// Given nums = [1, 3, 5]
//
//sumRange(0, 2) -> 9
//update(1, 2)
//sumRange(0, 2) -> 8
// 
//
// 说明: 
//
// 
// 数组仅可以在 update 函数下进行修改。 
// 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。 
// 
// Related Topics 树状数组 线段树 
// 👍 210 👎 0

class RangeSumQueryMutable {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray solution = new NumArray(nums);
        int a1 = solution.sumRange(2, 5);
        System.out.println(a1);
    }
}

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {

        private SegmentTree<Integer> segmentTree;

        public NumArray(int[] nums) {
            if(nums.length != 0){
                Integer[] data = new Integer[nums.length];
                for (int i = 0; i < nums.length; i++) {
                    data[i] = nums[i];
                }
//        segmentTree = new SegmentTree(data, (a, b) -> a + b);
                segmentTree = new SegmentTree<>(data, new Merger<Integer>() {
                    @Override
                    public Integer merger(Integer a, Integer b) {
                        return a + b;
                    }
                });
            }
        }

        public void update(int i, int val) {
            segmentTree.set(i, val);
        }

        public int sumRange(int i, int j) {
            if (i > j)
                throw new IllegalArgumentException("argument is illegal!");
            return segmentTree.query(i, j);
        }

        private interface Merger<E> {
            E merger(E a, E b);
        }

        private class SegmentTree<E> {
            E[] data;
            E[] tree;
            Merger<E> merger;

            public int leftChild(int treeIndex) {
                return treeIndex * 2 + 1;
            }

            public int rightChild(int treeIndex) {
                return treeIndex * 2 + 2;
            }

            SegmentTree(E[] arr, Merger<E> merger) {
                this.merger = merger;
                data = (E[]) new Object[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    data[i] = arr[i];
                }
                tree = (E[]) new Object[4 * arr.length];
                buildSegmentTree(0, 0, data.length - 1);
            }

            public void buildSegmentTree(int treeIndex, int l, int r) {
                if (l == r) {
                    tree[treeIndex] = data[l];
                    return;
                }
                int mid = l + (r - l) / 2;
                int leftChildIndex = leftChild(treeIndex);
                int rightChildIndex = rightChild(treeIndex);
//            if(l >= mid + 1){
//            }else if( r <= mid){
//            }
                buildSegmentTree(rightChildIndex, mid + 1, r);
                buildSegmentTree(leftChildIndex, l, mid);
                tree[treeIndex] = merger.merger(tree[leftChildIndex], tree[rightChildIndex]);
            }

            public E get(int index) {
                if (index < 0 || index >= data.length) throw new IllegalArgumentException("");
                return data[index];
            }

            public E query(int queryL, int queryR) {
                if (queryL < 0 || queryR < 0 || queryL > queryR || queryL >= data.length || queryR >= data.length)
                    throw new IllegalArgumentException("");
                return query(0, 0, data.length - 1, queryL, queryR);
            }

            public E query(int treeIndex, int l, int r, int queryL, int queryR) {
                if (queryL == l && queryR == r) return tree[treeIndex];
                int mid = l + (r - l) / 2;
                int leftTreeIndex = leftChild(treeIndex);
                int rightTreeIndex = rightChild(treeIndex);
                if (queryL >= mid + 1) {
                    return query(rightTreeIndex, mid + 1, r, queryL, queryR);
                } else if (queryR <= mid) {
                    return query(leftTreeIndex, l, mid, queryL, queryR);
                }
                E left = query(leftTreeIndex, l, mid, queryL, mid);
                E right = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
                return merger.merger(left, right);
            }

            public void set(int index, E e) {
                data[index] = e;
                set(0, 0, data.length - 1, index, e);
            }

            public void set(int treeIndex, int l, int r, int index, E e) {
                if (l == r) {
                    tree[treeIndex] = e;
                    return;
                }
                int mid = l + (r - l) / 2;
                int leftTreeIndex = leftChild(treeIndex);
                int rightTreeindex = rightChild(treeIndex);
                if (index >= mid + 1) {
                    set(rightTreeindex, mid + 1, r, index, e);
                } else if (index <= mid) {
                    set(leftTreeIndex, l, mid, index, e);
                }
                tree[treeIndex] = merger.merger(tree[leftTreeIndex], tree[rightTreeindex]);
            }
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
//leetcode submit region end(Prohibit modification and deletion)

