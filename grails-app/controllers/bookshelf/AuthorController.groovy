package bookshelf

import grails.rest.*
import grails.converters.*
import grails.transaction.Transactional

class AuthorController extends RestfulController<Author> {

    static responseFormats = ['json']

    AuthorController() {
        super(Author)
    }

    @Transactional
    def createDefaultBooks() {
        Author author = Author.get(params.authorId)

        List books = (1..4).collect {
            new Book(author: author, title: "The Art of Computer Programming, Vol. $it")
        }
        books*.save(flush: true)

        render books as JSON
}
