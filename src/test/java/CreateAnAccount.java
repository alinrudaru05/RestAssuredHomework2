import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import petclinic.models.Account;
import petclinic.util.EnvReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class CreateAnAccount {

    @Test
    public void createAccount(){
        Account account = new Account();

        Faker faker = new Faker();

        account.setName(faker.name().name());
        account.setOwner_access_token(faker.internet().password());


        ValidatableResponse postAccount = given()
                .baseUri(EnvReader.getBaseUri())
                .auth().oauth2("455136538609782|4fdbc3c6f529deaf84edc82aee315790")
                .pathParam("app-id", "455136538609782")
                .contentType(ContentType.JSON)
                .body(account)
                .log().all()
                .post("/v8.0/{app-id}/accounts/test-users")
                .prettyPeek()
                .then().statusCode(HttpStatus.SC_OK);


        account.setUid(postAccount.extract().jsonPath().getString("id"));

        ValidatableResponse getAccount = given()
                .baseUri(EnvReader.getBaseUri())
                .auth().oauth2("455136538609782|4fdbc3c6f529deaf84edc82aee315790")
                .pathParam("test-user-id", account.getUid())
                .log().all()
                .get("/v8.0/{test-user-id}")
                .prettyPeek()
                .then().statusCode(HttpStatus.SC_OK);

        //verificam ca respectiv contul nostru a fost creat cu succes
        Account actualAccount = getAccount.extract().as(Account.class);
        assertThat(actualAccount, is(account));
    }
}
