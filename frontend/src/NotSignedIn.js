import React from "react";
import { Form, Row, Col, Label, Input, Button } from "reactstrap";
import { useAuth } from "./hooks/useAuth";
import { getStudent } from "./controllers/appController";

function NotSignedIn(args) {

  const { login } = useAuth();

  const handleSubmit = (e) => {
    e.preventDefault();
    const userId = e.target.studentId.value;
    getStudent(userId).then(student => {
      login(student);
      e.target.reset();
    });
  };

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
