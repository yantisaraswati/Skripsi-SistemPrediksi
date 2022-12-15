#!/bin/bash
# RESTORE FROM BACKUP

if [ -z "$1" ]; then printf "\nERROR:\nSet [DB_NAME] as 1st argument\n\n"; exit; fi
if [ -z "$2" ]; then printf "\nERROR:\nSet Filename [FILE_NAME]\n\n"; exit; fi

DB_NAME=$1
FILE_NAME=$2

TARGET_FILE=$FILE_NAME

echo "STEP 1: Check FILE $TARGET_FILE"
if [ ! -f $TARGET_FILE ]; then printf "\nERROR:\nDUMP FILE NOT FOUND! Make sure you already dump the newest db!!!\n\n"; exit; fi

echo " ...File exist. Continue..."

echo "STEP 2: Restore SQL"
####### ACCESS TO SERVER DESTINATION / DROP CREATE DB  #######

PGPASSWORD="ndid123" psql -U postgres << END_OF_SCRIPT

SELECT pg_terminate_backend(pg_stat_activity.pid) FROM pg_stat_activity WHERE pg_stat_activity.datname = '$DB_NAME' AND pid <> pg_backend_pid();

DROP DATABASE $DB_NAME; -- drop the DB

CREATE DATABASE $DB_NAME WITH OWNER = postgres;

END_OF_SCRIPT

PGPASSWORD="ndid123" psql -U postgres -d $DB_NAME -f $TARGET_FILE

END_OF_SCRIPT

printf "\n\n--- SUCCESS ---\n\n";
