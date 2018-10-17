function renderMachine() {
  var state = true;

  function toggle() {
    state = (state) ? false : true
  }

  function render() {
    if (state) {
      return "being"
    } else {
      return "nothingness"
    }
  }

  return {
    toggle: toggle,
    render: render
  }
}

var renderMachine = renderMachine()
console.log(renderMachine.render())
renderMachine.toggle()
console.log(renderMachine.render())
