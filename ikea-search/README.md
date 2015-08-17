# AludraTest tutorial: IKEA Search

This tutorial uses AludraTest's Selenium bindings to test the IKEA UK web site.
It searches for a keyword and tests the price range input fields.

## Requirements 

To have this test execute locally, you must have a local Selenium server installed. You can download the
Standalone Selenium server at http://www.seleniumhq.org/download/. We recommend creating a batch / shellscript file for starting Selenium,
containing this command line:

```
java -jar selenium-server-standalone-2.47.1.jar -trustAllSSLCertificates
```

By default, this test is executed using Firefox (this is configured in src/test/resources/config/seleniumWrapper.properties). 
To use another browser, you will have to reconfigure Selenium (see below).

## Execution

Run

```
mvn clean test
```

or (Windows)

```
test.bat
```

or (Linux / Mac)

```
./test.sh
```

to run the test.


## Use Chrome Driver with Selenium

To e.g. use Selenium with Chrome, you need an additional software, the Chromedriver. Download the latest or the
appropriate version for your Chrome version here http://chromedriver.storage.googleapis.com/
(The mapping between Chrome and Chromedriver version is here: http://chromedriver.storage.googleapis.com/2.16/notes.txt)

Install the chromedriver.exe in your Selenium directory. Edit your startup batch / shellscript (see above) and add this parameter
to the Selenium invocation:

```
-Dwebdriver.chrome.driver=path\to\chromedriver.exe
```

or, for Linux or Mac:

```
-Dwebdriver.chrome.driver=/path/to/chromedriver
```

Restart your Selenium server, and adjust the src/test/resources/config/seleniumWrapper.properties of this tutorial to set
the driver property to CHROME. Now, the test should run using Chrome as browser.

For other browsers, required actions are similar. See Selenium home page on how to add bindings for other browsers.
