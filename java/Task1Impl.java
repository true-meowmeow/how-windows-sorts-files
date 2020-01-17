import java.util.List;

/**
 * <h1>Задание №1</h1>
 * Реализуйте интерфейс {@link IStringRowsListSorter}.
 *
 * <p>Мы будем обращать внимание в первую очередь на структуру кода и владение стандартными средствами java.</p>
 */
public class Task1Impl implements IStringRowsListSorter {

    // ваша реализация должна работать, как singleton. даже при использовании из нескольких потоков.
    public static final IStringRowsListSorter INSTANCE = new Task1Impl();

    private Task1Impl() {}

    public static IStringRowsListSorter getInstance() {
        return INSTANCE;
    }


    @Override
    public String[] sort(final List<String[]> rows, final int columnIndex) {
        synchronized (Task1Impl.class) {
            return insertSort(rows, columnIndex);
        }
    }


    private String[] insertSort(final List<String[]> rows, final int columnIndex) {
        String[] array = rows.get(columnIndex);

        for (int i = 0; i < rows.get(columnIndex).length; i++) {
            String newElement = rows.get(columnIndex)[i];
            int location = i - 1;
            while (location >= 0 && logic(array[location], newElement) > 0) {
                array[location + 1] = array[location];
                location--;
            }
            array[location + 1] = newElement;
        }
        return array;
    }


    private int logic(String s1, String s2) {
        if (s1 == null) return -1; //если null -> двигаем влево
        if (s2 == null) return 1;
        if (s1.equals("")) return -1; //если нет знака -> двигаем влево, но не так же далеко как null, поэтому они в разных условиях
        if (s2.equals("")) return 1;
        if (s1.equals(s2)) return 0; //если они равны, то нет смысла что-то делать


        int iteration = 0;
        int i;
        while (((i = compare(s1, s2, iteration)) == 0)) {
            iteration++;
        }
        return i;
    }


    private int compare(String s1, String s2, int iteration) {

        s1 = substring(s1, iteration);
        s2 = substring(s2, iteration);

        try {
            return Integer.compare(Integer.parseInt(s1), Integer.parseInt(s2));
        } catch (Exception ignored) {
            return s1.compareTo(s2);
        }
    }

    //получает сравниваемую часть по слову и по её номеру
    private StringBuilder stringBuilder = new StringBuilder();
    private String substring(String s, int iteration) {
        boolean firstCharIsNumber = isNumber(s.charAt(0));
        stringBuilder.setLength(0);
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (isNumber(s.charAt(j)) && !firstCharIsNumber) {
                firstCharIsNumber = true;
                i++;
            } else if (!isNumber(s.charAt(j)) && firstCharIsNumber) {
                firstCharIsNumber = false;
                i++;
            }
            if (i == iteration) {
                stringBuilder.append(s.charAt(j));
            }
            if (i > iteration) return stringBuilder.toString();
        }
        return stringBuilder.toString();
    }

    private boolean isNumber(char c) {
        try {
            Integer.parseInt(String.valueOf(c));
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }
}
