import java.util.Arrays;
import java.util.Scanner;


class Lake {
    String name,location;
    double square;

    public String toString() {
        return "Lake{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", square=" + square +
                '}';
    }
}

public class vv10 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество озёр=> ");
        int n = sc.nextInt();    // количество озер Lake []=new Lake[n];
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
        System.out.println("\nОзеро с максимальной площадью:");
        // для поиска наибольшего озера
        if(lakes!=null){
            double plowad=0;
            int index=0;
            for(int i=0;i <lakes.length;i++){

                if(lakes[i].square>plowad){
                    plowad= lakes[i].square;
                    index=i;
                }

            }
            System.out.println(lakes[index].name);
        }
        else{
            System.out.println("Ваш массив пуст");}

        //Находим количество озёр с площадью меньше чем средняя
        System.out.println("\nКоличество озёр с площадью меньше средней:");

        double size=0;
        for(Lake lake:lakes){
            size+=lake.square;

        }
        int count = 0;

        for (Lake lake : lakes) {
            if (size/ lakes.length >= lake.square) {
                count++;
            }

        }
         System.out.println(count);

        //Сортируем по имени
        System.out.println("\nОтсортированый массив по имени:");
//Внешний цикл
        for (int i = 0; i < lakes.length-1; i++)
            //Внутренний цикл
            for (int j = 0; j < lakes.length-i-1; j++)
                if(lakes [j].name.compareTo(lakes[j+1].name)>0){

                    Lake lake=lakes[j];	//lake – рабочая переменная для перестановки
                    lakes[j]=lakes[j+1];
                    lakes[j+1]=lake;
                }
        // Вывод уже отсортированого массива
        System.out.println( Arrays.toString(lakes));
        // поиск Озера по имени
        System.out.println("\nПОИСК	Озера \n Введите название озера => ");
        sc.nextLine();
        String check=sc.nextLine();
        int num=-1;	// -1 – озеро с искомым названием отсутствует
        for (int i = 0; i < lakes.length; i++) if (check.equalsIgnoreCase(lakes[i].name))
            num=i;
        if (num!= -1) {


            System.out.println("Информация про озеро с этим именем:"+lakes[num].toString());
        }else {
            System.out.println("такое озеро отсутствует");
        }
          Lake lak=lakes[0];
        //Задаем новую локацию
        System.out.println("Введите новую локацию для озера "+lak.name +"->");

        lak.location=sc.nextLine();
        System.out.println("Озеро после изменения:");
        System.out.println("" + lak.name +  " \t" +lak.location+ " \t" + lak.square + " кв. км");

        sc.close();
    }
}