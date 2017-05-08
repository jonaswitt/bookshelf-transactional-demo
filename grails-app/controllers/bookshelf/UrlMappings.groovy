package bookshelf

class UrlMappings {

    static mappings = {
        "/authors"(resources: 'author') {
        }
        "/books"(resources: 'book')

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
