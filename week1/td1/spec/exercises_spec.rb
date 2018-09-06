require 'exercises'

describe "remember_name method" do
  it 'tells us that name was storted' do
    expect(remember_name("Seb")).to eq("Seb's name was stored")
  end
end
