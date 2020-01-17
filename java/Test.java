//import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Test {

    private List<String[]> list;
    private int column;

    //@Before
    public void before() {
        list = new ArrayList<>();
        column = 0;
    }

    //@org.junit.Test
    public void test() {

        list.add(new String[]{"111хх25dddd03", "111хх25dddd034s", "111хх25dddd03", null, "юю", "12341fdas", "0", "22", " ", "23", "sa", "123zxfde143", "12341fda", " ", null, "", "sf234", "fsdfs23"}); // <-- unsorted
        //list.add(new String[]{null, null, "", " ", " ", "0", "22", "23", "111хх25dddd03", "111хх25dddd03", "111хх25dddd034s", "123zxfde143", "12341fda", "12341fdas", "fsdfs23", "sa", "sf234", "юю"}); // <-- sorted
        output(list, column);

        list.set(column, Task1Impl.getInstance().sort(list, column));
        output(list, column);
    }

    public static void output(List<String[]> list, int column) {
        System.out.println("\n" + Arrays.toString(list.get(column)));
    }


    public static void main(String[] args) {
        Test test = new Test();
        test.before();
        test.test();

    }



}
