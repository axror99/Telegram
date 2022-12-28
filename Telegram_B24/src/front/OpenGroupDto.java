package front;

import model.Group;
import service.OpenGroupServise;

import java.util.Scanner;

public class OpenGroupDto {
    public static boolean addGroup(Scanner scanner, OpenGroupServise openGroupServise) {
        String name1= scanner.nextLine();
        System.out.println("enter Group's  name");
        String name = scanner.nextLine();
        System.out.println("enter Group's  link (username)");
        String link = scanner.next();
        Group group = new Group(name,link);
        return openGroupServise.addGroup(group);
    }
}
