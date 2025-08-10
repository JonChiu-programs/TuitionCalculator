@echo off

set /p findFolder=Enter variable path from address bar: 
cd %findFolder%
echo.
java TuitionCalculator

echo PRESS ENTER TO EXIT.
pause >nul

