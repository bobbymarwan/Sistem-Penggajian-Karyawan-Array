package user;

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

	private float processPresentaseGajiLembur(float jamLembur) {
		if (jamLembur >= 5) {
			return persenLemburs[4] / 100F;
		} else if (jamLembur >= 4) {
			return persenLemburs[3] / 100F;
		} else if (jamLembur >= 3) {
			return persenLemburs[2] / 100F;
		} else if (jamLembur >= 2) {
			return persenLemburs[1] / 100F;
		} else if (jamLembur >= 1) {
			return persenLemburs[0] / 100F;
		}
		return 0.0F;
	}

	@Override
	public String toString() {
		return "Golongan " + golongan() + "\nGaji Pokok: " + Helper.formatRupiah(gajiPokok())
				+ "\n" + "Jumlah Jam Lembur: " + getJamLembur() + " Jam\n"
				+ "Gaji Lembur: " + Helper.formatRupiah(getGajiLembur()) + "\n"
				+ "Total Penghasilan sebesar: " + Helper.formatRupiah(jumlahGaji());
	}

}
