require 'greeter'

describe Greeter do

  describe '#greet' do
    it 'returns name"' do
      expect(subject.greet("Heinz")).to eq("Heinz")
    end
  end

  describe '#print_greeting' do
    it 'prints greeting' do
      expect(STDOUT).to receive(:puts).with('What is your name?')
      expect(STDOUT).to receive(:puts).with('Hello, Seb')
      subject.print_greeting('Seb')
    end
  end

end
