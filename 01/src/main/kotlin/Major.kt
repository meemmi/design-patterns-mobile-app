package org.example


class Major(val name: String) {
    val students = mutableListOf<Student>()

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun stats(): Triple<Double, Double, Double> {
        var minAverage = students[0].weightedAverage()
        var maxAverage = students[0].weightedAverage()
        var sumOfAverages = 0.0

        for (student in students) {
            val studentAverage = student.weightedAverage()
            sumOfAverages += studentAverage

            if (studentAverage < minAverage) minAverage = studentAverage
            if (studentAverage > maxAverage) maxAverage = studentAverage
        }

        val averageOfAverages = sumOfAverages / students.size

        return Triple(minAverage, maxAverage, averageOfAverages)
    }


    fun stats(courseName: String): Triple<Double, Double, Double> {
        var minAverage = Double.MAX_VALUE
        var maxAverage = Double.MIN_VALUE
        var sumOfAverages = 0.0
        var totalStudents = 0.0

        for (student in students) {
            for (course in student.courses) {
                if (course.courseName == courseName) {
                    sumOfAverages += course.grade
                    totalStudents += 1.0

                    if (course.grade < minAverage) minAverage = course.grade
                    if (course.grade > maxAverage) maxAverage = course.grade
                }
            }
        }

        val averageOfAverages = sumOfAverages / totalStudents
        return Triple(minAverage, maxAverage, averageOfAverages)
    }
}