require 'diary.rb'

describe Diary do
  it { should respond_to(:locked?) }
  let( :diary_unlocked ) { Diary.new(false) }
  let( :entry ) { double('entry') }
  it 'should be initialized as locked' do
     expect(subject.locked?).to eq true
  end

  describe '#add_entry'
    it 'should throw error when locked' do
      expect { subject.add_entry(entry) }.to raise_error 'Diary is locked'
    end
    it 'should work as desired if not locked' do
      diary_unlocked.add_entry(entry)
      expect(diary_unlocked.entries).to include entry
    end

  describe '#get_entries'
    it 'should throw error when locked' do
      expect { subject.get_entries }.to raise_error 'Diary is locked'
    end
    it 'should work as desired if not locked' do
      diary_unlocked.add_entry(entry)
      expect(diary_unlocked.get_entries).to include entry
    end

  describe '#unlock'
    it 'should set locked to false' do
      subject.unlock
      expect(subject.locked?).to eq false
    end

  describe '#lock'
    it 'should set locked to true' do
      diary_unlocked.lock
      expect(diary_unlocked.locked?).to eq true
    end
    it 'add_entry should throw errors again' do
      diary_unlocked.lock
      expect { diary_unlocked.add_entry(entry) }.to raise_error 'Diary is locked'
    end

end
