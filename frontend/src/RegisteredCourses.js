import { useState, useEffect } from "react";
import { Button, Container, Table } from "reactstrap";
import { getAllCourses, getAllCoursesSorted } from "./controllers/appController";

const RegisteredCourses = () => {
  const [courses, setCourses] = useState([]);
  const [isLoading, setLoading] = useState(true);

  useEffect(() => {
    let mounted = true;
    setLoading(true);
    getAllCourses().then((list) => {
      if (mounted) {
        setCourses(list);
        setLoading(false);
      }
    });
    return () => (mounted = false);
  }, []);

  const sortCourses = () => {
    setLoading(true);
    getAllCoursesSorted().then((list) => {
        setCourses(list);
        setLoading(false);
    });
  }

  const courseList = courses.map((course) => {
    return (
      <tr key={course.courseUniqueID}>
        <td style={{ whiteSpace: "nowrap" }}>{course.courseID}</td>
        <td>{1}</td>
        <td>
          <Button
            size="sm"
            color="primary"
          >
            DROP
          </Button>
        </td>
      </tr>
    );
  });

  return isLoading ? (
    <p>Loading...</p>
  ) : (
    <Container>
      <div className="d-flex justify-content-end">
        <Button color="success">Search Course</Button>
      </div>
      <h3>Registered Courses</h3>
      <Table className="mt-4">
        <thead>
          <tr>
            <th width="30%">Course Name <Button color="primary" onClick={sortCourses}>Sort Me</Button></th>
            <th width="30%">Section</th>
            <th width="40%">Actions</th>
          </tr>
        </thead>
        <tbody>{courseList}</tbody>
      </Table>
    </Container>
  );
};

export default RegisteredCourses;
