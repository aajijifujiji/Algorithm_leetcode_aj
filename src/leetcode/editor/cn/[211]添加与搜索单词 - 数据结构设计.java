package leetcode.editor.cn;

//请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。 
//
// 实现词典类 WordDictionary ： 
//
// 
// WordDictionary() 初始化词典对象 
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配 
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 '
//.' ，每个 . 都可以表示任何一个字母。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search","se
//arch"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 500 
// addWord 中的 word 由小写英文字母组成 
// search 中的 word 由 '.' 或小写英文字母组成 
// 最调用多 50000 次 addWord 和 search 
// 
// Related Topics 设计 字典树 回溯算法 
// 👍 195 👎 0

import java.util.TreeMap;

class DesignAddAndSearchWordsDataStructure{
    public static void main(String[] args) {
        WordDictionary solution = new DesignAddAndSearchWordsDataStructure().new WordDictionary();
        solution.addWord("bad");
        solution.addWord("apple");
        solution.addWord("ha");
        System.out.println(solution.search("ha"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class WordDictionary {
        private class Node{
            public boolean isWord;
            public TreeMap<Character, Node> next;
            public Node(boolean isWord) { this.isWord = isWord; next = new TreeMap<>(); }
            public Node() { this(false); }
        }
    /** Initialize your data structure here. */
    private int size;
    private Node root;
    public WordDictionary() {
        root = new Node();
        size = 0;
    }
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        addWord(word, 0, root);
    }
    public void addWord(String word, int i, Node cur) {
        if(i >= word.length()){
            cur.isWord = true;
            return;
        }
        char c = word.charAt(i);
        if(cur.next.get(c) == null){
            cur.next.put(c, new Node());
            size++;
        }
        addWord(word, i + 1, cur.next.get(c));
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, 0, root);
    }
    public boolean search(String word, int i, Node cur) {
//        if(cur == null)return false;
//        if(i == word.length() && cur.isWord == true)return true;
//        if(i == word.length() ){
//            return false;
//        }
        if(i == word.length())return cur.isWord;
        char c = word.charAt(i);
        if(c != '.'){
            if(cur.next.get(c) == null)return false;
            return search(word, i + 1, cur.next.get(c));
        }
        else {
//            boolean flag = false;
            for (char nextChar: cur.next.keySet()){
//                flag = flag || search(word, i + 1, cur.next.get(nextChar));
                if (search(word, i + 1, cur.next.get(nextChar))){
                    return true;
                }
            }
            return false;
//            return flag;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}