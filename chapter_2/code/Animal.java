
public class Animal {
    public String animalName = "null";
    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }
    public String getAnimalName() {
        return animalName;
    }
    public boolean isAnimalNameSet() {
        if(getAnimalName() == "notset") {
            return false;
    } else {
        return true;
    }
}

public static void main(String[] args) {
    Animal obj = new Animal();
    boolean flag = false;
    obj.setAnimalName("dog");
    flag = obj.isAnimalNameSet();
    System.out.println(flag);
    obj.setAnimalName("notset");
    flag = obj.isAnimalNameSet();
    System.out.println(flag);
    }
}

