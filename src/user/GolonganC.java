package user;

import util.Helper;

public class GolonganC extends Karyawan {
	@Override
	protected float gajiPokok() {
		return gajis[2];
	}

	@Override
	protected String golongan() {
		return golongans[2];
	}

}
