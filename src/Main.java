import java.util.Scanner;

import user.GolonganA;
import user.GolonganB;
import user.GolonganC;
import user.Karyawan;

public class Main {

	public static void main(String[] args) {
		for (int i = 0; i <= 80; i++) {
			System.out.print("-");
		}
		System.out.println("");
		System.out.println("Selamat Datang di Sistem Penggajian Karyawan (Tugas 2 STSI4102 057528135)");
		for (int i = 0; i <= 80; i++) {
			System.out.print("-");
		}
		System.out.println();
		panduan();
		System.out.println();
		proses();
	}

	private static void panduan() {
		System.out.println("Panduan Penginputan Kode Karyawan");
		System.out.println("Kode Golongan");
		System.out.println("A: Golongan A");
		System.out.println("B: Golongan B");
		System.out.println("C: Golongan C");
	}

	private static void proses() {
		Scanner input = new Scanner(System.in);

		char ulang = 'Y';

		do {
			Karyawan karyawan;
			char golongan;
			float jamLembur = 0F;
			do {
				System.out.print("Silakan masukan Kode Karyawan: ");
				golongan = input.next().toUpperCase().charAt(0);
				if (!isGolonganValid(golongan)) {
					System.out.println("Golongan yang Anda Masukan Salah. Silakan lihat panduan");
				}
			} while (!isGolonganValid(golongan));

			karyawan = processKaryawan(golongan);
			if (karyawan != null) {
				boolean isValid = false;
				do {
					try {
						System.out.print("Silakan masukan jumlah jam lembur: ");
						jamLembur = input.nextFloat();
						isValid = true;
					} catch (Exception exception) {
						System.out.println("Maaf data yang Anda masukkan salah, silakan masukan angka atau desimal");
						isValid = false;
					}
				} while ((!isValid));

				karyawan.setJamLembur(jamLembur);
				System.out.println(karyawan.toString());

				System.out.println("Apakah Anda Akan mengulang lagi Y/T");
				ulang = input.next().toUpperCase().charAt(0);
			}
		} while (ulang == 'Y');

		System.out.println("Program Selesai");

	}

	private static boolean isGolonganValid(char golongan) {
		if (golongan == 'A' || golongan == 'B' || golongan == 'C') {
			return true;
		}
		return false;
	}

	private static Karyawan processKaryawan(char golongan) {
		if (golongan == 'A') {
			return new GolonganA();
		} else if (golongan == 'B') {
			return new GolonganB();
		} else if (golongan == 'C') {
			return new GolonganC();
		}
		return null;
	}
}
