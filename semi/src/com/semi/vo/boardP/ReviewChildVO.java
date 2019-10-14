package com.semi.vo.boardP;

public class ReviewChildVO {

		private int rcnum;
		private int rnum;
		private String rcwriter;
		private String comments;
		private int ref;
		private int lev;
		private int step;
		
		public ReviewChildVO() {
			
		}

		public ReviewChildVO(int rcnum, int rnum, String rcwriter, String comments, int ref, int lev, int step) {
			super();
			this.rcnum = rcnum;
			this.rnum = rnum;
			this.rcwriter = rcwriter;
			this.comments = comments;
			this.ref = ref;
			this.lev = lev;
			this.step = step;
		}

		public int getRcnum() {
			return rcnum;
		}

		public void setRcnum(int rcnum) {
			this.rcnum = rcnum;
		}

		public int getRnum() {
			return rnum;
		}

		public void setRnum(int rnum) {
			this.rnum = rnum;
		}

		public String getRcwriter() {
			return rcwriter;
		}

		public void setRcwriter(String rcwriter) {
			this.rcwriter = rcwriter;
		}

		public String getComments() {
			return comments;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}

		public int getRef() {
			return ref;
		}

		public void setRef(int ref) {
			this.ref = ref;
		}

		public int getLev() {
			return lev;
		}

		public void setLev(int lev) {
			this.lev = lev;
		}

		public int getStep() {
			return step;
		}

		public void setStep(int step) {
			this.step = step;
		}
		
}
