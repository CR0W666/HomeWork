#!/bin/bash
echo -n "" > input.txt && echo -n "" > output.txt
VAR="true"
echo "input numbers:"   
while [ "$VAR" = "true" ]; do
    read INPUT
    echo "$INPUT" >> input.txt
    echo "continue? Y/N"
    read YESNO

    if [ "$YESNO" = "N" ] || [ "$YESNO" = "n" ]; then
    echo "END" >> input.txt
    java UkolOne < input.txt > output.txt
    VAR=false
    fi

done
echo "----------------"
echo "input:"
cat input.txt
echo "----------------"
echo "output:"
cat output.txt
echo "----------------"

