package bookshelf

import grails.rest.Resource

@Resource(formats = ['json'])
class Book {

    String title
    Author author

    static constraints = {
    }
}
