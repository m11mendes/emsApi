package net.javaguides.ems.repository;

import net.javaguides.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//We don't have to add @Repository annotation, because this class extends JpaRepository, which already has that annotation
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
