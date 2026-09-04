# CIT300 - Mini Hospital Emergency Management System

## Overview
This project is a console-based **Mini Hospital Emergency Management System** developed in **Java** as part of the CIT300 - Data Structures and Algorithms Individual Mid Assignment. The system simulates patient registration, emergency queue management, treatment completion, and patient visit history using core data structures implemented from scratch.

## Features
- Register, search, and delete patient records
- Manage an emergency queue of waiting patients (FIFO)
- Track completed treatments using a stack (LIFO)
- Maintain each patient's visit history using a singly linked list

## Data Structures Used

| Data Structure | Used For | Operations Implemented |
|---|---|---|
| Binary Search Tree (BST) | Patient Records | Insert, Search, Delete, In-order Traversal |
| Queue | Emergency Patient Queue | Enqueue, Dequeue, Display, Empty Handling |
| Stack | Treatment History | Push, Pop, Display, Empty Handling |
| Singly Linked List | Patient Visit History | Add, Remove, Search, Display |

## Project Structure
CIT300-Hospital-Emergency-System/
├── src/
│   ├── Patient.java           # Patient entity
│   ├── PatientBST.java        # BST for patient records
│   ├── EmergencyQueue.java    # Queue for waiting patients
│   ├── TreatmentRecord.java   # Treatment record entity
│   ├── TreatmentStack.java    # Stack for treatment history
│   ├── Visit.java             # Visit entity
│   ├── VisitLinkedList.java   # Linked list for visit history
│   └── Main.java              # Menu-driven console application
└── README.md