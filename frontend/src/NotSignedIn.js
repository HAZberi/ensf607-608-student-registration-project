import React from "react";
import { Form, Row, Col, Label, Input, Button } from "reactstrap";
import { Link } from "react-router-dom";
// import { useNavigate } from "react-router-dom";
import { useAuth } from "./hooks/useAuth";

function NotSignedIn(args) {


  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(e.target.studentId.value);
    alert(`Submit ho ga yahan or student Id ha ye -> ${e.target.studentId.value}`);
  };

  // const navigate = useNavigate();
  const { user, logout } = useAuth();

  return (
    <div className="d-flex justify-content-center mt-5">
      <Form onSubmit={handleSubmit}>
        <Row className="row-cols-lg-auto g-3 align-items-center">
          <Col>
            <Label className="visually-hidden" for="exampleEmail">
              Student ID
            </Label>
            <Input
              id="studentId"
              name="studentId"
              placeholder="Enter StudentID"
              type="text"
            />
          </Col>
          <Col>
            <Button color="btn btn-primary" type="submit">Submit</Button>
          </Col>
        </Row>
      </Form>
    </div>
  );
}

export default NotSignedIn;
