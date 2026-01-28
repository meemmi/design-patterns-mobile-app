package org.example

class Student(name: String, age: Int): Human(name, initialAge = age) {
    val courses = mutableListOf<CourseRecord>()

    fun addCourse(course: CourseRecord) = courses.add(course)


    fun weightedAverage(): Double {
        val totalCredits = courses.sumOf { it.credits }
        if (totalCredits == 0) return 0.0

        val weightedSum = courses.sumOf { it.grade * it.credits }
        return weightedSum / totalCredits
    }

    fun weightedAverage(year: Int): Double {
        val totalCredits = courses.filter { it.yearCompleted == year }.sumOf { it.credits }
        if (totalCredits == 0) return 0.0

        val weightedSum = courses.filter { it.yearCompleted == year }.sumOf { it.grade * it.credits  }
        return weightedSum / totalCredits
    }


    fun minMaxGrades(): Pair<Double, Double> {
        var minGrade = courses[0].grade
        var maxGrade = courses[0].grade

        for (course in courses) {
            if (course.grade < minGrade) minGrade = course.grade
            if (course.grade > maxGrade) maxGrade = course.grade
        }
        return minGrade to maxGrade

    }
}