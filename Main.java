import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Formatter;

public class Main //объявление класса
{
    public static void main(String[] args)
    {
        //Объявление и инициализация массива объектов класса Menu
        //Создает массив из 50 объектов класса Menu
        Menu[] restaurantmenu = new Menu[50];

        try
        {
        //Чтение данных из файла
        //Создается объект FileReader, который открывает файл для чтения, и передается в конструктор BufferedReader.
        //В цикле читаются данные из файла и сохраняются в каждом элементе массива restaurantmenu.

            FileReader fileReader = new FileReader("D:\\УНИВЕР\\II курс\\ASDC\\Lab0\\src\\menu.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for(int i = 0; i < restaurantmenu.length; i++)
            {
                restaurantmenu[i] = new Menu();
                restaurantmenu[i].readingFile(bufferedReader);
            }

        //Форматированный вывод
            Formatter form = new Formatter(System.out);
            for(int i = 0; i < restaurantmenu.length; i++)
            {
                restaurantmenu[i].writeTable(form);
            }
        //Закрытие файла с помощью метода close() объекта BufferedReader
            bufferedReader.close();
        }

        //Обработка исключений
        catch (IOException e)
        {
            System.out.println("Error " + e.getMessage());
        }
    }
}