import java.util.Observable;
/** 
 *  @author M.J
 */

public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields: 
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze; 

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);  
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);//s = 1;
        t = maze.xyTo1D(targetX, targetY);//t = end;
        distTo[s] = 0;//Distances to draw over the Maze
        edgeTo[s] = s;//Edges to draw on Maze             
    }

    /** Conducts a breadth first search of the maze starting at vertex x. */
    private void bfs(int s) {
        /* Your code here. */
        Queue<Integer> q = new Queue<Integer>();
        for (int v = 0; v < maze.V(); v++) distTo[v] = Integer.MAX_VALUE;
        distTo[s] = 0;
        marked[s] = true;
        
        q.enqueue(s);
        announce();

/*        if (v == t) {
            targetFound = true;
        }

        if (targetFound) {
            return;
        }*/

        while (!q.isEmpty()) {
            int v = q.dequeue();
            if (v == t) return;
            announce();
            for (int w : maze.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    announce();
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }        
    }


    @Override
    public void solve() {
        bfs(s);
    }
} 

