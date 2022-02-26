@echo off
set path=C:\Users\Brimore\.m2\repository\allure\allure-2.16.1\bin;C:\Program Files\Java\jdk-17\bin;%path%
allure serve allure-results
pause
exit