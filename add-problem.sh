#!/bin/bash

set -e

# USAGE:  add-problem.sh [NUMBER]

cp -r template q$1
wget https://projecteuler.net/problem=$1 -O q$1/$1.html

qbt addPackage --repo org.cmyers.euler --package org.cmyers.euler.q$1
qbt updatePackage --package org.cmyers.euler.q$1 --prefix q$1 --addQbtEnv JDK=1_8 --addNormalDependency Weak 3p.gradle --addNormalDependency Weak qbt_fringe.linter.release
qbt addPackage --repo org.cmyers.euler --package org.cmyers.euler.q$1.release
qbt updatePackage --package org.cmyers.euler.q$1.release --prefix q$1 --addQbtEnv JDK=1_8 --addNormalDependency Weak org.cmyers.euler.q$1 --addNormalDependency Weak qbt_fringe.wrapper_generator.release

echo "To add Guava:"
echo "qbt updatePackage --package org.cmyers.euler.q$1.release --addNormalDependency Strong mc.com.google.guava.guava"
echo "To add misc1 concurrency lib:"
echo "qbt updatePackage --package org.cmyers.euler.q$1.release --addNormalDependency Strong misc1.commons.concurrent.main"
echo ""

mkdir -p q$1/src/org/cmyers/euler/q$1
echo "package org.cmyers.euler.q$1;" >> q$1/src/org/cmyers/euler/q$1/Main.java
echo "" >> q$1/src/org/cmyers/euler/q$1/Main.java
echo "class Main {" >> q$1/src/org/cmyers/euler/q$1/Main.java
echo "    public static final void main(String[] args) {" >> q$1/src/org/cmyers/euler/q$1/Main.java
echo "        System.out.println(\"Problem $1\");" >> q$1/src/org/cmyers/euler/q$1/Main.java
echo "    }" >> q$1/src/org/cmyers/euler/q$1/Main.java
echo "}" >> q$1/src/org/cmyers/euler/q$1/Main.java
echo "" >> q$1/src/org/cmyers/euler/q$1/Main.java

