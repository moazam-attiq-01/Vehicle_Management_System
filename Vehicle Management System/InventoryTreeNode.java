public class InventoryTreeNode {
    private Vehicle vehicle;
    private int quantity;
    private InventoryTreeNode left;
    private InventoryTreeNode right;

    public InventoryTreeNode(Vehicle vehicle, int quantity) {
        this.vehicle = vehicle;
        this.quantity = quantity;
        this.left = null;
        this.right = null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public InventoryTreeNode getLeft() {
        return left;
    }

    public void setLeft(InventoryTreeNode left) {
        this.left = left;
    }

    public InventoryTreeNode getRight() {
        return right;
    }

    public void setRight(InventoryTreeNode right) {
        this.right = right;
    }

    public void addChild(InventoryTreeNode node) {
        if (left == null) {
            left = node;
        } else if (right == null) {
            right = node;
        } else {
            // Handle the case where both left and right are non-null
            throw new IllegalStateException("Cannot add a third child to a binary tree node.");
        }
    }
}