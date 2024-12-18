package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {".//features/loginDDTExcel.feature"},
                //(features= {".//features/login.feature",".//features/registration.feature"},
                glue={"stepdefinations" ,"hooks"},
                
                            
                plugin= {
                		"pretty","html:reports/myreprt.html",
                		
                		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                        },
             
                		dryRun=false,    // checks mapping between scenario steps and step definition methods
    					monochrome=true,    // to avoid junk characters in output
    					publish=true,   // to publish report in cucumber server
    					//tags="@sanity"  // this will execute scenarios tagged with @sanity
    					//tags="@regression"
    					//tags="@sanity and @regression" //Scenarios tagged with both @sanity and @regression
    					//tags="@sanity and not @regression" //Scenarios tagged with @sanity but not tagged with @regression
    					tags="@sanity or @regression" //Scenarios tagged with either @sanity or @regression
                          )
public class TestRunner {

}
