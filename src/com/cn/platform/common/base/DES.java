package com.cn.platform.common.base;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DES {

 

  Key key;

 

  public DES(String str) {

    setKey(str);//生成密匙

  }

 

  public DES() {

    setKey("1tyasdfjwei0%^&*#$%^&YGF5$%^&");

  }

 

  /**

   * 根据参数生成KEY

   */

  public void setKey(String strKey) {

      try {

        KeyGenerator _generator = KeyGenerator.getInstance("DES");

        _generator.init(new SecureRandom(strKey.getBytes()));

        this.key = _generator.generateKey();

        _generator = null;

      } catch (Exception e) {

        throw new RuntimeException(

            "Error initializing SqlMap class. Cause: " + e);

      }

  }

 

  /**

   * 加密String明文输入,String密文输出

   */

  public String getEncString(String strMing) {

      byte[] byteMi = null;

      byte[] byteMing = null;

      String strMi = "";

      BASE64Encoder base64en = new BASE64Encoder();

      try {

        byteMing = strMing.getBytes("UTF8");

        byteMi = this.getEncCode(byteMing);

        strMi = base64en.encode(byteMi);

      } catch (Exception e) {

        throw new RuntimeException(

            "Error initializing SqlMap class. Cause: " + e);

      } finally {

        base64en = null;

        byteMing = null;

        byteMi = null;

      }

      return strMi;

  }

 

  /**

   * 解密 以String密文输入,String明文输出

   * @param strMi

   * @return

   */

  public String getDesString(String strMi) {

      BASE64Decoder base64De = new BASE64Decoder();

      byte[] byteMing = null;

      byte[] byteMi = null;

      String strMing = "";

      try {

        byteMi = base64De.decodeBuffer(strMi);

        byteMing = this.getDesCode(byteMi);

        strMing = new String(byteMing, "UTF8");

      } catch (Exception e) {

        throw new RuntimeException(

            "Error initializing SqlMap class. Cause: " + e);

      } finally {
        base64De = null;
        byteMing = null;
        byteMi = null;
        return strMing;
      }

     

  }

 

  /**

   * 加密以byte[]明文输入,byte[]密文输出

   * @param byteS

   * @return

   */

  private byte[] getEncCode(byte[] byteS) {

      byte[] byteFina = null;

      Cipher cipher;

      try {

        cipher = Cipher.getInstance("DES");

        cipher.init(Cipher.ENCRYPT_MODE, key);

        byteFina = cipher.doFinal(byteS);

      } catch (Exception e) {

        throw new RuntimeException(

            "Error initializing SqlMap class. Cause: " + e);

      } finally {

        cipher = null;

      }

      return byteFina;

  }

 

  /**

   * 解密以byte[]密文输入,以byte[]明文输出

   * @param byteD

   * @return

   */

  private byte[] getDesCode(byte[] byteD) {

      Cipher cipher;

      byte[] byteFina = null;

      try {

        cipher = Cipher.getInstance("DES");

        cipher.init(Cipher.DECRYPT_MODE, key);

        byteFina = cipher.doFinal(byteD);

      } catch (Exception e) {

        throw new RuntimeException(

            "Error initializing SqlMap class. Cause: " + e);

      } finally {

        cipher = null;

      }

      return byteFina;

  }

 

  public static void main(String args[]) {
	  
	  String json = "{'business_scope_type':'','children':null,'content':[{'addr':'滨河路倚山嘉园附近','alias':['倚山嘉园1号楼'],'area':1117,'biz_type':0,'cla':[[25,'地产小区']],'detail':0,'dis':-1,'ext':'','ext_type':0,'f_flag':8,'geo':'.=OXBDNBIrCycA;','geo_type':2,'indoor_pano':'','name':'倚山家园1号楼','navi_x':'0','navi_y':'0','new_catalog_id':'100101','pano':1,'poiType':0,'poi_origin':0,'primary_uid':'7689213027152820987','route_flag':0,'show_tag':[],'status':1,'std_tag':'房地产;住宅区','storage_src':'api','street_id':'b5c0165a32df5afcb4265534','tag':'房地产 住宅区 <font color=\'#c60a00\'>小区</font>','ty':2,'uid':'b5c0165a32df5afcb4265534','view_type':5},{'addr':'滨河路倚山嘉园附近','alias':['倚山嘉园3号楼'],'area':1117,'biz_type':0,'cla':[[25,'地产小区']],'detail':0,'dis':-1,'ext':'','ext_type':0,'f_flag':8,'geo':'.=8oBDNB4ABycA;','geo_type':2,'indoor_pano':'','name':'倚山家园3号楼','navi_x':'0','navi_y':'0','new_catalog_id':'100101','pano':1,'poiType':0,'poi_origin':0,'primary_uid':'3077705322893585967','route_flag':0,'show_tag':[],'status':1,'std_tag':'房地产;住宅区','storage_src':'api','street_id':'f2b08db6fc2df384d6b74e0e','tag':'房地产 住宅区 <font color=\'#c60a00\'>小区</font>','ty':2,'uid':'f2b08db6fc2df384d6b74e0e','view_type':5},{'addr':'滨河路157-1附近','alias':['倚山嘉园5栋'],'area':1117,'biz_type':0,'cla':[[25,'地产小区']],'detail':0,'dis':-1,'ext':'','ext_type':0,'f_flag':8,'geo':'.=51DDNB0AAycA;','geo_type':2,'indoor_pano':'','name':'倚山嘉园5号楼','navi_x':'0','navi_y':'0','new_catalog_id':'100101','pano':1,'poiType':0,'poi_origin':0,'primary_uid':'9677562893437594158','route_flag':0,'show_tag':[],'status':1,'std_tag':'房地产;住宅区','storage_src':'api','street_id':'bf7536a51553276352e5c5fa','tag':'房地产 住宅区 <font color=\'#c60a00\'>小区</font>','ty':2,'uid':'bf7536a51553276352e5c5fa','view_type':5},{'addr':'北京市门头沟区月季园东里社区9栋','area':1117,'biz_type':0,'cla':[],'detail':0,'dis':-1,'ext':'','ext_type':0,'f_flag':8,'geo':'.=CICDNB8hFycA;','geo_type':2,'name':'月季园东里社区9栋','navi_x':'0','navi_y':'0','new_catalog_id':'100101','poiType':0,'poi_origin':0,'primary_uid':'15517093529873055113','route_flag':0,'show_tag':[],'status':1,'std_tag':'房地产;住宅区','storage_src':'api','tag':'房地产 住宅区 <font color=\'#c60a00\'>小区</font>','ty':2,'uid':'a49bdcd0ddc9efe8f60e7700','view_type':5},{'addr':'北京市门头沟区月季园东里社区4栋','aoi':'大峪','area':1117,'biz_type':0,'cla':[],'detail':0,'dis':-1,'ext':'','ext_type':0,'f_flag':8,'geo':'.=EZADNBA+EycA;','geo_type':2,'name':'月季园东里社区4栋','navi_x':'0','navi_y':'0','new_catalog_id':'100101','poiType':0,'poi_origin':0,'primary_uid':'17649978631349519009','route_flag':0,'show_tag':[],'status':1,'std_tag':'房地产;住宅区','storage_src':'api','tag':'房地产 住宅区 <font color=\'#c60a00\'>小区</font>','ty':2,'uid':'adff1af5c5f1332fd12dd633','view_type':5},{'addr':'北京市门头沟区倚山嘉园8栋','area':1117,'biz_type':0,'cla':[],'detail':0,'dis':-1,'ext':'','ext_type':0,'f_flag':8,'geo':'.=sYGDNB4OAycA;','geo_type':2,'indoor_pano':'','name':'倚山嘉园8栋','navi_x':'0','navi_y':'0','new_catalog_id':'100101','pano':1,'poiType':0,'poi_origin':0,'primary_uid':'14708253719514595354','route_flag':0,'show_tag':[],'status':1,'std_tag':'房地产;住宅区','storage_src':'api','street_id':'9f5540c183480fae7f29bdbc','tag':'房地产 住宅区 <font color=\'#c60a00\'>小区</font>','ty':2,'uid':'9f5540c183480fae7f29bdbc','view_type':5}],'current_city':{'code':131,'geo':'.=hWJPNB0A8wcA;','level':12,'name':'北京市','sup':1,'sup_bus':1,'sup_business_area':1,'sup_lukuang':1,'sup_subway':1,'type':2,'up_province_name':'北京市'},'disp_log_query_info':'','hot_city':['北京市|131','上海市|289','广州市|257','深圳市|340','成都市|75','天津市|332','南京市|315','杭州市|179','武汉市|218'],'lbs_forward':{'param':[{'d_brand_id':'0','d_query_attr_type':'2','d_tag_info_list':'房地产,住宅区,小区','sample_experiment':[]}]},'place_info':{'d_activity_gwj_section':'0-+','d_brand_id_section':'0-+','d_business_id':'','d_business_type':'','d_cater_book_pc_section':'0-+','d_cater_book_wap_section':'0-+','d_cater_rating_section':'0-+','d_data_type':'','d_discount2_section':'0-+','d_discount_section':'0-+','d_discount_tm2_section':'0-+','d_discount_tm_section':'0-+','d_dist':'0-+','d_filt_type_section':'0-+','d_free_section':'0-+','d_groupon_section':'0-+','d_groupon_type_section':'0-+','d_health_score_section':'0-+','d_hotel_book_pc_section':'0-+','d_hotel_book_wap_section':'0-+','d_level_section':'0-+','d_lowprice_flag_section':'0-+','d_meishipaihao_section':'0-+','d_movie_book_section':'0-+','d_overall_rating_section':'0-+','d_price_section':'0-+','d_query_attr_type':'2','d_rebate_section':'0-+','d_sort_rule':'0','d_sort_type':'','d_spothot_section':'0-+','d_sub_type':'','d_support_imax_section':'0-+','d_tag_filter':'0','d_tag_info_list':'房地产,住宅区,小区','d_ticket_book_flag_section':'0-+','d_tonight_sale_flag_section':'0-+','d_total_score_section':'0-+','d_wise_price_section':'0-+','search_ext':[{'title':'','wd':''}]},'result':{'catalogID':0,'count':6,'current_null':0,'db':0,'debug':0,'jump_back':1,'loc_attr':0,'op_gel':1,'page_num':0,'qid':'10696275528627317386','requery':'','res_bound':'','res_bound_acc':'','res_l':0,'res_x':'0.000000','res_y':'0.000000','return_query':'小区','spec_dispnum':0,'time':0,'total':6,'type':21,'wd':'小区','error':0,'tp':0,'qt':'bd','c':'131','cb_wd':'小区','ar':'(12926336.05,4828672.07;12926591.98,4828928.01)','rn':'99','l':'19','ie':'utf-8'},'place_param':null}";
	  JSONObject jsonObj = JSONObject.fromObject(json);
      DES des = new DES();

      // 设置密钥

      //des.setKey("12345678");

 

      String str1 = "smartplatform";

      //DES加密

      String str2 = des.getEncString(str1);

      String deStr = des.getDesString(str2);

      System.out.println("密文:" + str2);

      //DES解密

      System.out.println("明文:" + deStr);

  }

} 