package dietaria.dao;

import dietaria.models.totalNutrisi;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class TotalNutrisiDAO {
    private Map<LocalDate, totalNutrisi> totalNutrisiMap;

    public TotalNutrisiDAO() {
        this.totalNutrisiMap = new HashMap<>();
    }

    public totalNutrisi getTotalNutrisiByDate(LocalDate date) {
        return totalNutrisiMap.get(date);
    }

    public void addTotalNutrisi(totalNutrisi totalNutrisi, LocalDate date) {
        totalNutrisiMap.put(date, totalNutrisi);
    }

    public void removeTotalNutrisi(LocalDate date) {
        totalNutrisiMap.remove(date);
    }

    public void resetTotalNutrisi() {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        if (currentTime.isBefore(LocalTime.MIDNIGHT)) {
            LocalDate previousDate = currentDate.minusDays(1);
            totalNutrisiMap.remove(previousDate);
        }
    }
}
