import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class EmptyListException extends Exception {
  public EmptyListException(String message) {
    super("From Empty List Exception" + message);
  }
}

class InvalidInputException extends NumberFormatException {
  public InvalidInputException(String message) {
    super("From InvalidInputException " + message);
  }
}

class ListUtil implements Comparator<Number> {
  void ListSort(List list) {
    List<Number> sorted = new ArrayList<>(data);

        // Sort manual
        Collections.sort(sorted, new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                double a = o1.doubleValue();
                double b = o2.doubleValue();
                if (a < b)
                    return -1;
                if (a > b)
                    return 1;
                return 0;
            }
        });
  }

}

class CLIUtil {

  Number getNumber(Number value) throws InvalidInputException {
       if (Double.parseDouble(value) * 0 ) {
            throw new InvalidInputException("Bukan angka");
        } 
    }
}

class StatisticList<T extends Number> {
    private List<T> data = new ArrayList<>();

    void add(T value) {
        data.add(value);
    }
    double getAverage() throws EmptyListException {
        if (data.isEmpty()) {
            throw new EmptyListException("Kosong");
        }

        double jumlah = 0.0;

        for (T value : data) {
            jumlah += value.doubleValue();
        }

        return jumlah / data.size();
    }

    T getMax() throws EmptyListException{
      if (data.isEmpty()) {
        throw new EmptyListException("Kosong");
      }

      T max; 
      for (T value: data) {
        max = (T) Math.max(max, value.doubleValue());
      }

      return max;
    }

    T getMin() throws EmptyListException {
      if (data.isEmpty()) {
        throw new EmptyListException("Kosong");
      }

      T min = 0;
      for (T value: data) {
        min = Math.min(min, value.doubleValue());
      }

      return min;
    }
    
    double getMedian() {
      
      for (T t : data) {
        
      }
    }
  }

public class App {
  Scanner scanner = new Scanner(System.in);

  public void menu() {

    StatisticList<Integer> daftar = new StatisticList<>();
    while (true) {
      System.out.println("\n=== MENU ===");
      System.out.println("1. Tambah angka");
      System.out.println("2. Tampilkan Rata-Rata");
      System.out.println("3. Tampilkan Nilai Maksimum");
      System.out.println("4. Tampilkan Nilai Minimum");
      System.out.println("5. Tampilkan Median");
      System.out.println("6. Tampilkan daftar");
      System.out.println("7. Keluar");
      System.out.print("Pilihan: ");

      int pilihan = scanner.nextInt();

      switch (pilihan) {
        case 1:
          while (true) {
            System.out.print("Masukkan angka positif (atau ketik 'stop'): ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("stop"))
              break;

            try {
              int value = Integer.parseInt(input);
              daftar.add(value);
            } catch (InvalidInputException e) {
              System.out.println("Input bukan angka.");
            }
          }
          break;
        case 2:
          try {
            daftar.getAverage();
          } catch(EmptyListException e) {
            System.out.println("Daftar kosong");
          }
          break;
        case 3:
          System.out.println("Program selesai.");
          return;
        default:
          System.out.println("Pilihan tidak valid.");
      }
    }
  }

  public void tambahAngka() {

  }

}