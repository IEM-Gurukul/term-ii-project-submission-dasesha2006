[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/pG3gvzt-)
# PCCCS495 – Term II Project

## Project Title
---Library Management System


## Problem Statement (max 150 words)

Managing books manually in a library is time-consuming and error-prone. It becomes difficult to track which books are available, issued, or returned, and to maintain proper records of students borrowing books. This project aims to develop a simple Library Management System using Java that automates basic library operations. The system allows users to add books, view available books, issue books to students, and return them efficiently. It uses Object-Oriented Programming concepts such as abstraction, inheritance, and exception handling to ensure structured and error-free execution. The system is menu-driven and user-friendly, making it suitable for small libraries or academic purposes.

## Target User

---Librarian
Students / Users

## Core Features

Add new books
View all books
Issue books to students
Return books
Store student details
Track book issue status
Handle invalid input using exception handling
Menu-driven user interface

---

## OOP Concepts Used

- Abstraction
- Inheritance
- Exception Handling

---

## Proposed Architecture Description

The system follows a simple object-oriented architecture. It consists of different classes such as Person (abstract class), Student (derived class), Book, and the main class LibraryManagement. The Person class defines common properties, while the Student class inherits from it to manage student details. The Book class stores information about each book and its issue status. The LibraryManagement class controls the overall flow of the program using a menu-driven approach. Data is stored using arrays, and user input is handled through the scanner. Exception handling is used to manage invalid inputs, ensuring smooth execution of the system.

## How to Run

---Install Java (JDK 8 or above)
Open project in VS Code / IntelliJ

Compile using:

javac Main.java

Run using:

java Main

## Git Discipline Notes
Minimum 10 commits maintained
Each commit includes meaningful changes like feature addition, bug fix, or code improvement
Proper commit messages used
