package dietaria.dao;

import dietaria.models.aktivitas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class aktivitasDao {
    private static final String FILE_PATH = "dao/aktivitas_data.txt";

    public void saveAktivitas(aktivitas aktivitas) {
        List<aktivitas> aktivitasList = loadAktivitasList();
        aktivitasList.add(aktivitas);
        saveAktivitasList(aktivitasList);
    }

    public List<aktivitas> getAllAktivitas() {
        return loadAktivitasList();
    }

    private List<aktivitas> loadAktivitasList() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<aktivitas>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    private void saveAktivitasList(List<aktivitas> aktivitasList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(aktivitasList);
        } catch (IOException e) {
            System.out.println("Error saving aktivitas data: " + e.getMessage());
        }
    }
}
