package org.anand;

import java.util.*;

class Graph {
	int V;
	MyLinkedList[] lists;
	
	public Graph(int V) {
		this.V = V;
		this.lists = new MyLinkedList[V];
		
		for(int i=0;i<V;i++)
			lists[i] = new MyLinkedList();
	}
	
	void addEdge(int u, int v) {
		lists[u].add(v);
		lists[v].add(u);
	}
	
	void printGraph() {
		int i = 0;
		for(MyLinkedList l : lists) {
			System.out.print(i++ + " : ");
			for(Integer val : l)
				System.out.print(val + " ");
			System.out.println();
		}
	}
	
	boolean isCyclicUtil(int u, boolean[] visited, int parent) {
		visited[u] = true;
		
		for(Integer v : lists[u]) {
			if(!visited[v]) {
				if(isCyclicUtil(v,visited,u))
					return true;
			}
			
			else if(v != parent)	
				return true;
		}
		
		return false;
	}
	
	boolean isCyclic() {
		boolean[] visited = new boolean[V];
		
		for(int i=0;i<V;i++) {
			if(!visited[i]) {
				if(isCyclicUtil(i,visited,-1))
					return true;
			}
		}
		
		return false;
	}
}

class MyLinkedList extends LinkedList<Integer> {
}

class DetectCycleInAnUnDirectedGraph {
	public static void main(String[] args) {
		int V = 5;
		Graph g = new Graph(V);
		
		g.addEdge(0,1);
		g.addEdge(2,1);
		g.addEdge(2,0);
		g.addEdge(2,3);
		
		System.out.println("Graph:");
		g.printGraph();
		
		if(g.isCyclic())
			System.out.println("Cycle present.");
		else
			System.out.println("Cycle not present.");
	}
}