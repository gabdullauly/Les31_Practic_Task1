/*
Create a User class with parameters:
- int id
- String login
- String password
-String name
-String surname
+ User ()
+ User (int id, login, passwor, name, surname) Getters and Setters
+ String getData () // This method returns all user data

Создать меню
1- создать User(Добавить в массив)
2- Посмотреть список всех
3- Удалить весь список
4- Выйти из программы
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<User> users = new ArrayList<>();
    public static void createUser(){
        System.out.println("---------------------");
        System.out.println("Меню создания пользователя: ");
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
            User user = new User();
            user.setId(id);
            user.setLogin(login);
            user.setPassword(password);
            user.setName(name);
            user.setSurname(surname);
            users.add(user);
            System.out.println("Пользователь успешно создан!");
        }else {
            System.out.println("Ошибка сервера");
        }
    }
    public static void showAllList(){
        System.out.println("Список пользователей: ");
        for (int i=0; i<users.size(); i++){
            System.out.println(users.get(i).getData());
        }
    }
    public static void deleteAllUser(){
        users.clear();
        System.out.println("Пользователи успешно удалены!");
    }
    public static void deleteUserById(){
        showAllList();
        System.out.print("Введите id пользователя которого хотите удалить: ");
        Integer id = scan.nextInt();
        for (int i=0; i< users.size(); i++){
            if (users.get(i).getId()==id){
                users.remove(users.get(i));
                System.out.println("Пользователь с id: "+id+" успешно удален!");
            }else {
                System.out.println("Пользователь с таким id: "+id+" не найден!");
            }
        }
    }
    public static User getUserById(Integer id){
        for (int i=0; i< users.size(); i++){
            if (users.get(i).getId()==id){
                return users.get(i);
            }
        }
        return null;
    }
    public static void editUserById(){
        showAllList();
        System.out.print("Введите id пользователя которого хотите редактировать: ");
        Integer id = scan.nextInt();
        User user = getUserById(id);
        if (id==null){

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
                System.out.println("Пользователь с id: "+id+" успешно изменен");
            }else {
                System.out.println("Ошибка сервера");
            }
        }else {
            System.out.println("Пользователь с id: "+id+" не найден");
        }
    }
    public static void main(String[] args) {
        while (true){
            System.out.println("-------------");
            System.out.println("Основное меню:");
            System.out.println("1 - Создать пользователя");
            System.out.println("2 - Показать список всех пользователей");
            System.out.println("3 - Удалить весь список пользователей");
            System.out.println("4 - Удалить пользователя по его id");
            System.out.println("5 - Изменить данные пользователя по его id");
            System.out.println("6 - Выход с программы");
            System.out.print("Выберите действие: ");
            int choice = scan.nextInt();
            if (choice==1){
                createUser();
            }
            if (choice==2){
                showAllList();
            }
            if (choice==3){
                deleteAllUser();
            }
            if (choice==4){
                deleteUserById();
            }
            if (choice==5){
                editUserById();
            }
            if (choice==6){
                System.out.println("Программа завершена успешно!");
                break;
            }
        }
    }
}