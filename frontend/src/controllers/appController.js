export async function getAllCoursesSorted() {
  try {
    const response = await fetch("/api/courses sorted");
    const courses = await response.json();
    return courses;
  } catch (error) {
    return [];
  }
}

export async function getAllCourses() {
  try {
    const response = await fetch("/api/courses");
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

    return result;
  } catch (error) {
    return [];
  }
}

export async function registerCourse(stuId, offerId) {
  const requestOptions = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ studentId: stuId, offeringId: offerId}),
  };
  try {
    const response = await fetch("/api/registerCourse", requestOptions);
    const courses = await response.json();
    return courses;
  } catch (error) {
    return [];
  }
}

export async function dropCourse(stuId, offerId) {
  const requestOptions = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ studentId: stuId, offeringId: offerId}),
  };
  try {
    const response = await fetch("/api/deregisterCourse", requestOptions);
    const myCourses = await response.json();

    const registeredOfferings = await fetch("/api/offeringList", requestOptions);
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
