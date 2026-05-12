package user;

import util.Helper;

public abstract class Karyawan {
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
		if(jamLembur >= 5) {
			return 0.38F;
		} else if (jamLembur >= 4) {
			return 0.36F;
		} else if (jamLembur >= 3) {
			return 0.34F;
		} else if (jamLembur >= 2) {
			return 0.32F;
		} else if (jamLembur >= 1) {
			return 0.30F;
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
