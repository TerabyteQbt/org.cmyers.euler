#!/bin/bash

set -e

# USAGE:  add-problem.sh [NUMBER]

cp -r template q$1
wget https://projecteuler.net/problem=$1 -O q$1/$1.html

qbt addPackage --repo org.cmyers.euler --package org.cmyers.euler.q$1
qbt updatePackage --package org.cmyers.euler.q$1 --prefix q$1 --addQbtEnv JDK=1_8 --addNormalDependency Weak 3p.gradle --addNormalDependency Weak qbt_fringe.linter.release
qbt addPackage --repo org.cmyers.euler --package org.cmyers.euler.q$1.release
qbt updatePackage --package org.cmyers.euler.q$1.release --prefix q$1 --addQbtEnv JDK=1_8 --addNormalDependency Weak org.cmyers.euler.q$1 --addNormalDependency Weak qbt_fringe.wrapper_generator.release

