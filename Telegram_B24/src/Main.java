import front.OpenGroupDto;
import front.UserDto;
import model.Group;
import model.User;
import service.OpenGroupServise;
import service.PersonalChatService;
import service.UserService;

import java.util.Scanner;

public class Main {
    static Scanner kiritishInt = new Scanner(System.in);
    static Scanner kiritishStr = new Scanner(System.in);
    static UserService userService = new UserService();
    static OpenGroupServise openGroupServise = new OpenGroupServise();

    public static void main(String[] args) {


        int var = 10;

        while (var != 0) {
            System.out.println("1.Registration 2.Menu  0. Exit");
            var = kiritishInt.nextInt();
            switch (var) {
                case 1 -> {
                    int var1 = 10;
                    int var2;
                    while (var1 != 0) {
                        System.out.println("1.add Person  2.add OpenGroup    3.add Canal  0.Exit");
                        var1 = kiritishStr.nextInt();
                        var2 = var1;
                        switch (var2) {
                            case 1 -> System.out.println(UserDto.addUser(kiritishStr, userService));
                            case 2 -> {
                                System.out.println(OpenGroupDto.addGroup(kiritishStr, openGroupServise));
                            }
                        }
                    }
                }
                case 2 -> menu();
            }
        }
        System.out.println(userService);
    }

    public static void menu() {
        int var1;
        int var2 = 10;
        while (var2 != 0) {
            System.out.println("1.shaxsiy chat     2.guruh        3.kanal      4.search      0.exit");
            var1 = kiritishInt.nextInt();
            var2 = var1;
            while (var1 != 0) {
                switch (var1) {
                    case 1 -> {
                        while (var1 != 0) {
                            System.out.println("======shaxsiy chat======");
                            userService.showlistOnePerson();
                            var1 = kiritishInt.nextInt();
                            if (var1 != 0) {
                                User currentUser = userService.getUserInService(var1);
                                System.out.println("----> " + currentUser.getName()+" <------");
                                PersonalChatService personalChatService = new PersonalChatService();
                                personalChatService.chatWithMe(currentUser, kiritishStr);
                            }
                        }
                    }
                    case 2 -> {
                        System.out.println("=======Guruh======");
                        openGroupServise.showGroup();
                        var1 = kiritishStr.nextInt();
                        if (var1 != 0) {
                            Group currentGroup = openGroupServise.getgroupInService(var1);
                            System.out.println("----> " + currentGroup.getName()+" <----");
                            PersonalChatService personalChatService = new PersonalChatService();
                            personalChatService.chatwithGroup(currentGroup, userService, openGroupServise);
                        }
                    }
                    case 3 -> {
                        System.out.println("=========kanal=========");
                        //ro'yhatlar  list
                    }
                    case 4 -> {
                        System.out.println("========search======");
                        System.out.println("enter new  person's  username :");
                        String s2=kiritishStr.next();
                        User[] searcheUser= userService.getSearcheUser();
                        boolean isHave=false;
                        for (int i = 0; i < searcheUser.length; i++) {
                            if (searcheUser[i].getUsername().equals(s2))
                            {
                                isHave=true;
                                System.out.println("Found !!!");
                                System.out.println("Will  you add  this  person ?");
                                System.out.println("1. Add    0.Exit");
                                int a= kiritishStr.nextInt();
                                if (a==1)
                                {
                                    System.out.println(userService.addUsertoRegistrion(searcheUser[i]));
                                    break;
                                }
                            }
                        }
                        if (!isHave ) {
                            System.out.println("Not  found !!!");
                        }
                    }
                }
                var1 = 0;
            }
        }
    }
}