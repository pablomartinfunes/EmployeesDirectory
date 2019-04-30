package com.pfunes.sb.employees.service;

import com.pfunes.sb.employees.dao.EmployeeRepository;
import com.pfunes.sb.employees.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public List<Employee> findAll() {

        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    @Transactional
    public Optional<Employee> findById(int id) {

        return employeeRepository.findById(id);

    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
