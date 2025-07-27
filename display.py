class Student:
    def __init__(self, name, age, grade):
        self.name = name
        self.age = age
        self.grade = grade

    def display(self):
        print(f"Displaying student information from : {self.__class__.__name__}")
        print(f"Name: {self.name}, Age: {self.age}, Grade: {self.grade}")


class School(Student):        
    def school_student_display(self):
        print(f"Displaying student information from : {self.__class__.__name__}")
        print(f"Name: {self.name}, Age: {self.age}, Grade: {self.grade}")
        
# Example usage
if __name__ == "__main__":
    student1 = Student("Ram", 19, "A")
    student1.display()
    
    school1 = School("Kavitha", 22, "B")
    school1.school_student_display()
    