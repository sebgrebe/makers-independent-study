require 'socket'

socket = TCPSocket.new('localhost', 2345)

loop do
  puts socket.gets
  puts "Wow what a rude server... I'm going to say Sarah"
  socket.puts "Sarah"
  puts socket.gets
  puts "Another round? Enter y for yes"
  input = gets.chomp
  break if input != 'y'
end

socket.close
