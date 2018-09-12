require 'diary.rb'

describe Diary do

  let( :entry ) { double('entry') }
  before(:each) {
    @diary_unlocked = Diary.new
    allow(@diary_unlocked).to receive(:locked?) { false }
  }

  describe 'locked?'
    it { should respond_to(:locked?) }
    it 'should be initialized as locked' do
       expect(subject.locked?).to eq true
    end

  describe '#add_entry'
    it 'should throw error when locked' do
      expect { subject.add_entry(entry) }.to raise_error 'Diary is locked'
    end
    it 'should work as desired if not locked' do
      @diary_unlocked.add_entry(entry)
      expect(@diary_unlocked.entries).to include entry
    end

  describe '#get_entries'
    it 'should throw error when locked' do
      expect { subject.get_entries }.to raise_error 'Diary is locked'
    end
    it 'should work as desired if not locked' do
      @diary_unlocked.add_entry(entry)
      expect(@diary_unlocked.get_entries).to include entry
    end

end
