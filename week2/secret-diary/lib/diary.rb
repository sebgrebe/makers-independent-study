class Diary

  attr_reader :entries

  def initialize(locked = true)
    @locked = locked
    @entries = []
  end

  def locked?
    @locked
  end

  def add_entry(entry)
    raise 'Diary is locked' if @locked
    @entries << entry
  end

  def get_entries
    raise 'Diary is locked' if @locked
    @entries
  end

  def lock
    @locked = true
  end

  def unlock
    @locked = false
  end

end
