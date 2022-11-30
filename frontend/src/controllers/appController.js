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
        const response = await fetch("/registeredList");
        const courses = await response.json();
        return courses;
      } catch (error) {
        return [];
      }
}

