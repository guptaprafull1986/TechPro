import java.util.*

fun main(args: Array<String>) {
    val tree = Node(1)

    tree.left = Node(2)
    tree.right = Node(3)

    tree.left!!.left = Node(4)
    tree.left!!.right = Node(5)
    tree.right!!.left = Node(6)
    tree.right!!.right = Node(7)

    tree.left!!.left!!.left = Node(8)
    tree.left!!.left!!.right = Node(9)
    tree.left!!.right!!.left = Node(10)
    tree.left!!.right!!.right = Node(11)

    tree.right!!.left!!.left = Node(12)
    tree.right!!.left!!.right = Node(13)
    tree.right!!.right!!.left = Node(14)
    tree.right!!.right!!.right = Node(15)

    inorderTraversal(tree)
    zigzagTraversal(tree)
}

fun zigzagTraversal(root: Node) {
    if (root == null) return

    var count = 0
    val queue: Queue<Node> = LinkedList()
    queue.add(root)
    var level = 1
    while (!queue.isEmpty()) {
        val stack: Stack<Node> = Stack()
        while (!queue.isEmpty()) {
            count ++
            val node = queue.poll()

            print(" ${node.value} ")
            if ((level and 1) == 1) {
                if (node.left != null) {
                    stack.add(node.left)
                }
                if (node.right != null) {
                    stack.add(node.right)
                }
            } else {
                if (node.right != null) {
                    stack.add(node.right)
                }
                if (node.left != null) {
                    stack.add(node.left)
                }
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop())
            count++
        }

        println("")
        level++
    }
    println("count is $count")
}

fun inorderTraversal(root: Node) {
    if (root == null) return

    val queue: Queue<Node> = LinkedList()
    queue.add(root)

    while (!queue.isEmpty()) {
        val node = queue.poll()
        print(" ${node!!.value} ")
        if (node.left != null)
            queue.add(node.left)

        if (node.right != null)
            queue.add(node.right)
    }
    println()
}


class Node(val value: Int) {
    var left: Node? = null
    var right: Node? = null
}