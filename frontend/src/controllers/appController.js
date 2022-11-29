export async function getAllCourses() {
  try {
    const response = await fetch("/courses sorted");
    const courses = await response.json();
    console.log(courses);
    return courses;
  } catch (error) {
    return [];
  }
}

