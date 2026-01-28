package org.example


class Major(val name: String) {
    val students = mutableListOf<Student>()

    fun addStudent(student: Student) = students.add(student)

    fun stats(): Triple<Double, Double, Double> {
        var minAverage = Double.MAX_VALUE
        var maxAverage = Double.MIN_VALUE
        var sum = 0.0

        for (student in students) {
            val average = student.weightedAverage()
            sum += average

            if (average < minAverage) minAverage = average
            if (average > maxAverage) maxAverage = average
        }

        val studentsAverage = sum / students.size

        return Triple(minAverage, maxAverage, studentsAverage)
    }


    fun stats(courseName: String): Triple<Double, Double, Double> {
        var minGrade = Double.MAX_VALUE
        var maxGrade = Double.MIN_VALUE
        var sum = 0.0
        var totalStudents = 0.0

        for (student in students) {
            for (course in student.courses) {
                if (course.courseName == courseName) {
                    sum += course.grade
                    totalStudents += 1.0

                    if (course.grade < minGrade) minGrade = course.grade
                    if (course.grade > maxGrade) maxGrade = course.grade
                }
            }
        }

        val studentsAverage = sum / totalStudents
        return Triple(minGrade, maxGrade, studentsAverage)
    }
}