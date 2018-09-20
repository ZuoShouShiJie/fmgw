package com.dzjk.qzgw.core.common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstValue {
	
	/** UTF-8 **/
    public static final String CHAR_SET_UTF8 = "UTF-8";
    //宁意短信验证码
  	public static String smsNyURL ="http://oa.nysms.com/api/get_send";
  	public static String smsNyUser = "nanyuejf";
  	public static String smsNyPwd = "Nanyuejf123";
  	/** 存放用户登录后的session key */
	public static final String USER_KEY_IN_SESSION = "USER_KEY_IN_SESSION";
	
	public static final String OPEN_SERVICE_KEY_IN_SESSION="OPEN_SERVICE_KEY_IN_SESSION";
	
	public static final String ADMIN_BUSSINESS_ORG_CODE="ADMIN_BUSSINESS_ORG_CODE";
	
	public static final String ADMIN_BUSSINESS_ORG_NAME="ADMIN_BUSSINESS_ORG_NAME";
	
	/** 分页条数 */
	public static final int PAGE_SIZE=20;
	
	/** 编码 */
	public static final String ENCODEING="utf-8";
	
	/** 日期格式 */
	public static final String DATE_FORMAT="yyyy-MM-dd";
	
	/** 日间格式 */
	public static final String TIME_FORMAT="HH:mm:ss";
	
	/** 日期时间格式*/
	public static final String DATE_TIME_FORMAT="yyyy-MM-dd HH:mm:ss";
	
	
	public static String RESULT_CODE = "RESULT_CODE";
	public static String RESULT_MSG = "RESULT_MSG";
	public static String RESULT_LIST = "RESULT_LIST";
	
	public static String RESULT_ERROR = "9999";
	public static String RESULT_SUCC = "0000";
	
	public static String LENDER_NYB = "NYB";
	public static String LENDER_NYBE = "NYBE";
	public static String LENDER_MTB = "MTB";
	public static String LENDER_QLB = "QLB";
	public static String LENDER_SBB = "SBB";
	
	public static String DATA_TYPE_PLATFORM = "1";//平台
	public static String DATA_TYPE_LENDER = "2";//资方
	
	public static String PALN_CHANGE_FLAG_1 = "1";//还款计划的金额发生变化
	public static String PALN_CHANGE_FLAG_2 = "2";//这一期的还款计划被结清（FINISHDATE有值）
	public static String PALN_CHANGE_FLAG_3 = "3";//还款计划做了变更交易，或者提前还款导致的还款计划变更
	
	public enum LoanType {  
		  XXHB, DEBX, DQHBFX  
		}  
	
	public enum RepayType {  
		NORMAL, PREPAY, OVERDUE  
		} 
	
	public enum TimeLimitType {  
		DAY, MONTH  
		} 

	public enum PrepayType {
		RATE("1", "按手续费率计算"), DAY("2", "按天数计算");

		PrepayType(String code, String name) {
			this.code = code;
			this.name = name;
		}

		String code;
		String name;

		public String getCode() {
			return code;
		}

		public String getName() {
			return name;
		}
	} 
	
	public enum OverdueType {
		RATE("1", "按总本金乘以罚息利息"), COMPOUND("2", "罚息复利方式"),PASSTHROUGH("3", "透传资方数据方式");

		OverdueType(String code, String name) {
			this.code = code;
			this.name = name;
		}

		String code;
		String name;

		public String getCode() {
			return code;
		}

		public String getName() {
			return name;
		}
	} 
	
	
	/**
	 * 2080090	银银e贷13  	房贷
	 */
	public static String BUSINESS_TYPE_2080090="2080090";
	/**
	 * 2080100	银银e贷14		保单贷
	 */
	public static String BUSINESS_TYPE_2080100="2080100";
	/**
	 * 2080110	银银e贷15		车贷
	 */
	public static String BUSINESS_TYPE_2080110="2080110";
	/**
	 * 2080120	银银e贷16		公积金贷
	 */
	public static String BUSINESS_TYPE_2080120="2080120";
	/**
	 * 2080130	银银e贷17		车抵贷
	 */
	public static String BUSINESS_TYPE_2080130="2080130";
	/**
	 * 1110200  创新易贷3号
	 */
	public static String BUSINESS_TYPE_1110200="1110200";
	/**
	 * 1150590 南粤e贷55号
	 */
	public static String BUSINESS_TYPE_1150590="1150590";
	/**
	 * 车贷04002
	 */
	public static String MERCHCODE_04002="04002";
	/**
	 * 赎楼贷05002
	 */
	public static String MERCHCODE_05002="05002";
	/**
     * 麦子06002
     */
    public static String MERCHCODE_06002="06002";
	/**
	 * 交易类  对应南粤银行1110270
	 */
	public static String MERCHCODE_05002_51000="51000";
	/**
	 * 非交易类  对应南粤银行1110280
	 */
	public static String MERCHCODE_05002_51001="51001";
	
	public static String ACCOUNT_NYB_FLAG_YES = "45000";//客户的收款账号是南粤银行卡
	public static String ACCOUNT_NYB_FLAG_NO = "45001";//客户的收款账号不是是南粤银行卡
	public static String NYB_REMARK_FLAG_0 = "46000";//房产证，房产地址，备注
	public static String NYB_REMARK_FLAG_1 = "46001";//新贷款收款银行
	public static String PAY_STATUS_0 = "47000";//放款
	public static String PAY_STATUS_1 = "47001";//撤销未出账合同
	public static String IDCHECK_SUCCEE = "48000";
	public static String IDCHECK_FAIL = "48001";
	public static String ACCOUNTOPEN_SUCCEE = "49000";
	public static String ACCOUNTOPEN_FAIL = "49001";
	public static String CARDBINDING_SUCCEE = "50000";
	public static String CARDBINDING_FAIL = "50001";
	/**
	 * 要查征信
	 */
	public static String CREDITORNOT_1="1";
	/**
	 * 不要查征信
	 */
	public static String CREDITORNOT_2="2";
	/**
	 * 由大桔查询征信
	 */
	public static String CREDITORNOT_3="3";
	
	
	public static String SFT_MERMO="SftMermo";
	
	// 代付
	public static String SFT_AGENT_TYPE_PAY = "00";

	// 代收
	public static String SFT_AGENT_TYPE_COLLECTION = "01";
	
	public static String SFT_BUSINESSCODE = "SftBusinessCode";
	
	public static String SFT_BANKCODE = "SftBankCode";
	
	public static String SFT_BANKCARDNO = "SftBankCardNo";
	
	public static String SFT_BANKCARDHOLDER = "SftBankCardHolder";
	
	public static String SFT_PAYEEBANKNO = "SftPayeeBankNo";
	
	public static String SFT_COPPAYVERSION = "SftCorPayVersion";
	
	public static String SFT_BANKCARDNO_OUT = "SftBankCardNoOut";
	
	// 代付状态--成功
	public static String PAY_STATUS_SUCCESS = "1";

	// 代付状态--失败
	public static String PAY_STATUS_FAILED = "9";

	// 代付状态--处理中
	public static String PAY_STATUS_PROCESSED = "0";
	
	// 代付返回的8种代码
	public static List<String> SFT_RESULT_CODE_LIST = new ArrayList<String>(
			Arrays.asList("2000", "2001", "2003", "2005", "2007", "2008",
					"3028", "9001"));
	

	// 账务平台--逾期透传修改字段
	public static String UAM_ADJUST_FIELD = "feeAmount";
	// 账务平台--逾期透传调整类型
	public static String UAM_ADJUST_TYPE = "OVERDUE_ADJUST";
	
}
