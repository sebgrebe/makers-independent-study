require 'socket'

def run_server
  server = TCPServer.new(2345)
  loop do #put into a loop so that server is reopened after a request and can receive another request
    socket = server.accept #code only goes beyond this line if server gets a new request through hitting localhost:2345
    request = get_lines_until_blank_line(socket)
    puts "=== GOT REQUEST ==="
    puts request #prints the server request line by line once
    puts "=== END REQUEST ==="

    if request.start_with? "GET / HTTP/1.1"
      response = "Hello World!\n"
    elsif request.start_with? "GET /secret_page HTTP/1.1"
      response = "1. The gold is buried at harald creek\n"
      response += "2. OK I only have one secret"
    else
      response = "Nothing found :(" #404 if request is not for root route or /secret_page
    end

    http_response = build_http_response(response) #create a response from server
    socket.print http_response

    puts "=== SENT RESPONSE ===" #print that response to console
    puts http_response
    puts "=== END RESPONSE ==="
    puts "\n"
    socket.close #closed, to just be opened again at beginning of loop
  end
end

def get_lines_until_blank_line(socket)
  message = ""
  loop do
    line = socket.gets #stores the requests the server receives line by line
    if line.chomp == "" #once there are no more new lines, loop is broken and the stored lines returned to run_server
      break
    else
      message += line
    end
  end
  message
end

def build_http_response(response)
  "HTTP/1.1 200 OK\r\n" +
    "Content-Type: text/plain\r\n" +
    "Content-Length: #{response.bytesize}\r\n" +
    "Connection: close\r\n" +
    "\r\n" +
    response
end

run_server
