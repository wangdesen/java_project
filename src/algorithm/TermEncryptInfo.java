package algorithm;

import java.io.Serializable;

public class TermEncryptInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/// <summary>
	/// 终端唯一序列号
	/// </summary>
	public long POSCODE;

	/// <summary>
	/// 金额(分)
	/// </summary>
	public int OPFARE;

	/// <summary>
	/// 随机数
	/// </summary>
	public int RANDOMNUM;

	/// <summary>
	/// 操作时间
	/// </summary>
	public String OPDT;

	/// <summary>
	/// 用户密文信息
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
