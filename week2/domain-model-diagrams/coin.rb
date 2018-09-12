class Coin

  def flip
    if rand > 0.5
      'tails'
    else
      'heads'
    end
  end
end
