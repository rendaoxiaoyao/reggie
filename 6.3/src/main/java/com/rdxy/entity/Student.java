package com.rdxy.entity;

public class Student {
	public int id;
	public String name;
	public String sex;
	public int age;
	public String grade;
	public float score;
	public String file;

	public Student() {
	}

	public Student(int id, String name, String sex, int age, String grade, float score,String file) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.grade = grade;
		this.score = score;
		this.file=file;
	}

	public Student(int id, String name, String sex, int age, String grade, float score) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.grade = grade;
		this.score = score;
	}

	public Student(String name, String sex, int age, String grade, float score) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.grade = grade;
		this.score = score;
	}

    public Student(Integer id, String file) {
		this.id=id;
		this.file=file;
    }

    /**
	 * 获取
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 设置
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 获取
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * 设置
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * 获取
	 * @return grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * 设置
	 * @param grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * 获取
	 * @return score
	 */
	public float getScore() {
		return score;
	}

	/**
	 * 设置
	 * @param score
	 */
	public void setScore(float score) {
		this.score = score;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getFile() {
		return file;
	}

	public String toString() {
		return "Student{id = " + id + ", name = " + name + ", sex = " + sex + ", age = " + age + ", grade = " + grade + ", score = " + score + "}";
	}
}
