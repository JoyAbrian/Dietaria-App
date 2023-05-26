package dietaria.dao;

import dietaria.models.makanan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class makananDao {
    private static final String FILE_PATH = "dao/makanan_data.txt";

    public void saveMakanan(makanan makanan) {
        List<makanan> makananList = loadMakananList();
        makananList.add(makanan);
        saveMakananList(makananList);
    }

    public List<makanan> getAllMakanan() {
        return loadMakananList();
    }

    private List<makanan> loadMakananList() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<makanan>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    private void saveMakananList(List<makanan> makananList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(makananList);
        } catch (IOException e) {
            System.out.println("Error saving makanan data: " + e.getMessage());
        }
    }
}
