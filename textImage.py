from twilio.rest import Client

account_sid = 'AC231cb4e69264377a21e17181e79c2aaf' # Found on Twilio Console Dashboard
auth_token = '32e93f02143a659517a340edc3d13d7d' # Found on Twilio Console Dashboard

myPhone = 'xxxxxxxxxx' # Phone number you used to verify your Twilio account
TwilioNumber = 'xxxxxxxxxx' # Phone number given to you by Twilio

client = Client(account_sid, auth_token)
client.messages.create(
  to= +xxxxxxxxxx,
  from_=+19252639676,
  
