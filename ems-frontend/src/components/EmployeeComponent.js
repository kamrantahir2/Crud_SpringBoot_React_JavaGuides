import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import {
  updateEmployee,
  createEmployee,
  getEmployeeById,
} from "../service/EmployeeService";

// In this component we will implement Add Employee and Update Employee functionality. This will be in the same React Component

const EmployeeComponent = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");

  const navigate = useNavigate();

  // Retrieve the employee id from the route
  const { id } = useParams();

  const saveOrUpdateEmployee = (e) => {
    e.preventDefault();

    const employee = { firstName, lastName, email };
    console.log(employee);

    if (id) {
      updateEmployee(id, employee)
        .then((response) => {
          navigate("/employees");
        })
        .catch((error) => {
          console.log(error);
        });
    } else {
      createEmployee(employee)
        .then((response) => {
          console.log(response.data);

          // Navigate to list employees page
          navigate("/employees");
        })
        .catch((error) => {
          console.log(error);
        });
    }
  };

  useEffect(() => {
    if (id) {
      getEmployeeById(id).then((response) => {
        setFirstName(response.data.firstName);
        setLastName(response.data.lastName);
        setEmail(response.data.email);
      });
    }
  }, [id]);

  const pageTitle = () => {
    if (id) {
      return <h2 className="text-center">Update Employee</h2>;
    } else {
      return <h2 className="text-center">Add Employee</h2>;
    }
  };

  return (
    <div>
      <br />
      <br />
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            {pageTitle()}
            <div className="card-body">
              <form>
                <div className="form-group mb-2">
                  <label className="form-label"> First Name :</label>
                  <input
                    type="text"
                    placeholder="Enter first name"
                    name="firstName"
                    className="form-control"
                    value={firstName}
                    onChange={(e) => setFirstName(e.target.value)}
                  ></input>
                </div>

                <div className="form-group mb-2">
                  <label className="form-label"> Last Name :</label>
                  <input
                    type="text"
                    placeholder="Enter last name"
                    name="lastName"
                    className="form-control"
                    value={lastName}
                    onChange={(e) => setLastName(e.target.value)}
                  ></input>
                </div>

                <div className="form-group mb-2">
                  <label className="form-label"> Email ID :</label>
                  <input
                    type="email"
                    placeholder="Enter email"
                    name="email"
                    className="form-control"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                  ></input>
                </div>

                <button
                  className="btn btn-success"
                  onClick={(e) => saveOrUpdateEmployee(e)}
                >
                  Submit
                </button>

                {/* <Link to="/employees" className="btn btn-danger">
                  Cancel
                </Link> */}
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default EmployeeComponent;
