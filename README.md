# java-testng-gradle-saucelabs

Run tests in parallel on Sauce Labs using TestNG and Gradle

Check that threads are running in parallel:

  ./gradlew test --tests SimpleTest
  
Run multiple tests in parallel using Sauce Labs:  

  ./gradlew test --tests *SimpleSauceTests
