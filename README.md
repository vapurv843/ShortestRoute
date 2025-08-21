# 🚴‍♂️ Best Route Finder  

A Java program to compute the **best delivery route** for a food delivery executive, considering **restaurant preparation times** and **travel times** between geo-locations using the **Haversine formula**.  

---

## 📌 Problem Statement  

Imagine Aman (a delivery executive) gets multiple food orders:  
- Each order comes from a **restaurant** (with a prep time).  
- Each order is delivered to a **consumer location**.  

The goal is to determine the **shortest completion time** for delivering all orders, considering:  
- ⏱️ **Preparation times** at restaurants.  
- 🚗 **Travel times** between locations (based on latitude & longitude, assuming speed = 20 km/hr).  
- 📍 Aman starts from a given location.  

---

## ⚙️ Approach  

- **Entities**  
  - `Location` → Represents latitude & longitude, calculates distance & travel time.  
  - `Order` → Holds consumer, restaurant, and prep time.  
  - `DeliveryExecutive` → Simulates Aman’s movement and calculates route time.  

- **Route Evaluation**  
  - For **small N (≤ 8 orders)**: Generate all **permutations** and compute the exact best route.  
  - For **large N (> 8 orders)**: Use a **greedy heuristic** to approximate the best route quickly.  


## 🏗️ Project Structure  

```text
.
├── src
│   ├── Location.java
│   ├── Order.java
│   ├── DeliveryExecutive.java
│   ├── BestRouteFinder.java        # Example with 2 orders
│   └── BestRouteFinderN.java       # Scalable version (N orders)
└── README.md






