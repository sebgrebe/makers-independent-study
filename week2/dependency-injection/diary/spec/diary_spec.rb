require 'diary'

describe Diary do
  let(:title) { 'title' }
  let(:body) { 'body' }
  let(:entry) { entry = double :entry, title: title }
  let(:entry_class_double) { double :entry_class, new: entry }
  let(:diary) { Diary.new(entry_class_double) }
  describe 'add'
    it '#adds an entry' do
      diary.add(title, body)
      expect(diary.entries[-1]).to eq entry
    end

  describe 'index'
    it '#returns list of all titles' do
      diary.add(title, body)
      diary.add(title, body)
      expect(diary.index).to eq ("#{title}\n#{title}")
    end
end

describe Entry do
  let(:title) { 'title' }
  let(:body) { 'body' }
  let(:real_entry) { Entry.new(title,body) }
  describe '#initialize'
    it 'initializes with title' do
      expect(real_entry.title).to eq title
    end
    it 'initializes with body' do
      expect(real_entry.body).to eq body
    end
end
