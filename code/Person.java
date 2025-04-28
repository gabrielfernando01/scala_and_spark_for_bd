public class Person {
        private String name;
        private int age;

        public Person (String name, int age) {
            this.name = name;
            this.age = age;
        }
        public void showInfo() {
            System.out.println("Name: " + name + ", Age: " + age);
        }
        public static void main(String[] args) {
            Person person = new Person("Gabriel", 43);
            person.showInfo();
        }
}


