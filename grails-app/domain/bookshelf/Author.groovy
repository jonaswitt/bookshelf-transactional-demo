package bookshelf

import grails.rest.Resource

@Resource(superClass = AuthorController, formats = ['json'])
class Author {

    String name

    static constraints = {
    }
}
