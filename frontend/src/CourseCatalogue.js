import { useState, useEffect } from "react";
import { Button, Container, Table, Input } from "reactstrap";
import {
  getAllCourses,
  getAllCoursesSorted,
} from "./controllers/appController";

const CourseCatalogue = () => {
  const [courses, setCourses] = useState([]);
  const [isLoading, setLoading] = useState(true);
  const [filteredData, setFilteredData] = useState([]);
  const [wordEntered, setWordEntered] = useState("");

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

  const handleFilter = (event) => {
    const searchWord = event.target.value;
    setWordEntered(searchWord);
    const newFilter = courses.filter((course) => {
      return course.courseID.toLowerCase().includes(searchWord.toLowerCase());
    });

    if (searchWord === "") {
      setFilteredData([]);
    } else {
      setFilteredData(newFilter);
    }
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

  const filteredList = filteredData.map((course) => {
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

  return (
    <Container>
      <h3 className="mt-2 mb-4">Course Catalogue</h3>
      <div className="d-flex justify-content-center">
        <Input
          id="search"
          name="search"
          placeholder="Enter Course Name"
          type="text"
          bsSize="lg"
          value={wordEntered}
          onChange={handleFilter}
        />
      </div>
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
          <tbody>{filteredData.length === 0 ? courseList : filteredList}</tbody>
        </Table>
      )}
    </Container>
  );
};

export default CourseCatalogue;
