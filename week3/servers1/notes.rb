class Notes

  def initialize
    @notes = []
  end

  def add_note(note)
    @notes << note
  end

  def see
    @notes
  end
end
