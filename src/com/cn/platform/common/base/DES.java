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

    setKey(str);//�����ܳ�

  }

 

  public DES() {

    setKey("1tyasdfjwei0%^&*#$%^&YGF5$%^&");

  }

 

  /**

   * ���ݲ�������KEY

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

   * ����String��������,String�������

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

   * ���� ��String��������,String�������

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

   * ������byte[]��������,byte[]�������

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

   * ������byte[]��������,��byte[]�������

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
	  
	  String json = "{'business_scope_type':'','children':null,'content':[{'addr':'����·��ɽ��԰����','alias':['��ɽ��԰1��¥'],'area':1117,'biz_type':0,'cla':[[25,'�ز�С��']],'detail':0,'dis':-1,'ext':'','ext_type':0,'f_flag':8,'geo':'.=OXBDNBIrCycA;','geo_type':2,'indoor_pano':'','name':'��ɽ��԰1��¥','navi_x':'0','navi_y':'0','new_catalog_id':'100101','pano':1,'poiType':0,'poi_origin':0,'primary_uid':'7689213027152820987','route_flag':0,'show_tag':[],'status':1,'std_tag':'���ز�;סլ��','storage_src':'api','street_id':'b5c0165a32df5afcb4265534','tag':'���ز� סլ�� <font color=\'#c60a00\'>С��</font>','ty':2,'uid':'b5c0165a32df5afcb4265534','view_type':5},{'addr':'����·��ɽ��԰����','alias':['��ɽ��԰3��¥'],'area':1117,'biz_type':0,'cla':[[25,'�ز�С��']],'detail':0,'dis':-1,'ext':'','ext_type':0,'f_flag':8,'geo':'.=8oBDNB4ABycA;','geo_type':2,'indoor_pano':'','name':'��ɽ��԰3��¥','navi_x':'0','navi_y':'0','new_catalog_id':'100101','pano':1,'poiType':0,'poi_origin':0,'primary_uid':'3077705322893585967','route_flag':0,'show_tag':[],'status':1,'std_tag':'���ز�;סլ��','storage_src':'api','street_id':'f2b08db6fc2df384d6b74e0e','tag':'���ز� סլ�� <font color=\'#c60a00\'>С��</font>','ty':2,'uid':'f2b08db6fc2df384d6b74e0e','view_type':5},{'addr':'����·157-1����','alias':['��ɽ��԰5��'],'area':1117,'biz_type':0,'cla':[[25,'�ز�С��']],'detail':0,'dis':-1,'ext':'','ext_type':0,'f_flag':8,'geo':'.=51DDNB0AAycA;','geo_type':2,'indoor_pano':'','name':'��ɽ��԰5��¥','navi_x':'0','navi_y':'0','new_catalog_id':'100101','pano':1,'poiType':0,'poi_origin':0,'primary_uid':'9677562893437594158','route_flag':0,'show_tag':[],'status':1,'std_tag':'���ز�;סլ��','storage_src':'api','street_id':'bf7536a51553276352e5c5fa','tag':'���ز� סլ�� <font color=\'#c60a00\'>С��</font>','ty':2,'uid':'bf7536a51553276352e5c5fa','view_type':5},{'addr':'��������ͷ�����¼�԰��������9��','area':1117,'biz_type':0,'cla':[],'detail':0,'dis':-1,'ext':'','ext_type':0,'f_flag':8,'geo':'.=CICDNB8hFycA;','geo_type':2,'name':'�¼�԰��������9��','navi_x':'0','navi_y':'0','new_catalog_id':'100101','poiType':0,'poi_origin':0,'primary_uid':'15517093529873055113','route_flag':0,'show_tag':[],'status':1,'std_tag':'���ز�;סլ��','storage_src':'api','tag':'���ز� סլ�� <font color=\'#c60a00\'>С��</font>','ty':2,'uid':'a49bdcd0ddc9efe8f60e7700','view_type':5},{'addr':'��������ͷ�����¼�԰��������4��','aoi':'����','area':1117,'biz_type':0,'cla':[],'detail':0,'dis':-1,'ext':'','ext_type':0,'f_flag':8,'geo':'.=EZADNBA+EycA;','geo_type':2,'name':'�¼�԰��������4��','navi_x':'0','navi_y':'0','new_catalog_id':'100101','poiType':0,'poi_origin':0,'primary_uid':'17649978631349519009','route_flag':0,'show_tag':[],'status':1,'std_tag':'���ز�;סլ��','storage_src':'api','tag':'���ز� סլ�� <font color=\'#c60a00\'>С��</font>','ty':2,'uid':'adff1af5c5f1332fd12dd633','view_type':5},{'addr':'��������ͷ������ɽ��԰8��','area':1117,'biz_type':0,'cla':[],'detail':0,'dis':-1,'ext':'','ext_type':0,'f_flag':8,'geo':'.=sYGDNB4OAycA;','geo_type':2,'indoor_pano':'','name':'��ɽ��԰8��','navi_x':'0','navi_y':'0','new_catalog_id':'100101','pano':1,'poiType':0,'poi_origin':0,'primary_uid':'14708253719514595354','route_flag':0,'show_tag':[],'status':1,'std_tag':'���ز�;סլ��','storage_src':'api','street_id':'9f5540c183480fae7f29bdbc','tag':'���ز� סլ�� <font color=\'#c60a00\'>С��</font>','ty':2,'uid':'9f5540c183480fae7f29bdbc','view_type':5}],'current_city':{'code':131,'geo':'.=hWJPNB0A8wcA;','level':12,'name':'������','sup':1,'sup_bus':1,'sup_business_area':1,'sup_lukuang':1,'sup_subway':1,'type':2,'up_province_name':'������'},'disp_log_query_info':'','hot_city':['������|131','�Ϻ���|289','������|257','������|340','�ɶ���|75','�����|332','�Ͼ���|315','������|179','�人��|218'],'lbs_forward':{'param':[{'d_brand_id':'0','d_query_attr_type':'2','d_tag_info_list':'���ز�,סլ��,С��','sample_experiment':[]}]},'place_info':{'d_activity_gwj_section':'0-+','d_brand_id_section':'0-+','d_business_id':'','d_business_type':'','d_cater_book_pc_section':'0-+','d_cater_book_wap_section':'0-+','d_cater_rating_section':'0-+','d_data_type':'','d_discount2_section':'0-+','d_discount_section':'0-+','d_discount_tm2_section':'0-+','d_discount_tm_section':'0-+','d_dist':'0-+','d_filt_type_section':'0-+','d_free_section':'0-+','d_groupon_section':'0-+','d_groupon_type_section':'0-+','d_health_score_section':'0-+','d_hotel_book_pc_section':'0-+','d_hotel_book_wap_section':'0-+','d_level_section':'0-+','d_lowprice_flag_section':'0-+','d_meishipaihao_section':'0-+','d_movie_book_section':'0-+','d_overall_rating_section':'0-+','d_price_section':'0-+','d_query_attr_type':'2','d_rebate_section':'0-+','d_sort_rule':'0','d_sort_type':'','d_spothot_section':'0-+','d_sub_type':'','d_support_imax_section':'0-+','d_tag_filter':'0','d_tag_info_list':'���ز�,סլ��,С��','d_ticket_book_flag_section':'0-+','d_tonight_sale_flag_section':'0-+','d_total_score_section':'0-+','d_wise_price_section':'0-+','search_ext':[{'title':'','wd':''}]},'result':{'catalogID':0,'count':6,'current_null':0,'db':0,'debug':0,'jump_back':1,'loc_attr':0,'op_gel':1,'page_num':0,'qid':'10696275528627317386','requery':'','res_bound':'','res_bound_acc':'','res_l':0,'res_x':'0.000000','res_y':'0.000000','return_query':'С��','spec_dispnum':0,'time':0,'total':6,'type':21,'wd':'С��','error':0,'tp':0,'qt':'bd','c':'131','cb_wd':'С��','ar':'(12926336.05,4828672.07;12926591.98,4828928.01)','rn':'99','l':'19','ie':'utf-8'},'place_param':null}";
	  JSONObject jsonObj = JSONObject.fromObject(json);
      DES des = new DES();

      // ������Կ

      //des.setKey("12345678");

 

      String str1 = "smartplatform";

      //DES����

      String str2 = des.getEncString(str1);

      String deStr = des.getDesString(str2);

      System.out.println("����:" + str2);

      //DES����

      System.out.println("����:" + deStr);

  }

} 