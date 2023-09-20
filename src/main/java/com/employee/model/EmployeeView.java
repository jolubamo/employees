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
@Subselect("select e.id, e.emp_first_name, e.emp_last_name, p.pos_title, p.pos_hire_date, CASE WHEN (DATEDIFF(day, p.pos_hire_date, GETDATE()) < p.pos_time_in_position) THEN 'Active' ELSE 'Inactive' END AS status from employee e join position p on p.emp_id = e.id")
public class EmployeeView extends Base{

	@Column(name="emp_first_name", insertable = false, updatable = false)
    private String firstName;
	
	@Column(name="emp_last_name", insertable = false, updatable = false)
    private String lastName;

	@Column(name="pos_title", insertable = false, updatable = false)
	private String positionTitle;
	
	@Column(name="pos_hire_date", insertable = false, updatable = false)
	private LocalDate dateArrival;
	
	@Column(name="status", insertable = false, updatable = false)
	private String status;
}
