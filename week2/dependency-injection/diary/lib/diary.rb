class Diary

  attr_reader :entries
  
  def initialize(entry = Entry)
    @entry = entry
    @entries = []
  end

  def add(title, body)
    @entries << @entry.new(title, body)
  end

  def index
    titles = @entries.map do |entry|
      entry.title
    end
    titles.join("\n")
  end
end

class Entry
  def initialize(title, body)
    @title = title
    @body = body
  end

  attr_reader :title, :body
end
