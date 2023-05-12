import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int [][][] visited;
    static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
    
    public static int solution(int[][] board) {
        visited = new int[board.length][board.length][4];

        return bfs(board);
    }
    
    public static int bfs(int[][] board) {
        Queue<Node> q = new LinkedList<>();
        int x = 0;
        int y = 0;
        int dir = -1;
        int cost = 0;
        int min = Integer.MAX_VALUE;
        
        q.add(new Node(y, x, dir, cost));

        while(!q.isEmpty()) {
            Node crt = q.poll();

            if(crt.x == board.length - 1 && crt.y == board.length - 1) {
                min = Math.min(min, crt.cost);
            }

            for(int i = 0; i < 4; i++) {
            	int nextX = crt.x + dx[i];
                int nextY = crt.y + dy[i];

                if(nextY < 0 || nextX < 0 || nextY >= board.length || nextX >= board.length || board[nextY][nextX] == 1) {
                    continue;
                }

                int nextCost = crt.cost;
                if(crt.dir == -1 || crt.dir == i) { 
                    nextCost += 100;
                }
                else {
                    nextCost += 600;
                }

                if(visited[nextY][nextX][i] == 0 || board[nextY][nextX] >= nextCost) {
                    q.add(new Node(nextY, nextX, i, nextCost));
                    visited[nextY][nextX][i] = 1;
                    board[nextY][nextX] = nextCost;
                }
            }
        }
        return min;
    }
}

class Node {
    int x;
    int y; 
    int dir;
    int cost;

    public Node(int y, int x, int dir, int cost) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cost = cost;
    }
}