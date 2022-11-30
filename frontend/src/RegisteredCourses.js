import { useState, useEffect } from "react";
import { Button, Container, Table } from "reactstrap";
import { ToastContainer, toast } from "react-toastify";
import { myRegisteredCourses } from "./controllers/appController";

const RegisteredCourses = () => {
  const [courses, setCourses] = useState([]);
  const [isLoading, setLoading] = useState(true);

  useEffect(() => {
    let mounted = true;
    setLoading(true);
    myRegisteredCourses().then((list) => {
      if (mounted) {
        setCourses(list);
        setLoading(false);
      }
    });
    return () => (mounted = false);
  }, []);

  const dropCourse = (e) => {
    toast.success("Course Dropped Successfully", {
      position: "top-center",
      autoClose: 3000,
      hideProgressBar: false,
      closeOnClick: true,
      pauseOnHover: true,
      theme: "colored",
    });
  };

  const courseList = courses.map((course) => {
    const offerings = course.offerings.map((offering) => {
      return (
        <tr key={offering.offeringId}>
          <td style={{ whiteSpace: "nowrap" }}>{course.courseID}</td>
          <td>{offering.sectionNo}</td>
          <td>
            <Button size="sm" color="primary" onClick={dropCourse}>
              DROP
            </Button>
          </td>
        </tr>
      );
    });
    return offerings;
  });

  return (
    <Container>
      <h3 className="mt-4 mb-4">Registered Courses</h3>
      {isLoading ? (
        <div className="d-flex justify-content-center">
          <div
            className="spinner-border"
            style={{ width: "5rem", height: "5rem", marginTop: "10rem" }}
            role="status"
          >
            <span className="visually-hidden">Loading...</span>
          </div>
        </div>
      ) : (
        <Table className="mt-4">
          <thead>
            <tr>
              <th width="45%">
                <div className="d-flex justify-content-between">
                  Course Name
                </div>
              </th>
              <th width="25%">
                <div className="d-flex justify-content-between mb-1">
                  Section
                </div>
              </th>
              <th width="20%">
                <div className="d-flex justify-content-between mb-1">
                  Actions
                </div>
              </th>
            </tr>
          </thead>
          <tbody>{courseList}</tbody>
        </Table>
      )}
      <ToastContainer />
    </Container>
  );
};

export default RegisteredCourses;
