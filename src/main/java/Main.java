import static spark.Spark.*;
import com.google.gson.Gson;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    port(8080);
    staticFiles.location("/public");
    Gson gson = new Gson();
    // Allow CORS so frontend can talk to backend
    options("/*", (req, res) -> {
      String accessControlRequestHeaders = req.headers("Access-Control-Request-Headers");
      if (accessControlRequestHeaders != null) {
        res.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
      }

      String accessControlRequestMethod = req.headers("Access-Control-Request-Method");
      if (accessControlRequestMethod != null) {
        res.header("Access-Control-Allow-Methods", accessControlRequestMethod);
      }

      return "OK";
    });

    before((req, res) -> res.header("Access-Control-Allow-Origin", "*"));

    // Insertion Sorting Endpoint
    post("/sort/insertion", (req, res) -> {
      int[] input = gson.fromJson(req.body(), int[].class);
      List<int[]> result = InsertionSort.getInsertionSort(input);
      return gson.toJson(result);
    });

    // Bubble Sort Endpoint
    post("/sort/bubble", (req, res) -> {
      int[] input = gson.fromJson(req.body(), int[].class);
      List<int[]> result = BubbleSort.getBubbleSort(input);
      return gson.toJson(result);
    });

    // Selection Sort Endpoint
    post("/sort/selection", (req, res) -> {
      int[] input = gson.fromJson(req.body(), int[].class);
      List<int[]> result = SelectionSort.getSelectionSort(input);
      return gson.toJson(result);
    });

    // Quick Sort Endpoint
    post("/sort/quick", (req, res) -> {
      int[] input = gson.fromJson(req.body(), int[].class);
      List<int[]> result = QuickSort.getQuickSort(input);
      return gson.toJson(result);
    });

    // Linear Search endpoint
    post("/search/linear", (req, res) -> {
      SearchRequest searchReq = gson.fromJson(req.body(), SearchRequest.class);

      int[] array = searchReq.array;
      int target = searchReq.target;

      List<LinearSearch.Sorted> sorted = LinearSearch.getLinearSearch(array, target);

      // Prepare result for frontend
      List<Map<String, Object>> result = new ArrayList<>();
      for (LinearSearch.Sorted step : sorted) {
        Map<String, Object> stepMap = new HashMap<>();
        stepMap.put("array", Arrays.stream(step.array).boxed().toArray());
        stepMap.put("index", step.index);
        stepMap.put("found", step.found);
        result.add(stepMap);
      }

      res.type("application/json");
      return gson.toJson(result);
    });


    // Binary Search endpoint
    post("/search/binary", (req, res) -> {
      SearchRequest searchReq = gson.fromJson(req.body(), SearchRequest.class);
      List<BinarySearch.SearchStep> result = BinarySearch.getBinarySearch(searchReq.array, searchReq.target);
      return gson.toJson(result);
    });
    }

    // Helper class for JSON with array and target
    static class SearchRequest {
    int[] array;
    int target;
    }
  
  }
