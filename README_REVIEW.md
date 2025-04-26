# Review Pet Clinic Feature

## Please check the /spring-petclinic/src/main/java/org/springframework/samples/petclinic/reviewpackage to see the review feature added by Priyanka Priyadarsini

## And check the /spring-petclinic/src/test/java/org/springframework/samples/petclinic/reviewpackage to see the test cases for review feature added by Priyanka Priyadarsini

##The /spring-petclinic/src/main/resources/db/h2/schema.sql contains the table creation schema

##/spring-petclinic/src/main/resources/db/h2/data.sql contains the insertion data

## How to Run the Project

To run the project, follow these steps:

1. **Clone the repository:**

2. **Build the project using Maven:**

    If you need to format the code first, you can run:

    ```bash
    mvn spring-javaformat:apply
    ```

3. **Run the application:**

    To run the application, execute the following Maven command:

    ```bash
    mvn spring-boot:run
    ```

    Alternatively, you can build the project and then run the JAR file:

    ```bash
    mvn clean install
    ```

4. **To apply code formatting (if needed):**

    To ensure your code adheres to Spring's formatting standards, use:

    ```bash
    mvn spring-javaformat:apply
    ```

5. **Testing the application:**

    You can run tests using:

    ```bash
    mvn test
    ```

---

## Additional Information

- **Java Version:** Ensure you're using Java 17 or higher.
- **Dependencies:** Make sure all required dependencies are properly configured in the `pom.xml`.

