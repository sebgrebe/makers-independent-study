require_relative 'coin.rb'

class Score

  def initialize
    @scores = []
  end

  def flip
    result = Coin.new.flip
    p result
    save(result)
  end

  def save(result)
    @scores << result
  end

  def count_heads
    @scores.count('heads')
  end

  def print_heads
    p count_heads
  end

end
