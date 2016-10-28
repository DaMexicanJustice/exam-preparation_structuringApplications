/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.junit.BeforeClass;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.parsing.Parser;
import java.net.MalformedURLException;
import javax.servlet.ServletException;
import org.apache.catalina.LifecycleException;
import static org.hamcrest.Matchers.*;
import org.junit.AfterClass;
import org.junit.Test;
import test.utils.EmbeddedTomcat;

/**
 *
 * @author xboxm
 */
public class myTests {

    @Test
    public void footballclubs() {
        given().
                get("http://localhost:8084/seedMaven/api/footballclubs").
                then().statusCode(200)
                .equals("[{\"name\":\"Liverpool\", \"url\":\"http://www.liverpoolfc.com\"},{\"name\":\"Manchester United\",\"url\": \"http://www.manutd.com/\"}]");
    }

    @Test
    public void allusers() {
        given().
                get("http://localhost:8084/seedMaven/api/allusers").
                then().statusCode(200)
                .equals("[{\"name\": \"Jan\",\"mail\":\"jan@a.dk\"},{\"name\":\"Ann\",\"mail\":\"ann@a.dk\"},{\"name\":\"ib\",\"mail\":\"ib@a.dk\"}]");
    }
}
