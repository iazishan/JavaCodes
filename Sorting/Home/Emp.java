public class Emp {

    public int[] arr;

    class emp {

        int reg_no;
        String name;
        String cgpa;

        emp(int reg_no, String name, String cgpa) {

            this.reg_no = reg_no;
            this.name = name;
            this.cgpa = cgpa;

        }
    }

    public void addEmployee(Emp val) {
        if (arr == null) {
            arr = new int[100];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = -1;
            }
        }
    }
}
