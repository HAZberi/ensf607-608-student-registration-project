import { useState, useEffect } from "react";
import { Button, Container, Table } from "reactstrap";
import { getAllCourses } from "./controllers/appController";

const CourseCatalogue = () => {
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
            ADD
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
      <h3>Course Catalogue</h3>
      <Table className="mt-4">
        <thead>
          <tr>
            <th width="30%">Course Name</th>
            <th width="30%">Section</th>
            <th width="40%">Actions</th>
          </tr>
        </thead>
        <tbody>{courseList}</tbody>
      </Table>
    </Container>
  );
};

export default CourseCatalogue;
