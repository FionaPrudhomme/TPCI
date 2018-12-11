package tpci.matrix;

/**
 * Square matrix
 * @author ensg.dei
 *
 */
public class SquareMatrix {
	/**
	 * Nombre de lignes / colonnes
	 */
	private int size;
	private double[][] values; // tableau de nombres correspondant à la matrice

	/*
	 * Constructeurs
	 */


	public SquareMatrix(int size) {
		this.size = size;
		this.values = new double[this.size][this.size];
	}

	public SquareMatrix(double[][] values) {
		this.values = values;
		this.size = values.length;
	}

	/*
	 * Acesseurs et mutateurs
	 */

	public int getSize() {
		return size;
	}

	public double[][] getValues() {
		return values;
	}

	public void setValues(double[][] values) {
		this.values = values;
	}

	public double getElementAt(int i, int j) {
		return this.values[i][j];
	}

	public void setElementAt(int i, int j, double x) {
		this.values[i][j] = x;
	}


	@Override
	public boolean equals(Object o) {
		// redéfinition de equals héritée d'Object
		if(!(o instanceof SquareMatrix)) {
			return false;
		}
		// o est bien une SquareMatrix
		SquareMatrix M = (SquareMatrix)o; // on cast !
		if(this.size != M.getSize()) {
			return false;
		}
		for(int i=0; i< this.size; i++) {
			for(int j=0; j< this.size; j++) {
				if(this.getElementAt(i, j) != M.getElementAt(i, j)) {
					return false;
				}
			}
		}
		return true;
	}
}
