require 'note.rb'

describe Note do

  let (:title) { double :title }
  let (:body)  { double :body }
  describe 'display'
    it 'displays with the right format' do
      formatter = double :formatter
      allow(formatter).to receive(:format).with(an_instance_of(Note)) { "Title: #{title}\n#{body}" }
      note = Note.new(title, body, formatter)
      expect(note.display).to eq "Title: #{note.title}\n#{note.body}"
    end

end

describe NoteFormatter do
  let (:note) { double :note, title: "Title", body: "Body" }
  describe 'format'
    it 'puts note in correct format' do
      expect(subject.format(note)).to eq "Title: #{note.title}\n#{note.body}"
    end

end
