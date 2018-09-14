class EmailClient
  def message
    Message.new
  end
end

class Message
  def send(to, body)
    return "to: #{to}, body: #{body}"
  end
end

class SayHelloToMyLittleFriend
  def initialize(emailClientClass = EmailClient, messageClass = Message)
    @email_client_class = emailClientClass
    @message_class = messageClass
  end

  def run
    email = @email_client_class.new
    message = @message_class.new
    email.message.send("friend@example.com", "HELLO!")
  end
end
