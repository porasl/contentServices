
http://localhost:8081/contentservices/swagger-ui/index.html

curl -X PATCH -H "Content-Type: application/json" -d '{"filename": "example.pdf", "url": "http://example.com/example.pdf"}' http://localhost:8080/api/posts/{postId}/attachments/add


curl -X PATCH -H "Content-Type: application/json" -d '"example.pdf"' http://localhost:8080/api/posts/{postId}/attachments/remove


Start Mongo DB
brew services start mongodb/brew/mongodb-community

test connection to DB 
brew services list

Start Mongo DB manually
mongod --config /usr/local/etc/mongod.conf

//connect to Mongodb
>> Mongo or use the Mongo Compass

mongo DB
use inrik
db.createCollection("contents")


show collections

db.contents.find()  OR db["contents"].find()


GET  	/contentservices/{id} 
Delete /contentservices/{id} 
Patch  /{postId}/attachments/add
patch /{postId}/attachments/remove


# ===== Kafka
brew install kafka

#To start kafka now and restart at login:
  brew services start kafka
Or, if you don't want/need a background service you can just run:
  /opt/homebrew/opt/kafka/bin/kafka-server-start /opt/homebrew/etc/kafka/server.properties
==> Summary
🍺  /opt/homebrew/Cellar/kafka/4.1.0: 218 files, 128.3MB
==> Running `brew cleanup kafka`....

#To download Youtube videos
pip install yt-dlp
python -m yt_dlp https://www.youtube.com/shorts/1VjRfTG6FJc

yt-dlp -f "bv*+ba/best" --merge-output-format mp4 https://www.youtube.com/shorts/ii2I6BH8m4I

