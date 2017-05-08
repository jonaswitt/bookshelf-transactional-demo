import bookshelf.Author

class BootStrap {

    def init = { servletContext ->

        new Author(name: 'Donald Knuth').save()

    }
    def destroy = {
    }
}
