package com.mnc.dralarm;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.mnc.dralarm.adp.DralarmAdapter;
import com.mnc.dralarm.adp.DralarmCustomEventPlatformEnum;
import com.mnc.dralarm.av.DralarmLayout;
import com.mnc.dralarm.controller.listener.DralarmListener;
import com.mnc.dralarm.util.DralarmLayoutPosition;
import com.mnc.dralarm.util.DralarmSize;
import com.mnc.dralarm.util.DralarmUtil;
import com.mnc.dralarm.util.L;

public class CodeTypeAD extends Activity implements DralarmListener{
	
	DralarmLayout adsMogoView;
	private String mogoID = "34da8f0b85924b9f806f81ad75fa9377";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		L.debug = true; //璁剧疆鎵撳紑灞曠ずmogo鏃ュ織锛岄粯璁ゅ叧闂紙false锛�
		/**
		 * step1,鍒濆鍖朼dsMogoView
		 * 鍙傛暟锛氱涓�涓猘ctivity,绗簩涓猰ogoID锛堣鍊间负鑺掓灉鍚庡彴鐢宠鐨勭敓浜х殑鑺掓灉ID锛岄潪鍗曚竴骞冲彴ID锛�,绗笁涓缃箍鍛婂睍绀轰綅缃�,绗洓涓姹傚箍鍛婂昂瀵�		 *
		 */
		DralarmLayout adsMogoView = new DralarmLayout(this, mogoID,DralarmLayoutPosition.CENTER_BOTTOM,DralarmSize.AdsMoGoBanner);
		
		/**
		 * step2,璁剧疆鐩戝惉
		 * 鍙傛暟锛氫负AdsMogoListener
		 */
		adsMogoView.setDralarmListener(this);
		
		
		/**
		 * step3,娣诲姞adsMogoView鍒版寚瀹氱殑view涓�
		 */
		RelativeLayout parentLayput = new RelativeLayout(this);
		
		
		initCenterAd(parentLayput); //锛堜负浜哾emo鏁堟灉,姝ｅ紡浣跨敤鍙互娌℃湁杩欎釜锛屾牴鎹嚜宸遍�昏緫璁剧疆锛�
		initTopAd(parentLayput); //锛堜负浜哾emo鏁堟灉,姝ｅ紡浣跨敤鍙互娌℃湁杩欎釜锛屾牴鎹嚜宸遍�昏緫璁剧疆锛�
		
		RelativeLayout.LayoutParams parentLayputParams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.MATCH_PARENT);
		this.addContentView(parentLayput, parentLayputParams);
	}
	/**
	 * 鍒濆鍖栦腑闂村箍鍛婏紙涓轰簡demo鏁堟灉,姝ｅ紡浣跨敤鍙互娌℃湁杩欎釜锛屾牴鎹嚜宸遍�昏緫璁剧疆锛�
	 */
	private void initCenterAd(RelativeLayout parentLayput){		
		
		/**
		 * step1,鍒濆鍖朼dsMogoView
		 * 鍙傛暟锛氱涓�涓猘ctivity,绗簩涓猰ogoID锛堣鍊间负鑺掓灉鍚庡彴鐢宠鐨勭敓浜х殑鑺掓灉ID锛岄潪鍗曚竴骞冲彴ID锛�,绗笁涓姹傚箍鍛婂昂瀵�		 *
		 */
		final DralarmLayout adsMogoView = new DralarmLayout(this, mogoID,DralarmSize.AdsMoGoBanner);
		adsMogoView.setVisibility(View.GONE); //璁剧疆骞垮憡view闅愯棌锛堜负浜哾emo鏁堟灉,姝ｅ紡浣跨敤鍙互娌℃湁杩欎釜锛屾牴鎹嚜宸遍�昏緫璁剧疆锛�
		/**
		 * step2,璁剧疆鐩戝惉
		 * 鍙傛暟锛氫负AdsMogoListener
		 */
		adsMogoView.setDralarmListener(this);
		
		final Button centerBt = new Button(this);
		centerBt.setText("涓棿灞曠ず骞垮憡");
		centerBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				adsMogoView.setVisibility(View.VISIBLE);
				centerBt.setVisibility(View.GONE);
			}
		});
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT,
				RelativeLayout.TRUE);		
		parentLayput.addView(centerBt,layoutParams);
		parentLayput.addView(adsMogoView, layoutParams);
		
		
	}
	
	/**
	 * 鍒濆鍖栭《閮ㄥ箍鍛婏紙涓轰簡demo鏁堟灉,姝ｅ紡浣跨敤鍙互娌℃湁杩欎釜锛屾牴鎹嚜宸遍�昏緫璁剧疆锛�
	 */
	private void initTopAd(RelativeLayout parentLayput){
		/**
		 * step1,鍒濆鍖朼dsMogoView
		 * 鍙傛暟锛氱涓�涓猘ctivity,绗簩涓猰ogoID锛堣鍊间负鑺掓灉鍚庡彴鐢宠鐨勭敓浜х殑鑺掓灉ID锛岄潪鍗曚竴骞冲彴ID锛�		 *
		 */
		final DralarmLayout adsMogoView = new DralarmLayout(this, mogoID,DralarmSize.AdsMoGoBanner);
		adsMogoView.setVisibility(View.GONE); //璁剧疆骞垮憡view闅愯棌锛堜负浜哾emo鏁堟灉,姝ｅ紡浣跨敤鍙互娌℃湁杩欎釜锛屾牴鎹嚜宸遍�昏緫璁剧疆锛�
		/**
		 * step2,璁剧疆鐩戝惉
		 * 鍙傛暟锛氫负AdsMogoListener
		 */
		adsMogoView.setDralarmListener(this);
		
		/**
		 * step3,娣诲姞adsMogoView鍒版寚瀹氱殑view涓�
		 */
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		Button topBt = new Button(this);
		topBt.setText("椤堕儴灞曠ず骞垮憡");
		topBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				adsMogoView.setVisibility(View.VISIBLE);
			}
		});
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP,
				RelativeLayout.TRUE);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,
				RelativeLayout.TRUE);
		parentLayput.addView(topBt,layoutParams);
		parentLayput.addView(adsMogoView, layoutParams);
		
	}
	
	@Override
	protected void onDestroy() {
		// 娓呴櫎 adsMogoLayout 瀹炰緥 鎵�浜х敓鐢ㄤ簬澶氱嚎绋嬬紦鍐叉満鍒剁殑绾跨▼姹�
		// 姝ゆ柟娉曡涓嶈杞绘槗璋冪敤锛屽鏋滆皟鐢ㄦ椂闂翠笉褰擄紝浼氶�犳垚鏃犳硶缁熻璁℃暟
//		if (adsMogoView != null) {
//			adsMogoView.clearThread();
//		}
		super.onDestroy();
	}

	@Override
	public void onClickAd(String adName) {
		// TODO Auto-generated method stub
		/**
		 * 鐐瑰嚮banner浼氭墽琛岃繖涓洖璋�
		 * 鍙傛暟锛歛dName 涓哄綋鍓嶇偣鍑荤殑骞垮憡骞冲彴鍚嶇О
		 */
		Log.d(DralarmUtil.ADMOGO, "-=onClickAd=-"+adName);
	}

	@Override
	public boolean onCloseAd() {
		// TODO Auto-generated method stub
		/**
		 * 褰撶敤鎴风偣鍑讳簡骞垮憡鍏抽棴鎸夐挳鏃跺洖璋�(鍏抽棴骞垮憡鎸夐挳鍔熻兘鍙互鍦∕ogo鐨凙pp绠＄悊涓缃�)
		 * return false 鍒欏箍鍛婂叧闂� return true 骞垮憡灏嗕笉浼氬叧闂�
		 */
		Log.d(DralarmUtil.ADMOGO, "-=onCloseAd=-");
		
		AlertDialog dialog = new AlertDialog.Builder(this).create();

		dialog.setMessage("鏄惁鍏抽棴骞垮憡锛�");

		dialog.setButton("鏄�", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				// return true;

				dialog.dismiss();

				if (adsMogoView != null) {
					// 鍏抽棴褰撳墠骞垮憡
					adsMogoView.setADEnable(false);
				}

			}
		});

		dialog.setButton2("鍚�", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub

				dialog.dismiss();
			}
		});

		dialog.show();
		return true;
	}

	@Override
	public void onCloseMogoDialog() {
		// TODO Auto-generated method stub
		/**
		 * 褰撶敤鎴峰叧闂簡涓嬭浇绫诲瀷骞垮憡鐨勮缁嗙晫闈㈡椂鍥炶皟(骞垮憡鐗╂枡绫诲瀷涓轰笅杞藉箍鍛婂苟涓旀槸寮瑰嚭绠�浠嬩笅杞界殑鎵嶄細鏈夋Dialog)
		 */
		Log.d(DralarmUtil.ADMOGO, "-=onCloseMogoDialog=-");
	}

	@Override
	public void onFailedReceiveAd() {
		// TODO Auto-generated method stub
		/**
		 * 鎵�鏈夊箍鍛婂钩鍙拌姹傚け璐ユ椂鍥炶皟
		 */
		Log.d(DralarmUtil.ADMOGO, "-=onFailedReceiveAd=-");
	}

	@Override
	public void onRealClickAd() {
		// TODO Auto-generated method stub
		/**
		 * 褰撶敤鎴风偣鍑诲箍鍛婃椂(鐪熷疄鐐瑰嚮骞垮憡娆℃暟, Mogo涓嶄細鏍规嵁姝ゅ洖璋冩椂璁板綍鐐瑰嚮鏁帮紝娆＄偣鍑绘槸鏃犺繃婊よ繃鐨勭偣鍑�)
		 */
		Log.d(DralarmUtil.ADMOGO, "-=onRealClickAd=-");
	}

	@Override
	public void onReceiveAd(ViewGroup view, String adName) {
		// TODO Auto-generated method stub
		/**
		 * 璇锋眰骞垮憡鎴愬姛鏃跺洖璋� view涓哄崟涓�骞冲彴鐨勫箍鍛婅鍥� adName涓鸿姹傚钩鍙板悕绉�
		 */
		Log.d(DralarmUtil.ADMOGO, "-=onReceiveAd=-"+adName);
	}

	@Override
	public void onRequestAd(String adName) {
		// TODO Auto-generated method stub
		/**
		 * 寮�濮嬭姹傚箍鍛婃椂鍥炶皟 adName涓鸿姹傚钩鍙板悕绉�
		 */
		Log.d(DralarmUtil.ADMOGO, "-=onRequestAd=-"+adName);
	}
	
	
	/**
	 *  鑷畾涔夊钩鍙板姛鑳斤細鍏宠仈鑷畾涔堿dapter
		 濡備笉闇�瑕佽嚜瀹氫箟骞冲彴鍔熻兘锛� 杩斿洖 null
		AdsMogoCustomEventPlatform_1瀵瑰簲骞冲彴涓�
		AdsMogoCustomEventPlatform_2瀵瑰簲骞冲彴浜岋紝濡傛灉寮�鍙戣�呬慨鏀瑰钩鍙板悕绉扮殑璇濓紝闇�澶囨敞涓�涓嬩互鍏嶅紕娣�
		 濡備笉闇�瑕佽嚜瀹氫箟骞冲彴鍔熻兘锛� 杩斿洖 null
	 */
	@Override
	public Class getCustomEvemtPlatformAdapterClass(
			DralarmCustomEventPlatformEnum enumIndex) {
		// TODO Auto-generated method stub
		Class<? extends DralarmAdapter> clazz = null;
		if (DralarmCustomEventPlatformEnum.DralarmCustomEventPlatform_1
				.equals(enumIndex)) {
//			clazz = DianDongAdapter.class;
		}
		return clazz;
	}


}
