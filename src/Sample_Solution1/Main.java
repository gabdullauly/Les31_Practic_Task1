/*
Создать меню
1- создать User(Добавить в массив)
2- Посмотреть список всех
3- Удалить весь список
4- Удалить пользователя по его id;
5- Изменить данные пользователя по его id;
6- Выйти из программы
 */

package Sample_Solution1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<User> users = new ArrayList<>();
    public static void createUser(){
        System.out.print("Введите id: ");
        Integer id = scan.nextInt();
        System.out.print("Введите login: ");
        String login = scan.next();
        System.out.print("Введите password: ");
        String password = scan.next();
        System.out.print("Введите name: ");
        String name = scan.next();
        System.out.print("Введите surname: ");
        String surname = scan.next();
        if (id!=null && !login.trim().isEmpty() && !password.trim().isEmpty() && !name.trim().isEmpty() && !surname.trim().isEmpty()){
            User user = new User(id, login, password, name, surname);
            users.add(user);
            System.out.println("Пользователь успешно создан!");
        }
    }
    public static void shouListUsers(){
        System.out.println("Список пользователей: ");
        for (User users: users){
            System.out.println(users.getData());
        }
    }
    public static void deleteAllUsers(){
        users.clear();
        System.out.println("Все пользователи успешно удалены!");
    }
    public static User getUserById(Integer id){
        for (int i=0; i< users.size(); i++){
            if (id == users.get(i).getId()){
                return users.get(i);
            }
        }
        return null;
    }
    public static void deleteUserById(){
        shouListUsers();
        System.out.print("Выберите id для удаления пользователя: ");
        Integer id = scan.nextInt();
        if (id!=null){
            users.remove(getUserById(id));
            System.out.println("Пользователь с id: "+id+" успешно удален!");
        }
    }
    public static void editUserById(){
        shouListUsers();
        System.out.print("Выберите id для изменения пользователя: ");
        Integer id = scan.nextInt();
        User user = getUserById(id);
        if (user!=null){
            System.out.print("Введите login: ");
            String login = scan.next();
            System.out.print("Введите password: ");
            String password = scan.next();
            System.out.print("Введите name: ");
            String name = scan.next();
            System.out.print("Введите surname: ");
            String surname = scan.next();
            if (!login.trim().isEmpty() && !password.trim().isEmpty() && !name.trim().isEmpty() && !surname.trim().isEmpty()){
                user.setLogin(login);
                user.setPassword(password);
                user.setName(name);
                user.setSurname(surname);
                System.out.println("Пользователь с id: "+id+" успешно изменен!");
            }
        }
    }
    public static void main(String[] args) {
        while (true){
            System.out.println("------------------");
            System.out.println("Основное меню:");
            System.out.println("1 - Создать пользователя");
            System.out.println("2 - Показать список пользователей");
            System.out.println("3 - Удалить весь список пользователей");
            System.out.println("4 - Удалить пользователя по его id");
            System.out.println("5 - Изменить данные пользователя по его id");
            System.out.println("6 - Выход из программы");
            System.out.print("Выберите действие: ");
            int choice = scan.nextInt();
            if (choice == 1){
                createUser();
            }
            if (choice == 2){
                shouListUsers();
            }
            if (choice == 3){
                deleteAllUsers();
            }
            if (choice == 4){
                deleteUserById();
            }
            if (choice == 5){
                editUserById();
            }
            if (choice == 6){
                System.out.println("Программа успешно завершена");
                break;
            }
        }
    }
}
