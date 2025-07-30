fetch("https://6e0ae7bd-1d51-464b-84bd-88ed5dfd8e8a-00-2rdepn66tctsa.pike.replit.dev/sort/bubble", {
  method: "POST",
  headers: {
    "Content-Type": "application/json",
  },
  body: JSON.stringify([4, 3, 2, 1]) // Your array input here
})
.then(res => res.json())
.then(data => {
  console.log("Sorting Steps:", data);
})
.catch(err => {
  console.error("Error fetching from backend:", err);
});
