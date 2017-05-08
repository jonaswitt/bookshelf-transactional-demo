package bookshelf

class UrlMappings {

    static mappings = {
        "/authors"(resources: 'author') {
            "/createDefaultBooks"(action: 'createDefaultBooks', method: 'POST')
        }
        "/books"(resources: 'book')

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
