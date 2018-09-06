#trying to figure out how blocks work
def it(str)
  puts str
  yield
end

it 'works' do
  puts 'hello'
end
