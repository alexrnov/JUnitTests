package garden;

public class Site {
    private Tree tree; //дерево
    private int place; //место для посадки в саду
    private int amountTree;

    public Site(Tree tree) {
        this.tree = tree;
    }

    public void plant(int place, int old) {
        tree.oak(old);
        amountTree = amountTree + tree.getAmountOak();
    }

    public int getAmountTree() {
        return amountTree;
    }

    public void setAmountTree(int amountTree) {
        this.amountTree = amountTree;
    }
}
