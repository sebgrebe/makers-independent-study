require 'calculator.rb'

describe Calculator do
  it 'should add two numbers' do
    expect(subject.add(1,2)).to eq(3)
  end
end
