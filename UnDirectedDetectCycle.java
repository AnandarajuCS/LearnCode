package algo531;

import java.util.Iterator;
import java.util.LinkedList;

public class UnDirectedDetectCycle {
public static void main(String[] args) {
	Graph g1= new Graph(5);
	Graph g2 = new Graph(5);
//	g1.addEdge(0,1);
//	g1.addEdge(0,2);
//	g1.addEdge(0,3);
//	g1.addEdge(1,0);
//	g1.addEdge(1,2);
//	g1.addEdge(2,0);
//	g1.addEdge(2,1);
//	g1.addEdge(3,0);
//	g1.addEdge(3,4);
//	g1.addEdge(4,3);
	
	g1.addEdge(1, 0);
    g1.addEdge(0, 2);
    g1.addEdge(2, 0);
    g1.addEdge(0, 3);
    g1.addEdge(3, 4);
    
	
	g2.addEdge(0,1);
	g2.addEdge(2,1);
	g2.addEdge(2,0);
	g2.addEdge(2,3);
	System.out.println("Does the graph contain cycle : " + g1.checkCyclic());
}

}
class Graph
{
	int V;
	LinkedList<Integer>[] adjList;//Array of linkedList
	Graph(int v)
	{
		this.V=v;
		adjList=new LinkedList[v];
		for(int i = 0; i < v;i++){
			adjList[i]=new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int m, int n)
	{
		adjList[n].add(m);
		adjList[m].add(n);
	}
	
	public boolean checkCyclic()
	{
		boolean[] visited = new boolean[V];
		for(int i =0 ; i<V; i++)
		{
			visited[i]= false;
		}
		for(int i =0;i<V;i++)
		{
			if(!visited[i])
			{
				return cyclicUtil(i,visited,-1);
			}
		}
		return false;
	}
	
	public boolean cyclicUtil(int u, boolean[] visited, int parent)
	{
		visited[u]=true;
		
		Iterator<Integer> it = adjList[u].listIterator();
		while(it.hasNext())
		{
			int c = it.next();
			if(!visited[c])
			{
				cyclicUtil(c,visited,u);
			}
			else if (c != parent)
			{
				return true;
			}
		}
		return false;
	}
}