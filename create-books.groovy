
import groovy.json.JsonSlurper
import org.apache.http.HttpResponse
import org.apache.http.client.methods.*
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.util.EntityUtils

@Grab(group = 'org.apache.httpcomponents', module = 'httpclient', version = '4.5.3')
class TestClient {

    def createDefaultBooks(authorId) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build()

        println "Sending /createDefaultBooks request..."
        HttpResponse result = httpClient.execute(new HttpPost("http://localhost:8080/authors/$authorId/createDefaultBooks"))
        assert result.statusLine.statusCode == 200

        String responseBody = result.getEntity() ? EntityUtils.toString(result.getEntity(), "UTF-8") : null
        result.close()
        def books = new JsonSlurper().parseText(responseBody)
        def ids = books*.id
        println "Created book IDs: $ids"

        return ids
    }

    def showBook(id) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build()

        println "Fetching /books/${id}"
        HttpResponse result = httpClient.execute(new HttpGet("http://localhost:8080/books/${id}"))
        assert result.statusLine.statusCode == 200

        String responseBody = result.getEntity() ? EntityUtils.toString(result.getEntity(), "UTF-8") : null
        result.close()
        println "Book $id: ${new JsonSlurper().parseText(responseBody)}"
    }

}

def client = new TestClient()

def bookIds = client.createDefaultBooks(1)
client.showBook(bookIds.last())
