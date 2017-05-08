package bookshelf

import grails.rest.*
import grails.converters.*
import grails.transaction.Transactional

class AuthorController extends RestfulController<Author> {

    static responseFormats = ['json']

    AuthorController() {
        super(Author)
    }
    
}
