package org.example

class Student(name: String, age: Int): Human(name, initialAge = age) {
    var courses = mutableListOf<CourseRecord>()

    fun addCourse(course: CourseRecord) {
        courses.add(course)
    }

    fun weightedAverage(): Double {
        var weightedSum = 0.0
        var totalCredits = 0.0

        for (course in courses) {
            weightedSum += course.grade * course.credits
            totalCredits += course.credits
        }

        if (totalCredits == 0.0) return 0.0

        return weightedSum / totalCredits
    }

    fun weightedAverage(year: Int): Double {
        var weightedSum = 0.0
        var totalCredits = 0.0

        for (course in courses) {
            if (course.yearCompleted == year) {
                weightedSum += course.grade * course.credits
                totalCredits += course.credits
            }
        }

        if (totalCredits == 0.0) return 0.0

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