import java.io.IOException;
import java.net.URI;
import java.net.http.*;

public class RestApiClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private final HttpClient client;

    // Constructor initializes HttpClient once
    public RestApiClient() {
        this.client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2) // Use HTTP/2 when possible
                .build();
    }

    // -------------------- Generic Methods --------------------

    // GET request
    public String get(String endpoint) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + endpoint))
                .GET()
                .build();
        return sendRequest(request);
    }

    // POST request
    public String post(String endpoint, String jsonBody) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + endpoint))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        return sendRequest(request);
    }

    // PUT request
    public String put(String endpoint, String jsonBody) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + endpoint))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        return sendRequest(request);
    }

    // DELETE request
    public String delete(String endpoint) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + endpoint))
                .DELETE()
                .build();
        return sendRequest(request);
    }

    // Core method to send requests
    private String sendRequest(HttpRequest request) throws IOException, InterruptedException {
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Handle HTTP errors gracefully
        if (response.statusCode() >= 200 && response.statusCode() < 300) {
            return response.body();
        } else {
            return "❌ Error: HTTP " + response.statusCode() + " -> " + response.body();
        }
    }

    // -------------------- Testing the Client --------------------
    public static void main(String[] args) throws IOException, InterruptedException {
        RestApiClient apiClient = new RestApiClient();

        // 1. GET
        String getResponse = apiClient.get("/posts/1");
        System.out.println("🔹 GET -> " + getResponse);

        // 2. POST
        String newPost = """
            {
                "title": "Advanced REST Client",
                "body": "This is an optimized Java client example.",
                "userId": 99
            }
        """;
        String postResponse = apiClient.post("/posts", newPost);
        System.out.println("🔹 POST -> " + postResponse);

        // 3. PUT
        String updatePost = """
            {
                "id": 1,
                "title": "Updated REST Client",
                "body": "Optimized version updated successfully.",
                "userId": 99
            }
        """;
        String putResponse = apiClient.put("/posts/1", updatePost);
        System.out.println("🔹 PUT -> " + putResponse);

        // 4. DELETE
        String deleteResponse = apiClient.delete("/posts/1");
        System.out.println("🔹 DELETE -> " + deleteResponse);
    }
}
