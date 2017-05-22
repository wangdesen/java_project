package algorithm;

import java.io.Serializable;

public class TermEncryptInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/// <summary>
	/// �ն�Ψһ���к�
	/// </summary>
	public long POSCODE;

	/// <summary>
	/// ���(��)
	/// </summary>
	public int OPFARE;

	/// <summary>
	/// �����
	/// </summary>
	public int RANDOMNUM;

	/// <summary>
	/// ����ʱ��
	/// </summary>
	public String OPDT;

	/// <summary>
	/// �û�������Ϣ
	/// </summary>
	public String USERENCRYPTINFO;

	public long getPOSCODE() {
		return POSCODE;
	}

	public void setPOSCODE(long pOSCODE) {
		POSCODE = pOSCODE;
	}

	public int getOPFARE() {
		return OPFARE;
	}

	public void setOPFARE(int oPFARE) {
		OPFARE = oPFARE;
	}

	public int getRANDOMNUM() {
		return RANDOMNUM;
	}

	public void setRANDOMNUM(int rANDOMNUM) {
		RANDOMNUM = rANDOMNUM;
	}

	public String getOPDT() {
		return OPDT;
	}

	public void setOPDT(String oPDT) {
		OPDT = oPDT;
	}

	public String getUSERENCRYPTINFO() {
		return USERENCRYPTINFO;
	}

	public void setUSERENCRYPTINFO(String uSERENCRYPTINFO) {
		USERENCRYPTINFO = uSERENCRYPTINFO;
	}

}
