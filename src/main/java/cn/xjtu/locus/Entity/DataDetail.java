package cn.xjtu.locus.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data_detail")
public class DataDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	// private int SynWord1;// 同步字1
	// private int SynWord2;// 同步字2
	// private int FrameNum;// 帧序号
	// private int State;// 状态字
	// private int DefWord1;//故障字1
	// private int DefWord2;//故障字2
	
	private double Longitude;// 经度
	private double Latitude;// 纬度
	private int Height;// 惯导组合高度
	private double VelE;// 东向速度
	private double VelN;// 北向速度
	private double VelU;// 天向速度
	private double Roll;// 横滚脚
	private double Pitch;// 俯仰角
	private double Course;// 惯导航向角

	// private double AliTime;//对准时间
	// private int AliState;//对准状态字

	private double LogAcce;// 纵向加速度
	private double LateralAcce;// 横向加速度
	private double NorAcce;// 法向加速度
	private int TimeYear;// 北京时间年
	private int TimeMonth;// 北京时间月
	private int TimeDay;// 北京时间日
	private int TimeHour;// 北京时间时
	private int TimeMinute;// 北京时间分
	private double TimeSecond;// 北京时间秒

	// private int EffiWord;// 有效字
	// private double MagVir;// 磁差
	// private int Check;// 校验和

	private int dataItemId;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(length=20)
	public double getLongitude() {
		return Longitude;
	}


	public void setLongitude(double longitude) {
		Longitude = longitude;
	}

	@Column(length=20)
	public double getLatitude() {
		return Latitude;
	}

	public void setLatitude(double latitude) {
		Latitude = latitude;
	}
	@Column(length=5)
	public int getHeight() {
		return Height;
	}

	public void setHeight(int height) {
		Height = height;
	}

	@Column(length=20)
	public double getVelE() {
		return VelE;
	}

	public void setVelE(double velE) {
		VelE = velE;
	}

	@Column(length=20)
	public double getVelN() {
		return VelN;
	}

	public void setVelN(double velN) {
		VelN = velN;
	}

	@Column(length=20)
	public double getVelU() {
		return VelU;
	}

	public void setVelU(double velU) {
		VelU = velU;
	}

	@Column(length=20)
	public double getRoll() {
		return Roll;
	}

	public void setRoll(double roll) {
		Roll = roll;
	}

	@Column(length=20)
	public double getPitch() {
		return Pitch;
	}

	public void setPitch(double pitch) {
		Pitch = pitch;
	}

	@Column(length=20)
	public double getCourse() {
		return Course;
	}

	public void setCourse(double course) {
		Course = course;
	}

	@Column(length=20)
	public double getLogAcce() {
		return LogAcce;
	}

	public void setLogAcce(double logAcce) {
		LogAcce = logAcce;
	}

	@Column(length=20)
	public double getLateralAcce() {
		return LateralAcce;
	}

	public void setLateralAcce(double lateralAcce) {
		LateralAcce = lateralAcce;
	}

	@Column(length=20)
	public double getNorAcce() {
		return NorAcce;
	}

	public void setNorAcce(double norAcce) {
		NorAcce = norAcce;
	}

	@Column(length=4)
	public int getTimeYear() {
		return TimeYear;
	}

	public void setTimeYear(int timeYear) {
		TimeYear = timeYear;
	}

	@Column(length=2)
	public int getTimeMonth() {
		return TimeMonth;
	}

	public void setTimeMonth(int timeMonth) {
		TimeMonth = timeMonth;
	}

	@Column(length=2)
	public int getTimeDay() {
		return TimeDay;
	}

	public void setTimeDay(int timeDay) {
		TimeDay = timeDay;
	}

	@Column(length=2)
	public int getTimeHour() {
		return TimeHour;
	}

	public void setTimeHour(int timeHour) {
		TimeHour = timeHour;
	}

	@Column(length=2)
	public int getTimeMinute() {
		return TimeMinute;
	}

	public void setTimeMinute(int timeMinute) {
		TimeMinute = timeMinute;
	}

	@Column(length=20)
	public double getTimeSecond() {
		return TimeSecond;
	}

	public void setTimeSecond(double timeSecond) {
		TimeSecond = timeSecond;
	}

	public int getDataItemId() {
		return dataItemId;
	}

	public void setDataItemId(int dataItemId) {
		this.dataItemId = dataItemId;
	}

}
