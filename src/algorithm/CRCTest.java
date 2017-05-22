package algorithm;

public class CRCTest {

	public static void main(String[] args) {
		
		//测试对象进行CRC加密
		/*TermEncryptInfo t = new TermEncryptInfo();
		t.POSCODE = 16909060L;
		t.OPFARE = 123456;
		t.RANDOMNUM = 578385;
		t.OPDT = "161027103121";
		
		try {
			byte[] bytes = CRC.objectToBytes(t);
			Long result = CRC.ComputeCRC32(bytes, bytes.length);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		//测试生成0-256byte
		/*byte bytes[] = {-76, -76, -108, -12, -44, 52, -76, -108, -24, -68, -76, -75, -50, -98, 118, -74, 80, -74, -110, -112, 52, 55};
		int data[] = new int[bytes.length];
		for(int i=0;i < bytes.length ; i++){
		   data[i] = bytes[i] & 0xff;
		}
		
		for(int i : data){
			System.out.println(i);
		}*/
		
		
		/*byte[] bytes = ParseTermRequest.HexStringToByteArrays("B4B494F4D434B494E8BCB4B5CE9E76B650B692903437");
		
		int data[] = new int[bytes.length];
		for(int i=0;i < bytes.length ; i++){
		   data[i] = bytes[i] & 0xff;
		}
		
		int crc1 = (data[20] << 8) | data[21];
		
		System.out.println(crc1);
		
		System.out.println(CRC16Util.ComputeCRC16(bytes));*/
		
		
		byte[] data = ParseTermRequest.HexStringToByteArrays("B4B494F4D434B494E8BCB4B5CE9E76B650B692903437");
		System.out.println((data[20] << 8) | data[21]);
		/*
		 * int crc1=(test[20]<<8)|test[21]; System.out.println(crc1);
		 * System.out.println(CRCUtil.mkCrc16(test));
		 * System.out.println(CRCUtil.evalCRC16(test));
		 * System.out.println(CRCUtil.crcTable(test));
		 * System.out.println(CRCUtil.getCRC16(test));
		 */
		// System.out.println(CRCUtil.do_crc(test));
		if (CRC16Util.ComputeCRC16(data)) {
			int[] realData = new int[20]; // 原始数据
			for (int i = 0; i < 20; i++) {
				realData[i] = (byte) ((data[i] & 0x00ff) << 3) | ((data[i] & 0x00ff) >> 5);
				realData[i] ^= 0x00A5;
				realData[i] = realData[i] & 0x00ff;
			}

			int[] bytePoscode = subBytes(realData, 0, 6);
			long poscode = Integer.parseInt(bytesToHexString(bytePoscode), 16);
			System.out.println("poscode" + poscode);

			int[] byteOpfare = subBytes(realData, 6, 4);
			int opfare = Integer.parseInt(bytesToHexString(byteOpfare), 16);
			System.out.println("opfare" + opfare);
			
			int[] byteRandom = subBytes(realData, 10, 4);
			int randomnum = Integer.parseInt(bytesToHexString(byteRandom), 16);
			System.out.println("randomnum" + randomnum);
			
			int[] byteOpdt = subBytes(realData, 14, 6);
			String OPDT = bytesToHexString(byteOpdt);
			System.out.println("OPDT" + OPDT);
		}
		
	}
	
	/// <summary>
		/// 从byte数组中去其中几个字节
		/// </summary>
		/// <param name="src"></param>
		/// <param name="begin"></param>
		/// <param name="count"></param>
		/// <returns></returns>
		public static int[] subBytes(int[] src, int begin, int count) {
			int[] bs = new int[count];
			for (int i = begin; i < begin + count; i++)
				bs[i - begin] = src[i];
			return bs;
		}

		public static String bytesToHexString(int[] src) {
			StringBuilder stringBuilder = new StringBuilder("");
			if (src == null || src.length <= 0) {
				return null;
			}
			for (int i = 0; i < src.length; i++) {
				int v = src[i] & 0xFF;
				String hv = Integer.toHexString(v);
				if (hv.length() < 2) {
					stringBuilder.append(0);
				}
				stringBuilder.append(hv);
			}
			return stringBuilder.toString();
		}

}
