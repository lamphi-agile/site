package fr.lamphi.api.lesson;

public class Note {
	
	private int lesson;
	private int user;
	private double rate;
	
	public Note() {}

	public Note(int lesson, int user, int rate) {
		this.lesson = lesson;
		this.user = user;
		this.rate = rate;
	}

	public int getLesson() {
		return lesson;
	}

	public void setLesson(int lesson) {
		this.lesson = lesson;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

}
