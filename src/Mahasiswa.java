public class Mahasiswa {


    int NIM;



    String nama;
    String programStudi;
    int semester;
    double IPK;
    public String getNama() {
        return nama;
    }


    public Mahasiswa(int NIM, String nama, String programStudi, int semester, double IPK) {
        this.NIM = NIM;
        this.nama = nama;
        this.programStudi = programStudi;
        this.semester = semester;
        this.IPK = IPK;
    }
    public int getNIM() {
        return NIM;
    }
    @Override
    public String toString() {
        return "Mahasiswa{" +
                "NIM=" + NIM +
                ", nama='" + nama + '\'' +
                ", programStudi='" + programStudi + '\'' +
                ", semester=" + semester +
                ", IPK=" + IPK +
                '}';
    }
}
