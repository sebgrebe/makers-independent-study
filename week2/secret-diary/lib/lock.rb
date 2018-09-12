class Lock

  def initialize(locked = true)
    @locked = locked
  end

  def locked?
    @locked
  end

  def lock
    @locked = true
  end

  def unlock
    @locked = false
  end

end
