import { useState, useEffect } from "react";
import { Button, Container, Table } from "reactstrap";
import { ToastContainer, toast } from "react-toastify";
import { myRegisteredCourses, dropCourse } from "./controllers/appController";
import { useAuth } from "./hooks/useAuth";

const RegisteredCourses = () => {
  const [courses, setCourses] = useState([]);
  const [isLoading, setLoading] = useState(true);
  const { user } = useAuth();

  useEffect(() => {
    let mounted = true;
    setLoading(true);
    myRegisteredCourses(user.studentId).then((list) => {
      if (mounted) {
        setCourses(list);
        setLoading(false);
      }
    });
    return () => (mounted = false);
  }, [user]);

  const dropCrs = (offeringId, courseName, e) => {
    dropCourse(user.studentId, offeringId).then((list) => {
      if (!list.error) {
        const droppedCourse = list[0].filter((course) =>
          course.courseID.toLowerCase().includes(courseName.toLowerCase())
        );
        setCourses([...list]);
        if (droppedCourse.length === 0) {
          return toast.success("Course Dropped Successfully", {
            position: "top-center",
            autoClose: 3000,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            theme: "colored",
          });
        }
      }
      return toast.error("Course cannot be dropped", {
        position: "top-center",
        autoClose: 3000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        theme: "colored",
      });
    });
  };

  const courseList =
    courses.length === 2 ? (
      courses[0].map((course) => {
        const offerings = course.offerings.map((offering) => {
          const offeringFilter = courses[1].filter(
            (myOffering) => myOffering.offeringId === offering.offeringId
          );
          if (offeringFilter.length > 0) {
            return (
              <tr key={offeringFilter[0].offeringId}>
                <td style={{ whiteSpace: "nowrap" }}>{course.courseID}</td>
                <td>{offeringFilter[0].sectionNo}</td>
                <td>
                  <Button
                    size="sm"
                    color="primary"
                    onClick={(e) => dropCrs(offeringFilter[0].offeringId, course.courseID, e)}
                  >
                    DROP
                  </Button>
                </td>
              </tr>
            );
          }

          return <></>;
        });
        return offerings;
      })
    ) : (
      <></>
    );

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
