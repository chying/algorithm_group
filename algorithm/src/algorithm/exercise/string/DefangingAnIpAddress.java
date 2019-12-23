package algorithm.exercise.string;

/**
 * 【1108. IP 地址无效化】https://leetcode-cn.com/problems/defanging-an-ip-address/
 * 
 * @author chying
 *
 */
public class DefangingAnIpAddress {

	public String defangIPaddr(String address) {
		String result = "";
		if (null != address) {
			String[] arr = address.split("\\.");
			for (int i = 0; i < arr.length - 1; i++) {
				result += arr[i] + "[.]";
			}
			result += arr[arr.length - 1];
		}
		return result;
	}

	public static void main(String[] args) {
		DefangingAnIpAddress a = new DefangingAnIpAddress();
		System.out.println(a.defangIPaddr_substring("255.100.50.0"));
	}

	public String defangIPaddr_arr(String address) {
		String result = "";
		if (null != address) {
			for (int i = 0; i < address.length(); i++) {
				if (address.charAt(i) == '.') {
					result += "[.]";
				} else {
					result += address.charAt(i);
				}
			}
		}
		return result;
	}
	
	public String defangIPaddr_substring(String address) {
		String result = "";
		if (null != address) {
			 for (int i = address.length() - 2; i >= 0; i--)
		            if (address.charAt(i+1) == '.')
		                address = address.substring(0, i + 1) + "[.]" + address.substring(i + 2);
		        return address;
		}
		return result;
	}
}
