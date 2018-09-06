#dependencies
require 'colorize'

#overriding include method
module OwnMethods
  def include(value)
    Include.new(value)
  end
end

singleton_class.prepend(OwnMethods)

class Expect
  def initialize(arg1)
    @arg = arg1
  end

  def to(comp)
    if comp.name == "equal"
      equal(comp.arg)
    elsif comp.name == "include"
      include(comp.elem)
    elsif comp.name == "respond_to"
      respond_to(comp.method)
    elsif comp.name == "be_a"
      be_a(comp.obj)
    end
  end

  private

  def be_a(obj)
    if @arg.is_a?(obj)
      print_pass
    else
      print_fail
    end
  end

  def equal(arg2)
    if @arg == arg2
      print_pass
    else
      print_fail
    end
  end

  def include(elem)
    if @arg.include?(elem)
      print_pass
    else
      print_fail
    end
  end

  def print_pass
    puts "Test passes :)".green
  end

  def print_fail
    puts "Test fails: D:".red
  end

  def respond_to(method)
    if @arg.respond_to?(method)
      print_pass
    else
      print_fail
    end
  end

end

#comparison classes
class Equal
  attr_reader :arg, :name
  def initialize(arg)
    @arg = arg
    @name = "equal"
  end
end

class Include
  attr_reader :elem, :name
  def initialize(elem)
    @elem = elem
    @name = "include"
  end
end

class RespondTo
  attr_reader :method, :name
  def initialize(method)
    @method = method
    @name = "respond_to"
  end
end

class BeA
  attr_reader :obj, :name
  def initialize(obj)
    @obj = obj
    @name = "be_a"
  end
end

#methods in rspec syntax
def expect(value)
  Expect.new(value)
end

def eq(value)
  Equal.new(value)
end

def respond_to(value)
  RespondTo.new(value)
end

def be_a(value)
  BeA.new(value)
end

#extension: it blocks
def it(description)
  puts description
  yield
end

it 'returns whether object is a class' do
  expect(BeA).to be_a Class
end
