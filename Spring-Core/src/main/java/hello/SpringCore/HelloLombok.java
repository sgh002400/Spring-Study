package hello.SpringCore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Getter
@Setter
@ToString
public class HelloLombok {
    private String name;
    private int age;



    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("Lazybear");


        String name = helloLombok.getName();
        System.out.println("name = " + name);

        System.out.println("helloLombok = " + helloLombok);
    }
}
