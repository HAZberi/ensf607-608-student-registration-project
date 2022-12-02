import React from "react";
import { Form, Row, Col, Label, Input, Button } from "reactstrap";
import { useAuth } from "./hooks/useAuth";
import { getStudent } from "./controllers/appController";
import { ToastContainer, toast } from "react-toastify";

function NotSignedIn(args) {
  const { login } = useAuth();

  const handleSubmit = (e) => {
    e.preventDefault();
    const userId = e.target.studentId.value;
    getStudent(userId).then((student) => {
      e.target.reset();
      if (!student.error) {
        login(student);
      } else {
        toast.error(student.message, {
          position: "top-center",
          autoClose: 3000,
          hideProgressBar: false,
          closeOnClick: true,
          pauseOnHover: true,
          theme: "colored",
        });
      }
    });
  };

  return (
    <>
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
              <Button color="btn btn-primary" type="submit">
                Submit
              </Button>
            </Col>
          </Row>
        </Form>
      </div>
      <ToastContainer />
    </>
  );
}

export default NotSignedIn;
