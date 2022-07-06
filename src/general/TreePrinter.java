package general;

import java.util.*;

/**
 * Write a java function, printTree(), which prints a given tree to stdout;
 * Details:
 * - The argument of printTree is a stream of Relations: Pair of "parents -> child" relationships.
 * - Each string found anywhere in the inputs represent a unique node.
 * - Each parent can have many children
 * - The input list may contain Relationship in any order, although:
 * - The order in which the pair appear in the input list determines the node' order with respect to the siblings.
 *
 * Example input:
 * List<Relation> input = new ArrayList<>();
 * input.add(new Relation("animal","mammal"));
 * input.add(new Relation("animal","bird"));
 * input.add(new Relation("lifeform","animal"));
 * input.add(new Relation("cat","lion"));
 * input.add(new Relation("mammal","cat"));
 * input.add(new Relation("animal","fish"));
 *
 * TreePrinter.printTree(input);
 *
 * Expected output:
 * 1: lifeform
 * 2.   animal
 * 3.     mammal
 * 4.       cat
 * 5.         lion
 * 6.     bird
 * 7.     fish
 */
public class TreePrinter {

    public static Map<String, List<String>> treeMap = new HashMap<>();
    public static Set<String> allChildren = new HashSet<>();

    public static void printTree(List<Relation> rs) {
        defineTree(rs);

        String root = findRoot();

        Set<String> seen = new HashSet<>();
        seen.add(root);

        for(String key : treeMap.keySet()) {
            if (!seen.contains(key)) {
                dfs(treeMap, 0, root, seen);
            }
        }

    }


    private static void dfs(Map<String, List<String>> treeMap, int level, String root, Set<String> seen) {
        if (root.equals("")) return;

        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(root);

        seen.add(root);

        List<String> childList = treeMap.get(root);

        if (childList == null) return;

        childList.forEach(child -> {
            if (!seen.contains(child)) {
                dfs(treeMap, level + 1, child, seen);
            }
        });
    }

    private static void dfs1(Map<String, List<String>> treeMap, int level, String root) {
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(root);

        if (!treeMap.containsKey(root)) return;

        List<String> childList = treeMap.get(root);

        childList.forEach(child -> dfs1(treeMap, level+1, child));
    }




    public static void defineTree(List<Relation> rs) {
        rs.forEach(relation -> {
            if (!treeMap.containsKey(relation.getParent())) {
                treeMap.put(relation.getParent(), new ArrayList<>());
            }
            List<String> childList = treeMap.get(relation.getParent());
            childList.add(relation.getChild());
            treeMap.put(relation.getParent(), childList);

            allChildren.addAll(childList);
        });

    }

    public static String findRoot() {
        for(String key : treeMap.keySet()) {
            if (!allChildren.contains(key)) {
                return key;
            }
        }
        return "";
    }




    static class Relation {
        private final String parent;
        private final String child;

        public Relation(String parent, String child) {
            this.parent = parent;
            this.child = child;
        }

        public String getParent() {
            return parent;
        }

        public String getChild() {
            return child;
        }


    }

    public static void main(String[] args) {
        List<Relation> input = new ArrayList<>();
        input.add(new Relation("animal", "mammal"));
        input.add(new Relation("animal", "bird"));
        input.add(new Relation("lifeform", "animal"));
        input.add(new Relation("cat", "lion"));
        input.add(new Relation("mammal", "cat"));
        input.add(new Relation("animal", "fish"));
        input.add(new Relation("cat", "cheater"));
        input.add(new Relation("fish", "tilapia"));

        printTree(input);
    }
}
