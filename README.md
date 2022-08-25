# REAL ESTATES STATS APP
***
Application for extracting real estate price statistics

## Technologies:
***
Java 11

Spring boot 2.7.3

MySQL

WireMock

## Setup:
***

To run this project download wiremock jar from website:

[Wiremock download link](https://repo1.maven.org/maven2/com/github/tomakehurst/wiremock-jre8-standalone/2.33.2/wiremock-jre8-standalone-2.33.2.jar)

Then run standalone wiremock app from cmd console with command:

java -jar wiremock-jre8-standalone-2.33.2.jar --port 9090 --bind-address 127.0.0.1 --root-dir <%[path_to_realEstateResponse.json](/src/main/resources/mock/mappings/realEstateResponse.json)%>

Now you can run application from intelliJ using default springboot job.

## Using:
***
Call endpoint: GET /api/real-estates-stats/[regionId]?size=[size]&types=[types]&dateSince=[dateSince]&dateUntil=[dateUntil]

where params:
* regionId is one of __[DLN_WROC_C, DLN_WROC_PC, DLN_POZA_WROC, SL_POL, SL_KATO, SL_PN, M_WAW_CE, M_WAW_W, M_WAW_Z, LUBL, LUBL_INNE]__
* size is one of __[S, M, L]__
* types is one of or list of __[detached_house, flat, semi_detached_house, terraced_house]__ entered after decimal point
* dateSince is date including data collected from dateSince in format __yyyyMMdd__
* dateUntil is date including data collected until dateUntil in format __yyyyMMdd__

Example:
``GET /api/real-estates-stats/SL_KATO?size=M&types=detached_house,flat&dateSince=20210501&dateUntil=20210910``

In the response application will return average price for real estate, meeting the given criteria.

Example:
``{
"avgValue": 760332.99
}``

## Additional information:
***
To run integration tests, it is required to prepare an additional database in accordance with the settings in the src / test / resources / application.properties file
