import java.io.BufferedReader;
import java.io.IOException;
import java.util.Formatter;

//класс Меню
public class Menu
{
    private String name;//Название блюда
    private int price;//Стоимость блюда
    private int weight;//Масса
    private String kind;//Вид (Постное/Кашерное/Диетическое)
    private String type;//Тип (Первое блюдо/Второе блюдо/Салат/Закуска/Напиток)

// конструктор класса, устанавливающий значения полей по умолчанию
    public Menu()
    {
        name = "None";
        price = 0;
        weight = 0;
        kind = "None";
        type = "None";
    }

// конструктор класса, копирующий поля из другого объекта Menu
    public Menu(Menu other)
    {
        name = other.name;
        price = other.price;
        weight = other.weight;
        kind = other.kind;
        type = other.type;
    }

// метод, создающий копию объекта Menu
    public Menu clone()
    {
        return new Menu(this);
    }

// метод, сравнивающий два объекта Menu на равенство значений их полей
    public boolean equal(Menu other)
    {
        return (name.equals(other.name) &&
                price == other.price &&
                weight == other.weight &&
                kind.equals(other.kind) &&
                type.equals(other.type));
    }

// метод для чтения информации о блюде из файла, переданного как BufferedReader
    public void readingFile(BufferedReader reader) throws IOException
    {
        String line = reader.readLine();// читаем первую строку файла
        String[] fields = line.split(", "); // разделяем её на поля

        name = fields[0];// первое поле - название блюда
        price = Integer.parseInt(fields[1]);// второе поле - стоимость блюда
        weight = Integer.parseInt(fields[2]);// третье поле - масса блюда
        kind = fields[3];// четвёртое поле - вид блюда
        type = fields[4];// пятое поле - тип блюда
    }

// метод для вывода информации о блюде в виде одной строки в консоль
    public void writeElement()
    {
        System.out.println( name + ", " +
                            price + ", " +
                            weight + ", " +
                            kind + ", " +
                            type);
    }
// метод для вывода информации о блюде в виде таблицы, форматированной с помощью объекта Formatter
    public void writeTable(Formatter formatter)
    {
        formatter.format("%-50s Стоимость: %-10d гр:%-10d %-15s %s\n", name, price, weight, kind, type);
    }
}
