import java.util.Arrays;
import java.util.Scanner;

class Lake {
    String name, location;
    double square;


    public String toString() {
        return "Lake{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", square=" + square +
                '}';
    }
}

public class v10 {
    //Добавляем наши обьекты в массив
    public static Lake[] setLakeArr(int n) {
        Scanner sc = new Scanner(System.in);
        Lake[] lakes = new Lake[n];

        for (int i = 0; i < lakes.length; i++) {

            lakes[i] = new Lake();
            System.out.print("Название " + (i + 1) + "-ого озера => ");
            lakes[i].name = sc.next();
            System.out.print("Локация  " + (i + 1) + "-ого озера => ");
            lakes[i].location = sc.next();
            System.out.print("Площадь " + (i + 1) + "-ого озера => ");
            lakes[i].square = sc.nextDouble();

        }
        return lakes;
    }

    //Метод для поиска наибольшего озера
    static public Lake theBiggestLake(Lake[] array) {

        if (array != null) {
            double plowad = 0;
            int index = 0;
            for (int i = 0; i < array.length; i++) {

                if (array[i].square > plowad) {
                    plowad = array[i].square;
                    index = i;
                }

            }
            return array[index];
        }
        System.out.println("Ваш массив пуст");
        return null;
    }

    //находим среднее значение площади
    static public double averageSize(Lake[] array) {

        double size = 0;
        for (Lake lake : array) {
            size += lake.square;

        }

        return size / array.length;
    }

    //находим озера с меньшой площадью чем среднее значение
    static public int lowerAvg(Lake[] array) {
        int count = 0;
        for (Lake lake : array) {
            if (averageSize(array) >= lake.square) {
                count++;
            }
        }

        return count;
    }

    //Сортировка по названию
    static public void sortByName(Lake[] array) {
        //Внешний цикл
        for (int i = 0; i < array.length - 1; i++)
            //Внутренний цикл
            for (int j = 0; j < array.length - i - 1; j++)
                if (array[j].name.compareTo(array[j + 1].name) > 0) {

                    Lake lake = array[j];    //lake – рабочая переменная для перестановки
                    array[j] = array[j + 1];
                    array[j + 1] = lake;
                }
        // Вывод уже отсортированого массива
        System.out.println("\nОтсортированный список по названиям:" + Arrays.toString(array));

    }

    //Поиск по названию
    static public Lake findForName(Lake lakes[], String name) {
        int n = -1;    // -1 – озеро с искомым названием отсутствует
        for (int i = 0; i < lakes.length; i++)
            if (name.equalsIgnoreCase(lakes[i].name))
                n = i;
        if (n != -1) {
            return lakes[n];
        } else
            return null;

    }

    //Меняем  площадь в нашем обьекте
    static public void setSquare(Lake lake, double sqr) {
        lake.square = sqr;
        System.out.println("Озеро после изменения:");
        System.out.println("" + lake.name + " \t" + lake.location + " \t" + lake.square + " кв. км");

    }
    //Меняем  локацию в нашем обьекте
    static public void setLocation(Lake lake, String loc) {
        lake.location = loc;
        System.out.println("Озеро после изменения:");
        System.out.println("" + lake.name + " \t" + lake.location + " \t" + lake.square + " кв. км");

    }
    //Меняем  имя в нашем обьекте
    static public void setName(Lake lake, String name) {
        lake.name = name;
        System.out.println("Озеро после изменения:");
        System.out.println("" + lake.name + " \t" + lake.location + " \t" + lake.square + " кв. км");

    }

    //Выводим массив
    public static void showArray(Lake[] array) {    // ВЫВОД МАССИВА
        for (int i = 0; i < array.length; i++) {
            System.out.println("" + array[i].name + " \t" + array[i].location + " \t" + array[i].square + "  кв. км");
        }
    }
    //выводим обьект

    public static void showLake(Lake lake) {    // ВЫВОД Ozera

        System.out.println("" + lake.name + " \t" + lake.location + " \t" + lake.square + "  кв. км");

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество озёр=> ");
        int n = sc.nextInt();    // количество стран Lake []=new Lake[n];
        //Добавляем наши озера в массив
        Lake[] lakes = setLakeArr(n);
        //Находим самое боьшое озеро
        System.out.println("\nОзеро с максимальной площадью:");
        System.out.println(theBiggestLake(lakes).name);
        //Находи количество озёр с площадью меньше чем средняя
        System.out.println("\nКоличество озёр с площадью меньше средней:");
        System.out.println(lowerAvg(lakes));
        //Сортируем по имени
        System.out.println("\nОтсортированый массив по имени:");
        sortByName(lakes);
        // поиск Озера по имени
        System.out.println("\nПОИСК	Озера \n Введите название озера => ");
        sc.nextLine();
        String sname = sc.nextLine();
        Lake sfind = findForName(lakes, sname);
        if (sfind != null) {
            showLake(sfind);
        } else {
            System.out.println("Такой страны нет в списке!");
        }

        //Задаем новую локацию
        System.out.println("Введите новую локацию для озера " + sfind);
        setLocation(sfind, sc.nextLine());
        //Задаем новую площадь
        System.out.println("Введите новую площадь для озера " + sfind);
        setSquare(sfind, sc.nextDouble());
        sc.close();
    }
}
