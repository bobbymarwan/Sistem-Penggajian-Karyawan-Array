package user;

import util.Helper;

public class GolonganA extends Karyawan {

	@Override
	protected float gajiPokok() {
		return gajis[0];
	}

	@Override
	protected String golongan() {
		return golongans[0];
	}

}
