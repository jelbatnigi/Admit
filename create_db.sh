#!/bin/bash

user=$1
password=$2

mysql -u$user -p$password -e "create database admitone"

mysql -u$user -p$password -D admitone < scripts.sql

