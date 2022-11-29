import { useState, useEffect } from "react";
import { Button, Container, Table, Input } from "reactstrap";
import {
  getAllCourses,
  getAllCoursesSorted,
} from "./controllers/appController";

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

  const sortCourses = () => {
    setLoading(true);
    getAllCoursesSorted().then((list) => {
      setCourses(list);
      setLoading(false);
    });
  };

  const courseList = courses.map((course) => {
    return (
      <tr key={course.courseUniqueID}>
        <td style={{ whiteSpace: "nowrap" }}>{course.courseID}</td>
        <td>{1}</td>
        <td>
          <Button size="sm" color="primary">
            REGISTER
          </Button>
        </td>
      </tr>
    );
  });

  return isLoading ? (
    <p>Loading...</p>
  ) : (
    <Container>
      <h3 className="mt-2 mb-4">Course Catalogue</h3>
      <div className="d-flex justify-content-center">
        <Input
          id="search"
          name="search"
          placeholder="Enter Course Name"
          type="text"
          bsSize="lg"
          value=""
        />
      </div>
      <Table className="mt-1">
        <thead>
          <tr>
            <th width="45%">
              <div className="d-flex justify-content-between">
                Course Name
                <Button
                  color="btn btn-outline-primary btn-sm"
                  onClick={sortCourses}
                >
                  Sort Me
                </Button>
              </div>
            </th>
            <th width="25%">
              <div className="d-flex justify-content-between mb-1">Section</div>
            </th>
            <th width="20%">
              <div className="d-flex justify-content-between mb-1">Actions</div>
            </th>
          </tr>
        </thead>
        <tbody>{courseList}</tbody>
      </Table>
    </Container>
  );
};

export default CourseCatalogue;
