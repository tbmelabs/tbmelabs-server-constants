#!/bin/bash
# Deployment script for TBME Labs Actuator Endpoints Security Utils
# https://github.com/tbmelabs/actuator-endpoints-security-utils

if [[ $TRAVIS_BRANCH == "master" && $TRAVIS_PULL_REQUEST == "false" ]] ; then
  mvn clean versions:set deploy -Psign,build-extras -DremoveSnapshot -DskipTests
fi

