package com.GermanExpats.SalaryRate.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="germanemployee")
public class GermanEmployee implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int employeeId;
    @Column(name="date_point")
    private String date_point;
    @Column(name="age")
    private int age;
    @Column(name="sex")
    private char sex;
    @Column(name="city")
    private String city;
    @Column(name="position")
    private String position;
    @Column(name="experience_in_Europe")
    private int experience_in_Europe;
    @Column(name="total_experience")
    private Integer total_experience;
    @Column(name="salary")
    private int salary;
    @Column(name="salary_1_year_ago")
    private int salary_1_year_ago;
    @Column(name="first_europe_salary")
    private int first_europe_salary;
    @Column(name="number_of_job_in_europe")
    private int number_of_job_in_europe;
    @Column(name="work_language")
    private String work_language;
    @Column(name="company_size")
    private String company_size;
    @Column(name="company_type")
    private String company_type;
    @Column(name="level")
    private String level;

//getters and setters for all fields.
    public int getId() {
        return employeeId;
    }

    public void setId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getDate_point() {
        return date_point;
    }

    public void setDate_point(String date_point) {
        this.date_point = date_point;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getExperience_in_Europe() {
        return experience_in_Europe;
    }

    public void setExperience_in_Europe(int experience_in_Europe) {
        this.experience_in_Europe = experience_in_Europe;
    }

    public int getTotal_experience() {
        return total_experience;
    }

    public void setTotal_experience(int total_experience) {
        this.total_experience = total_experience;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary_1_year_ago() {
        return salary_1_year_ago;
    }

    public void setSalary_1_year_ago(int salary_1_year_ago) {
        this.salary_1_year_ago = salary_1_year_ago;
    }

    public int getFirst_europe_salary() {
        return first_europe_salary;
    }

    public void setFirst_europe_salary(int first_europe_salary) {
        this.first_europe_salary = first_europe_salary;
    }

    public int getNumber_of_job_in_europe() {
        return number_of_job_in_europe;
    }

    public void setNumber_of_job_in_europe(int number_of_job_in_europe) {
        this.number_of_job_in_europe = number_of_job_in_europe;
    }

    public String getWork_language() {
        return work_language;
    }

    public void setWork_language(String work_language) {
        this.work_language = work_language;
    }

    public String getCompany_size() {
        return company_size;
    }

    public void setCompany_size(String company_size) {
        this.company_size = company_size;
    }

    public String getCompany_type() {
        return company_type;
    }

    public void setCompany_type(String company_type) {
        this.company_type = company_type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GermanEmployee that = (GermanEmployee) o;
        return employeeId == that.employeeId &&
                age == that.age &&
                sex == that.sex &&
                experience_in_Europe == that.experience_in_Europe &&
                salary == that.salary &&
                salary_1_year_ago == that.salary_1_year_ago &&
                first_europe_salary == that.first_europe_salary &&
                number_of_job_in_europe == that.number_of_job_in_europe &&
                Objects.equals(date_point, that.date_point) &&
                Objects.equals(city, that.city) &&
                Objects.equals(position, that.position) &&
                Objects.equals(total_experience, that.total_experience) &&
                Objects.equals(work_language, that.work_language) &&
                Objects.equals(company_size, that.company_size) &&
                Objects.equals(company_type, that.company_type) &&
                Objects.equals(level, that.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, date_point, age, sex, city, position, experience_in_Europe, total_experience, salary, salary_1_year_ago, first_europe_salary, number_of_job_in_europe, work_language, company_size, company_type, level);
    }
}
