package com.www.app.network;

/**
 * @author lishisheng
 */
public class Urls {
    public static final String MAINURL="http://aimipu.haini.hk/";
    public static final String ROOT=MAINURL+"?mod=appapi&act=";
	public static final String SHAREROOT=MAINURL+"?act=api&ctrl=";
	//首页标题
	public static final String HOMETITLE=ROOT+"PanicBuying";
    //首页抢购商品
	public static final String HOMEGOODS=ROOT+"PanicBuying&ctrl=getgoods";
    //商品详情
	public static final String GOODSDETAIL=ROOT+"yhq_goods&ctrl=goodsdetail";
    //拼购
	public static final String PIN=ROOT+"yhq_pingou";
    //直播
	public static final String LIVE=ROOT+"zhibo";
   //点赞
	public static final String ZAN=ROOT+"zhibo&ctrl=good";
	//获取验证码
	public static final String GETCODE=ROOT+"yhq_register&ctrl=getcode";
	//注册
	public static final String REGISTER=ROOT+"yhq_register&ctrl=register";
	//登录
	public static final String LOGIN=ROOT+"yhq_register&ctrl=login";
	//会员中心首页
	public static final String USER=ROOT+"yhq_user&ctrl=index";
	//订单
	public static final String MYORDER=ROOT+"yhq_user&ctrl=order";
    //优惠卷商品列表
	public static final String GOODSLIST=ROOT+"yhq_goods&ctrl=yhq_goodslist";
    //幻灯片
	public static final String BANNER=ROOT+"yhq_slide";
	//摇一摇分享url
	public static final String SHARE = MAINURL+"?act=api&ctrl=other&ctrl=invfriends1&name=";
	//邀请榜单TOP3
	public static final String TOP3 = SHAREROOT + "getExtendtopthree";
	//邀请累积的奖励,成功邀请的人数
	public static final String INVITEDCOUNT = SHAREROOT + "InvitationAward";
	//我的邀请
	public static final String MYINVITED = SHAREROOT + "getFirendOrder";
	//第三方分享标题，url,图片
	public static final String SHARETITLE = SHAREROOT + "getShareInfo";
	//邀请有奖图片
	public static final String INVITATE = SHAREROOT + "getpic";
    //分类
	public static final String CLASSIFY = ROOT + "category&ctrl=getCates";


}
