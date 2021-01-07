package protocols;

import java.util.HashMap;

public class SecureSuite {
	private int alg;
	private int mode;
	private int pad;
	public static final HashMap<Integer, String> algMap = new HashMap<Integer, String>();
	{
		algMap.put(0, "AES128"); // AES com chave de 128 bits
		algMap.put(1, "AES192"); // AES com chave de 192 bits
		algMap.put(2, "AES256"); // AES com chave de 256 bits
		algMap.put(3, "DES"); // DES
		algMap.put(4, "3DES-EDE2"); // Triple-DES no modo EDE com duas chaves
		algMap.put(5, "3DES-EDE3"); // Triple-DES no modo EDE com três chaves
	};
	public static final HashMap<Integer, String> modeMap = new HashMap<Integer, String>();
	{
		modeMap.put(0, "ECB"); // Electronic Codebook Book
		modeMap.put(1, "CBC"); // Cipher Block Chaining
		modeMap.put(2, "CFB1"); // Cipher FeedBack com deslocamento de 1 bit (S)
		modeMap.put(3, "CFB8"); // Cipher FeedBack com deslocamento de 1 byte (S)
		modeMap.put(4, "CFB64"); // Cipher FeedBack com deslocamento de 8 bytes (S)
		modeMap.put(5, "CFB128"); // Cipher FeedBack com deslocamento de 16 bytes (S)
		modeMap.put(6, "CTR"); // Counter
	};
	public static final HashMap<Integer, String> padMap = new HashMap<Integer, String>();
	{
		padMap.put(0, "NoPadding"); // Sem preenchimento
		padMap.put(1, "PKCS5Padding"); // Preenchimento no padrão PKCS5
	};

	SecureSuite(int algoritmo, int modo, int padding) {
		this.alg = algoritmo;
		this.mode = modo;
		this.pad = padding;
	}

	public int getAlg() {
		return alg;
	}

	public void setAlg(int alg) {
		this.alg = alg;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public void setPad(int pad) {
		this.pad = pad;
	}

	public int getMode() {
		return mode;
	}

	public int getPad() {
		return pad;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final SecureSuite other = (SecureSuite) obj;
		if (this.alg != other.alg) {
			return false;
		}
		if (this.mode != other.mode) {
			return false;
		}
		if (this.pad != other.pad) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		return hash;
	}

	@Override
	public String toString() {
		String ret;

		ret = algMap.get(new Integer(this.alg)) + "/" + modeMap.get(new Integer(this.mode)) + "/"
				+ padMap.get(new Integer(this.pad));
		return ret;
	}

	public String getTextAlg() {
		return algMap.get(this.alg);
	}
}
