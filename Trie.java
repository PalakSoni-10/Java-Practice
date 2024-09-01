public class Trie {
    /*static class Node{
        Node[] children;
        boolean eow;

        public Node() {
            children = new Node[26];
            for(int i=0; i<26; i++) {
                children[i]=null;
            }
            eow=false;
        }
    }

    static Node root= new Node();

    public static void insert(String word) {
        for(int i=0; i<word.length(); i++){
            int idx=word.charAt(i)-'a';

            if(root.children[idx]==null) 
            root.children[idx]=new Node(); //add new node

            if(i==word.length()-1)
            root.children[idx].eow=true;

            root=root.children[idx];
        }
    }

    public static void main(String[] args) {
        String words[]={"the", "a", "there", "their", "any"};
        for(int i=0; i<words.length; i++) {
            insert(words[i]);

        }
        System.out.println(root);



    }*/

    
        static class Node {
            Node[] children = new Node[26];
            boolean eow;
     
     
            public Node() {
                for (int i=0; i<26; i++) {
                    children[i] = null;
                }
            }
        }
     
     
        public static Node root = new Node();
     
     
        public static void insert(String word) { //O(n)
            int level = 0;
            int len = word.length();
            int idx = 0;
     
     
            Node curr = root;
            for(; level<len; level++) {
                idx = word.charAt(level)-'a';
                if(curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                }
                curr = curr.children[idx];
            }
            curr.eow = true;
        }
     
     
        public static boolean search(String key) { //O(n)
            int level = 0;
            int len = key.length();
            int idx = 0;
     
     
            Node curr = root;
            for(; level<len; level++) {
                idx = key.charAt(level)-'a';
                if(curr.children[idx] == null) {
                    return false;
                }
                curr = curr.children[idx];
            }
            return curr.eow == true;
        }

        public static boolean wordBreak(String key) {
            int len = key.length();
            if(len == 0) {
                return true;
            }
     
            for(int i=1; i<=len; i++) {
                if( search(key.substring(0, i)) &&
                    wordBreak(key.substring(i)) ) {
                        return true;
                    }
            }
            return false;
        }
     

        public static boolean startsWith(String prefix) {
            Node curr = root;
            for(int i=0; i<prefix.length(); i++) {
                int idx = prefix.charAt(i)-'a';
                if(curr.children[idx] == null) {
                    return false;
                }
                curr = curr.children[idx];
            }
            return true;
        }

        public static int countNode(Node root) {
            if(root==null)
            return 0;

            int count = 0;
            for(int i=0; i<26; i++) {
                if(root.children[i]!=null) {
                    count+=countNode(root.children[i]);
                }
            }

            return count+1;

        }

        public static String ans = "";

        public static void longestWord(Node root, StringBuilder curr) {
            for(int i=0; i<26; i++) {
                if(root.children[i] != null && root.children[i].eow == true) {
                    curr.append((char)(i+'a'));
                    if(curr.length() > ans.length()) {
                        ans = curr.toString();
                    }
                    longestWord(root.children[i], curr);
                    curr.deleteCharAt(curr.length()-1);
                }
            }
        }
     
     
     
     
        public static void main(String args[]) {
            /*String words[] = {"the", "a", "there", "their", "any", "thee"};
            for (String word : words) {
                insert(word);
                System.out.println("inserted " + word);
            }
     
     
            System.out.println("thee -> " + search("thee"));
            System.out.println("thor -> " + search("thor"));
     
     
            System.out.println(startsWith("the"));
            System.out.println(startsWith("thi"));
            System.out.println(wordBreak("anythere"));*/

            //String str="apple"; //a, ap, app, appl, apple, p, pp, ppl, pple, pl, ple, l, le, e, " "
            /*String str="ababa";
            for(int i=0; i<str.length(); i++) {
                String suffix=str.substring(i);
                insert(suffix);
            }
            System.out.println(countNode(root));*/

            String words[]={"a", "banana", "app", "appl", "ap", "apply", "apple"};
            for(int i=0; i<words.length; i++)
            {
                insert(words[i]);
            }
            longestWord(root, new StringBuilder(""));
            System.out.println(ans);

        }
     }
     

