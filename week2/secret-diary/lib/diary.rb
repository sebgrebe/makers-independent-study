require_relative 'lock.rb'

class Diary

  attr_reader :entries

  def initialize
    @lock = Lock.new
    @entries = []
  end

  def locked?
    @lock.locked?
  end

  def lock
    @lock.lock
  end

  def unlock
    @lock.unlock
  end

  def add_entry(entry)
    raise 'Diary is locked' if locked?
    @entries << entry
  end

  def get_entries
    raise 'Diary is locked' if locked?
    @entries
  end



end
