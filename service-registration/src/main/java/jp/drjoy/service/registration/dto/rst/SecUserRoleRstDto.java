/**
* Copyright (c) Acroquest Technology Co., Ltd. All Rights Reserved.
* Please read the associated COPYRIGHTS file for more details.
*
* THE SOFTWARE IS PROVIDED BY Acroquest Technology Co., Ltd.,
* WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
* BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
* IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDER BE LIABLE FOR ANY
* CLAIM, DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING
* OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
*/

package jp.drjoy.service.registration.dto.rst;

import java.io.Serializable;
import java.sql.Timestamp;

import jp.drjoy.service.common.dto.DTO;

public class SecUserRoleRstDto extends DTO<Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;
	private SecRoleRstDto secRole;

	public SecRoleRstDto getSecRole() {
		return secRole;
	}

	public void setSecRole(SecRoleRstDto secRole) {
		this.secRole = secRole;
	}

	public static class SecRoleRstDto implements Serializable {

		private static final long serialVersionUID = 1L;

		private Long id;

		private Timestamp createdTime;

		private Long creatorId;

		private String dbActive;

		private String description;

		private Long lastUpdatedId;

		private Timestamp lastUpdatedTime;

		private String name;

		private String type;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Timestamp getCreatedTime() {
			return createdTime;
		}

		public void setCreatedTime(Timestamp createdTime) {
			this.createdTime = createdTime;
		}

		public Long getCreatorId() {
			return creatorId;
		}

		public void setCreatorId(Long creatorId) {
			this.creatorId = creatorId;
		}

		public String getDbActive() {
			return dbActive;
		}

		public void setDbActive(String dbActive) {
			this.dbActive = dbActive;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Long getLastUpdatedId() {
			return lastUpdatedId;
		}

		public void setLastUpdatedId(Long lastUpdatedId) {
			this.lastUpdatedId = lastUpdatedId;
		}

		public Timestamp getLastUpdatedTime() {
			return lastUpdatedTime;
		}

		public void setLastUpdatedTime(Timestamp lastUpdatedTime) {
			this.lastUpdatedTime = lastUpdatedTime;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

	}
}
