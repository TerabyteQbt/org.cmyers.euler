#!/bin/bash

set -e

# USAGE:  add-problem.sh [name]

cp -r practice-template practice/$1

qbt addPackage --repo org.cmyers.euler --package org.cmyers.practice.$1
qbt updatePackage --package org.cmyers.practice.$1 --prefix practice/$1 --addQbtEnv JDK=1_8 --addNormalDependency Weak 3p.gradle --addNormalDependency Weak qbt_fringe.linter.release
qbt addPackage --repo org.cmyers.euler --package org.cmyers.practice.$1.release
qbt updatePackage --package org.cmyers.practice.$1.release --prefix practice/$1 --addQbtEnv JDK=1_8 --addNormalDependency Weak org.cmyers.practice.$1 --addNormalDependency Weak qbt_fringe.wrapper_generator.release

echo "To add Guava:"
echo "qbt updatePackage --package org.cmyers.practice.$1.release --addNormalDependency Strong mc.com.google.guava.guava"
echo "To add misc1 concurrency lib:"
echo "qbt updatePackage --package org.cmyers.practice.$1.release --addNormalDependency Strong misc1.commons.concurrent.main"
echo ""

mkdir -p practice/$1/src/org/cmyers/practice/$1
FILE="practice/$1/src/org/cmyers/practice/$1/Main.java"
echo "package org.cmyers.practice.$1;" >> $FILE
echo "" >> $FILE
echo "class Main {" >> $FILE
echo "    public static final void main(String[] args) {" >> $FILE
echo "        System.out.println(\"Practice $1\");" >> $FILE
echo "    }" >> $FILE
echo "}" >> $FILE
echo "" >> $FILE

