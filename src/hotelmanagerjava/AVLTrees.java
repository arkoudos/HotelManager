package hotelmanagerjava;

public class AVLTrees {
	
    private static class Node {
        Node left, right;
        Node parent;
        int value ;
        int height = 0;
        Hotel temp=new Hotel();
        
        //Node contains left,right and parent node,value will get the id of the hotel,and height is the height of the node.

        public Node(Hotel data, Node parent) {
            this.value = data.getId();
            this.parent = parent;
            temp=data;
        }


        void setLeftChild(Node child) {
            if (child != null) {
                child.parent = this;
            }

            this.left = child;
        }

        void setRightChild(Node child) {
            if (child != null) {
                child.parent = this;
            }

            this.right = child;
        }
    }

    private Node root = null;

    //calls the inster(node,hotel) to insert a new node in the avl tree
    
    public void insert(Hotel data) {
        insert(root, data);
    }

    //return the height of a node
    
    private int height(Node node) {
        return node == null ? -1 : node.height;
    }

    
    
    
    private void insert(Node node, Hotel value) {
        if (root == null) {
            root = new Node(value, null); //if root is empty it will place the node to the root
            return;
        }

        if (value.getId() < node.value) {
            if (node.left != null) {              //if the value of the new node is smaller than the parent  
            	insert(node.left, value);         //insert the node to the left if its empty
            } else {
                node.left = new Node(value, node);   //run the insert again with the left node as parent
            }

            if (height(node.left) - height(node.right) == 2) { //left heavier
                if (value.getId() < node.left.value) {
                    rotateRight(node);           //makes a right rotation 
                } else {
                    rotateLeftThenRight(node);   //first makes a left and then a right rotation
                }
            }
        } else if (value.getId() > node.value) {
            if (node.right != null) {
                insert(node.right, value); //if the node value is greater than the parent and the right node isn't empty run the insert algo with right node as parrent
            } else {
                node.right = new Node(value, node); //if the node value is greater than the parent and the right node is empty add the node to the right
            }

            if (height(node.right) - height(node.left) == 2) { //right heavier
                if (value.getId() > node.right.value)
                    rotateLeft(node); //makes a left rotation
                else {
                    rotateRightThenLeft(node); //makes a right and then left rotation
                }
            }
        }

        reHeight(node); //sets the new height of the node
    }

    private void rotateRight(Node pivot) {
        Node parent = pivot.parent;
        Node leftChild = pivot.left;
        Node rightChildOfLeftChild = leftChild.right;
        pivot.setLeftChild(rightChildOfLeftChild); 
        leftChild.setRightChild(pivot);   //the unbalanced node becomes the right child of its left child
        if (parent == null) {
            this.root = leftChild;    //if the node has not parent makes the left child a root
            leftChild.parent = null;
            return;
        }

        if (parent.left == pivot) {
            parent.setLeftChild(leftChild);		//if the left node of parent is the same as the unbalanced node set it to be the left child
        } else {
            parent.setRightChild(leftChild);    //set the left child on the right of the parent
        }

        reHeight(pivot);      //get the new height for unbalanced note
        reHeight(leftChild);   //get the new height for the left child
    }

    private void rotateLeft(Node pivot) {  //same as the right rotation but with left instructions
        Node parent = pivot.parent;
        Node rightChild = pivot.right;
        Node leftChildOfRightChild = rightChild.left;
        pivot.setRightChild(leftChildOfRightChild);
        rightChild.setLeftChild(pivot);
        if (parent == null) {
            this.root = rightChild;
            rightChild.parent = null;
            return;
        }

        if (parent.left == pivot) {
            parent.setLeftChild(rightChild);
        } else {
            parent.setRightChild(rightChild);
        }

        reHeight(pivot);
        reHeight(rightChild);
    }

    private void reHeight(Node node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1; //returns the max height of right or left node +1
    }

    private void rotateLeftThenRight(Node node) {
        rotateLeft(node.left);  //rotate the left node left
        rotateRight(node);      //and then right
    }

    private void rotateRightThenLeft(Node node) {
        rotateRight(node.right); //rotate the right node right
        rotateLeft(node);        //and then left
    }

   

    public Hotel search(int key) {
        return binarySearch(root, key).temp;  //gets the id you want to look for and makes a binary search on the tree
        
    }

    private Node binarySearch(Node node, int key) {
    	
        if (node == null) return null; //if node is null return null

        if (key == node.value) {
        	

            return node;   //if my id is my node return the node
            
        }

        if (key < node.value && node.left != null) {
            return binarySearch(node.left, key);  //if key<node value and left node isn't empty continue the search with the left subnode
        }

        if (key > node.value && node.right != null) {
            return binarySearch(node.right, key);  //if key>node value and right node isn't empty continue the search with the right subnode
        }
        return null; 
    }
}