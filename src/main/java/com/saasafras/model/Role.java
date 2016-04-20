package com.saasafras.model;

public class Role {
		private String roleId;
		private String roleName;
		public String getRoleId() {
			return roleId;
		}
		public void setRoleId(String roleId) {
			this.roleId = roleId;
		}
		public String getRoleName() {
			return roleName;
		}
		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}
		public Role(String roleId, String roleName) {
			super();
			this.roleId = roleId;
			this.roleName = roleName;
		}
		public Role() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}
