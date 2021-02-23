import java.util.Random;

/**
 * 跳表的实现
 *
 * @since 2021-02-23
 */
public class SkipList {
    // 索引最大层数
    private static final int MAX_LEVEL = 16;

    // 当前跳表的索引层数
    private int countLevel = 1;

    // 头节点，这是一个包含头节点的链表，头节点会存在每一层索引中，并且在最前面
    private Node head = new Node(MAX_LEVEL);

    /**
     * 插入一个新的值
     * 
     * @param value 要插入的值
     */
    public void insert(int value) {
        // 如果第一层头节点后继节点为空，表示链表为空
        int level = head.getNext()[0] == null ? 1 : randomLevel();
        // 如果生成的随机level大于跳表的当前索引层数，则层数变为当前索引层数+1
        if (level > countLevel) {
            level = ++countLevel;
        }

        Node newNode = new Node(level);
        newNode.setValue(value);

        Node p = head;
        for (int i = countLevel - 1; i >= 0; i--) {
            while (p.getNext()[i] != null && p.getNext()[i].getValue() < value) {
                p = p.getNext()[i];
            }
            if (level > i) {
                if (p.getNext()[i] == null) {
                    p.getNext()[i] = newNode;
                } else {
                    Node temp = p.getNext()[i];
                    p.getNext()[i] = newNode;
                    newNode.getNext()[i] = temp;
                }
            }
        }
    }

    /**
     * 根据值查找节点信息
     * 
     * @param value 需要查找的值
     * @return 查找的结果
     */
    public Node find(int value) {
        Node p = head;
        for (int i = countLevel - 1; i >= 0; i--) {
            while (p.getNext()[i] != null && p.getNext()[i].getValue() < value) {
                p = p.getNext()[i];
            }
        }
        if (p.getNext()[0] != null && p.getNext()[0].getValue() == value) {
            return p.getNext()[0];
        }
        return null;
    }

    /**
     * 从跳表中删除指定的值
     * 
     * @param value 要删除的值
     */
    public void delete(int value) {
        Node p = head;
        for (int i = countLevel - 1; i >= 0; i--) {
            while (p.getNext()[i] != null && p.getNext()[i].getValue() < value) {
                p = p.getNext()[i];
            }
            while (p.getNext()[i].getValue() == value) {
                p.getNext()[i] = p.getNext()[i].getNext()[i];
            }
        }
    }

    /**
     * 删除指定的元素
     * 
     * @param value 要删除的元素值
     */
    public void delete2(int value) {
        Node p = head;
        Node[] update = new Node[countLevel];
        for (int i = countLevel - 1; i >= 0; i--) {
            while (p.getNext()[i] != null && p.getNext()[i].getValue() < value) {
                p = p.getNext()[i];
            }
            update[i] = p;
        }
        if (update[0].getNext()[0] != null && update[0].getNext()[0].getValue() == value) {
            for (int i = 0; i < countLevel; i++) {
                while (update[i].getNext()[i] != null && update[i].getNext()[i].getValue() == value) {
                    update[i].getNext()[i] = update[i].getNext()[i].getNext()[i];
                }
            }
        }
    }

    public void printNode() {
        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            Node p = head;
            System.out.print(i + " : ");
            while (p.getNext()[i] != null) {
                p = p.getNext()[i];
                System.out.print(p.getValue() + "---");
            }
            System.out.println();
        }
    }

    // 理论来讲，一级索引中元素个数应该占原始数据的 50%，二级索引中元素个数占 25%，三级索引12.5% ，一直到最顶层。
    // 因为这里每一层的晋升概率是 50%。对于每一个新插入的节点，都需要调用 randomLevel 生成一个合理的层数。
    // 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
    // 50%的概率返回 1
    // 25%的概率返回 2
    // 12.5%的概率返回 3 ...
    private int randomLevel() {
        int level = 1;
        Random random = new Random();
        for (int i = 1; i < MAX_LEVEL; ++i) {
            if (random.nextInt() % 2 == 1) {
                level++;
            }
        }
        return level;
    }

    // 节点类
    class Node {
        // 当前节点的值
        private int value = -1;

        // 存放当前节点在第n层的后继节点，next[3] = a，表示当前节点在第三层的后继节点为a
        private Node[] next;

        public Node(int level) {
            next = new Node[level];
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node[] getNext() {
            return next;
        }

        public void setNext(Node[] next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        SkipList list = new SkipList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(6);
        list.insert(8);
        list.insert(7);
        list.printNode();
        list.delete(6);
        list.printNode();
    }
}
