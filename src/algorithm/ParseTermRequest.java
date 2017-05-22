package algorithm;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ParseTermRequest {

	public static byte[] subBytes(byte[] src, int begin, int count) {
		byte[] bs = new byte[count];
		for (int i = begin; i < begin + count; i++){
			bs[i - begin] = src[i];
		}
		return bs;
	}
	
	public static byte[] HexStringToByteArrays(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}

	/*public static byte[] HexStringToByteArray(String s) {
		s = s.replace(" ", "");
		byte[] buffer = new byte[s.length() / 2];
		for (int i = 0; i < s.length(); i += 2){
			buffer[i / 2] = (byte) Convert.ToByte(s.substring(i, 2), 16);
		}
		return buffer;
	}*/

	/*public static String ByteArrayToHexString(byte[] data) {
		StringBuilder sb = new StringBuilder(data.length * 3);
		for (byte b : data){
			sb.append("");//Convert.ToString(b, 16).PadLeft(2, '0')
		}
		return sb.toString().toUpperCase();
	}*/

	/**
	 * ASCII码转换
	 * */
	/*public static String AsciiToString(String ascInfo) {
		List buffer = new ArrayList();
		for (int i = 0; i < ascInfo.length(); i += 2) {
			String temp = ascInfo.substring(i, 2);
			byte value = Convert.ToByte(temp, 16);
			buffer.add(value);
		}
		String str = System.Text.Encoding.ASCII.GetString(buffer.toArray());
		return str;
	}*/

	/*public TermEncryptInfo ParseTermRequestInfo(String encryptinfo, int type,
			int result, String msg) {
		
		TermEncryptInfo toReturn = new TermEncryptInfo();
		try {
			if (type == 1) {
				byte[] data = HexStringToByteArrays(encryptinfo);
				int crc1 = (data[20] << 8) | data[21];

				long crc = CRC.ComputeCRC16(data, 22);

				
				if (CRC16Util.ComputeCRC16(data)) {
					int[] realData = new int[20]; // 原始数据
					for (int i = 0; i < 20; i++) {
						//realData[i] = (byte) ((data[i] << 3) | (data[i] >> 5));
						//realData[i] ^= 0xA5;
						
						realData[i] = (byte) ((data[i] & 0x00ff) << 3) | ((data[i] & 0x00ff) >> 5);
						realData[i] ^= 0x00A5;
						realData[i] = realData[i] & 0x00ff;
					}

					byte[] bytePoscode = subBytes(realData, 0, 6);

					toReturn.POSCODE = Convert.ToInt64(
							ByteArrayToHexString(bytePoscode), 16);

					byte[] byteOpfare = subBytes(realData, 6, 4);

					toReturn.OPFARE = Convert.ToInt32(
							ByteArrayToHexString(byteOpfare), 16);

					byte[] byteRandom = subBytes(realData, 10, 4);

					toReturn.RANDOMNUM = Convert.ToInt32(
							ByteArrayToHexString(byteRandom), 16);

					byte[] byteOpdt = subBytes(realData, 14, 6);

					toReturn.OPDT = DateTime.Now.ToString("yyyy").Substring(0,
							2)
							+ ByteArrayToHexString(byteOpdt);
				} else {
					result = -30002;
					msg = "终端请求密文信息CRC校验失败";
					return null;
				}
			} else if (type == 2) {
				byte[] data = HexStringToByteArray(encryptinfo);
				int crc1 = (data[39] << 8) | data[40];

				long crc = CRC.ComputeCRC16(data, 41);

				byte[] realData = new byte[39]; // 原始数据
				if (crc1 == crc) {
					for (int i = 0; i < 39; i++) {
						realData[i] = (byte) ((data[i] << 3) | (data[i] >> 5));
						realData[i] ^= 0xA5;
					}

					byte[] bytePoscode = subBytes(realData, 0, 6);

					toReturn.POSCODE = Convert.ToInt64(
							ByteArrayToHexString(bytePoscode), 16);

					byte[] byteOpfare = subBytes(realData, 6, 4);

					toReturn.OPFARE = Convert.ToInt32(
							ByteArrayToHexString(byteOpfare), 16);

					byte[] byteRandom = subBytes(realData, 10, 4);

					toReturn.RANDOMNUM = Convert.ToInt32(
							ByteArrayToHexString(byteRandom), 16);

					byte[] byteOpdt = subBytes(realData, 14, 6);

					toReturn.OPDT = DateTime.Now.ToString("yyyy").Substring(0,
							2)
							+ ByteArrayToHexString(byteOpdt);

					byte[] byteUserInfo = subBytes(realData, 20, 19);

					toReturn.USERENCRYPTINFO = AsciiToString(ByteArrayToHexString(byteUserInfo));
				} else {
					result = -30002;
					msg = "终端请求密文信息CRC校验失败";
					return null;
				}

			} else if (type == 3) {
				byte[] data = HexStringToByteArray(encryptinfo);
				int crc1 = (data[6] << 8) | data[7];

				long crc = CRC.ComputeCRC16(data, 8);

				byte[] realData = new byte[6]; // 原始数据
				if (crc1 == crc) {
					for (int i = 0; i < 6; i++) {
						realData[i] = (byte) ((data[i] << 3) | (data[i] >> 5));
						realData[i] ^= 0xA5;
					}

					byte[] byteUserInfo = subBytes(realData, 0, 6);

					toReturn.USERENCRYPTINFO = AsciiToString(ByteArrayToHexString(byteUserInfo));
				} else {
					result = -30002;
					msg = "终端请求密文信息CRC校验失败";
					return null;
				}

			} else {
				result = -30003;
				msg = "终端请求密文信息类型异常";
				return null;
			}

			result = 100;
			msg = "终端请求信息校验解析成功";

		} catch (Exception ex) {
			result = -30001;
			msg = "解析终端请求密文信息异常：" + ex.Message;
			return null;
		}

		return toReturn;
	}*/


}
