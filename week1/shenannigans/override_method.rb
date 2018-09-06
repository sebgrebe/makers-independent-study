#trying to figure out how to override methods

module OwnMethods
  def include(arr,elem)
    arr.include?(elem)
  end
end

singleton_class.prepend OwnMethods

puts include([1,2,3],1)
