class Queue {
    constructor() {
        this.array = [];
    }

    enqueue(value) {
        this.array.push(value);
    }

    dequeue() {
        this.array.shift();
    }

    printQueue() {
        for (var i = 0; i < this.array.length; i++) {
            console.log(this.array[i]);
        }
    }

    front() {
        console.log(this.array[0]);
    }

    rear() {
        console.log(this.array[this.array.length - 1]);
    }
}
var q = new Queue();