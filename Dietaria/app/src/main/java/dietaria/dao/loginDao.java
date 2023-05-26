package dietaria.dao;

import dietaria.models.login;

import java.io.*;

public class loginDao {
    private static final String FILE_PATH = "dao/login_data.txt";

    public void saveLogin(login user) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(user);
            System.out.println("Login data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving login data: " + e.getMessage());
        }
    }

    public login loadLogin() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            login user = (login) ois.readObject();
            System.out.println("Login data loaded successfully.");
            return user;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading login data: " + e.getMessage());
        }
        return null;
    }
}