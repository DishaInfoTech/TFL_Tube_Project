package com.TFL_Tube.cucumber;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Map;


public class MyStepdefs {
    private String lineName;
    private String lineId;
    private String lineStatus;

    @Given("I have the line name {string}")
    public void iHaveTheLineName(String lineName) {
        this.lineName = lineName;
    }

    @When("I retrieve the line id using the TFL API")
    public void iRetrieveTheLineIdUsingTheTFLAPI() {
        Response response = RestAssured.get("https://api.tfl.gov.uk/line/mode/tube");
        lineId = response.jsonPath().getString("find { it.name == '" + lineName + "' }.id");
    }

    @Then("the line id should be {string}")
    public void theLineIdShouldBe(String expectedLineId) {
        Assert.assertEquals(expectedLineId, lineId);
    }
    @DataTableType
    public Map<String, String> lineDetailsEntry(Map<String, String> entry) {
        return entry;
    }

    @When("I check the status of the line using the TFL API")
    public void iCheckTheStatusOfTheLineUsingTheTFLAPI() {
        Response response = RestAssured.get("https://api.tfl.gov.uk/Line/" + lineId + "/status");
        lineStatus = response.jsonPath().getString("lineStatuses.statusSeverityDescription[0]");
        lineStatus = lineStatus.toLowerCase().trim();
    }

    @Then("the line status should be {string}")
    public void theLineStatusShouldBe(String expectedLineStatus) {
        String trimmedExpectedLineStatus = expectedLineStatus.toLowerCase().trim();
        String trimmedActualLineStatus = lineStatus.toLowerCase().trim().replaceAll("[\\[\\]]", "");
        Assert.assertEquals(trimmedActualLineStatus, trimmedExpectedLineStatus);
    }
}
