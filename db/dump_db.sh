#!/bin/bash
# RESTORE FROM BACKUP

if [ -z "$1" ]; then printf "\nERROR:\nSet [DB_NAME] as 1st argument\n\n"; exit; fi

DB_NAME=$1

PGPASSWORD="ndid123" pg_dump -U postgres -h localhost -O -x -f $DB_NAME$(date +"%Y%m%d").sql $DB_NAME

printf "\n\n--- SUCCESS ---\n\n";
