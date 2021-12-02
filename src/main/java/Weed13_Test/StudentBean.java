package Weed13_Test;

public class StudentBean {
    private String name;
    private int age;
    private String gender;
    private int[] result;

    public StudentBean(String Name, int Age, String Gender, int[] Result) {
        name = Name;
        age = Age;
        gender = Gender;
        result = Result;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int[] getResult() {
        return result;
    }
}
