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
    if comp.compare(@arg)
      print_pass
    else
      print_fail
    end
  end

  private

  def print_pass
    puts "Test passes :)".green
  end

  def print_fail
    puts "Test fails: D:".red
  end

end

#comparison classes
class Equal
  def initialize(arg2)
    @arg2 = arg2
  end
  def compare(arg)
    puts 'calling Equal '
    arg == @arg2
  end
end

class Include
  def initialize(elem)
    @elem = elem
  end
  def compare(arg)
    arg.include?(@elem)
  end
end

class RespondTo
  def initialize(elem)
    @method = method
  end
  def compare(arg)
    arg.respond_to?(@method)
  end
end

class BeA
  def initialize(obj)
    @obj = obj
  end
  def compare(arg)
    arg.is_a?(@obj)
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

it 'works' do
  expect([1,2,3,]).to include 4
end
