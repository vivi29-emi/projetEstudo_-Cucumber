package projetcucumber.runners;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/features/Test_cucumber_ContaBancaria.feature"},
                 glue={"projetcucumber.steps"},
                 snippets=SnippetType.CAMELCASE)//Para que no método fique no estilo CamelCase.
public class Runner {

}
