# Bookshelf Transaction Demo

This Grails 3.1 app demonstrates the dangers of using @Transactional
annotations on Grails controller actions (instead of the best practice
of relying on the transactional behavior of Grails services).

The `create-books.groovy` script can be run directly using the 
groovy command. It assumes the Grails app server is running at
`http://localhost:8080/` and performs two requests:

1. `POST /authors/1/createDefaultBooks` to create some books 
   for the author
2. `GET /books/<id>` with the ID of one of the books returned by 
   the first request
    
As the books created in the first request are rendered & returned
to the client before the transaction is commited, it is possible
to encounter a race condition where the book with that ID cannot
be found in the database for the second request.
