package main;

public class ModifiersDemo {

    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person("Aslan");
        Person p3 = new Person(25);
        Person p4 = new Person("Test", 30);

        p1.publicMethod();
        p1.protectedMethod();
        p1.defaultMethod();

        p1.methodWithFinalParam(10);

        System.out.println(Person.counter);
    }
}

class Person {

    public String name;
    private int age;
    protected double salary;
    String city;

    static int counter = 0;

    public void publicMethod() {
        System.out.println("PUBLIC");
    }

    private void privateMethod() {
        System.out.println("PRIVATE");
    }

    protected void protectedMethod() {
        System.out.println("PROTECTED");
    }

    void defaultMethod() {
        System.out.println("DEFAULT");
    }

    public Person() {
        counter++;
    }

    public Person(String name) {
        this.name = name;
        counter++;
    }

    public Person(int age) {
        this.age = age;
        counter++;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        counter++;
    }

    public void methodWithFinalParam(final int a) {
        System.out.println(a);
    }
}
