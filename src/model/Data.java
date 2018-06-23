package model;

public class Data {

		private int id;
		private String ename;
		private int age;
		@Override
		public String toString() {
			return "Info [id=" + id + ", ename=" + ename + ", age=" + age + "]";
		}
		public int getId() {
			return id;
		}
		public String getEname() {
			return ename;
		}
		public int getAge() {
			return age;
		}
		public void setId(int id) {
			this.id = id;
		}
		public void setEname(String ename) {
			this.ename = ename;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
	
}
