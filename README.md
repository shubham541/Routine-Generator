# Routine-Generator

Time table generation in it is easy and flexible. In it you can effortlessly create time table for different year/semester and sections. Based on the start and end time of your school /colleges you can place duration of each class and system produces the time table slots according to this rules specified.
Academic time table generator based inputs and constraints using Java GUI, different algorithms and coding with consideration for re-usability: a simple software program to solve real-world problems

## Current state

The project is an early-stage Java Swing desktop application. What exists in the code today:

- A start window with a File menu (New, Exit), view menus (Section, Room, Instructor) and an About dialog
- An input window with file-chooser buttons for uploading the Time Slot, Courses, Instructor Detail, Section and Room files, plus Back and Generate buttons
- An output window that displays a time table in a Swing table (Day x 1st-7th period) with an Export button

The Generate button and the file-parsing/scheduling logic are not implemented yet, and the output table currently shows hard-coded sample data.

## Tech stack

- Java 8 (Swing GUI)
- NetBeans / Apache Ant project (`build.xml`, `nbproject/`)

## Project structure

```
src/Ui.java     main class (Ui): menus, input window, output window, splash
src/check.java  small file read/write scratch test
nbproject/      NetBeans project configuration (main class: Ui)
build.xml       Ant build script
```

## Prerequisites

- JDK 8 or newer
- NetBeans (recommended) or Apache Ant

## Build and run

Open the folder as a project in NetBeans and run it (main class `Ui`), or build with Ant:

```
ant jar
java -jar dist/Routine-Generator.jar
```

Note: the code loads images from a `res/` package (for example `res/iconApp.png`, `res/bgClock.jpg`, `res/loading.gif`) and references a `Splash` class that are not in this repository, so the app will not start from a fresh clone until those resources are supplied. The jar name above is assumed from the project name and may differ.

## Credits

The About dialog credits Kumar Atul, Kumar Shubham, Hritik Kumar and Kunal Kumar.
