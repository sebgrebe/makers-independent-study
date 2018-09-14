require 'email'

describe SayHelloToMyLittleFriend do
  let(:to) { 'friend@example.com'}
  let(:body) { 'HELLO!' }
  let(:email_client_double) { double :email_client_double, message: messageClass.new}
  let(:emailClientClass) {double :emailClientClass, new: email_client_double}

  let(:messageClass) { double :messageClass, new: message_double }
  let(:message_double) { double :message_double, send: "to: #{to}, body: #{body}"}

  describe '#run'
    let(:say_hello) { described_class.new(emailClientClass, messageClass) }
    it 'sends email to friend@example.com with message "HELLO!"' do
      expect(say_hello.run).to eq "to: #{to}, body: #{body}"
    end
end
