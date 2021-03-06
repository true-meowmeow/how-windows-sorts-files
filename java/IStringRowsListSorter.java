import java.util.List;

/**
 * Интерфейс механизма «умной» сортировки.
 */
public interface IStringRowsListSorter {

    /**
     * Сортирует переданный список записей (каждая запись - набор колонок) таблицы по указанной колонке по следующим правилам:
     * <ul>
     *  <li>в колонке могут быть null и пустые значения - строки с null-значениями должны быть первыми, затем строки с пустым значением, затем все остальные,</li>
     *  <li>строка бьется на подстроки следующим образом: выделяем непрерывные максимальные фрагменты строки, состоящие только из цифр, и считаем набором подстрок эти фрагменты и все оставшиеся от такого разбиения фрагменты строки</li>
     *  <li>при сравнении строк осуществляется последовательное сравнение их подстрок до первого несовпадения,</li>
     *  <li>если обе подстроки состоят из цифр - то при сравнении они интерпретируются как целые числа (вначале должно идти меньшее число), в противном случае - как строки,</li>
     *  <li>сортировка должна быть устойчива к исходной сортировке списка - т.е., если строки (в контексте указанных правил сравнения) неразличимы, то сортировка не должна менять их местами.</li>
     * </ul>
     *
     * @param rows список записей таблицы (например, результат sql select), которые нужно отсортировать по указанной колонке
     * @param columnIndex индекс колонки, по которой нужно провести сортировку
     */
    String[] sort(List<String[]> rows, int columnIndex);
}



/*

    мне кажется, что я не могу до конца понять ваше задание
    Выполняя его я ориентировался на эти два ответа:
        https://www.sql.ru/forum/actualutils.aspx?action=gotomsg&tid=1227811&msg=19577375
        https://www.sql.ru/forum/actualutils.aspx?action=gotomsg&tid=1227811&msg=19577526
    пожалуйста, дайте обратную связь по поводу ожидаемого вывода
    также я изменил тип возвращаемых данных в интерфейсе
*/

