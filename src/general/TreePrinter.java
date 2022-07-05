package general;

import java.util.List;

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


    public static void printTree(List<Relation> rs) {
        StringBuilder sb = new StringBuilder();

        rs.forEach(relation -> {

        });

    }




    /**
     * animal -> mammal -> bird -> fish
     * lifeform -> animal
     * cat -> lion
     * mammal -> cat
     */
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
}
