package com.employee.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Subselect;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Subselect("select t.id, CASE WHEN COUNT(s.id) IS NULL THEN 0 ELSE COUNT(s.id) END AS total_students from teacher t left join classroom c on c.tea_id = t.id left join student s on s.cla_id = c.id group by t.id")
public class EmployeeView extends Base{

	@Column(name = "total_students", insertable = false, updatable = false)
    private String firstName;
	
	private String lastName;
	
	private String positionTitle;
	
	private LocalDate dateArrival;
	
	private Status status;
}
