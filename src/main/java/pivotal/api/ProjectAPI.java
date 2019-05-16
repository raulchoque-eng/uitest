package pivotal.api;

import pivotal.entities.Project;


import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * ProjectAPI class
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class ProjectAPI {

    public static void createProject(Project project) {
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());

        Response response = given().
                                header("X-TrackerToken", "65fb37c3caad0c00c3acf0158f15f6c7").
                                contentType(JSON).
                                body(jsonAsMap).
                            when().
                                    post("https://www.pivotaltracker.com/services/v5/projects").
                            then().
                                assertThat().
                                statusCode(200).
                                and().
                                contentType(JSON);
    }
}
