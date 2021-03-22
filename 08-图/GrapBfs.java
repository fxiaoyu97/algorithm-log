import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先搜索
 *
 * @since 2021-03-18
 */
public class GrapBfs {
    // 顶点的个数
    private int v;

    // 邻接表
    private LinkedList<Integer>[] adj;

    public GrapBfs(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
        visited = new boolean[v];
        pre = new Integer[v];
        for (int i = 0; i < v; i++) {
            pre[i] = -1;
        }
    }

    /**
     * 一条边的两个顶点，表示两个边相连
     *
     * @param s 顶点
     * @param t 顶点
     */
    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    public int getV() {
        return v;
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

    // 存放接下来需要查找其周边顶点的顶点
    Queue<Integer> queue = new LinkedList<>();

    // 记录顶点是否已经被访问过
    boolean[] visited;

    // 记录顶点的前一个顶点
    Integer[] pre;

    /**
     * 广度优先搜索
     * 
     * @param start 起始位置
     * @param end 结束位置
     */
    public void bfs(int start, int end) {
        if (start == end) {
            return;
        }
        queue.offer(start);
        Integer present;
        visited[start] = true;
        while (!queue.isEmpty()) {
            present = queue.poll();
            LinkedList<Integer> linkedList = adj[present];
            for (Integer nextVertex : linkedList) {
                if (visited[nextVertex]) {
                    continue;
                }
                visited[nextVertex] = true;
                pre[nextVertex] = present;
                if (nextVertex == end) {
                    print(pre, nextVertex);
                    System.out.println(end);
                    return;
                }
                queue.offer(nextVertex);
            }
        }
    }

    /**
     * 输出查找的路径
     * 
     * @param pre 记录顶点前一个顶点的数组
     * @param nextVertex 当前顶点的下一个顶点
     */
    private void print(Integer[] pre, Integer nextVertex) {
        if (pre[nextVertex] == -1) {
            return;
        }
        print(pre, pre[nextVertex]);
        System.out.print(pre[nextVertex]);
    }

    public static void main(String[] args) {
        GrapBfs grap = new GrapBfs(9);
        grap.addEdge(1, 2);
        grap.addEdge(1, 4);
        grap.addEdge(2, 3);
        grap.addEdge(2, 5);
        grap.addEdge(3, 6);
        grap.addEdge(4, 5);
        grap.addEdge(5, 6);
        grap.addEdge(5, 7);
        grap.addEdge(6, 8);
        grap.addEdge(7, 8);
        grap.bfs(1, 7);
    }
}
