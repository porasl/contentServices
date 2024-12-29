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

mongo
use inrik
db.createCollection("contents")


show collections

db.contents.find()  OR db["contents"].find()
