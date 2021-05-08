//Creates Node
function Node(data) {
    this.data = data;
    this.next = null;
}

//Creates Linked List
function LinkedList() {
    this.head = null;

    //Checks whether List is Empty or not
    this.isEmpty = function () {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    //Adds new Node in List
    this.add = function (data) {
        var node = new Node(data);
        var current;
        if (this.head == null)
            this.head = node;
        else {
            current = this.head;
            while (current.next) {
                current = current.next;
            }
            current.next = node;
        }
    }

    //Deletes Node from List
    this.remove = function (data) {
        if (!this.isEmpty()) {
            var current = this.head;
            var previousElement = null;
            while (current != null) {
                if (current.data === data) {
                    if (previousElement == null) {
                        this.head = current.next;
                    } else {
                        previousElement.next = current.next;
                    }
                    return current.element;
                }
                previousElement = current;
                current = current.next;
            }
        }
        return -1;
    }

    //Traverses List
    this.display = function () {
        if (!this.isEmpty()) {
            var currentNode = this.head;
            var output = "";
            while (currentNode != null) {
                output += currentNode.data + "\n";
                currentNode = currentNode.next;
            }
            console.log(output);
        } else {
            console.log("List is empty");
        }
    }
}