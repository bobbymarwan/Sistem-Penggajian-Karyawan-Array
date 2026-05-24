package user;

import util.Helper;

public class GolonganB extends Karyawan {

	@Override
	protected float gajiPokok() {
		return gajis[1];
	}

	@Override
	protected String golongan() {
		return golongans[1];
	}

}
