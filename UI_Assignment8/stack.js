class Stack {

    constructor() {
        this.array = [];
    }

    push(value) {
        this.array.push(value);
    }

    pop() {
        if (!this.isEmpty()) {
            console.log("stack is empty");
        } else {
            console.log(this.array.pop());
        }
    }

    peep() {
        console.log(this.array[this.array.length - 1]);
    }

    isEmpty() {
        if (this.array.length == 0)
            return false;
        else
            return true;
    }
}

var s = new Stack();