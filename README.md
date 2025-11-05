
# 🧠 Sorting and Searching Visualizer

An **interactive web application** that visually demonstrates how classic **sorting and searching algorithms** work step-by-step.  
Built with a **Java backend (Spark)** and a **modern, responsive frontend** using **HTML, Tailwind CSS, and JavaScript**, this project helps users **understand algorithm behavior visually** with dynamic bar animations, color cues, and speed control.

---

## 🚀 Tech Stack

**Frontend:**  
- HTML5  
- Tailwind CSS  
- Vanilla JavaScript  
- LocalStorage  

**Backend:**  
- Java  
- Spark Java Framework  
- JSON (via Gson or similar)  

**Hosting / Dev Environment:**  
- Replit  

---

## 🎯 Project Outcome

This project provides:  
- Step-by-step visual understanding of how each algorithm operates.  
- Real-time interaction for user-provided arrays and targets.  
- Speed control for animations.  
- Dark mode toggle for user comfort.  
- Backend-driven snapshots for consistent visualization.

---

## 🧩 Architecture

### High-Level Design

```
+-------------------------+
|      Frontend (UI)      |
|-------------------------|
| HTML, CSS, JS, Tailwind |
| Pages: bubble, quick,   |
| insertion, selection,   |
| linear, binary, index   |
+-----------+-------------+
            |
            | JSON (via fetch API)
            ▼
+-------------------------+
|      Backend (Java)     |
|-------------------------|
| Spark Java REST Server  |
| Algorithms: BubbleSort, |
| InsertionSort, etc.     |
+-----------+-------------+
            |
            ▼
+-------------------------+
|      Algorithm Logic    |
|-------------------------|
| Generates snapshots     |
| (step-by-step states)   |
+-------------------------+
```

---

## ⚙️ Workflow

1. User enters input array (and target for searches).
2. Frontend parses input and sends JSON to backend.
3. Java backend runs algorithm and stores intermediate states as snapshots.
4. JSON snapshots are sent to frontend.
5. Frontend animates each snapshot using `renderBars()`.

---

## 💡 Algorithms and DSA Used

| Algorithm | File | Time Complexity | Purpose |
|------------|------|----------------|----------|
| Bubble Sort | BubbleSort.java | O(n²) | Visualize pairwise swaps |
| Selection Sort | SelectionSort.java | O(n²) | Visualize min selection |
| Insertion Sort | InsertionSort.java | O(n²) | Show sorted prefix growth |
| Quick Sort | QuickSort.java | O(n log n) | Partitioning and recursion |
| Linear Search | LinearSearch.java | O(n) | Sequential element checking |
| Binary Search | BinarySearch.java | O(log n) | Midpoint range shrinking |

**Data Structures Used:**  
- Arrays (`int[]`, `List<Integer>`)  
- Lists for snapshots  

---

## 🎨 Frontend

**Files:** `index.html`, `bubble.html`, `selection.html`, `insertion.html`, `quick.html`, `linear.html`, `binary.html`, `style.css`, `script.js`

### Key Features
| Feature | Why Used | Functionality |
|----------|-----------|---------------|
| Speed Control | Learning flexibility | Changes delay between animation frames |
| Dynamic Bars | Easy visualization | Maps numbers to bar heights |
| Color Cues | Highlights swaps/comparisons | Red = swap, Yellow = compare, Green = found |
| Dark Mode | Better UX | Saved in LocalStorage |
| Backend Fetch | Connects UI to Java API | Sends/receives JSON data |

**Example Rendering Function**
```javascript
function renderBars(arr, compareIndices = [], swapIndices = []) {
  const container = document.getElementById("bars");
  container.innerHTML = "";
  const max = Math.max(...arr);
  const scale = 200 / max;
  arr.forEach((value, i) => {
    const bar = document.createElement("div");
    bar.style.height = `${value * scale}px`;
    bar.className = "bar";
    bar.style.backgroundColor = swapIndices.includes(i)
      ? "red"
      : compareIndices.includes(i)
      ? "gold"
      : "blue";
    const label = document.createElement("div");
    label.textContent = value;
    bar.appendChild(label);
    container.appendChild(bar);
  });
}
```

---

## 🌐 Backend (Java)

**Core Files:**  
- Main.java — defines API routes.  
- Algorithm files — implement logic and return snapshots.

**Example Endpoint**
```java
post("/sort/bubble", (req, res) -> {
    int[] arr = new Gson().fromJson(req.body(), int[].class);
    BubbleSort sorter = new BubbleSort();
    List<int[]> steps = sorter.sort(arr);
    res.type("application/json");
    return new Gson().toJson(steps);
});
```

---

## 🧭 Features Summary

| Feature | Description |
|----------|-------------|
| Animated Visualization | Step-by-step visual changes |
| Speed Control | Custom animation speed |
| Dark Mode | Persistent user preference |
| Dynamic Input | Parses comma-separated values |
| Error Handling | Alerts invalid inputs |
| REST API Communication | JSON-based frontend-backend link |

---

## 🧰 Setup Instructions

### Backend
1. Open the backend project folder.  
2. Ensure Spark and Gson are added to dependencies.  
3. Run `Main.java`.  

### Frontend
1. Open `index.html` in browser.  
2. Navigate to algorithm page.  
3. Input array and click “Sort” or “Search”.  

---

## 📈 Learning Outcomes

- Mastered REST API design using Java.  
- Reinforced DSA knowledge through visualization.  
- Gained frontend-backend integration experience.  
- Implemented responsive design with Tailwind CSS.  

---

## 🌟 Future Enhancements

- Add Play/Pause/Reset controls.  
- Include Merge and Heap Sort visualizers.  
- Add step-backward navigation.  
- Switch to Canvas rendering for performance.  
- Add theoretical notes beside visualizer.  

---

## 👨‍💻 Author

**Srinivas**  
- B.Tech CSE (Core), India  
- Oracle Certified Professional (OCP) Java Developer  
- Interests: Deep Learning, AI, Full Stack Development

---

> *"Visualizing an algorithm makes understanding it ten times easier."*
