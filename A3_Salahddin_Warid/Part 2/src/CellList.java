/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #3
Due Date: 22 August 2021
*/

import java.util.NoSuchElementException;

/**
 * CellList class represents a list of CellPhones objects stored inside, using CellNodes.
 *
 */
public class CellList implements Cloneable {
    // Creating attributes of CellList Object.
    private CellNode head;
    private int size;

    /**
     * Default Constructor for CellList.
     * All attributes are set to null.
     *
     */
    public CellList() {
        head = null; size = 0;
    }

    /**
     * Copy constructor for CellList object from another existing CellList object.
     *
     * @param otherList CellList object to be copied.
     */
    public CellList(CellList otherList){
        if (otherList == null) throw new NullPointerException("Empty list passed in.");
        if (otherList.head == null) head = null;
        else {
            head = copyOf(otherList.head);
            size = otherList.size;
        }
    }

    /**
     * Function clones an existing CellList object to a new CellList object.
     *
     * @return CellList
     */
    public CellList clone(){
        try{
            CellList copy = (CellList) super.clone();
            if (head == null) copy.head =null;
            else copy.head = copyOf(head);
            return copy;
        }catch(CloneNotSupportedException ignored){return null;}
    }

    /**
     * Function copies an existing CellNode object into a new CellNode object.
     *
     * @param otherHead CellNode object to be copied.
     * @return CellNode
     */
    private CellNode copyOf(CellNode otherHead){
        CellNode newHead;

        if (otherHead == null ||otherHead.data == null) {
            return newHead = new CellNode();
        }
        assert false;
        newHead = new CellNode(otherHead.data.clone(otherHead.data.getSerialNum()),null);
        CellNode position = newHead;
        CellNode other_position = otherHead.next;

        while(other_position != null){
            position.next = new CellNode(other_position.data.clone(other_position.data.getSerialNum()),null);
            position = position.next;
            other_position = other_position.next;
        }

        return newHead;
    }

    /**
     * Function adds a CellPhone object passed by argument to the head of the list.
     * Used by creating a node.
     *
     * @param data
     */
    public void addToStart(CellPhone data){
        if (data == null) throw new NullPointerException("Data is empty.");
        head = new CellNode(data, head);
        ++size;
    }

    /**
     * Function adds a CellPhone object passed by argument to a specified index in the list.
     * Used by creating a node.
     *
     * @param data CellPhone object to be added to list.
     * @param index Int representing the index in the list where @data is added.
     */
    public void insertAtIndex(CellPhone data, int index){
        // Verifying for all special cases using if/if-else statements.
        if (data == null) throw new NullPointerException("Data is empty.");
        if (index == 0) addToStart(data);
        else if (index > size || index < 0) throw new NoSuchElementException("Index given is out of bound.");
        else{
            int count =0; CellNode position = head;
            while (count < index-1){
                position = position.next;
                count++;
            }
            CellNode newNode = new CellNode(data,position.next);
            position.next = newNode;
            ++size;
        }
    }

    /**
     * Function deletes first node in the list.
     * First CellPhone object in the list is therefore deleted.
     *
     */
    public void deleteFromStart(){
        if (head != null){
            head = head.next;
            --size;
        }
    }

    /**
     * Function deletes a CellPhone object passed by argument when deleting a node.
     * Node deleted at index passed by argument.
     *
     * @param index Int representing the index in the list where node is deleted.
     */
    public void deleteFromIndex(int index){
        // Verifying for all special cases using if/if-else statements.
        if (index == 0) deleteFromStart();
        else if (index > size-1 || index < 0) throw new NoSuchElementException("Index given is out of bound.");
        else{
            int count =0; CellNode position = head;
            while (count < index-1){
                position = position.next;
                count++;
            }
            if (index == size-1){
                position.next = null;
            }
            else {
                position.next = position.next.next;
            }
            --size;
        }
    }

    /**
     * Function replaces a CellPhone object in the list by a CellPhone object passed by argument.
     * The object to be replaced (indexed position in the list) is passed passed by argument.
     *
     * @param data CellPhone object to be replaced inside the list.
     * @param index Int representing the index in the list where @data is replaced.
     */
    public void replaceAtIndex(CellPhone data,int index){
        // Verifying for all special cases using if/if-else statements.
        if (data == null) throw new NullPointerException("Data is empty.");
        if (index == 0) head.data =data;
        else if (index > size-1 || index < 0) throw new NoSuchElementException("Index given is out of bound.");
        else{
            int count =0; CellNode position = head;
            while (count < index){
                position = position.next;
                count++;
            }
            position.data = data;
        }
    }

    /**
     * Functions verifies if a Serial number passed by argument is inside the list.
     * If the Serial number belongs in the list, a pointer to the node of that CellPhone object is returned.
     * A count of the iterations before returning is given.
     *
     * @param serialNum Long type representing the Serial number to search inside the list.
     * @return
     */
    public CellNode find(long serialNum){
        CellNode position = head; int iter=0;

        while(position != null){
            if (position.data.getSerialNum()==serialNum){
                ++iter;
                System.out.println(position.data);
                System.out.println("It took "+iter+" iterations to find the element on the list.");
                return new CellNode(position);
            }
            ++iter;
            position = position.next;
        }

        System.out.println("The element was not found after "+iter+" iterations.");
        return null;
    }

    /**
     * Functions verifies if a Serial number passed by argument is inside the list.
     * Returns True or False.
     *
     * @param serialNum Long type representing the Serial number to search inside the list.
     * @return Boolean value.
     */
    public boolean contains(long serialNum){
        return find(serialNum) != null;
    }

    /**
     * Shows all the content inside the list.
     *
     */
    public void showContents(){
        CellNode position = head; int count=0;

        while(position != null){
            ++count;
            System.out.print(position.data+" ---> ");
            if (count % 3 ==0) System.out.println();
            position = position.next;
        }
        System.out.print("X");
    }

    /**
     * Function compares CellList object to another object to verify if the content is equal.
     *
     * @param otherObject Object to be compared to.
     * @return Boolean value.
     */
    @Override
    public boolean equals(Object otherObject){
        if (otherObject == null) return false;
        else if (getClass() != otherObject.getClass()) return false;
        else
        {
            CellList otherList = (CellList) otherObject;
            if (size != otherList.size) return false;
            CellNode position = head;
            CellNode other_position = otherList.head;
            while(position!=null){
                if (!(position.data).equals(other_position.data)) return false;
                position = position.next;
                other_position = other_position.next;
            }
            return true;
        }
    }

    /**
     * Function returns the Size attribute of CellList object.
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Inner class of CellList.
     * Used to create nodes storing CellPhone objects.
     *
     */
    private class CellNode implements Cloneable{
        //They don't need mutator and accessor, since they can already be accessed by the outer class.
        //This adds privacy.
        private CellPhone data; private CellNode next;

        /**
         * Default Constructor for CellNode.
         * All attributes are set to null.
         *
         */
        public CellNode() {data = null; next = null;}

        /**
         * Parametrized constructor for CellNode object.
         * Attributes are passed by argument.
         *
         * @param data CellPhone object
         * @param next CellNode type
         */
        public CellNode(CellPhone data, CellNode next) {
            this.data = data;
            this.next = next;
        }

        /**
         * Copy constructor for CellNode object from another existing CellNode object.
         *
         * @param otherNode
         */
        public CellNode(CellNode otherNode){
            if (otherNode == null) throw new IllegalArgumentException("Empty Node passed in.");
            this.data = otherNode.data;
            this.next = otherNode.next;
        }

        /**
         * Function clones an existing CellNde object to a new CellNode object.
         *
         * @return CellNode
         */
        @Override
        public CellNode clone(){
            try{
                return (CellNode) super.clone();
            }catch(CloneNotSupportedException ignored){return null;}
        }

    }

}
