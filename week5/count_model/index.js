function CountModel() {
  this._count = 0;
};

CountModel.prototype.count = function() {
  return this._count;
};

CountModel.prototype.set = function(count) {
  this._count = count;
};

var countModel = new CountModel();
countModel.set(5);
console.log("count is", countModel.count());
// Bonus research project. Can you find the property name below that
// makes the statement print out `true`?
console.log(countModel["__proto__"] === CountModel.prototype);
