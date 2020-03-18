/* This class represents node in the list */
Node = function(value) {
    this.value = value;
    this.next = null;
}

/* This class represents singly linked list and operations performed on it */
LinkedList = function() {
    this.head = null;

    //This function is used to insert node at end
    this.insertElementAtLast = function(element) {
        var node = new Node(element);
        if (this.head == null) {
            this.head = node;
        } else {
            var temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            current = temp;
            current.next = node;
            current = node;
        }
    }

    //This function is used to insert node at starting of the list
    this.insertElementAtStart = function(element) {
        var node = new Node(element);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    //This function is used to delete node at starting of the list
    this.deleteAtStart = function() {
        if (this.head == null) {
            console.log("List is empty");
        } else if (this.head.next == null) {
            this.head = null;
        } else {
            this.head = this.head.next;
        }
    }

    //This function is used to delete node at end of the list
    this.deleteAtEnd = function() {
        if (this.head == null) {
            console.log("List is empty");
        } else if (this.head.next == null) {
            this.head = null;
        } else {
            temp = this.head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    //This functionis used to display elements in list
    this.traverse = function() {
        if (this.head == null) {
            console.log("List is empty");
        } else {
            this.temp = this.head;
            while (this.temp != null) {
                console.log(this.temp.value);
                this.temp = this.temp.next;
            }
        }
    }
}

var singlyList = new LinkedList();