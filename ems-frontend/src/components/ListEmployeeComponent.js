import React, { useState, useEffect } from "react";

import { listEmployees } from "../service/EmployeeService";

const ListEmployeeComponent = () => {
    const [employees, setEmployees] = useState([]);

    useEffect(() => {
        getAllEmployees()
    }, [])

    const getAllEmployees = () => {
        listEmployees()
            .then((response) => {
            setEmployees(response.data);
            console.log(response.data);
            })
            .catch((error) => {
                console.log(error)
            })
    }

    return (
        <div className="container">
            <h2 className="text-center"> List Employees </h2>
            <table className="table table-bordered table-striped">
                <thead>
                    <th> Employee ID </th>
                    <th> Employee First Name </th>
                    <th> Emplyee Last Name </th>
                    <th> Employee Email ID </th>
                </thead>
                <tbody>
                    {
                        employees.map(
                            employee => 
                                <tr key={employee.id}>
                                    <td>{employee.id}</td>
                                    <td>{employee.firstName}</td>
                                    <td>{employee.lastName}</td>
                                    <td>{employee.email}</td>
                                </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )

};

export default ListEmployeeComponent;