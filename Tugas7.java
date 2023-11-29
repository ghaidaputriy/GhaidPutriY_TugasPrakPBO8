import java.util.ArrayList;
import java.util.Scanner;

class DetailPembelian {
    String kodBrg;
    String namaBrg;
    double hrgBrg;
    int jmlhBeli;

    public DetailPembelian(String kodBrg, String namaBrg, double hrgBrg, int jmlhBeli) {
        this.kodBrg = kodBrg;
        this.namaBrg = namaBrg;
        this.hrgBrg = hrgBrg;
        this.jmlhBeli = jmlhBeli;
    }
}
public class Tugas7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         System.out.print("Masukkan total barang: ");
        int totalBrg = scanner.nextInt();

        String[] kodBrg = new String[totalBrg];
        String[] namaBrg = new String[totalBrg];
        double[] hrgBrg = new double[totalBrg];

        for (int i = 0; i < totalBrg; i++) {
            System.out.println("\nData Barang ke-" + (i + 1));
            System.out.print("Masukkan Kode Barang: ");
            kodBrg[i] = scanner.next();
            System.out.print("Masukkan Nama Barang: ");
            namaBrg[i] = scanner.next();
            System.out.print("Masukkan Harga Barang: ");
            hrgBrg[i] = scanner.nextDouble();
        }
        
        ArrayList<DetailPembelian> detailPembelianList = new ArrayList<>();

        do {
            System.out.println("\nData Barang:");
            System.out.println(" No | Kode Barang | Nama Barang | Harga Barang ");
            for (int i = 0; i < totalBrg; i++) {
                System.out.println("===================================================");
                System.out.println(" " + (i + 1) + "  | " + kodBrg[i] + "          | " + namaBrg[i] + "         | " + hrgBrg[i]);
                System.out.println("====================================================");
            }

            System.out.print("\nMasukkan nama kode barang yang akan dibeli: ");
            String kodePembelian = scanner.next();
            int indexPembelian = -1;

            for (int i = 0; i < totalBrg; i++) {
                if (kodBrg[i].equals(kodePembelian)) {
                    indexPembelian = i;
                    break;
                }
            }
            if (indexPembelian != -1) {
                System.out.print("Masukkan jumlah beli: ");
                int jumlahBeli = scanner.nextInt();

                double subtotal = hrgBrg[indexPembelian] * jumlahBeli;

                detailPembelianList.add(new DetailPembelian(kodBrg[indexPembelian], namaBrg[indexPembelian], hrgBrg[indexPembelian], jumlahBeli));

                System.out.print("Apakah ingin membeli barang lagi? (ya/tidak): ");
                String pilihan = scanner.next().toLowerCase();

                if (!pilihan.equals("ya")) {
                    break; 
                }
            } else {
                System.out.println("Barang tidak ditemukan");
            }
        } while (true);
        
         System.out.println("\nTabel Pembelian Keseluruhan:");
        System.out.println(" No | Kode Barang | Nama Barang | Harga Barang | Jumlah Beli | Jumlah Bayar ");
        System.out.println("=========================================================================");

        double totalHarga = 0.0;
        
        for (int i = 0; i < detailPembelianList.size(); i++) {
            DetailPembelian detailPembelian = detailPembelianList.get(i);
            double subtotal = detailPembelian.hrgBrg * detailPembelian.jmlhBeli;
            totalHarga += subtotal;

            System.out.println(" " + (i + 1) + "   | " + detailPembelian.kodBrg + "           | " + detailPembelian.namaBrg + "           | " + detailPembelian.hrgBrg + "             | " + detailPembelian.jmlhBeli + "            | " + subtotal);
        }
        
        System.out.println("=========================================================================");
        System.out.println("                                               | Total Harga Keseluruhan | " + totalHarga);
        System.out.println("=========================================================================");

        System.out.println("Terima kasih telah berbelanja!");

        scanner.close();
    }
    
}
