@echo off

echo "Cleaning up temporary files..."

rem Delete temporary files
del /s /q *.tmp

rem Remove temporary directories
rmdir /s /q temp

echo "Cleanup completed."
