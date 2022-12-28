package front;

import model.User;
import service.UserService;

import java.util.Scanner;

public class UserDto {

        public static boolean addUser(Scanner scanner, UserService userService){
            User user = new User();
            String name2= scanner.nextLine();
            System.out.println("enter name");
            user.setName(scanner.nextLine());
            System.out.println("enter username");
            user.setUsername(scanner.next());

            return userService.addUsertoRegistrion(user);
       }
//       public static void addUserForGroup(Scanner scanner, UserService userService)
//       {
//           User user=new User();
//           System.out.println("enter  name");
//           user.setName(scanner.nextLine());
//           System.out.println("enter  username");
//       }
}

