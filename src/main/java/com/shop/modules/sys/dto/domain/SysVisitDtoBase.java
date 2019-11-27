package com.shop.modules.sys.dto.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.shop.common.dto.BaseDto;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author Generator
 * @date 2019-08-27 18:00:06
 */
public class SysVisitDtoBase extends BaseDto implements Serializable {
	private static final long serialVersionUID = 1L;

			/**
		 * id
		 */
		@TableId
		private Integer visitId;
			/**
		 * 访问ip
		 */
		private String visitIp;
			/**
		 * 访问地址
		 */
		private String visitAddress;
			/**
		 * 访问次数
		 */
		private Integer visitNum;
			/**
		 * X 纬度
		 */
		private String visitX;
			/**
		 * Y 经度
		 */
		private String visitY;
			/**
		 * 有效状态
		 */
		private String validInd;
			/**
		 * 创建人
		 */
		private String createdUser;
			/**
		 * 创建时间
		 */
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
		private Date createdDate;
			/**
		 * 更新人
		 */
		private String updatedUser;
			/**
		 * 更新时间
		 */
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
		private Date updatedDate;
	
			/**
		 * 设置：id
		 */
		public void setVisitId(Integer visitId) {
			this.visitId = visitId;
		}
		/**
		 * 获取：id
		 */
		public Integer getVisitId() {
			return visitId;
		}
			/**
		 * 设置：访问ip
		 */
		public void setVisitIp(String visitIp) {
			this.visitIp = visitIp;
		}
		/**
		 * 获取：访问ip
		 */
		public String getVisitIp() {
			return visitIp;
		}
			/**
		 * 设置：访问地址
		 */
		public void setVisitAddress(String visitAddress) {
			this.visitAddress = visitAddress;
		}
		/**
		 * 获取：访问地址
		 */
		public String getVisitAddress() {
			return visitAddress;
		}
			/**
		 * 设置：访问次数
		 */
		public void setVisitNum(Integer visitNum) {
			this.visitNum = visitNum;
		}
		/**
		 * 获取：访问次数
		 */
		public Integer getVisitNum() {
			return visitNum;
		}
			/**
		 * 设置：X 纬度
		 */
		public void setVisitX(String visitX) {
			this.visitX = visitX;
		}
		/**
		 * 获取：X 纬度
		 */
		public String getVisitX() {
			return visitX;
		}
			/**
		 * 设置：Y 经度
		 */
		public void setVisitY(String visitY) {
			this.visitY = visitY;
		}
		/**
		 * 获取：Y 经度
		 */
		public String getVisitY() {
			return visitY;
		}
			/**
		 * 设置：有效状态
		 */
		public void setValidInd(String validInd) {
			this.validInd = validInd;
		}
		/**
		 * 获取：有效状态
		 */
		public String getValidInd() {
			return validInd;
		}
			/**
		 * 设置：创建人
		 */
		public void setCreatedUser(String createdUser) {
			this.createdUser = createdUser;
		}
		/**
		 * 获取：创建人
		 */
		public String getCreatedUser() {
			return createdUser;
		}
			/**
		 * 设置：创建时间
		 */
		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}
		/**
		 * 获取：创建时间
		 */
		public Date getCreatedDate() {
			return createdDate;
		}
			/**
		 * 设置：更新人
		 */
		public void setUpdatedUser(String updatedUser) {
			this.updatedUser = updatedUser;
		}
		/**
		 * 获取：更新人
		 */
		public String getUpdatedUser() {
			return updatedUser;
		}
			/**
		 * 设置：更新时间
		 */
		public void setUpdatedDate(Date updatedDate) {
			this.updatedDate = updatedDate;
		}
		/**
		 * 获取：更新时间
		 */
		public Date getUpdatedDate() {
			return updatedDate;
		}
	}
