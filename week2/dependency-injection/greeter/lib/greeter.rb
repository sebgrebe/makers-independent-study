class Greeter
  def greet(name = Kernel.gets.chomp)
    name
  end

  def print_greeting(name = greet)
    puts "What is your name?"
    puts "Hello, #{name}"
  end
end
