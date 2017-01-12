import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * This is the class containing the main method to determine
 * the Minimum Spanning tree of the given graph.
 * @author Anandaraju CS
 *
 */
public class MinimumSpanningTree{

	public static String inputFile = "";
	public static String outputFile = "";
	public static TreeNode[] nodes;
	public static BufferedWriter outputFileWriter = null;

	public static void main(String[] args) {
		inputFile = "input.txt";
		outputFile = "output.txt";

		File file = new File(outputFile);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			outputFileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), Charset.forName( "UTF-8" )));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			readInputFile();
			determineMST();
			outputFileWriter.flush();
			outputFileWriter.close();
		} catch (IOException e) {
			try{
				outputFileWriter.flush();
				outputFileWriter.close();
			}catch(Exception e1)
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	/**
	 * readInputFile method is used to read the vertices and weights from the input file.
	 * @throws IOException
	 */
	public static void readInputFile() throws IOException
	{
		Scanner scanner = new Scanner(new File(inputFile));
		int vertices = scanner.nextInt();
		int edges = scanner.nextInt();
		nodes = new TreeNode[vertices];
		for(int e = 0 ; e < edges;e++)
		{
			int uNode = scanner.nextInt(); //vertex of the TreeNode
			int vNode = scanner.nextInt();
			int uIndex = uNode-1;
			int vIndex = vNode-1;
			TreeNode uTreeNode = nodes[uIndex];
			TreeNode vTreeNode = nodes[vIndex];
			if(uTreeNode == null)
			{
				nodes[uIndex] = new TreeNode(uNode);
				uTreeNode = nodes[uIndex];
			}
			if(vTreeNode == null)
			{
				nodes[vIndex]= new TreeNode(vNode);
				vTreeNode = nodes[vIndex];
			}
			int dist = scanner.nextInt();			
			uTreeNode.addChild(vTreeNode, dist);
			vTreeNode.addChild(uTreeNode, dist);
		}
		scanner.close();
	}

	/**
	 * This method will use the created Heap DataStructure to find 
	 * the Minimum Spanning Tree of the given graph and also prints
	 * the output to the file
	 * @throws IOException
	 */
	public static void determineMST() throws IOException
	{
		MyHeapDS minHeap = new MyHeapDS(nodes.length);
		List<TreeNode> inMST = new ArrayList<TreeNode>();
		List<TreeNode> visited = new ArrayList<TreeNode>();
		Map<Integer,Integer> parentMap = new HashMap<Integer,Integer>();

		TreeNode startNode = nodes[0];
		minHeap.insert(startNode);
		visited.add(startNode);
		int mst = 0;
		while(inMST.size() < nodes.length)
		{
			TreeNode uNode = minHeap.extractMinimum();
			if(inMST.contains(uNode))
			{
				continue;
			}
			inMST.add(uNode);
			mst+=uNode.keyValue;
			for(TreeNode child : uNode.myChildren.keySet())
			{
				if(inMST.contains(child))
				{
					continue;
				}
				if(visited.contains(child))
				{
					if(child.keyValue > uNode.myChildren.get(child))
					{	
						// update the keyValue of the corresponding Node.
						minHeap.decreaseKey(child,uNode.myChildren.get(child));
						parentMap.put(child.vertex,uNode.vertex);
					}
				}else
				{
					visited.add(child);
					child.keyValue=uNode.myChildren.get(child);
					minHeap.insert(child);
					parentMap.put(child.vertex,uNode.vertex);
				}
			}
		}
		printOutput(mst,parentMap);
	}

	/**
	 * Prints the Minimum Spanning tree distance and the corresponding edges.
	 * @param mst
	 * @param parentMap
	 * @throws IOException
	 */
	public static void printOutput(int mst, Map<Integer,Integer> parentMap) throws IOException
	{
		outputFileWriter.write(String.valueOf(mst));
		outputFileWriter.newLine();
		for(int i : parentMap.keySet())
		{	
			outputFileWriter.write(String.valueOf(i));
			outputFileWriter.write(" ");
			outputFileWriter.write(String.valueOf(parentMap.get(i)));
			outputFileWriter.newLine();
		}
	}
}

/**
 * The Heap DataStructure used to store the TreeNode Objects.
 * @author Anandaraju CS
 *
 */
class MyHeapDS {

	/**
	 * Array of the TreeNode Objects.
	 */
	public TreeNode[] heapData;
	public int arrayCapacity;
	int heapSize;
	/**
	 * Stores the position of each Heap element
	 */
	HashMap<Integer,Integer> positionMap = new HashMap<Integer,Integer>();

	public MyHeapDS(int capacity)
	{
		heapSize = 0;
		arrayCapacity = capacity;
		heapData = new TreeNode[capacity];
	}

	public HashMap<Integer,Integer> getPositionMap()
	{
		return this.positionMap;
	}
	/**
	 * Used to reduce the KeyValue of the corresponding Node.
	 * @param child
	 * @param toValue
	 */
	public void decreaseKey(TreeNode child, Integer toValue) 
	{
		child.keyValue = toValue;
		heapifyUp(positionMap.get(child.vertex));
	}

	/**
	 * Inserts new Nodes to the Heap array.
	 * @param node
	 */
	public void insert(TreeNode node)
	{
		if(heapSize >= arrayCapacity)
		{
			TreeNode[] tempArray = Arrays.copyOf(heapData, 2*arrayCapacity);
			heapData=tempArray;
		}
		positionMap.put(node.vertex, heapSize);
		heapData[heapSize++]=node;
		heapifyUp(heapSize-1);
	}

	public void heapifyUp(int pos)
	{
		if(pos <= 0)
		{
			return;
		}
		TreeNode child = heapData[pos];
		int parentPos = (pos-1)/2;
		if(heapData[parentPos].keyValue > child.keyValue)
		{
			swapNodes(pos,parentPos);
			heapifyUp(parentPos);
		}else
		{
			return;
		}
	}

	/**
	 * Removes and Retrieves the root element in the Heap.
	 * @return
	 */
	public TreeNode extractMinimum()
	{
		TreeNode minNode = heapData[0];
		positionMap.put(heapData[heapSize-1].vertex, 0);
		heapData[0]=heapData[heapSize-1];
		heapData[heapSize-1]=null;
		heapSize--;
		heapifyDown(0);
		return minNode;
	}

	public void heapifyDown(int pos)
	{
		int child1Pos = 2*pos+1;
		int child2Pos = 2*pos+2;
		int correctChild = 0;
		if(child1Pos <= heapSize-1)
		{
			if(child1Pos == heapSize-1 || heapData[child1Pos].keyValue < heapData[child2Pos].keyValue)
			{
				correctChild=child1Pos;
			}else
			{
				correctChild=child2Pos;	
			}
			if(heapData[correctChild].keyValue < heapData[pos].keyValue)
			{
				swapNodes(correctChild,pos);
				heapifyDown(correctChild);
			}
		}
	}
	public void swapNodes(int pos1, int pos2)
	{
		positionMap.put(heapData[pos1].vertex,pos2);
		positionMap.put(heapData[pos2].vertex,pos1);
		TreeNode temp = heapData[pos1];
		heapData[pos1] = heapData[pos2];
		heapData[pos2] = temp;
	}

	/**
	 * Utility method to display all the elements in the Heap data array.
	 */
	public String toString()
	{
		String output = "[";
		for(TreeNode tn:heapData)
		{
			if(tn != null)
				output+=tn.vertex+":"+tn.keyValue+":"+positionMap.get(tn.vertex)+" ,";
		}
		output+="]";
		return output;
	}
}

/**
 * TreeNode Object is the base object in the Graph, representing the vertex.
 * Each TreeNode object contains the KeyValue, vertex, its children and its position in the heap data structure
 * @author Anandaraju CS
 *
 */
class TreeNode
{
	/*
	 * Used to store the distance from parent for prim's algorithm
	 */
	int keyValue = 0; 
	int vertex;
	Map<TreeNode,Integer> myChildren = new HashMap<TreeNode,Integer>(); 

	TreeNode(int vertex)
	{
		this.vertex = vertex;
	}

	public void addChild(TreeNode tn , int dis)
	{
		myChildren.put(tn, dis);
	}
	public void toStrings()
	{
		System.out.print("Tree Node ==>  ");
		for(TreeNode tn : myChildren.keySet())
		{
			System.out.print( vertex + " - "+tn.vertex +" - " + myChildren.get(tn) + "\n");
		}
	}
}
