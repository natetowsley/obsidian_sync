-- Name: Nathan Towsley
-- Class: CST-363
-- Date: 09/20/26

-- 1.
SELECT section.course_id, course.title, section.section_id
FROM section
INNER JOIN course
    ON section.course_id = course.course_id
WHERE section.semester = 'Spring'
    AND section.section_year = 2009
    AND course.dept_name = 'Comp. Sci.'
ORDER BY section.section_id ASC;

-- 2.
SELECT course.dept_name, COUNT(*) AS enrollment_count
FROM takes
INNER JOIN course
    ON takes.course_id = course.course_id
INNER JOIN section
    ON takes.course_id = section.course_id
    AND takes.section_id = section.section_id
WHERE takes.semester = 'Spring'
  AND takes.section_year = 2009
GROUP BY course.dept_name
ORDER BY course.dept_name ASC;

-- 3.
SELECT instructor.instructor_id,
       instructor.instructor_name,
       instructor.dept_name,
       COUNT(teaches.instructor_id) AS courses_taught
FROM instructor
LEFT JOIN teaches
    ON instructor.instructor_id = teaches.instructor_id
GROUP BY instructor.instructor_id,
         instructor.instructor_name,
         instructor.dept_name
ORDER BY instructor.instructor_id;