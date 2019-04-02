#!/bin/bash

BASEDIR="$( cd "$( dirname "$0" )"/.. && pwd )"

java -cp "${BASEDIR}/lib/*" org.sudoku.validator.ValidatorCLI $1
