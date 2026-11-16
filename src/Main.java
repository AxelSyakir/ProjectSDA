import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static Mahasiswa[] mahasiswa =  new Mahasiswa[5];
    static void main() {
        ViewDisplay();
    }

    private static void ViewDisplay() {
        while (true) {
            Display();
            System.out.println("Enter your choice: ");
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Search");
            System.out.println("5. Exit");

            int option = scan.nextInt();
            switch (option) {
                case 1:
                    ViewInsert();
                    break;
                case 2:
                    ViewUpdate();
                    break;
                case 3:
                    ViewDelete();
                    break;
                case 4:
                    ViewSearch();
                    break;
                case 5:
                    scan.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private static void ViewDelete() {
        System.out.println("What would you like to delete? (Enter NIM)");
        int option = scan.nextInt();
        Delete(option);
    }

    private static void ViewSearch() {
        System.out.println("What would you like to search? (Enter NIM)");
        int option = scan.nextInt();
        Search(option);

    }

    private static void ViewUpdate() {
        System.out.println("What would you like to update? (Enter NIM)");
        int option = scan.nextInt();
        Update(option);
    }

    private static void ViewInsert() {
        System.out.println("Enter Data: NIM");
        int nim = scan.nextInt();
        System.out.println("Enter Data: Nama");
        String nama = scan.next();
        System.out.println("Enter Data: ProgramStudi");
        String programStudi = scan.next();
        System.out.println("Enter Data: Semester");
        int semester = scan.nextInt();
        System.out.println("Enter Data: IPK");
        int IPK = scan.nextInt();
        Mahasiswa inMahasiswa = new Mahasiswa(nim, nama, programStudi, semester, IPK);
        Insert(inMahasiswa);
    }

    private static void Insert(Mahasiswa inMahasiswa) {
        var isFull = true;
        for (int k = 0; k < mahasiswa.length; k++) {
            if (mahasiswa[k] == null) {
                isFull = false;
            }
        }
        //kalau tidak di add, kalau iya di besarkan model
        if (isFull) {
            Mahasiswa temp[] = new Mahasiswa[mahasiswa.length];
            for (int i = 0; i < mahasiswa.length; i++) {
                temp[i] = mahasiswa[i];
            }
            mahasiswa = new Mahasiswa[mahasiswa.length + 5];
            for (int l = 0; l < temp.length; l++) {
                mahasiswa[l] = temp[l];
            }
        }

        for (int j = 0; j < mahasiswa.length; j++) {
            if (mahasiswa[j] == null) {
                mahasiswa[j] = inMahasiswa;
                break;
            }
        }

    }


    private static void Update(int option) {
        boolean isFound = false;
        for (int k = 0; k < mahasiswa.length; k++) {
            if (mahasiswa[k] == null) break;
            else if (mahasiswa[k].getNIM() == option) {
                System.out.println("Enter Data: NIM");
                int nim = scan.nextInt();
                System.out.println("Enter Data: Nama");
                String nama = scan.next();
                System.out.println("Enter Data: ProgramStudi");
                String programStudi = scan.next();
                System.out.println("Enter Data: Semester");
                int semester = scan.nextInt();
                System.out.println("Enter Data: IPK");
                int IPK = scan.nextInt();
                mahasiswa[k] = new Mahasiswa(nim, nama, programStudi, semester, IPK);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Invalid option");
        }

    }

    private static void Delete(int option) {
        boolean isFound = false;
        for (int k = 0; k < mahasiswa.length; k++) {
            if (mahasiswa[k] == null) break;
            else if (mahasiswa[k].getNIM() == option) {
                for (int j = k; j < mahasiswa.length - 1; j++) {
                    mahasiswa[j] = mahasiswa[j + 1];
                }
                mahasiswa[mahasiswa.length - 1] = null;  // slot terakhir dikosongkan
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Invalid option");
        }
    }
    private static void Search(int option) {
        boolean isFound = false;
        for (int k = 0; k < mahasiswa.length; k++) {
            if (mahasiswa[k] == null) break;
            else if (mahasiswa[k].getNIM() == option) {
                System.out.println(mahasiswa[k].toString());
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Invalid option");
        }
    }

    private static void Display() {
        System.out.println("MAHASISWA: ");
        for (int i = 0; i< mahasiswa.length; i++) {
            int numb = i+1;
            if (mahasiswa[i] != null) {
                System.out.println(numb + ". " + mahasiswa[i].toString());
            }
        }
    }
}
