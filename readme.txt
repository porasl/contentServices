
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

mongo
use inrik
db.createCollection("contents")


show collections

db.contents.find()  OR db["contents"].find()



Post  request body create
{
  "id": "string",
  "title": "string",
  "content": "string",
  "attachments": [
    {
      // attachment fields here
    }
  ],
  "comments": [
    {
      // comment fields here
    }
  ],
  "isDeleted": false,
  "isDisabled": false,
  "isPrivate": false,
  "category": {
    // category fields here
  },
  "accessType": "string", // Enum value as string
  "state": "string",      // Enum value as string
  "createdTime": "2025-03-23T10:15:30",
  "updatedTime": "2025-03-23T10:15:30",
  "eventDate": "2025-03-23T10:15:30",
  "memoryDate": "2025-03-23T10:15:30",
  "locale": "en-US",
  "description": "string",
  "deletedCode": "string"
}


GET  	/contentservices/{id} 
Delete /contentservices/{id} 
Patch  /{postId}/attachments/add
patch /{postId}/attachments/remove

