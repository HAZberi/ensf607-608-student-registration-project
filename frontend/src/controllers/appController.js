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

export async function myRegisteredCourses() {
  try {

    console.log("Before requests");

    const registeredCourses = await fetch("/registeredList");
    const myCourses = await registeredCourses.json();

    const registeredOfferings = await fetch("/offeringList");
    const myOfferings = await registeredOfferings.json();

    const result = [myCourses, myOfferings];

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
    const courses = await response.json();
    return courses;
  } catch (error) {
    return [];
  }
}
