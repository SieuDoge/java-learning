package model;

import java.util.UUID;

public class Student {
    private String id;
    private String name;
    private int age;
    private double gpa;
    private String major;

    public Student(String name, int age, double gpa, String major) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.name = name;
        this.age = age;
        if (gpa < 0 || gpa > 4.0) {
            throw new IllegalArgumentException(
                    "GPA không được dưới 0.0 hoặc hơn 4.0"
            );
        }
        this.gpa = gpa;
        this.major = major;
    }

    public void setGpa(double gpa) {
        if (gpa < 0 || gpa > 4.0) throw new IllegalArgumentException("GPA không hợp lệ");
        this.gpa = gpa;
    }

    public String getId() {return id;}

    public String getName() {return name;}

    public double getGpa() {return gpa;}

    public String getMajor() {return major;}

    public int getAge() {return age;}

    public String toFileString(){
        return String.join(",", id, name, String.valueOf(age),
                String.valueOf(gpa), major);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s | %s | Age: %d | GPA: %.2f", id, name, major, age, gpa);
    }

    public static Student fromFileString(String line) {
        String[] parts = line.split(",");
        return new Student(parts[1],
                Integer.parseInt(parts[2]),
                Double.parseDouble(parts[3]),
                parts[4]);
    }
}
