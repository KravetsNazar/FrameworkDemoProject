I've created the entire logic as per the requirement inside one feature file for demonstration purposes. It could be easily refactored to 2 different TC if needed.
I've completed my project using IntelliJ, based on JDK 11, Selenium, BDD Cucumber, and JUnit. I performed testing using the latest version of Google Chrome (I've set the
browser dynamically, so cross-browser testing is possible). It should run on other IDEs as well, but I'm 100% sure about IntelliJ. I've provided code comments along the way
for clarity and readability. I’ve used Page Object Model for maintainability and scalability, and Configuration Reader for reading important test data from Configuration.Properties.

To run the test case execution, you can use either TestRunner.java or directly execute it from NewUserRegisterAndUpdate. A demo video of the test case execution is also
attached.

I spent a good amount of time on an extra task involving automated image upload functionality. I had to implement the Robot class, managed to make it work, and screen
recorded the whole flow. This video will be attached to the project. For the consistency of test case execution, I've commented it out inside the respective step of
UserRegAndAccUpdateStepDefs. You can uncomment and test run, also feel free to check the logic behind the upload method. I would be glad to see how you test this feature on
the tablet. I've created quite a few new users, and I already love your website, apologies for quite a few newly created users.
There is no option of deleting account on users end, otherwise I would have added a method to clean up after my test.

