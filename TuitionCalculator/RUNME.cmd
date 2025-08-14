@echo off

set /p findFolder=Enter variable path from address bar: 
cd %findFolder%
cls
java TuitionCalculator
echo.
echo PRESS ENTER TO EXIT.
pause >nul
