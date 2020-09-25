CREATE TABLE course (
    courseID VARCHAR(10) NOT NULL,
    name VARCHAR(100) NOT NULL,
    credits INTEGER NOT NULL,
    prereqs VARCHAR(1000) NOT NULL,
    corereqs VARCHAR(1000) NOT NULL,
    description VARCHAR(1000) NOT NULL
)