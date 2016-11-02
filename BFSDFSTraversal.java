package algo531;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSDFSTraversal {
public static void main(String[] args) {
	 Graph1 g = new Graph1(7);
	 
//     g.addEdge(0, 1);
//     g.addEdge(0, 2);
//     g.addEdge(1, 2);
//     g.addEdge(2, 0);
//     g.addEdge(2, 3);
//     g.addEdge(3, 3);
	 
	 g.addEdge(0, 1);
     g.addEdge(0, 2);
     g.addEdge(1, 3);
     g.addEdge(1, 4);
     g.addEdge(2, 5);
     g.addEdge(2, 6);

     System.out.println("Following is Breadth First Traversal "+
                        "(starting from vertex 2)");

    // g.BFS(2);
     System.out.println("===========================");
     g.DFS(0);
	
}
}
class Graph1
{
	int V;
	LinkedList<Integer>[] adjList;
	Graph1(int v)
	{
		V=v;
		adjList= new LinkedList[v];
		for(int i = 0 ; i < V ;i++)
		{
			adjList[i] = new LinkedList<Integer>();
		}
	}
	public void addEdge(int n , int m )
	{
		adjList[n].add(m);
		//adjList[m].add(n);
	}
	
	public void DFS(int s)
	{
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[V];
		for(int i =0 ; i< V ; i++)
		{
			visited[i]=false;
		}
		
		Iterator<Integer>[] adjIts= (Iterator<Integer>[]) new Iterator[V];
		for(int i =0 ; i<V;i++)
		{
			adjIts[i]=adjList[i].listIterator();
		}
		
		visited[s]=true;
		stack.push(s);
		while(!stack.isEmpty())
		{
			int c = stack.peek();
			
			if(adjIts[c].hasNext())
			{
				int n = adjIts[c].next();
				if(!visited[n])
				{
					visited[n]=true;
					stack.push(n);
				}
				
			}else
			{
				System.out.print(stack.peek() + " ");
				stack.pop();
			}
		}
	}
	
	public void BFS(int s)
	{
		boolean[] visited = new boolean[V];
		for(int i = 0 ; i <V;i++)
		{
			visited[i]= false;
		}
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		
		while(queue.size() != 0)
		{
			int c = queue.poll();
			System.out.print(c + " ");
			Iterator<Integer> it = adjList[c].listIterator();
			while(it.hasNext())
			{
				int n = it.next();
				if(!visited[n])
				{
					visited[n]=true;
					queue.add(n);
				}
			}
		}
	}
}
