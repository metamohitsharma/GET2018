//Creates Queue
class Queue {
	constructor() {
		this.elements = [];
	}
}

//Checks whether Queue is Empty or not
Queue.prototype.isEmpty = function () {
	if (this.elements.length == 0) {
		return true;
	}
	return false;
}

//Adds Element to Queue
Queue.prototype.enqueue = function (data) {
	this.elements.push(data);
}
//Deletes Element from Queue
Queue.prototype.dequeue = function () {
	if (this.isEmpty()) {
		return "Queue Underflow";
	}
	return this.elements.shift();
}

//Traverses Queue
Queue.prototype.display = function () {
	for (var i = 0; i < this.elements.length; i++) {
		console.log(this.elements[i]);
	}
}