#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username postgres <<-EOSQL
  CREATE DATABASE drjoy ENCODING UTF8;
  GRANT ALL PRIVILEGES ON DATABASE drjoy TO postgres;
EOSQL

psql -f setup.sql -U postgres -d drjoy
