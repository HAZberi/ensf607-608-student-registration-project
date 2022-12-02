export async function getAllCoursesSorted() {
  try {
    const response = await fetch("/courses sorted");
    const courses = await response.json();
    return courses;
  } catch (error) {
    return [];
  }
}

export async function getAllCourses() {
  try {
    const response = await fetch("/courses");
    const courses = await response.json();
    return courses;
  } catch (error) {
    return [];
  }
}

export async function myRegisteredCourses(id) {
  try {
    const requestOptions = {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ studentId: id }),
    };
    const registeredCourses = await fetch(
      "/api/registeredList",
      requestOptions
    );
    const myCourses = await registeredCourses.json();

    const registeredOfferings = await fetch(
      "/api/offeringList",
      requestOptions
    );
    const myOfferings = await registeredOfferings.json();

    const result = [myCourses, myOfferings];

    console.log(result);
    return result;
  } catch (error) {
    return [];
  }
}

export async function registerCourse() {
  try {
    const response = await fetch("/registerCourse");
    const courses = await response.json();
    return courses;
  } catch (error) {
    return [];
  }
}

export async function dropCourse() {
  try {
    const response = await fetch("/deregisterCourse");
    const myCourses = await response.json();

    const registeredOfferings = await fetch("/offeringList");
    const myOfferings = await registeredOfferings.json();

    const result = [myCourses, myOfferings];

    return result;
  } catch (error) {
    return [];
  }
}

export async function getStudent(id) {
  const requestOptions = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ studentId: id }),
  };
  try {
    const response = await fetch("/api/byID", requestOptions);
    const student = await response.json();
    return student;
  } catch (error) {
    return []; //need to change this depending on the response
  }
}
