//Creates Stack
class Stack {
	constructor() {
		this.elements = [];
	}
}

//Checks whether Stack is Empty or not
Stack.prototype.isEmpty = function () {
	if (this.elements.length == 0) {
		return true;
	}
	return false;
}

//Adds Element to Stack
Stack.prototype.pushElement = function (data) {
	this.elements.push(data);
}

//Removes Element from Stack
Stack.prototype.popElement = function () {
	if (this.isEmpty()) {
		return "Stack Underflow";
	}
	return this.elements.pop();
}

//Traverses Stack
Stack.prototype.display = function () {
	for (var i = 0; i < this.elements.length; i++) {
		console.log(this.elements[i]);
	}
}