echo off

set cp=../lib/*;
set prop=../cfg/test.properties
set log=../cfg/log4j2.properties
set main=org.testng.TestNG
set suitDefault=../suits/testng.xml
set suitParam=%1
if defined suitParam (
	set suit=%suitParam%
) else (
	set suit=%suitDefault%
)

java -cp %cp% -DconfigFile=%prop% -DLogj4=%log% %main%  %suit%