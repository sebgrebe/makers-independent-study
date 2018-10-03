function Pen() {
  this.sheeps = [];
}

Pen.prototype.take_in = function(sheep) {
  this.sheeps.push(sheep);
}

Pen.prototype.names = function() {
  this.sheeps.forEach(function(sheep) {
    console.log(sheep.say_name());
  });
}

function Sheep(name) {
  this._name = name;
}

Sheep.prototype.say_name = function() {
  return this._name
}

pen = new Pen()
sheep1 = new Sheep("Karl")
sheep2 = new Sheep("Heinz")
sheep3 = new Sheep("Klaus")
sheep4 = new Sheep("Waldemar")
pen.take_in(sheep1)
pen.take_in(sheep2)
pen.names()
