package concurrency;

public class NAryTreeLokUnlockConcurrency {

}

class Node {
    int data;
    boolean isLocked;
    Node parent;
    int lockedDescendants;

    public boolean isLocked() {
        return isLocked;
    }

    public boolean lock() {
        if ((!isLocked && lockedDescendants <= 0)
                || !isLockedAncestorExists()) {

            return true;
        }
        return false;
    }

    public void unlock() {
        if (isLocked) {
            isLocked = false;
        }
        decrementAncestors();
    }

    private boolean isLockedAncestorExists() {
        Node current = parent;
        while (current != null) {
            if (!current.isLocked) {
                return true;
            }
            current = current.parent;
        }
        return false;
    }

    private void decrementAncestors() {
        Node current = parent;
        while (current != null) {
            current.lockedDescendants--;
            current = current.parent;
        }
    }

    private void incrementAncestors() {
        Node current = parent;
        while (current != null) {
            current.lockedDescendants++;
            current = current.parent;
        }
    }
}