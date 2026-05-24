package user;

import java.util.Arrays;

import util.Helper;

public abstract class Karyawan {
	// Array
	protected static float[] gajis = { 5000000, 6500000, 9500000 };
	protected static int[] persenLemburs = { 30, 32, 34, 36, 38 };
	protected static String[] golongans = { "A", "B", "C" };

	private float gajiLembur = 0;
	private float jamLembur = 0F;

	protected abstract String golongan();

	protected abstract float gajiPokok();

	protected float jumlahGaji() {
		return gajiPokok() + getGajiLembur();
	}

	public float getJamLembur() {
		return jamLembur;
	}

	public void setJamLembur(float jamLembur) {
		this.jamLembur = jamLembur;
		setGajiLembur(processPresentaseGajiLembur(this.jamLembur) * gajiPokok());
	}

	public float getGajiLembur() {
		return gajiLembur;
	}

	public void setGajiLembur(float gajiLembur) {
		this.gajiLembur = gajiLembur;
	}

	private int getIndexPersenLembur(float jamLembur) {
		if (jamLembur >= 5) {
			return 4;
		} else if (jamLembur >= 4) {
			return 3;
		} else if (jamLembur >= 3) {
			return 2;
		} else if (jamLembur >= 2) {
			return 1;
		} else if (jamLembur >= 1) {
			return 0;
		}
		return -1;
	}

	private float processPresentaseGajiLembur(float jamLembur) {
		int index = getIndexPersenLembur(jamLembur);
		if (index >= 0) {
			return persenLemburs[index] / 100F;
		}
		return 0.0F;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("==========================================================\n");
		sb.append("              DETAIL INFO ARRAY & HASIL GAJI              \n");
		sb.append("==========================================================\n");

		sb.append("\n--- Array Golongan ---\n");
		sb.append("golongans = ").append(Arrays.toString(golongans)).append("\n");
		for (int i = 0; i < golongans.length; i++) {
			sb.append("  golongans[").append(i).append("] = \"").append(golongans[i]).append("\"\n");
		}

		sb.append("\n--- Array Gaji ---\n");
		sb.append("gajis = [");
		for (int i = 0; i < gajis.length; i++) {
			sb.append(Helper.formatRupiah(gajis[i]));
			if (i < gajis.length - 1)
				sb.append(", ");
		}
		sb.append("]\n");
		for (int i = 0; i < gajis.length; i++) {
			sb.append("  gajis[").append(i).append("] = ").append(Helper.formatRupiah(gajis[i]));
			sb.append(" (Golongan ").append(golongans[i]).append(")\n");
		}

		sb.append("\n--- Array Persen Lembur ---\n");
		sb.append("persenLemburs = ").append(Arrays.toString(persenLemburs)).append("\n");
		for (int i = 0; i < persenLemburs.length; i++) {
			sb.append("  persenLemburs[").append(i).append("] = ").append(persenLemburs[i]).append("%");
			sb.append(" (Lembur ").append(i + 1);
			if (i == persenLemburs.length - 1)
				sb.append("+");
			sb.append(" Jam)\n");
		}

		sb.append("\n==========================================================\n");
		sb.append("              HASIL PERHITUNGAN GAJI KARYAWAN             \n");
		sb.append("==========================================================\n");
		sb.append("Golongan           : ").append(golongan()).append("\n");
		sb.append("Gaji Pokok         : ").append(Helper.formatRupiah(gajiPokok())).append("\n");
		sb.append("Jumlah Jam Lembur  : ").append((int) getJamLembur()).append(" Jam\n");

		int indexLembur = getIndexPersenLembur(getJamLembur());
		if (indexLembur >= 0) {
			sb.append("Persen Lembur      : persenLemburs[").append(indexLembur).append("] = ");
			sb.append(persenLemburs[indexLembur]).append("% dari Gaji Pokok\n");
			sb.append("Perhitungan Lembur : ").append(persenLemburs[indexLembur]).append("% x ");
			sb.append(Helper.formatRupiah(gajiPokok())).append(" = ");
			sb.append(Helper.formatRupiah(getGajiLembur())).append("\n");
		} else {
			sb.append("Persen Lembur      : 0% (Tidak Lembur)\n");
			sb.append("Gaji Lembur        : ").append(Helper.formatRupiah(0)).append("\n");
		}

		sb.append("Gaji Lembur        : ").append(Helper.formatRupiah(getGajiLembur())).append("\n");
		sb.append("----------------------------------------------------------\n");
		sb.append("Total Penghasilan  : ").append(Helper.formatRupiah(jumlahGaji())).append("\n");
		sb.append("==========================================================");

		return sb.toString();
	}

}
