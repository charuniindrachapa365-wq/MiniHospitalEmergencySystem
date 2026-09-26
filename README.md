# Mini Hospital Emergency Management System

## CIT300 - Data Structures and Algorithms

### Individual Mid Assignment

## Project Overview

The Mini Hospital Emergency Management System is a Java-based console application developed for the CIT300 Data Structures and Algorithms Individual Mid Assignment.

The system simulates basic hospital operations including patient registration, emergency patient management, completed treatment history, and patient visit history.

The project demonstrates the practical implementation of four fundamental data structures:

- Binary Search Tree (BST)
- Queue
- Stack
- Singly Linked List

---

## Features

### 1. Patient Records - Binary Search Tree (BST)

Patient records are stored using a Binary Search Tree where the Patient ID is used as the key.

Supported operations:

- Insert a new patient
- Search for a patient using Patient ID
- Delete a patient
- Display all patients using in-order traversal
- Display patients in ascending Patient ID order

Each patient contains:

- Patient ID
- Patient Name
- Age
- Contact Number
- Medical Condition

---

### 2. Emergency Patient Queue

Emergency patients are managed using a Queue following the FIFO (First-In, First-Out) principle.

Supported operations:

- Enqueue a patient
- Dequeue the next patient for treatment
- Display all waiting patients
- Handle an empty queue

---

### 3. Treatment History - Stack

Completed treatment records are stored using a Stack following the LIFO (Last-In, First-Out) principle.

Supported operations:

- Push a completed treatment record
- Pop the most recently completed treatment record
- Display treatment history
- Handle an empty stack

---

### 4. Patient Visit History - Singly Linked List

Each patient maintains a separate Singly Linked List containing previous hospital visits.

Supported operations:

- Add a new visit
- Search for a visit
- Remove a visit
- Display patient visit history

Each visit contains:

- Visit ID
- Visit Date
- Doctor Name
- Diagnosis
- Treatment

---

## Project Structure

```text
MiniHospitalEmergencySystem/
│
├── src/
│   ├── Patient.java
│   ├── PatientBST.java
│   ├── EmergencyQueue.java
│   ├── TreatmentRecord.java
│   ├── TreatmentStack.java
│   ├── Visit.java
│   ├── VisitLinkedList.java
│   └── Main.java
│
├── .gitignore
└── README.md