require 'socket'
require_relative 'notes'

server = TCPServer.new(2345)
notes = Notes.new
socket = server.accept

loop do
  socket.puts "Enter a note."
  socket.puts "Type 'quit' to close. Type 'see' to see your notes"
  they_said = socket.gets.chomp
  if they_said == 'see'
    socket.puts("These are your notes")
    socket.puts(notes.see)
  elsif they_said == 'quit'
    break
  else
    notes.add_note(they_said)
    socket.puts "Note saved."
  end
end

socket.puts "Good bye!"
socket.close
