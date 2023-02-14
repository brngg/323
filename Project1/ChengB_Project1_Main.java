import java.io.*;
import java.util.*;



class listNode{
    public String data;
    public listNode next;
    
    public listNode(String data) { //listNode constructor
        this.data = data;
        this.next = null;
    }

}

class LList{
	String deBugFile;
	private BufferedWriter output;
	
    listNode listHead = new listNode("dummy");
    listNode middleNode  = new listNode(null);

    public void constructLL(listNode listHead, String inFile, String deBugFile){
    	/*constructs linkedlist*/
        try {
			Scanner input = new Scanner(new FileReader(inFile));
			try {
				output = new BufferedWriter(new FileWriter(deBugFile));

                output.write("In constructLL method\n ");
                
				while(input.hasNext()){
                    String data = input.next();
                    listNode newNode = new listNode(data);
                    listInsert(listHead, newNode, deBugFile);
                    printList(listHead, deBugFile);
                }
				
				input.close();
				output.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    }
}

    public void listInsert(listNode listHead, listNode newNode, String deBugFile){
    	/*Method that inserts node in linkedlist*/
       try {
    	output = new BufferedWriter(new FileWriter(deBugFile, true));
        output.write("\nIn listInsert method\n");

        listNode Spot = findSpot(listHead, newNode);
        newNode.next = Spot.next;
        Spot.next = newNode;
        output.write("Returns from findSpot where Spot.data is " + Spot.data + "\n");
        output.close();
        } catch (IOException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
    public listNode findSpot(listNode listHead, listNode newNode){
    	/*Method to find a spot for a new node to be inserted in order using .compareTo*/
        while(listHead.next != null && newNode.data.compareToIgnoreCase(listHead.next.data)>0){
            listHead = listHead.next;
        }
        return listHead;
    }

    public void printList(listNode listHead, String outFile){
    	/*Method to print linkedlist gets head of list
    	 * then head.next and iterates until list is null*/
    	int count = 0;
    	
        try {
        	output = new BufferedWriter(new FileWriter(outFile, true));
            output.write("listHead ->");
            
            while(listHead != null){
                if (listHead.next != null) {
                    output.write("(" + listHead.data + ", " + listHead.next.data + ") -> ");
                } else {
                    output.write("null\n");
                }
                listHead = listHead.next;
                count++;
				if(count >= 5) {
					output.write("\n");
					output.write("\n");
					count = 0;
				}
            }
            output.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public listNode findMiddleNode(listNode listHead, String deBugFile) throws IOException{
         	output = new BufferedWriter(new FileWriter(deBugFile, true));
            output.write("In findMiddleNode method "); //debug
            	
            /*Setting up pointers, walker1 = slow walker2 = fast 
             * Reason why is because we are trying to find 
             * middle of LinkedList*/
            
                listNode walker1 = listHead.next; 
                listNode walker2 = listHead.next;
                while(walker2 != null && walker2.next !=null){
                    walker1 = walker1.next;
                    walker2 = walker2.next.next;
                    output.write("\n walker1's data is " + walker1.data + " ");
                    
                }
                output.write("\nThe middle node is " + walker1.data);     
                output.close();
                return walker1;
            
    }
}

public class ChengB_Project1_Main {
    public static void main(String[] args) throws IOException{
    	
        String inFile = new String(args[0]);
		String outFile = new String(args[1]);
        String deBugFile = new String(args[2]);
    	
        LList linkedList = new LList();
        listNode listHead = new listNode("dummy");
        
        linkedList.constructLL(listHead, inFile, deBugFile);  
        linkedList.printList(listHead, outFile);
        linkedList.findMiddleNode(listHead, deBugFile);
        
    }
}