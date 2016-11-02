package algo531;

import java.util.Iterator;
import java.util.LinkedList;
enum State
{
	UNPROCESSED,PROCESSING,PROCESSED;
}
public class DirectedDetectCycle {

	public static void main(String[] args) {

		//		Graph2 g = new Graph2(7);
		//		g.addEdge(0, 1);
		//	    g.addEdge(0, 2);
		//	    g.addEdge(2, 1);
		//	    //g.addEdge(2, 0);
		//	    g.addEdge(2, 3);
		//	    g.addEdge(1, 3);
		//	    g.addEdge(3, 4);
		//	    g.addEdge(3, 5);
		//	    g.addEdge(4, 1);
		//	    g.addEdge(4, 6);
		//	    g.addEdge(5, 4);
		//	    g.addEdge(6, 1);

		Graph2 graph = new Graph2(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);

		//This back edge introdues a Cycle
		//graph.addEdge(2, 0);
		graph.addEdge(2, 3);

		//This self loop introduces a Cycle
		graph.addEdge(3, 3);

		System.out.println(graph.checkCyclic());
	}
}
class Graph2
{
	int V;
	LinkedList<Integer>[] adjList;//Array of linkedList
	Graph2(int v)
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
		//adjList[m].add(n);
	}

	public boolean checkCyclic()
	{
		State[] state = new State[V];
		for(int i =0 ; i<V; i++)
		{
			state[i]= State.UNPROCESSED;
		}
		for(int i =0;i<V;i++)
		{
			if(state[i] == State.UNPROCESSED)
			{
				return cyclicUtil(i,state);
			}
		}
		return false;
	}

	public boolean cyclicUtil(int u, State[] state)
	{
		state[u]=State.PROCESSING;

		Iterator<Integer> it = adjList[u].listIterator();
		while(it.hasNext())
		{
			int c = it.next();
			if(state[c]== State.PROCESSING)
			{
				printState(state);
				return true;
			}
			if (state[c] ==State.UNPROCESSED && cyclicUtil(c,state))
			{
				return true;
			}
		}
		state[u]=State.PROCESSED;
		return false;
	}

	public void printState(State[] state)
	{
		for(int i =0;i < state.length ; i++)
		{
			System.out.println(i + " ::: " + state[i]);
		}
	}
}