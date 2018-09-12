require 'lock'

describe Lock do

  let(:lock_unlocked) { Lock.new(false) }
  describe 'locked?'
    it { should respond_to :locked? }
    it 'should have locked as true as default' do
      expect(subject).to be_locked
    end

  describe 'lock'
    it { should respond_to :lock }
    it 'should set locked to true' do
      lock_unlocked.lock
      expect(lock_unlocked.locked?).to eq true
    end
    # it 'add_entry should throw errors again' do
    #   diary_unlocked.lock
    #   expect { diary_unlocked.add_entry(entry) }.to raise_error 'Diary is locked'
    # end
end
