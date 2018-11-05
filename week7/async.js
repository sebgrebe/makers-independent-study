var later = function() {
  var stack = new Error("In `later`").stack;
  console.log(stack);
  return "ok I did it!"
}

var schedule = function() {
  var stack = new Error("In `schedule`").stack;
  console.log(stack);

  window.setTimeout(later, 2000); // call `later` 2 seconds
  return "scheduled!"
}

schedule()
