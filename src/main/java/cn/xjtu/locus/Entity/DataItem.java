package cn.xjtu.locus.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data_item")
public class DataItem {

	public enum LocusType{
		/** 直行*/
		Straight,
		/** 左转弯*/
		TurnLeft,
		/** 右转弯*/
		TurnRight,
		/** 左换道*/
		LeftLaneChange,
		/** 右换道*/
		RightLaneChange,
		/** 左掉头*/
		TurnAround,
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	

	private String fileName;//文件名称
	private String driverName;// 驾驶员名称
	private boolean isAvailable;// 是否可用
	private String speed;// 速度性
	private String locus;// 轨迹方面
	private String comfortable;// 舒适性
	private String overallEval;// 总体评价
	private LocusType type;// 道路类型

	@Column(length=1)
	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	@Column(length=1)
	public String getLocus() {
		return locus;
	}

	public void setLocus(String locus) {
		this.locus = locus;
	}

	@Column(length=1)
	public String getComfortable() {
		return comfortable;
	}

	public void setComfortable(String comfortable) {
		this.comfortable = comfortable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length=10)
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	@Column(length=1)
	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Column(length=1)
	public String getOverallEval() {
		return overallEval;
	}

	public void setOverallEval(String overallEval) {
		this.overallEval = overallEval;
	}

	@Column(length=1)
	public LocusType getType() {
		return type;
	}

	public void setType(LocusType type) {
		this.type = type;
	}

	@Column(length=50)
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
