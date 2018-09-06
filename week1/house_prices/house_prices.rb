require('./house_prices_hash.rb')

house_prices_hash = HousePrices.new.get()
#house_prices_hash = HousePrices.get()

def house_prices(hash)
  hash.each do |key,val|
    val[:transactions].each do |transaction|
      puts "A house was sold in #{key[0]}, #{key[1]} for £#{transaction[0]} on #{transaction[2]}"
    end
  end
end

house_prices(house_prices_hash)
