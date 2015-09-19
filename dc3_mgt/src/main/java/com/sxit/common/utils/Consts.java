package com.sxit.common.utils;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 公用常量类
 * @author wuyiming
 */
public final class Consts {
	/** 低优先级异步操作线程池 */
	public static final ExecutorService LOWER_LEVEL_THREAD_POOL = Executors.newFixedThreadPool(5);
	
	/** 高优先级异步操作线程池 */
	public static final ExecutorService HIGH_LEVEL_THREAD_POOL = Executors.newFixedThreadPool(10);
	
	/** 登录结果 */
	public static final String LOGIN_RESULT = "loginResult";
	
	/** 自动登录 */
	public static final String AUTO_LOGIN = "0";
	
	/** 正常登录 */
	public static final String NORMAL_LOGIN = "1";
	
	/** 用户名 */
	public static final String USERNAME = "username";
	
	/** 密码 */
	public static final String PASSWORD  = "password";
	
	/** ROOT节点的菜单编码 */
	public static final String ROOT_MENU_ID  = "Root";
	
	/** 最近访问菜单URL */
	public static final String LAST_ACC_MENU_URL  = "lastAccMenuURL";
	
	/** 用户会话key */
	public static final String USER_SESSION_KEY  = "curentuser";
	
	/** 用户会话权限Code */
	public static final String USER_RIGHT_CODES  = "userRightCodes";
	
	public static final String USER_ESTATE_RIGHTS  = "userEstateRights";
	
	public static final String USER_PROPERTY_RIGHTS  = "userPropertyRights";
	
	/** 成功 */
	public static final String SUCCESS = "success";
	
	/** 失败 */
	public static final String ERROR = "error";
	
	/** 取消绑定新浪微博账号的错误编码 */
	public static final String CANCEL_BIND_SINA = "21330";
	
	/** 微博类型 1：新浪微博 */
	public static final long WEIBO_TYPE_SINA = 1;

	/** 微博类型 2：腾讯微博 */
	public static final long WEIBO_TYPE_TENCENT = 2;
	
	/** 当前用户的微博列表标示 */
	public static final long CUR_USER = 1;

	/** 当前平台的微博列表标示 */
	public static final long CUR_PLA = 2;
	
	/** 空字符串 */
	public static final String EMPTY = "";
	
	/** 腾讯后缀 */
	public static final String TENCENT_SUFFIX = "_tencent";
	
	/** 跳转到信息中心页面 */
	public static final String LOGIN_CENTER = "loginCenter";
	
	/** 跳转到登录页面 */
	public static final String INIT_LOGIN = "initLogin";
	
	/** 跳转到授权页面 */
	public static final String TENT_USER_TOKEN = "tentUserToken";
	
	/** 跳转到信息中心页面 */
	public static final String INFO_CENTER = "infoCenter";
	
	/** 普通参数 */
	public static final long NOR_PARAMS = 1;
	
	/** 系统参数 */
	public static final long ADV_PARAMS = 0;
	
	/** 用户类别为企业级用户（广告主） */
	public static final long ENTERPRISE_USER = 0;
	
	/** 用户类别为超级管理员 */
	public static final long SUPER_ADMIN = 1;
	
	/** 用户类别为博主 */
	public static final long BLOGER = 2;
	
	/** 用户类别为微博操作员 */
	public static final long MICRO_OPERATOR = 3;
	
	/** 用户类别为运营人员 */
	public static final long OPERATE_PERSON = 4;
	
	/** 用户类别为业务员 */
	public static final long SALESMAN = 5;
	
	/** 用户类别为代理商 */
	public static final long AGENT = 6;
	
	/** 发送者类型为系统绑定 */
	public static final long SYSTEM_BINDS = 0;
	
	/** 发送者类型为微博主的微博 */
	public static final long MICRO_LORD_MICRO = 1;

	/** 数据字典操作类型常量 */
	public static final String LOG_TYPE = "Log_Type";

	/** 数据字典模块类型常量 */
	public static final String MODEL_CODE = "Model_Code";

	/** 数据字典权限类型常量 */
	public static final String RIGHT_CODE = "Right_Code";

	/** 日志操作类型－退出 */
	public static final long LOG_LOGOUT = -1;

	/** 日志操作类型－登录 */
	public static final long LOG_LOGIN = 0;

	/** 日志操作类型－查看 */
	public static final long LOG_VIEW = 1;

	/** 日志操作类型－新增 */
	public static final long LOG_ADD = 2;

	/** 日志操作类型－审核 */
	public static final long LOG_AUDIT = 3;

	/** 日志操作类型－修改 */
	public static final long LOG_EDIT = 4;

	/** 日志操作类型－删除 */
	public static final long LOG_DEL = 5;

	/** 日志操作类型－查询 */
	public static final long LOG_QUERY = 6;

	/** 数据字典操作类型常量-渠道类型 */
	public static final String CHANNEL_TYPE = "MrkChannelType";

	/** 数据字典操作类型常量-产品类型 */
	public static final String PRODUCT_TYPE = "MrkProductType";

	/** 数据字典操作类型常量-资源类型 */
	public static final String RSCCONTENT_TYPE = "MrkRsccontentType";

	/** 数据字典操作类型常量-业务类型 */
	public static final String BUSINESS_TYPE = "Business_Type";

	/** 审核状态-驳回 */
	public static final long AUDIT_REJECT = -1;

	/** 审核状态-待审核 */
	public static final long AUDIT_READY = 0;

	/** 审核状态-已批准 */
	public static final long AUDIT_PASS = 1;

	/** 营销推广条件类型-营销模型 */
	public static final long MRK_CONDITIONTYPE_MODEL = 0;

	/** 营销推广条件类型-兴趣特征 */
	public static final long MRK_CONDITIONTYPE_INTEREST = 1;

	/** 营销推广条件类型-GPRS */
	public static final long MRK_CONDITIONTYPE_GPRS = 2;

	/** 营销推广条件类型-时段得分 */
	public static final long MRK_CONDITIONTYPE_TIMES = 3;

	/** 营销推广条件类型-关联规则 */
	public static final long MRK_CONDITIONTYPE_SVCRULE = 4;

	/** 营销推广条件类型-消费偏好 */
	public static final long MRK_CONDITIONTYPE_SVCLOVE = 5;

	/** 营销推广条件类型-消费档次 */
	public static final long MRK_CONDITIONTYPE_COMSUMELVL = 6;

	/** 营销推广条件类型-决策规则 */
	public static final long MRK_CONDITIONTYPE_CARTRULE = 7;

	/** UTF-8编码 */
	public static final String UTF8_Encoding = "UTF-8";

	/** GBK编码 */
	public static final String GBK_Encoding = "GBK";

	/** 系统提示信息 */
	public static final String sysErrMsg = "系统忙,请稍后再试!";

	/** 分隔符 */
	public static final String SEPARATOR = ",";

	/** 值为-1 */
	public static final String NEGATIVE_ONE = "-1";

	/** 值为0 */
	public static final String ZERO = "0";

	/** 上传Excel路径 */
	public static final String UPLOAD_EXCEL_PATH = "/exceltemp/";

	/** Excel格式 */
	public static final String EXCEL_FORMAT = ".xls";

	/** 目标群一级类型 */
	public static final String GROUP_FIRST_TYPE = "1";

	/** 目标群二级类型 */
	public static final String GROUP_SECOND_TYPE = "2";

	/** 水军传播助手任务表名 */
	public static final String TASK_TAB_NAME = "TWBO_WATER_ARMY_TASK";

	/** 水军传播助手任务序列名 */
	public static final String TASK_SEQ_NAME = "TWBO_WATER_ARMY_TASK_ID";
	
	/** 系统用户和前台用户序列名 */
	public static final String USER_SEQ_NAME = "TSYSUSERID";
	
	/** 用户表名 */
	public static final String TSYS_USER_TAB_NAME = "TSYS_USER";
	
	/** 用户表序列名 */
	public static final String TSYS_USER_SEQ_NAME = "WZ_SYS_USER_ID";

	/** 任务状态：等待执行 */
	public static final String WAIT_EXECUTED = "0";

	/** 目标群类型 */
	public static final String GROUP_TYPE = "groupSelectType";

	/** 上传的目标用户 */
	public static final String UPLOAD_TARGET_USER = "uploadTargetUser";
	
	/**账单类型-充值*/
	public static final Integer ORDER_TYPE_RECHARGE = Integer.valueOf(1);
	
	/**账单类型-消费*/
	public static final Integer ORDER_TYPE_PAID = Integer.valueOf(2);
	
	/**账单类型-质检退款*/
	public static final Integer ORDER_TYPE_QA_REFUND = Integer.valueOf(3);
	
	/**账单类型-礼卷赠送*/
	public static final Integer ORDER_TYPE_PRESENT = Integer.valueOf(4);
	
	/**账单类型-冻结*/
	public static final Integer ORDER_TYPE_LOCK = Integer.valueOf(6);
	
	/**
	 * seervlet请求的方法
	 */
	public static String SERVLET_FUNCTION = "func";
	
	/** 上传目标的文件夹名称 */
	public static final String UPLOAD_FILE_NAME = "uploadFile";
	
	/** 上传目标的文件夹名称（商家） */
	public static final String UPLOAD_FILE_MER_NAME = "uploadFile/image/merchant";
	
	/** 上传目标的文件夹名称（优惠券） */
	public static final String UPLOAD_FILE_COU_NAME = "uploadFile/image/coupon";
	
	/** 上传目标的文件夹名称（活动） */
	public static final String UPLOAD_FILE_ACT_NAME = "uploadFile/image/activity";
	
	/** 个人图片 */
	public static final String PERSONAL_IMAGE = "1";
	
	/** 网络图片里的风景图片 */
	public static final String SCAPE_IMAGE = "2";
	
	/** 网络图片里的美女图片 */
	public static final String BEAUTY_IMAGE = "3";
	
	/** 模板信息里的正常发送*/
	public static final String NORMAL_SAND = "0";
	
	/** 模板信息里的暂停发送*/
	public static final String STOP_SAND = "1";
	
	/** 模板信息里模板类型的普通模板*/
	public static final String NORMAL_TEMPLATE_TYPE = "1";
	
	/** 模板信息里模板类型的excel批量内容模板*/
	public static final String EXCEL_TEMPLATE_TYPE = "2";
	
	public static final String IS_IMAGE_SERVICE = "is_image_service";
	public static final String IMAGE_SERVICE_HEAD_URL = "image_service_head_url";
	public static final String IS_IMGAGE_SERVICE_NO = "0";
	
	/** 渠道类型-所有渠道 */
	public static final String ALL_CHANNEL = "0";
	
	/** 渠道类型-新浪 */
	public static final String SINA = "1";
	
	/** 渠道类型-腾讯 */
	public static final String TENCENT = "2";
	
	/** 渠道类型-短信 */
	public static final String SMS = "3";
	
	/** 渠道类型-微信 */
	public static final String MCHAN = "4";
	
	/** 定时任务类型 1：信息发布原生定时任务 2：活动定时任务*/
	public static final String TASK_TYPE_NATIVE  = "1";
	
	/** 定时任务类型 1：信息发布原生定时任务 2：活动定时任务 */
	public static final String TASK_TYPE_ACTIVITY = "2";

	public static final String SESSION_SHOPINFO = "SHOP_AREANAME";
	
	/**店铺类型  -1 为全范围店铺  0 区域店铺  1店铺名称*/
	public static final int ALLSHOPTYPE = -1;
	public static final int AREASHOPTYPE = 0;
	public static final int SUBSHOPTYPE = 1;
	public static final String ALLPARENTNO = "0";
	/** 用户管理添加用户 */
	public static final String ADD_USER = "1";
	/** 用户管理修改用户 */
	public static final String UPDATE_USER = "2";

	/** Y或者N常量 */
	public static class YesOrNo {
		public static final String YES = "Y";
		public static final String NO = "N";
	}
	
	/** 素材类型常量 add by gzq 2014-02-26*/
	public static final String TEXT_MSG = "text";
	public static final String IMAGE_MSG = "image";
	public static final String VOICE_MSG = "voice";
	public static final String VIDEO_MSG = "video";
	public static final String MUSIC_MSG = "music";
	public static final String NEWS_MSG = "news";

	/**
	 * 获取最大数
	 * @param items
	 * @return long
	 */
	public static long getMax(long[] items) {
		if (items.length == 0) {
			return 0;
		}
		if (items.length == 1) {
			return items[0];
		}

		int i;
		long temp = items[0];
		long max = 0L;

		for (i = 1; i < items.length; i++) {
			if (temp > items[i]) {
				max = temp;
			} else {
				max = items[i];
			}
			temp = max;
		}
		return max;
	}

	/**
	 * 获取最大数
	 * @param items
	 * @return double
	 */
	public static double getMax(double[] items) {
		if (items.length == 0) {
			return 0.0;
		}
		if (items.length == 1) {
			return items[0];
		}

		int i;
		double temp = items[0];
		double max = 0.0;

		for (i = 1; i < items.length; i++) {
			if (temp > items[i]) {
				max = temp;
			} else {
				max = items[i];
			}
			temp = max;
		}
		return max;
	}
  
	/** 初始密码配置名称*/
	public static final String INIT_PASSWD="initPasswd";
	
	//导出数据默认一个sheet在数据量
	public static final int EXPORT_SHEET_NUM = 50000;
	
	/** 短信拆分字符长度 */
	public static final int SMS_NUM = 60;
	
	
	/** 跳转到客户管理页面 */
	public static final String INIT_CUSTOMER_MANAGE = "initCustomerManage";
	
	
	/** 逗号 */
	public static final String COMMA = ",";
	
	/** 短信服务调用成功 */
	public static final String SMS_SUCCESS = "00";
	
	/** 微信执行消息群发的判断标识 */
	public static final String MCHAN_MSG_MASS = "-1000";
	
	/** 消息类型-文本 */
	public static final String TEXT = "1";
	
	/** 消息类型-图片 */
	public static final String PICTURE = "2";
	
	/** 消息类型-图文消息 */
	public static final String TEXT_MESSAGES = "3";
	
	/** excel模板占位符 */
	public static final String PLACEHOLDER = "$";
	
	/** 是微博广播 */
	public static final String BROADCAST = "1";
	
	/** 非微博广播 */
	public static final String NO_BROADCAST = "0";
	
	/** 是微信广播 */
	public static final String WEIXIN_BROADCAST = "1";
	
	/** 非微信广播 */
	public static final String NO_WEIXIN_BROADCAST = "0";
	
	/** 预发送每日微信推送状态，1：已推送 */
	public static final String HAS_PUSH = "1";
	
	/** 预发送每日微信推送状态，0：未推送 */
	public static final String NOT_PUSH = "0";
 
	/**
	 * 保留小数 int num -
	 * 小数位数 double value 数字
	 * @param num, value
	 * @return double
	 */
	public static double changeDecimal(int num, double value) {
		BigDecimal b = new BigDecimal(value);
		double v = b.setScale(num, BigDecimal.ROUND_HALF_UP).doubleValue();// 表明四舍五入，保留两位小数
		return v;
	}

	/**
	 * 返回比num大的第一个整十的数
	 * @param num
	 * @return long
	 */
	public static long getRoundNumber(long num) {
		return (num - num % 10) + 10;
	}
	
	/** 支付宝 收款类型-商品购买*/
	public static final String ALIPAY_PAYMENT_TYPE_BUY = "1";
	
	/** 支付宝接口-实时到账接口*/
	public static final String ALIPAY_SERVICE_NAME_REALTIME_ARRIVAL ="create_direct_pay_by_user";
	
	
	public static final String MAIL_SERVER_HOST="mailServerHost";
	public static final String MAIL_SERVER_PORT="mailServerPort";
	public static final String MAIL_USER_NAME="userName";
	public static final String MAIL_PASSWORD="password";
	public static final String FROM_ADDRESS="fromAddress";

	/** 项目详细信息类型--简介 */
	public static final String YZY_PROJECT_DESC_ITEM_TYPE_INFO = "1";
	/** 项目详细信息类型--配套 */
	public static final String YZY_PROJECT_DESC_ITEM_TYPE_SUPPORT = "2";
	/** 项目详细信息类型--banner图 */
	public static final String YZY_PROJECT_DESC_ITEM_TYPE_IMAGE = "3";
	/** 项目详细信息类型--项目详情banner图 */
	public static final String YZY_PROJECT_IMAGE_DETAIL = "detailBanner";
	/** 项目详细信息类型--项目基本信息banner图 */
	public static final String YZY_PROJECT_IMAGE_BASE = "baseBanner";
	/** 项目详细信息类型--项目配套banner图 */
	public static final String YZY_PROJECT_IMAGE_DESC = "descBanner";
	
	/** 在售项目分类--未提交 */
	public static final String YZY_PROJECT_WTJ = "wtj";
	/** 在售项目分类--未审核 */
	public static final String YZY_PROJECT_WSH = "wsh";
	/** 在售项目分类--已审核 */
	public static final String YZY_PROJECT_YSH = "ysh";
	/** 在售项目分类--已下架 */
	public static final String YZY_PROJECT_YXJ = "yxj";
	
	/** 在售项目状态--新建 */
	public static final int YZY_PROJECT_STATUS_XJ = 1;
	/** 在售项目状态--驳回 */
	public static final int YZY_PROJECT_STATUS_BH = 2;
	/** 在售项目状态--再次编辑 */
	public static final int YZY_PROJECT_STATUS_ZCBJ = 3;
	/** 在售项目状态--未审核 */
	public static final int YZY_PROJECT_STATUS_WSH = 4;
	/** 在售项目状态--已审核 */
	public static final int YZY_PROJECT_STATUS_YSH = 5;
	/** 在售项目状态--已下架 */
	public static final int YZY_PROJECT_STATUS_YXJ = 6;
	/** 时间格式: yyyy-MM-dd */
	public static final String DATE_FMT_YYYY_MM_DD = "yyyy-MM-dd";
	/** 时间格式: yyyy-MM-dd HH:mm */
	public static final String DATE_FMT_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	/** 时间格式: yyyy-MM-dd HH:mm:ss */
	public static final String DATE_FMT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	
	/** 用户权限模块 */
	public static final String USER_RIGHT_MODELS = "userRightModels";
	
	/** 权限模块按钮类型 */
	public static final String RIGHT_MODELS_TYPE_BUTTON = "button";
	
	/** 权限模块菜单类型 */
	public static final String RIGHT_MODELS_TYPE_MENU = "menu";
	
	/** 极致物业接口地址配置 */
	public static final String JEEZ_PRO_WSDL = "jeez_property_wsdl";
	
	/** 参数名 - 前端APP访问地址 */
	public static final String WEB_APP_HOST = "WEB_APP_HOST";
	
	/** 数据中心接口请求路径 */
	public static final String ACTION = "action";
	
	/** 微博授权 - 新浪 */
	public static final int BIND_TYPE_SINA_WEIBO = 1;
	/** 微博授权 - 腾讯 */
	public static final int BIND_TYPE_TENCENT_WEIBO = 2;
	/** 微信授权 */
	public static final int BIND_TYPE_WEIXIN = 3;
	/** 绑定结果返回信息 失败 */
	public static final String BIND_MSG_ERROR = "很抱歉，微博绑定失败。";
	/** 绑定结果返回信息 失败 */
	public static final String BIND_MSG_ERROR_2 = "此微博账号已被其他用户使用，请使用其它微博账号。";
	/** 绑定结果返回信息 失败 */
	public static final String BIND_WX_MSG_ERROR_2 = "此微博账号已被其他用户使用，请使用其它微博账号。";
	/** 绑定结果返回信息 成功 */
	public static final String BIND_MSG_SUCC = "恭喜您，微博绑定成功！";
	/** 绑定结果返回信息 成功 */
	public static final String BIND_WX_MSG_SUCC = "恭喜您，微信绑定成功！";
	/** 系统异常返回信息 异常 */
	public static final String DEF_ERROR_MSG = "系统繁忙，请稍后再试。";
	/** 请求参数异常 */
	public static final String REQUEST_PARAMS_ERROR = "请求参数异常，请刷新界面后重试。";
	/** 空列表 */
	public static final String NULL_LIST_MSG = "暂时无记录";
	/** 默认时间格式 */
	public static final String DEF_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/** 授权状态 0.取消授权 */
	public static final int AUTH_STATUS_CANCEL = 0;
	/** 授权状态 1.TOKEN过期 */
	public static final int AUTH_STATUS_OUT = 1;
	/** 授权状态 2.授权中 */
	public static final int AUTH_STATUS_IN = 2;
	/** 标示  1 true */
	public static final int TURE = 1;
	/** 标示  0 false */
	public static final int FALSE = 0;
	/** 账号ID */
	public static final String SESSION_KEY_ACCOUNT_ID = "accountId";
	/** 账号 */
	public static final String SESSION_KEY_ACCOUNT = "account";
	
	public static final List<String> WEIBO_TIME_OUT_ERROR_CODES = new ArrayList<String>();
	
	static {
		WEIBO_TIME_OUT_ERROR_CODES.add("10006");
		WEIBO_TIME_OUT_ERROR_CODES.add("21314");
		WEIBO_TIME_OUT_ERROR_CODES.add("21315");
		WEIBO_TIME_OUT_ERROR_CODES.add("21316");
		WEIBO_TIME_OUT_ERROR_CODES.add("21317");
		WEIBO_TIME_OUT_ERROR_CODES.add("21319");
		WEIBO_TIME_OUT_ERROR_CODES.add("21327");
		WEIBO_TIME_OUT_ERROR_CODES.add("21332");
	}
	
	/** 开通城市key */
	public static final String SESSION_KEY_CITY_LIST = "CITY_LIST_ALL";
	
	/** 有权限的地产小区key（ysh_project） */
	public static final String SESSION_KEY_SERVICE_SERVICES_PRO = "SERVICE_SERVICES_PRO";
	
	/** 有权限的物业小区key （ysh_service_center）*/
	public static final String SESSION_KEY_SERVICE_SERVICES_CEN = "SESSION_KEY_SERVICE_SERVICES_CEN";

}
