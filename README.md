# Gradebook-Project
# Gradebook Application

## Description
The Gradebook Application is a console-based program that allows users to manage student grades. Users can add students, display all students, compute average and median scores, and find the highest and lowest scores. 
The application also supports changing student grades and retrieving specific student information.

## Features
- Add new students
- Display all students with scores or letter grades
- Compute average and median scores and their corresponding letter grades
- Find the minimum and maximum scores and their corresponding letter grades
- Retrieve letter grade or name by student PID
- Change a student's grade

## Technologies Used
- Java

## How to Use
1. Clone the repository:
    ```
    git clone https://github.com/yourusername/Gradebook.git
    ```
2. Navigate to the project directory:
    ```
    cd Gradebook
    ```
3. Compile the Java files:
    ```
    javac src/util/*.java src/main/Main.java
    ```
4. Run the application:
    ```
    java src/main/Main
    ```

## Sample Commands
- `min score` - Shows minimum score
- `min letter` - Shows minimum letter grade
- `max score` - Shows maximum score
- `max letter` - Shows maximum letter grade
- `letter <PID>` - Shows letter grade for a student by PID
- `name <PID>` - Shows name of a student by PID
- `change <PID> <new grade>` - Change a student's grade by PID
- `average score` - Shows average score
- `average letter` - Shows average letter grade
- `median score` - Shows median score
- `median letter` - Shows median letter grade
- `tab scores` - Lists all students with their scores
- `tab letters` - Lists all students with their letter grades

## License
MIT License
