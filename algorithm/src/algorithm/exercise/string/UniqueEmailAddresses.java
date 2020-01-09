package algorithm.exercise.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 【929. 独特的电子邮件地址】 https://leetcode-cn.com/problems/unique-email-addresses/
 * 
 * @author chying
 *
 */
public class UniqueEmailAddresses {

	public int numUniqueEmails(String[] emails) {
		if (null != emails && emails.length > 0) {
			Set<String> set = new HashSet<>();
			for (String email : emails) {
				char[] arr = email.toCharArray();
				StringBuilder sb = new StringBuilder();
				boolean plusFlag = false;
				boolean yuFlag = false;
				for (char ch : arr) {
					if (ch == '.' && !yuFlag) {
						continue;
					} else if (ch == '+' && !yuFlag) {
						plusFlag = true;
					} else {
						if (plusFlag && ch != '@') {
							continue;
						}
						if (ch == '@') {
							if (plusFlag) {
								plusFlag = !plusFlag;
							}
							yuFlag = !yuFlag;
						}
						if (!plusFlag) {
							sb.append(ch);
						}
					}
				}
				set.add(sb.toString());
			}
			return set.size();
		}
		return 0;
	}

	public static void main(String[] args) {
		UniqueEmailAddresses a = new UniqueEmailAddresses();
		String[] emails = new String[] { "test.email+alex@leetcode.com", "testemail+david@lee.tcode.com" };
		System.out.println(a.numUniqueEmails_1(emails));

	}

	public int numUniqueEmails_1(String[] emails) {
		if (null != emails && emails.length > 0) {
			Set<String> set = new HashSet<>();
			for (String email : emails) {
				char[] arr = email.toCharArray();
				StringBuilder sb = new StringBuilder();
				boolean plusFlag = false;
				boolean yuFlag = false;
				for (char ch : arr) {
					if (ch == '.' && !yuFlag) {
						continue;
					} else if (ch == '+' && !yuFlag) {
						plusFlag = true;
					} else if (ch == '@') {
						yuFlag = true;
					}
					if (yuFlag || !plusFlag)
						sb.append(ch);
				}
				set.add(sb.toString());
			}
			return set.size();
		}
		return 0;
	}

}
