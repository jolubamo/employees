package com.employee.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="position")
public class Position extends Base{
	
	@ManyToOne(optional = false)
    @JoinColumn(name="emp_id",nullable = false, foreignKey = @ForeignKey(name = "fk_position_employee"))
    private Employee employee;

	
	@Column(name="pos_title", nullable = false)
    private String title;
	
	@Column(name="pos_hire_date", nullable = false)
    private LocalDate hireDate;
	
	@Column(name="pos_email", nullable = false)
    private String email;
	
	@Column(name="pos_salary", nullable = false)
    private double salary;
	
	@Column(name="pos_time_in_position", nullable = false)
    private int timeInPosition;
    

}
