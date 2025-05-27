public class StudentDemo {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        
        try {
            // 1. Insert a new student
            Student newStudent = new Student("Alice Johnson", 19, "A");
            int id = studentDAO.insertStudent(newStudent);
            if (id > 0) {
                System.out.println("New student added with ID: " + id);
            }
            
            // 2. Update the student
            newStudent.setAge(20);
            newStudent.setGrade("A+");
            if (studentDAO.updateStudent(newStudent)) {
                System.out.println("Student updated successfully!");
            }
            
            // 3. Get all students
            System.out.println("\nAll Students:");
            List<Student> students = studentDAO.getAllStudents();
            students.forEach(System.out::println);
            
            // 4. Get a specific student
            Student student = studentDAO.getStudentById(id);
            if (student != null) {
                System.out.println("\nStudent with ID " + id + ":");
                System.out.println(student);
            }
            
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
